package net.exotreus.finaltutorial;

import net.exotreus.finaltutorial.block.ModBlocks;
import net.exotreus.finaltutorial.component.ModDataComponentTypes;
import net.exotreus.finaltutorial.item.ModItemGroups;
import net.exotreus.finaltutorial.item.ModItems;
import net.exotreus.finaltutorial.util.HammerUsageEvent;
import net.exotreus.finaltutorial.util.ModFuels;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinalTutorial implements ModInitializer {
	public static final String MOD_ID = "finaltutorial";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		ModFuels.registerModFuels();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}