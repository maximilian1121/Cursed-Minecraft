package ca.maximilian.cursed_craft.datagen;

import ca.maximilian.cursed_craft.item.ModItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;



//? >=1.20.4 {
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;

//?} else if <=1.20.1 {
/*import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

*///?}

public class Recipes extends FabricRecipeProvider {
    //? >=1.21 {
    /*public Recipes(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }
    *///?} else if <=1.20.4 {
    Recipes(FabricDataOutput generator) {
        super(generator);
    }
    //?}

    //? >= 1.20.4 {
    public void buildTNTWandRecipe(ShapedRecipeBuilder builder, RecipeOutput consumer) {
    //?} else if <=1.20.1 {
    /*public void buildTNTWandRecipe(ShapedRecipeBuilder builder, Consumer<FinishedRecipe> consumer) {
    *///?}
        builder
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

    //? if >=1.21.9 {
    /*@Override
    public String getName() {
        return "CursedCraftRecipes";
    }
    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                buildTNTWandRecipe(shaped(RecipeCategory.TOOLS, ModItem.TNT_WAND, 1), recipeOutput);
            }
        };
    }
    *///?} else if >= 1.20.4 {
    @Override
    public void buildRecipes(RecipeOutput recipeExporter) {
        buildTNTWandRecipe(ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.TNT_WAND, 1), recipeExporter);
    }
    //?} else <= 1.20.1 {
    /*@Override
    public void buildRecipes(Consumer<FinishedRecipe> consumer) {
        buildTNTWandRecipe(ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItem.TNT_WAND, 1), consumer);
    }
    *///?}
}