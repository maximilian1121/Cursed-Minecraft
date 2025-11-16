package ca.maximilian.cursed_craft.mixin;

import ca.maximilian.cursed_craft.Config;
import net.minecraft.world.entity.monster.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Zombie.class)
public class ZombieOneTap {
    @ModifyConstant(method = "createAttributes", constant = @Constant(doubleValue = 3.0))
    private static double cursedCraft$setZombieAttackDamage(double original) {
        if (Config.HANDLER.instance().oneTapZombies) {
            return 10000.0;
        } else {
            return original;
        }
    }
}
