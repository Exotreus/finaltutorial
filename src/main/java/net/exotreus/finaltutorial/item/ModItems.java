package net.exotreus.finaltutorial.item;

import net.exotreus.finaltutorial.FinalTutorial;
import net.exotreus.finaltutorial.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item GUARDIAN_HEART = registerItem("guardian_heart",
            new Item(new Item.Settings()
                    .food(ModFoodComponents.GUARDIAN_HEART)));

    public static final Item SPAWNER_FRAGMENT = registerItem("spawner_fragment",
            new Item(new Item.Settings()
                    .rarity(Rarity.UNCOMMON)));

    public static final Item VOLATITE = registerItem("volatite",
            new Item(new Item.Settings()));

    public static final Item TOTEM_BASE = registerItem("totem_base",
            new Item(new Item.Settings()));

    public static final Item IRON_CHISEL = registerItem("iron_chisel",
            new ChiselItem(new Item.Settings()
                    .maxDamage(250)));

    public static final Item DIAMOND_CHISEL = registerItem("diamond_chisel",
            new ChiselItem(new Item.Settings()
                    .maxDamage(1561)));

    public static final Item NETHERITE_CHISEL = registerItem("netherite_chisel",
            new ChiselItem(new Item.Settings()
                    .maxDamage(2031)
                    .fireproof()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FinalTutorial.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FinalTutorial.LOGGER.info("Registering Items for " + FinalTutorial.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(VOLATITE);
            entries.add(SPAWNER_FRAGMENT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(GUARDIAN_HEART));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(IRON_CHISEL);
            entries.add(DIAMOND_CHISEL);
            entries.add(NETHERITE_CHISEL);
            entries.add(TOTEM_BASE);
        });
    }
}
