package fr.lunaria;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
	public static final EntityType<MoonWraithEntity> MOON_WRAITH = Registry.register(
		Registries.ENTITY_TYPE, Identifier.of(Lunaria.MOD_ID, "moon_wraith"),
		EntityType.Builder.create(MoonWraithEntity::new, SpawnGroup.MONSTER)
			.dimensions(0.6f, 1.95f).maxTrackingRange(8).fireImmune()
			.build("moon_wraith"));

	public static final EntityType<MoonSpiderEntity> MOON_SPIDER = Registry.register(
		Registries.ENTITY_TYPE, Identifier.of(Lunaria.MOD_ID, "moon_spider"),
		EntityType.Builder.create(MoonSpiderEntity::new, SpawnGroup.MONSTER)
			.dimensions(1.4f, 0.9f).maxTrackingRange(8)
			.build("moon_spider"));

	public static void register() {
		FabricDefaultAttributeRegistry.register(MOON_WRAITH, MoonWraithEntity.createMoonAttributes());
		FabricDefaultAttributeRegistry.register(MOON_SPIDER, MoonSpiderEntity.createMoonAttributes());
	}
}
