package net.exotreus.finaltutorial.item;

import net.exotreus.finaltutorial.FinalTutorial;
import net.exotreus.finaltutorial.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup VOLATITE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FinalTutorial.MOD_ID, "volatite_items_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.VOLATITE))
                    .displayName(Text.translatable("itemgroup.finaltutorial.volatite_items_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.VOLATITE);
                        entries.add(ModItems.SPAWNER_FRAGMENT);
                        entries.add(ModItems.GUARDIAN_HEART);

                        entries.add(ModItems.IRON_CHISEL);
                        entries.add(ModItems.DIAMOND_CHISEL);
                        entries.add(ModItems.NETHERITE_CHISEL);

                        entries.add(ModItems.TOTEM_BASE);
                        entries.add(ModItems.RAW_ONYX);
                        entries.add(ModItems.ONYX);

                        entries.add(ModItems.ONYX_SWORD);
                        entries.add(ModItems.ONYX_PICKAXE);
                        entries.add(ModItems.ONYX_AXE);
                        entries.add(ModItems.ONYX_SHOVEL);
                        entries.add(ModItems.ONYX_HOE);

                        entries.add(ModItems.ONYX_HAMMER);
                    })
                    .build());

    public static final ItemGroup VOLATITE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FinalTutorial.MOD_ID, "volatite_blocks_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.VOLATITE_BLOCK))
                    .displayName(Text.translatable("itemgroup.finaltutorial.volatite_blocks_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.VOLATITE_BLOCK);

                        entries.add(ModBlocks.VOLATITE_STAIRS);
                        entries.add(ModBlocks.VOLATITE_SLAB);

                        entries.add(ModBlocks.VOLATITE_BUTTON);
                        entries.add(ModBlocks.VOLATITE_PRESSURE_PLATE);

                        entries.add(ModBlocks.VOLATITE_FENCE);
                        entries.add(ModBlocks.VOLATITE_FENCE_GATE);
                        entries.add(ModBlocks.VOLATITE_WALL);

                        entries.add(ModBlocks.VOLATITE_DOOR);
                        entries.add(ModBlocks.VOLATITE_TRAPDOOR);

                        entries.add(ModBlocks.VOLATITE_LAMP);

                        entries.add(ModBlocks.VOLATITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_VOLATITE_ORE);
                        entries.add(ModBlocks.ONYX_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);
                    })
                    .build());

    public static void registerItemGroups() {
        FinalTutorial.LOGGER.info("Registering Item Groups for " + FinalTutorial.MOD_ID);
    }
}
