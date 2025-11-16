package ca.maximilian.cursed_craft;

import dev.isxander.yacl3.api.NameableEnum;
import net.minecraft.network.chat.Component;

public enum CrashOnDeathType implements NameableEnum {
    OFF,
    MEMSET,
    STOPPEDRESPONDING;

    @Override
    public Component getDisplayName() {
        return Component.translatable("cursed_craft.config.enum.cond_type." + name().toLowerCase());
    }
}
