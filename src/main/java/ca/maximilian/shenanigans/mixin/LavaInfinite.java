package ca.maximilian.shenanigans.mixin;

import ca.maximilian.shenanigans.Config;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.LavaFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(LavaFluid.Flowing.class)
public class LavaInfinite {
    /**
     * @author me
     * @reason make lava flow infinitely
     */
    @Overwrite
    public boolean isSource(FluidState fluidState) {
        return Config.HANDLER.instance().lavaInfinite;
    }
}
