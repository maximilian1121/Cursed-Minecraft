package ca.maximilian.cursed_craft.datagen;

import ca.maximilian.cursed_craft.item.ModItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Items;

import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

//? >=1.21.9 {

/*import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.RecipeOutput;

public class Recipes extends FabricRecipeProvider {
    public Recipes(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.TOOLS, ModItem.TNT_WAND, 1)
                        .pattern("#i")
                        .pattern("i/")
                        .define('i', Items.IRON_INGOT)
                        .define('/', Items.STICK)
                        .define('#', Items.TNT)
                        .unlockedBy(Items.STICK.getDescriptionId(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                        .unlockedBy(Items.IRON_INGOT.getDescriptionId(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                        .unlockedBy(Items.TNT.getDescriptionId(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.TNT))
                        .save(recipeOutput);
            }
        };
    }

    @Override
    public String getName() {
        return "CursedCraftRecipes";
    }
}
*///?} else if >= 1.21 {
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;

public class Recipes extends FabricRecipeProvider {
    public Recipes(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeExporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.TNT_WAND, 1)
                .pattern("#i")
                .pattern("i/")
                .define('i', Items.IRON_INGOT)
                .define('/', Items.STICK)
                .define('#', Items.TNT)
                .unlockedBy(Items.STICK.getDescriptionId(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .unlockedBy(Items.IRON_INGOT.getDescriptionId(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .unlockedBy(Items.TNT.getDescriptionId(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.TNT))
                .save(recipeExporter);
    }
}
//?} else {
/*import java.util.function.Consumer;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
public class Recipes extends FabricRecipeProvider {
    Recipes(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.TNT_WAND, 1)
                .pattern("#i")
                .pattern("i/")
                .define('i', Items.IRON_INGOT)
                .define('/', Items.STICK)
                .define('#', Items.TNT)
                .unlockedBy(Items.STICK.getDescriptionId(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .unlockedBy(Items.IRON_INGOT.getDescriptionId(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .unlockedBy(Items.TNT.getDescriptionId(), InventoryChangeTrigger.TriggerInstance.hasItems(Items.TNT))
                .save(consumer);
    }


}
*///?}