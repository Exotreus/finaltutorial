package net.exotreus.finaltutorial.util;

import net.exotreus.finaltutorial.FinalTutorial;
import net.exotreus.finaltutorial.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModFuels {
    public static void registerModFuels() {
        FinalTutorial.LOGGER.info("Registering Fuels for " + FinalTutorial.MOD_ID);

        FuelRegistry.INSTANCE.add(ModItems.TOTEM_BASE, 800);
    }
}