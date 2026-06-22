package net.exotreus.finaltutorial.datagen;

import net.exotreus.finaltutorial.block.ModBlocks;
import net.exotreus.finaltutorial.item.ModItems;
import net.exotreus.finaltutorial.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.VOLATITE)
                .add(Items.COAL)
                .add(ModBlocks.MAGIC_BLOCK.asItem())
                .forceAddTag(ItemTags.PLANKS);

        getOrCreateTagBuilder(ModTags.Items.LAMP_GLASS)
                .addOptionalTag(ConventionalItemTags.GLASS_BLOCKS)
                .add(Items.TINTED_GLASS);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.ONYX_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.ONYX_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.ONYX_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.ONYX_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.ONYX_HOE);
    }
}
