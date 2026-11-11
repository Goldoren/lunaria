package fr.lunaria;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lunaria implements ModInitializer {
	public static final String MOD_ID = "lunaria";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.register();
		ModEntities.register();
		ModItems.register();
		ModItemGroups.register();
		ModWorldGen.register();
		LOGGER.info("Lunaria 1.1 est chargé : que la lune soit avec toi !");
	}
}
