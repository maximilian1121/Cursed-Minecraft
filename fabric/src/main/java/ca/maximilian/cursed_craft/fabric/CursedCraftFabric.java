package ca.maximilian.cursed_craft.fabric;

import net.fabricmc.api.ModInitializer;

import ca.maximilian.cursed_craft.ExampleMod;

public final class CursedCraftFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        ExampleMod.init();
    }
}
