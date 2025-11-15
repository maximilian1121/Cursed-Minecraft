package ca.maximilian.cursed_craft.neoforge;

import net.neoforged.fml.common.Mod;

import ca.maximilian.cursed_craft.CursedCraft;

@Mod(CursedCraft.MOD_ID)
public final class CursedCraftNeoForge {
    public CursedCraftNeoForge() {
        // Run our common setup.
        CursedCraft.init();
    }
}
