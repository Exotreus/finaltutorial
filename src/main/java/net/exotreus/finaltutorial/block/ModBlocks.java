package net.exotreus.finaltutorial.block;

import net.exotreus.finaltutorial.FinalTutorial;
import net.exotreus.finaltutorial.block.custom.MagicBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block VOLATITE_BLOCK = registerBlock("volatite_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(6.5F, 8F)
                    .sounds(BlockSoundGroup.METAL)
            ));

    public static final Block VOLATITE_ORE = registerBlock("volatite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 6), AbstractBlock.Settings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(4F, 5F)
                    .sounds(BlockSoundGroup.STONE)
            ));

    public static final Block DEEPSLATE_VOLATITE_ORE = registerBlock("deepslate_volatite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 6), AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(5F, 5F)
                    .sounds(BlockSoundGroup.DEEPSLATE)
            ));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_PURPLE)
                    .instrument(NoteBlockInstrument.PLING)
                    .requiresTool()
                    .strength(2f, 2f)
                    .sounds(BlockSoundGroup.PACKED_MUD)
            )
    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FinalTutorial.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FinalTutorial.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        FinalTutorial.LOGGER.info("Registering Blocks for " + FinalTutorial.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(VOLATITE_BLOCK);
            entries.add(VOLATITE_ORE);
            entries.add(DEEPSLATE_VOLATITE_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(MAGIC_BLOCK);
        });
    }
}
