package fr.lunaria;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
	public static final Item RAW_MOONSTONE = register("raw_moonstone", new Item(new Item.Settings()));
	public static final Item MOONSTONE = register("moonstone", new Item(new Item.Settings()));

	public static final Item MOONSTONE_PICKAXE = register("moonstone_pickaxe",
		new PickaxeItem(ModToolMaterials.MOONSTONE, new Item.Settings()
			.attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.MOONSTONE, 1.0f, -2.8f))));

	public static final Item MOONSTONE_SWORD = register("moonstone_sword",
		new SwordItem(ModToolMaterials.MOONSTONE, new Item.Settings()
			.attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.MOONSTONE, 3, -2.4f))));

	public static final Item MOON_STAFF = register("moon_staff",
		new MoonStaffItem(new Item.Settings().maxDamage(64).rarity(Rarity.RARE)));

	private static Item register(String name, Item item) {
		return Registry.register(Registries.ITEM, Identifier.of(Lunaria.MOD_ID, name), item);
	}

	public static void register() {
		Lunaria.LOGGER.debug("Objets Lunaria enregistrés");
	}
}
