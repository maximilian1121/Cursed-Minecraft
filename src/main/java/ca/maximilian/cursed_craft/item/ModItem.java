package ca.maximilian.cursed_craft.item;

import ca.maximilian.cursed_craft.CursedCraft;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModItem {
    public static final Item TNT_WAND = new TNTWand(new Item.Properties().durability(10));
    public static void init() {
        CursedCraft.LOGGER.info("Registering items...");

        Registry.register(BuiltInRegistries.ITEM, CursedCraft.id(CursedCraft.MOD_ID, "tnt_wand"), TNT_WAND);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((itemGroup) -> itemGroup.accept(TNT_WAND));

        CursedCraft.LOGGER.info("Done registering items!");
    }
}
