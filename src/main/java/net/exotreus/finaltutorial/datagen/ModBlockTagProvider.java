package net.exotreus.finaltutorial.datagen;

import net.exotreus.finaltutorial.block.ModBlocks;
import net.exotreus.finaltutorial.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.VOLATITE_BLOCK)

                .add(ModBlocks.VOLATITE_STAIRS)
                .add(ModBlocks.VOLATITE_SLAB)

                .add(ModBlocks.VOLATITE_BUTTON)
                .add(ModBlocks.VOLATITE_PRESSURE_PLATE)

                .add(ModBlocks.VOLATITE_FENCE)
                .add(ModBlocks.VOLATITE_FENCE_GATE)
                .add(ModBlocks.VOLATITE_WALL)

                .add(ModBlocks.VOLATITE_DOOR)
                .add(ModBlocks.VOLATITE_TRAPDOOR)

                .add(ModBlocks.VOLATITE_ORE)
                .add(ModBlocks.DEEPSLATE_VOLATITE_ORE);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.MAGIC_BLOCK);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.MAGIC_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MAGIC_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.VOLATITE_BLOCK)

                .add(ModBlocks.VOLATITE_STAIRS)
                .add(ModBlocks.VOLATITE_SLAB)

                .add(ModBlocks.VOLATITE_BUTTON)
                .add(ModBlocks.VOLATITE_PRESSURE_PLATE)

                .add(ModBlocks.VOLATITE_FENCE)
                .add(ModBlocks.VOLATITE_FENCE_GATE)
                .add(ModBlocks.VOLATITE_WALL)

                .add(ModBlocks.VOLATITE_DOOR)
                .add(ModBlocks.VOLATITE_TRAPDOOR)

                .add(ModBlocks.VOLATITE_ORE)
                .add(ModBlocks.DEEPSLATE_VOLATITE_ORE);

        // for wooden fences, use BlockTags.WOODEN_FENCES
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.VOLATITE_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.VOLATITE_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.VOLATITE_WALL);

        getOrCreateTagBuilder(ModTags.Items.LAMP_GLASS)
                .addOptionalTag(ConventionalItemTags.GLASS_BLOCKS)
                .add(Items.TINTED_GLASS);
    }
}
