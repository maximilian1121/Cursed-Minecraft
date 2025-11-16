package ca.maximilian.cursed_craft.mixin;

import ca.maximilian.cursed_craft.Config;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.WaterFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(WaterFluid.Flowing.class)
public class WaterFluidMixin {
    /**
     * @author me
     * @reason make water flow infinitely
     */
    @Overwrite
    public boolean isSource(FluidState fluidState) {
        return Config.HANDLER.instance().waterInfinite;
    }
}
