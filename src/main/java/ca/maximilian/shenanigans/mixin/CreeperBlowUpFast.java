package ca.maximilian.shenanigans.mixin;

import ca.maximilian.shenanigans.Config;
import net.minecraft.world.entity.monster.Creeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Creeper.class)
public class CreeperBlowUpFast {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        if (Config.HANDLER.instance().instantCreepers) {
            ((CreeperAccessor)this).setMaxSwell(1);
        } else {
            ((CreeperAccessor)this).setMaxSwell(30);
        }
    }
}
