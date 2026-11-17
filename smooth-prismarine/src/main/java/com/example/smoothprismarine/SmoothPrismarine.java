package com.example.smoothprismarine;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
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

		// Im Kreativmenue direkt nach den Dark-Prismarine-Bloecken einsortieren.
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries ->
			entries.addAfter(
				Items.DARK_PRISMARINE,
				ModBlocks.SMOOTH_PRISMARINE.asItem(),
				ModBlocks.SMOOTH_DARK_PRISMARINE.asItem()
			)
		);

		LOGGER.info("Smooth Prismarine geladen.");
	}
}
