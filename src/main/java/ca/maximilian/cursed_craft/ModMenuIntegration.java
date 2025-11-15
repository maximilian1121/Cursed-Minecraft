package ca.maximilian.cursed_craft;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        Config.HANDLER.load();
        return parentScreen -> ConfigScreen.create(parentScreen);
    }
}