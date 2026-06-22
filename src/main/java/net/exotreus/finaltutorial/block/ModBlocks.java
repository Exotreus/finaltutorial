package net.exotreus.finaltutorial.block;

import net.exotreus.finaltutorial.FinalTutorial;
import net.exotreus.finaltutorial.block.custom.MagicBlock;
import net.exotreus.finaltutorial.block.custom.VolatiteLampBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
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

    public static final Block VOLATITE_STAIRS = registerBlock("volatite_stairs",
            new StairsBlock(ModBlocks.VOLATITE_BLOCK.getDefaultState(), AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(6.5F, 8F)
                    .sounds(BlockSoundGroup.METAL)
            )
    );

    public static final Block VOLATITE_SLAB = registerBlock("volatite_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(6.5F, 8F)
                    .sounds(BlockSoundGroup.METAL)
            )
    );

    public static final Block VOLATITE_BUTTON = registerBlock("volatite_button",
            new ButtonBlock(BlockSetType.IRON, 5, AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(3F, 8F)
                    .sounds(BlockSoundGroup.METAL)
                    .noCollision()
            )
    );

    public static final Block VOLATITE_PRESSURE_PLATE = registerBlock("volatite_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(4F, 8F)
                    .sounds(BlockSoundGroup.METAL)
            )
    );

    public static final Block VOLATITE_FENCE = registerBlock("volatite_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(5F, 8F)
                    .sounds(BlockSoundGroup.METAL)
            )
    );

    public static final Block VOLATITE_FENCE_GATE = registerBlock("volatite_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(6.5F, 8F)
                    .sounds(BlockSoundGroup.METAL)
            )
    );

    public static final Block VOLATITE_WALL = registerBlock("volatite_wall",
            new WallBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(6.5F, 8F)
                    .sounds(BlockSoundGroup.METAL)
            )
    );

    public static final Block VOLATITE_DOOR = registerBlock("volatite_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(6.5F, 8F)
                    .sounds(BlockSoundGroup.METAL)
                    .nonOpaque()
            )
    );

    public static final Block VOLATITE_TRAPDOOR = registerBlock("volatite_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(6.5F, 8F)
                    .sounds(BlockSoundGroup.METAL)
                    .nonOpaque()
            )
    );

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

    public static final Block VOLATITE_LAMP = registerBlock("volatite_lamp",
            new VolatiteLampBlock(AbstractBlock.Settings.create()
                    .mapColor(state -> state.get(VolatiteLampBlock.ENABLED) ? MapColor.TERRACOTTA_WHITE : MapColor.TERRACOTTA_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(4F, 3F)
                    .sounds(BlockSoundGroup.GLASS)
                    .luminance(state -> state.get(VolatiteLampBlock.ENABLED) ? 15 : 0))
    );

    public static final Block ONYX_ORE = registerBlock("onyx_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(7, 10), AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_YELLOW)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(7.5F, 20F)
                    .sounds(BlockSoundGroup.STONE)
            ));

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

            entries.add(VOLATITE_STAIRS);
            entries.add(VOLATITE_SLAB);

            entries.add(VOLATITE_BUTTON);
            entries.add(VOLATITE_PRESSURE_PLATE);

            entries.add(VOLATITE_FENCE);
            entries.add(VOLATITE_FENCE_GATE);
            entries.add(VOLATITE_WALL);

            entries.add(VOLATITE_DOOR);
            entries.add(VOLATITE_TRAPDOOR);

            entries.add(VOLATITE_ORE);
            entries.add(DEEPSLATE_VOLATITE_ORE);

            entries.add(ONYX_ORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(VOLATITE_LAMP);

            entries.add(MAGIC_BLOCK);
        });
    }
}
