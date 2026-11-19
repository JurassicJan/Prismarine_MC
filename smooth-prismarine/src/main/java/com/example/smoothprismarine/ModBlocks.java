package com.example.smoothprismarine;

import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public final class ModBlocks {
	// Vollbloecke
	public static final Block SMOOTH_PRISMARINE = register("smooth_prismarine", Block::new, baseProperties());
	public static final Block SMOOTH_DARK_PRISMARINE = register("smooth_dark_prismarine", Block::new, baseProperties());

	// Smooth Prismarine: Treppe, Stufe, Mauer
	public static final Block SMOOTH_PRISMARINE_STAIRS = register("smooth_prismarine_stairs",
		p -> new StairBlock(SMOOTH_PRISMARINE.defaultBlockState(), p),
		BlockBehaviour.Properties.ofFullCopy(SMOOTH_PRISMARINE));
	public static final Block SMOOTH_PRISMARINE_SLAB = register("smooth_prismarine_slab",
		SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(SMOOTH_PRISMARINE));
	public static final Block SMOOTH_PRISMARINE_WALL = register("smooth_prismarine_wall",
		WallBlock::new, BlockBehaviour.Properties.ofFullCopy(SMOOTH_PRISMARINE).forceSolidOn());

	// Smooth Dark Prismarine: Treppe, Stufe, Mauer
	public static final Block SMOOTH_DARK_PRISMARINE_STAIRS = register("smooth_dark_prismarine_stairs",
		p -> new StairBlock(SMOOTH_DARK_PRISMARINE.defaultBlockState(), p),
		BlockBehaviour.Properties.ofFullCopy(SMOOTH_DARK_PRISMARINE));
	public static final Block SMOOTH_DARK_PRISMARINE_SLAB = register("smooth_dark_prismarine_slab",
		SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(SMOOTH_DARK_PRISMARINE));
	public static final Block SMOOTH_DARK_PRISMARINE_WALL = register("smooth_dark_prismarine_wall",
		WallBlock::new, BlockBehaviour.Properties.ofFullCopy(SMOOTH_DARK_PRISMARINE).forceSolidOn());

	private ModBlocks() {
	}

	/** Eigenschaften wie normales Prismarine: Spitzhacke noetig, Haerte 1.5, Widerstand 6.0. */
	private static BlockBehaviour.Properties baseProperties() {
		return BlockBehaviour.Properties.of()
			.mapColor(MapColor.DIAMOND)
			.instrument(NoteBlockInstrument.BASEDRUM)
			.sound(SoundType.STONE)
			.requiresCorrectToolForDrops()
			.strength(1.5F, 6.0F);
	}

	private static Block register(String name, Function<BlockBehaviour.Properties, Block> factory,
			BlockBehaviour.Properties properties) {
		Identifier id = Identifier.fromNamespaceAndPath(SmoothPrismarine.MOD_ID, name);

		ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);
		Block block = factory.apply(properties.setId(blockKey));
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
