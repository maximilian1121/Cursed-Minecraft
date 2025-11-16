package ca.maximilian.cursed_craft;

import ca.maximilian.cursed_craft.item.ModItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CursedCraft implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("cursed_craft");
    public static final String MOD_ID = "cursed_craft";
    public static final String MINECRAFT = /*$ minecraft*/ "1.20.4";

    @Override
    public void onInitialize() {
        Config.HANDLER.load();
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