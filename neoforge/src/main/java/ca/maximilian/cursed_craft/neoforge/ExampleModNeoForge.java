package ca.maximilian.cursed_craft.neoforge;

import net.neoforged.fml.common.Mod;

import ca.maximilian.cursed_craft.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
