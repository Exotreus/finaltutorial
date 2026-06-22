package net.exotreus.finaltutorial.item;

import net.exotreus.finaltutorial.FinalTutorial;
import net.exotreus.finaltutorial.item.custom.ChiselItem;
import net.exotreus.finaltutorial.item.custom.HammerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
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

    public static final Item ONYX = registerItem("onyx",
            new Item(new Item.Settings()));

    public static final Item RAW_ONYX = registerItem("raw_onyx",
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

    public static final Item ONYX_SWORD = registerItem("onyx_sword",
            new SwordItem(ModToolMaterials.ONYX, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ONYX, 3, -2.4F))));

    public static final Item ONYX_PICKAXE = registerItem("onyx_pickaxe",
            new PickaxeItem(ModToolMaterials.ONYX, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ONYX, 1, -2.8F))));

    public static final Item ONYX_AXE = registerItem("onyx_axe",
            new AxeItem(ModToolMaterials.ONYX, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ONYX, 6, -3.2F))));

    public static final Item ONYX_SHOVEL = registerItem("onyx_shovel",
            new ShovelItem(ModToolMaterials.ONYX, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ONYX, 1.5F, -3.0F))));

    public static final Item ONYX_HOE = registerItem("onyx_hoe",
            new HoeItem(ModToolMaterials.ONYX, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ONYX, 0, -3.0F))));

    public static final Item ONYX_HAMMER = registerItem("onyx_hammer",
            new HammerItem(ModToolMaterials.ONYX, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ONYX, 6, -4.0F))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FinalTutorial.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FinalTutorial.LOGGER.info("Registering Items for " + FinalTutorial.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(VOLATITE);
            entries.add(SPAWNER_FRAGMENT);
            entries.add(ONYX);
            entries.add(RAW_ONYX);
            entries.add(TOTEM_BASE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(GUARDIAN_HEART));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(IRON_CHISEL);
            entries.add(DIAMOND_CHISEL);
            entries.add(NETHERITE_CHISEL);

            entries.add(ONYX_SWORD);
            entries.add(ONYX_PICKAXE);
            entries.add(ONYX_AXE);
            entries.add(ONYX_SHOVEL);
            entries.add(ONYX_HOE);

            entries.add(ONYX_HAMMER);
        });
    }
}
