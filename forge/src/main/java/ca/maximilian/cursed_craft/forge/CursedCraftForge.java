package ca.maximilian.cursed_craft.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import ca.maximilian.cursed_craft.CursedCraft;

@Mod(CursedCraft.MOD_ID)
public final class CursedCraftForge {
    public CursedCraftForge() {
        EventBuses.registerModEventBus(CursedCraft.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        CursedCraft.init();
    }
}
