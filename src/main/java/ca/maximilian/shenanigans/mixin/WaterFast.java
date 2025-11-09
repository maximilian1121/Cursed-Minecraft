package ca.maximilian.shenanigans.mixin;

import ca.maximilian.shenanigans.Config;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.WaterFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(WaterFluid.class)
public class WaterFast {
    /**
     * @author max
     * @reason make water flow faster by reducing the tick delay
     */
    @Overwrite
    public int getTickDelay(LevelReader levelReader) {
        if (Config.HANDLER.instance().waterFast) {
            return 0;
        } else {
            return 5;
        }
    }
}

