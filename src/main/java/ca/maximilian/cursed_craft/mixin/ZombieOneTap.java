package ca.maximilian.cursed_craft.mixin;

import ca.maximilian.cursed_craft.Config;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//? <1.21.11 {
import net.minecraft.world.entity.monster.Zombie;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

//?} else {
/*import net.minecraft.world.entity.monster.zombie.Zombie;
*///?}
@Mixin(Zombie.class)
public class ZombieOneTap {
    @Inject(method = "<init>*", at = @At("TAIL"))
    private void checkConfigAndApplyDamage(EntityType<? extends Zombie> type, Level level, CallbackInfo ci) {
        if (Config.HANDLER.instance().oneTapZombies) {

            Zombie zombie = (Zombie) (Object) this;
            var attackDamage = zombie.getAttribute(Attributes.ATTACK_DAMAGE);

            if (attackDamage != null) {
                attackDamage.setBaseValue(10_000D); // 10k is pretty good i think
            }
        }
    }
}