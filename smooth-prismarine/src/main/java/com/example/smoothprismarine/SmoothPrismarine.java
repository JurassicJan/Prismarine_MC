package com.example.smoothprismarine;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmoothPrismarine implements ModInitializer {
	public static final String MOD_ID = "smoothprismarine";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.init();

		// Im Kreativmenue hinter die Prismarin-Mauer einsortieren.
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output ->
			output.insertAfter(
				Items.PRISMARINE_WALL,
				ModBlocks.SMOOTH_PRISMARINE,
				ModBlocks.SMOOTH_PRISMARINE_STAIRS,
				ModBlocks.SMOOTH_PRISMARINE_SLAB,
				ModBlocks.SMOOTH_PRISMARINE_WALL,
				ModBlocks.SMOOTH_DARK_PRISMARINE,
				ModBlocks.SMOOTH_DARK_PRISMARINE_STAIRS,
				ModBlocks.SMOOTH_DARK_PRISMARINE_SLAB,
				ModBlocks.SMOOTH_DARK_PRISMARINE_WALL
			)
		);

		LOGGER.info("Smooth Prismarine geladen.");
	}
}
