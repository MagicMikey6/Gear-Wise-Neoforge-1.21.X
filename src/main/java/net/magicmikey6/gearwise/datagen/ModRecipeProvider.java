package net.magicmikey6.gearwise.datagen;

import net.magicmikey6.gearwise.block.ModBlocks;
import net.magicmikey6.gearwise.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BASIC_MACHINE_CASING.get())
                .pattern("SIS")
                .pattern("IOI")
                .pattern("SIS")
                .define('I', Items.IRON_INGOT)
                .define('O', Items.OAK_PLANKS)
                .define('S', Items.STICK)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BASIC_MECHANISM.get(), 2)
                .pattern("IAI")
                .pattern("SRS")
                .pattern("IAI")
                .define('I', Items.IRON_INGOT)
                .define('R', Items.REDSTONE)
                .define('S', Items.STICK)
                .define('A', Items.ANDESITE)
                .unlockedBy("has_redstone", has(Items.REDSTONE)).save(recipeOutput);
    }
}