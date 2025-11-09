package ca.maximilian.shenanigans.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import static ca.maximilian.shenanigans.Shenanigans.LOGGER;
import static ca.maximilian.shenanigans.Shenanigans.MOD_ID;

public class ModItem {
    public static final Item TNT_WAND = new TNTWand(new Item.Properties().durability(10).stacksTo(1));
    public static void init() {
        LOGGER.info("Registering items...");


        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, "tnt_wand"), TNT_WAND);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(TNT_WAND));

        LOGGER.info("Done registering items!");
    }
}
