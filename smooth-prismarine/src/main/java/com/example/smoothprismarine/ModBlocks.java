package com.example.smoothprismarine;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public final class ModBlocks {
	public static final Block SMOOTH_PRISMARINE = register("smooth_prismarine", MapColor.DIAMOND);
	public static final Block SMOOTH_DARK_PRISMARINE = register("smooth_dark_prismarine", MapColor.DIAMOND);

	private ModBlocks() {
	}

	private static Block register(String name, MapColor color) {
		Identifier id = Identifier.fromNamespaceAndPath(SmoothPrismarine.MOD_ID, name);

		// Eigenschaften wie normales Prismarine: Spitzhacke noetig, Haerte 1.5, Widerstand 6.0.
		ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);
		Block block = new Block(BlockBehaviour.Properties.of()
			.setId(blockKey)
			.mapColor(color)
			.instrument(NoteBlockInstrument.BASEDRUM)
			.sound(SoundType.STONE)
			.requiresCorrectToolForDrops()
			.strength(1.5F, 6.0F));
		Registry.register(BuiltInRegistries.BLOCK, id, block);

		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);
		BlockItem item = new BlockItem(block, new Item.Properties()
			.setId(itemKey)
			.useBlockDescriptionPrefix());
		Registry.register(BuiltInRegistries.ITEM, id, item);

		return block;
	}

	/** Erzwingt das Laden der Klasse (und damit die Registrierung) beim Mod-Start. */
	public static void init() {
	}
}
