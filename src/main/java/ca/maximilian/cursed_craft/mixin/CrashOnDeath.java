package ca.maximilian.cursed_craft.mixin;

import ca.maximilian.cursed_craft.Config;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import org.lwjgl.system.MemoryUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public class CrashOnDeath {
    @Inject(method="die", at=@At("HEAD"))
    private void onDeath(DamageSource source, CallbackInfo info) {
        if (Config.HANDLER.instance().crashOnDeath) {
            MemoryUtil.memSet(0, 0, 1L);
        }
    }
}
