package ca.maximilian.cursed_craft;

import ca.maximilian.cursed_craft.item.ModItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CursedCraft implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("cursed_craft");
    public static final String MOD_ID = "cursed_craft";

    @Override
    public void onInitialize() {
        ModItem.init();
    }

    /**
     * Adapts to the {@link ResourceLocation} changes introduced in 1.21.
     */
    public static ResourceLocation id(String namespace, String path) {
        //? if <1.21 {
        return new ResourceLocation(namespace, path);
         //?} else
        /*return ResourceLocation.fromNamespaceAndPath(namespace, path);*/
    }
}