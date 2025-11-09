package ca.maximilian.shenanigans.datagen;

import ca.maximilian.shenanigans.item.ModItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class Recipies extends FabricRecipeProvider {
    public Recipies(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.TNT_WAND, 1)
                .pattern("ti")
                .pattern("is")
                .define('i', Items.IRON_INGOT)
                .define('s', Items.STICK)
                .define('t', Items.TNT)
                .unlockedBy(FabricRecipeProvider.getItemName(ModItem.TNT_WAND), InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .unlockedBy(FabricRecipeProvider.getItemName(ModItem.TNT_WAND), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .unlockedBy(FabricRecipeProvider.getItemName(ModItem.TNT_WAND), InventoryChangeTrigger.TriggerInstance.hasItems(Items.TNT))
                .save(recipeOutput);
    }
}
