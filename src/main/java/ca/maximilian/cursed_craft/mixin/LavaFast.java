package ca.maximilian.cursed_craft.mixin;

import ca.maximilian.cursed_craft.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.LavaFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.world.level.material.FlowingFluid.FALLING;

@Mixin(LavaFluid.class)
public abstract class LavaFast {
    @Shadow
    public abstract int getTickDelay(LevelReader levelReader);

    /**
     * @author max
     * @reason lessen the tick delay.
     */
    @Inject(
            method = "getTickDelay",
            at = @At("HEAD"),
            cancellable = true
    )
    private void fastLava(LevelReader level, CallbackInfoReturnable<Integer> cir) {
        if (Config.HANDLER.instance().lavaFast) {
            cir.setReturnValue(0);
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

