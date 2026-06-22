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
        List<ItemConvertible> RAW_ONYX_SMELTABLES = List.of(ModBlocks.ONYX_ORE);
        List<ItemConvertible> ONYX_SMELTABLES = List.of(ModItems.RAW_ONYX);

        offerSmelting(exporter, VOLATITE_SMELTABLES, RecipeCategory.MISC, ModItems.VOLATITE, 1.0F, 200, "volatite");
        offerBlasting(exporter, VOLATITE_SMELTABLES, RecipeCategory.MISC, ModItems.VOLATITE, 1.0F, 100, "volatite");

        offerSmelting(exporter, RAW_ONYX_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_ONYX, 1.0F, 600, "raw_onyx");
        offerBlasting(exporter, RAW_ONYX_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_ONYX, 1.0F, 300, "raw_onyx");

        offerBlasting(exporter, ONYX_SMELTABLES, RecipeCategory.MISC, ModItems.ONYX, 2.0F, 600, "onyx");

//        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VOLATITE, RecipeCategory.MISC, ModBlocks.VOLATITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VOLATITE_BLOCK, 1)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .input('A', ModItems.VOLATITE)
                .criterion(hasItem(ModItems.VOLATITE), conditionsFromItem(ModItems.VOLATITE))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "volatite_block"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VOLATITE_STAIRS, 4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .input('A', ModBlocks.VOLATITE_BLOCK)
                .criterion(hasItem(ModBlocks.VOLATITE_BLOCK), conditionsFromItem(ModBlocks.VOLATITE_BLOCK))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "volatite_stairs"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VOLATITE_SLAB, 6)
                .pattern("AAA")
                .input('A', ModBlocks.VOLATITE_BLOCK)
                .criterion(hasItem(ModBlocks.VOLATITE_BLOCK), conditionsFromItem(ModBlocks.VOLATITE_BLOCK))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "volatite_slab"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VOLATITE_FENCE, 3)
                .pattern("ABA")
                .pattern("ABA")
                .input('A', ModBlocks.VOLATITE_BLOCK)
                .input('B', Items.STICK)
                .criterion(hasItem(ModBlocks.VOLATITE_BLOCK), conditionsFromItem(ModBlocks.VOLATITE_BLOCK))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "volatite_fence"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VOLATITE_FENCE_GATE)
                .pattern("BAB")
                .pattern("BAB")
                .input('A', ModBlocks.VOLATITE_BLOCK)
                .input('B', Items.STICK)
                .criterion(hasItem(ModBlocks.VOLATITE_BLOCK), conditionsFromItem(ModBlocks.VOLATITE_BLOCK))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "volatite_fence_gate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VOLATITE_WALL, 6)
                .pattern("AAA")
                .pattern("AAA")
                .input('A', ModBlocks.VOLATITE_BLOCK)
                .criterion(hasItem(ModBlocks.VOLATITE_BLOCK), conditionsFromItem(ModBlocks.VOLATITE_BLOCK))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "volatite_wall"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.VOLATITE_DOOR, 3)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .input('A', ModBlocks.VOLATITE_BLOCK)
                .criterion(hasItem(ModBlocks.VOLATITE_BLOCK), conditionsFromItem(ModBlocks.VOLATITE_BLOCK))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "volatite_door"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.VOLATITE_TRAPDOOR, 2)
                .pattern("AA")
                .pattern("AA")
                .input('A', ModBlocks.VOLATITE_BLOCK)
                .criterion(hasItem(ModBlocks.VOLATITE_BLOCK), conditionsFromItem(ModBlocks.VOLATITE_BLOCK))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "volatite_trapdoor"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.VOLATITE_BUTTON)
                .pattern("A")
                .input('A', ModBlocks.VOLATITE_BLOCK)
                .criterion(hasItem(ModBlocks.VOLATITE_BLOCK), conditionsFromItem(ModBlocks.VOLATITE_BLOCK))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "volatite_button"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.VOLATITE_PRESSURE_PLATE)
                .pattern("AA")
                .input('A', ModBlocks.VOLATITE_BLOCK)
                .criterion(hasItem(ModBlocks.VOLATITE_BLOCK), conditionsFromItem(ModBlocks.VOLATITE_BLOCK))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "volatite_pressure_plate"));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VOLATITE_STAIRS, ModBlocks.VOLATITE_BLOCK, 1);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VOLATITE_SLAB, ModBlocks.VOLATITE_BLOCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VOLATITE_WALL, ModBlocks.VOLATITE_BLOCK, 1);

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.VOLATITE_LAMP)
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ABA")
                .input('A', ModBlocks.VOLATITE_BLOCK)
                .input('B', Ingredient.fromTag(ModTags.Items.LAMP_GLASS))
                .input('C', Blocks.REDSTONE_LAMP)
                .criterion(hasItem(ModBlocks.VOLATITE_BLOCK), conditionsFromItem(ModBlocks.VOLATITE_BLOCK))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "volatite_lamp"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ONYX_SWORD)
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .input('A', ModItems.ONYX)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.ONYX), conditionsFromItem(ModItems.ONYX))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "onyx_sword"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ONYX_PICKAXE)
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .input('A', ModItems.ONYX)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.ONYX), conditionsFromItem(ModItems.ONYX))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "onyx_pickaxe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ONYX_AXE)
                .pattern("AA")
                .pattern("AB")
                .pattern(" B")
                .input('A', ModItems.ONYX)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.ONYX), conditionsFromItem(ModItems.ONYX))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "onyx_axe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ONYX_SHOVEL)
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .input('A', ModItems.ONYX)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.ONYX), conditionsFromItem(ModItems.ONYX))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "onyx_shovel"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ONYX_HOE)
                .pattern("AA")
                .pattern(" B")
                .pattern(" B")
                .input('A', ModItems.ONYX)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.ONYX), conditionsFromItem(ModItems.ONYX))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "onyx_hoe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ONYX_HAMMER)
                .pattern("AAA")
                .pattern("ABA")
                .pattern(" B ")
                .input('A', ModItems.ONYX)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.ONYX), conditionsFromItem(ModItems.ONYX))
                .offerTo(exporter, Identifier.of(FinalTutorial.MOD_ID, "onyx_hammer"));
    }
}