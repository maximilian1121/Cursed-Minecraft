package ca.maximilian.cursed_craft.datagen;

import ca.maximilian.cursed_craft.item.ModItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

//? if <1.21 {

import net.minecraft.data.recipes.FinishedRecipe;
public class Recipies extends FabricRecipeProvider {
    public Recipies(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.TNT_WAND, 1)
                .pattern("#i")
                .pattern("i/")
                .define('i', Items.IRON_INGOT)
                .define('/', Items.STICK)
                .define('#', Items.TNT)
                .unlockedBy(FabricRecipeProvider.getItemName(Items.STICK), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .unlockedBy(FabricRecipeProvider.getItemName(Items.IRON_INGOT), InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .unlockedBy(FabricRecipeProvider.getItemName(Items.TNT), InventoryChangeTrigger.TriggerInstance.hasItems(Items.TNT))
                .save(exporter);
    }
}
//?} else {


/*import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;

public class Recipies extends FabricRecipeProvider {

    public Recipies(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.TNT_WAND, 1)
                .pattern("#i")
                .pattern("i/")
                .define('i', Items.IRON_INGOT)
                .define('/', Items.STICK)
                .define('#', Items.TNT)
                .unlockedBy(FabricRecipeProvider.getItemName(Items.STICK), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .unlockedBy(FabricRecipeProvider.getItemName(Items.IRON_INGOT), InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .unlockedBy(FabricRecipeProvider.getItemName(Items.TNT), InventoryChangeTrigger.TriggerInstance.hasItems(Items.TNT))
                .save(exporter);
    }
}
*/