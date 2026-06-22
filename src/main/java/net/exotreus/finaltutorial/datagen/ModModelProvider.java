package net.exotreus.finaltutorial.datagen;

import net.exotreus.finaltutorial.block.ModBlocks;
import net.exotreus.finaltutorial.block.custom.VolatiteLampBlock;
import net.exotreus.finaltutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool volatitePool = blockStateModelGenerator.
                registerCubeAllModelTexturePool(ModBlocks.VOLATITE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOLATITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ONYX_ORE);
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

        Identifier volatiteLampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.VOLATITE_LAMP, blockStateModelGenerator.modelCollector);
        Identifier volatiteLampOnIdentifier = blockStateModelGenerator
                .createSubModel(ModBlocks.VOLATITE_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.VOLATITE_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(VolatiteLampBlock.ENABLED, volatiteLampOnIdentifier, volatiteLampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GUARDIAN_HEART, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPAWNER_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VOLATITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONYX, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ONYX, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOTEM_BASE, Models.GENERATED);

        itemModelGenerator.register(ModItems.IRON_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_CHISEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.ONYX_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ONYX_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.ONYX_HAMMER, Models.HANDHELD);
    }
}
