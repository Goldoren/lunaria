package fr.lunaria;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModWorldGen {
	public static final RegistryKey<PlacedFeature> MOONSTONE_ORE_PLACED =
		RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Lunaria.MOD_ID, "moonstone_ore"));

	public static void register() {
		// Les définitions du filon sont dans data/lunaria/worldgen/
		BiomeModifications.addFeature(
			BiomeSelectors.foundInOverworld(),
			GenerationStep.Feature.UNDERGROUND_ORES,
			MOONSTONE_ORE_PLACED);
	}
}
