package fr.lunaria;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
	public static final Block MOONSTONE_ORE = register("moonstone_ore",
		new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
			AbstractBlock.Settings.copy(Blocks.IRON_ORE).strength(3.0f, 3.0f)));

	public static final Block MOONSTONE_BLOCK = register("moonstone_block",
		new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(4.0f, 6.0f)));

	public static final Block MOON_LAMP = register("moon_lamp",
		new Block(AbstractBlock.Settings.copy(Blocks.GLOWSTONE)
			.strength(0.5f)
			.sounds(BlockSoundGroup.GLASS)
			.luminance(state -> 15)));

	private static Block register(String name, Block block) {
		Identifier id = Identifier.of(Lunaria.MOD_ID, name);
		Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
		return Registry.register(Registries.BLOCK, id, block);
	}

	public static void register() {
		Lunaria.LOGGER.debug("Blocs Lunaria enregistrés");
	}
}
