package ca.maximilian.cursed_craft.mixin;

import ca.maximilian.cursed_craft.Config;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(PistonStructureResolver.class)
public class InfPiston {
    @ModifyConstant(method = "addBlockLine", constant = @Constant(intValue = 12))
    private int changeConstant(int constant) {
        if (Config.HANDLER.instance().infinitePiston) {
            return Integer.MAX_VALUE;
        } else {
            return 12;
        }
    }
}
