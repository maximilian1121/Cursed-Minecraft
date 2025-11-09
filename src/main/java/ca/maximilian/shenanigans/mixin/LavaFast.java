package ca.maximilian.shenanigans.mixin;

import ca.maximilian.shenanigans.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.LavaFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static net.minecraft.world.level.material.FlowingFluid.FALLING;

@Mixin(LavaFluid.class)
public class LavaFast {
    /**
     * @author max
     * @reason lessen the tick delay.
     */
    @Overwrite
    public int getTickDelay(LevelReader level) {
        if (Config.HANDLER.instance().lavaFast) {
            return 0;
        } else {
            return level.dimensionType().ultraWarm() ? 10 : 30;
        }
    }

    /**
     * @author max
     * @reason lessen the spread delay.
     */
    @Overwrite
    public int getSpreadDelay(Level level, BlockPos pos, FluidState currentState, FluidState newState) {
        if (Config.HANDLER.instance().lavaFast) {
            return 0;
        } else {
            int i = this.getTickDelay(level);
            if (!currentState.isEmpty() && !newState.isEmpty() && !(Boolean)currentState.getValue(FALLING) && !(Boolean)newState.getValue(FALLING) && newState.getHeight(level, pos) > currentState.getHeight(level, pos) && level.getRandom().nextInt(4) != 0) {
                i *= 4;
            }

            return i;
        }
    }
}

