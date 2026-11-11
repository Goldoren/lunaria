package fr.lunaria;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
	public static final ItemGroup LUNARIA = Registry.register(Registries.ITEM_GROUP,
		Identifier.of(Lunaria.MOD_ID, "lunaria"),
		FabricItemGroup.builder()
			.icon(() -> new ItemStack(ModItems.MOON_STAFF))
			.displayName(Text.translatable("itemGroup.lunaria"))
			.entries((context, entries) -> {
				entries.add(ModBlocks.MOONSTONE_ORE);
				entries.add(ModItems.RAW_MOONSTONE);
				entries.add(ModItems.MOONSTONE);
				entries.add(ModBlocks.MOONSTONE_BLOCK);
				entries.add(ModBlocks.MOON_LAMP);
				entries.add(ModBlocks.MOON_DUST_BLOCK);
				entries.add(ModItems.MOON_DUST);
				entries.add(ModItems.LUNAR_ESSENCE);
				entries.add(ModItems.LUNAR_THREAD);
				entries.add(ModItems.MOONSTONE_PICKAXE);
				entries.add(ModItems.MOONSTONE_AXE);
				entries.add(ModItems.MOONSTONE_SHOVEL);
				entries.add(ModItems.MOONSTONE_HOE);
				entries.add(ModItems.MOONSTONE_SWORD);
				entries.add(ModItems.SPECTRAL_BLADE);
				entries.add(ModItems.MOON_STAFF);
				entries.add(ModItems.MOON_AMULET);
				entries.add(ModItems.MOON_APPLE);
				entries.add(ModItems.MOON_WRAITH_SPAWN_EGG);
				entries.add(ModItems.MOON_SPIDER_SPAWN_EGG);
			})
			.build());

	public static void register() {
		Lunaria.LOGGER.debug("Onglet créatif Lunaria enregistré");
	}
}
