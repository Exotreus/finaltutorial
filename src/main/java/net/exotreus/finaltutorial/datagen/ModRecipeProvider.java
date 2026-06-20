package net.exotreus.finaltutorial.datagen;

import net.exotreus.finaltutorial.FinalTutorial;
import net.exotreus.finaltutorial.block.ModBlocks;
import net.exotreus.finaltutorial.item.ModItems;
import net.exotreus.finaltutorial.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> VOLATITE_SMELTABLES = List.of(ModBlocks.VOLATITE_ORE, ModBlocks.DEEPSLATE_VOLATITE_ORE);

        offerSmelting(exporter, VOLATITE_SMELTABLES, RecipeCategory.MISC, ModItems.VOLATITE, 1.0F, 200, "volatite");
        offerBlasting(exporter, VOLATITE_SMELTABLES, RecipeCategory.MISC, ModItems.VOLATITE, 1.0F, 100, "volatite");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VOLATITE, RecipeCategory.MISC, ModBlocks.VOLATITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.SPAWNER)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .input('A', ModItems.SPAWNER_FRAGMENT)
                .input('B', ModItems.GUARDIAN_HEART)
                .criterion(hasItem(ModItems.SPAWNER_FRAGMENT), conditionsFromItem(ModItems.SPAWNER_FRAGMENT))
                .criterion(hasItem(ModItems.GUARDIAN_HEART), conditionsFromItem(ModItems.GUARDIAN_HEART))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "spawner"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TOTEM_BASE)
                .pattern("ABA")
                .pattern(" A ")
                .input('A', Ingredient.fromTag(ItemTags.PLANKS))
                .input('B', Items.HONEYCOMB)
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "totem_base"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.IRON_CHISEL)
                .pattern(" B")
                .pattern("A ")
                .input('A', Ingredient.fromTag(ItemTags.PLANKS))
                .input('B', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "iron_chisel"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.DIAMOND_CHISEL)
                .pattern(" B")
                .pattern("A ")
                .input('A', Ingredient.fromTag(ItemTags.PLANKS))
                .input('B', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "diamond_chisel"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ModItems.DIAMOND_CHISEL),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        ModItems.NETHERITE_CHISEL
                )
                .criterion(hasItem(ModItems.DIAMOND_CHISEL), conditionsFromItem(ModItems.DIAMOND_CHISEL))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "netherite_chisel"));
    }
}
