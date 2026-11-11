package fr.lunaria;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
	// matériaux
	public static final Item RAW_MOONSTONE = register("raw_moonstone", new Item(new Item.Settings()));
	public static final Item MOONSTONE = register("moonstone", new Item(new Item.Settings()));

	// drops des monstres
	public static final Item MOON_DUST = register("moon_dust", new Item(new Item.Settings()));
	public static final Item LUNAR_ESSENCE = register("lunar_essence", new Item(new Item.Settings().rarity(Rarity.UNCOMMON)));
	public static final Item LUNAR_THREAD = register("lunar_thread", new Item(new Item.Settings()));

	// outils
	public static final Item MOONSTONE_PICKAXE = register("moonstone_pickaxe",
		new PickaxeItem(ModToolMaterials.MOONSTONE, new Item.Settings()
			.attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.MOONSTONE, 1.0f, -2.8f))));

	public static final Item MOONSTONE_AXE = register("moonstone_axe",
		new AxeItem(ModToolMaterials.MOONSTONE, new Item.Settings()
			.attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.MOONSTONE, 5.0f, -3.1f))));

	public static final Item MOONSTONE_SHOVEL = register("moonstone_shovel",
		new ShovelItem(ModToolMaterials.MOONSTONE, new Item.Settings()
			.attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.MOONSTONE, 1.5f, -3.0f))));

	public static final Item MOONSTONE_HOE = register("moonstone_hoe",
		new HoeItem(ModToolMaterials.MOONSTONE, new Item.Settings()
			.attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.MOONSTONE, -2.0f, -1.0f))));

	// armes
	public static final Item MOONSTONE_SWORD = register("moonstone_sword",
		new SwordItem(ModToolMaterials.MOONSTONE, new Item.Settings()
			.attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.MOONSTONE, 3, -2.4f))));

	public static final Item SPECTRAL_BLADE = register("spectral_blade",
		new SpectralBladeItem(ModToolMaterials.MOONSTONE, new Item.Settings().rarity(Rarity.UNCOMMON)
			.attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.MOONSTONE, 4, -2.4f))));

	// objets spéciaux
	public static final Item MOON_STAFF = register("moon_staff",
		new MoonStaffItem(new Item.Settings().maxDamage(MoonStaffItem.MAX_CHARGE).rarity(Rarity.RARE)));

	public static final Item MOON_AMULET = register("moon_amulet",
		new MoonAmuletItem(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON)));

	public static final Item MOON_APPLE = register("moon_apple",
		new Item(new Item.Settings().rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder()
			.nutrition(6).saturationModifier(0.8f).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0f)
			.statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 600, 0), 1.0f)
			.build())));

	// oeufs d'apparition
	public static final Item MOON_WRAITH_SPAWN_EGG = register("moon_wraith_spawn_egg",
		new SpawnEggItem(ModEntities.MOON_WRAITH, 0x9AC4F5, 0x2C3670, new Item.Settings()));

	public static final Item MOON_SPIDER_SPAWN_EGG = register("moon_spider_spawn_egg",
		new SpawnEggItem(ModEntities.MOON_SPIDER, 0x1E244C, 0x6E96E6, new Item.Settings()));

	private static Item register(String name, Item item) {
		return Registry.register(Registries.ITEM, Identifier.of(Lunaria.MOD_ID, name), item);
	}

	public static void register() {
		Lunaria.LOGGER.debug("Objets Lunaria enregistrés");
	}
}
