package net.exotreus.finaltutorial.datagen;

import net.exotreus.finaltutorial.block.ModBlocks;
import net.exotreus.finaltutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool volatitePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VOLATITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOLATITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_VOLATITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        volatitePool.stairs(ModBlocks.VOLATITE_STAIRS);
        volatitePool.slab(ModBlocks.VOLATITE_SLAB);

        volatitePool.button(ModBlocks.VOLATITE_BUTTON);
        volatitePool.pressurePlate(ModBlocks.VOLATITE_PRESSURE_PLATE);

        volatitePool.fence(ModBlocks.VOLATITE_FENCE);
        volatitePool.fenceGate(ModBlocks.VOLATITE_FENCE_GATE);
        volatitePool.wall(ModBlocks.VOLATITE_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.VOLATITE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.VOLATITE_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GUARDIAN_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPAWNER_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOLATITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOTEM_BASE, Models.GENERATED);

        itemModelGenerator.register(ModItems.IRON_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_CHISEL, Models.GENERATED);
    }
}
