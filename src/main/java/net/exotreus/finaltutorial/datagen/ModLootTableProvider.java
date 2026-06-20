package net.exotreus.finaltutorial.datagen;

import net.exotreus.finaltutorial.block.ModBlocks;
import net.exotreus.finaltutorial.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.VOLATITE_BLOCK);
        addDrop(ModBlocks.MAGIC_BLOCK);

        addDrop(ModBlocks.VOLATITE_STAIRS);
        addDrop(ModBlocks.VOLATITE_SLAB, slabDrops(ModBlocks.VOLATITE_SLAB));

        addDrop(ModBlocks.VOLATITE_BUTTON);
        addDrop(ModBlocks.VOLATITE_PRESSURE_PLATE);

        addDrop(ModBlocks.VOLATITE_FENCE);
        addDrop(ModBlocks.VOLATITE_FENCE_GATE);
        addDrop(ModBlocks.VOLATITE_WALL);
        
        addDrop(ModBlocks.VOLATITE_DOOR, doorDrops(ModBlocks.VOLATITE_DOOR));
        addDrop(ModBlocks.VOLATITE_TRAPDOOR);

        addDrop(ModBlocks.VOLATITE_ORE, multipleOreDrops(ModBlocks.VOLATITE_ORE, ModItems.VOLATITE, 1, 2));
        addDrop(ModBlocks.DEEPSLATE_VOLATITE_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_VOLATITE_ORE, ModItems.VOLATITE, 1, 2));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
