package fr.lunaria;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class LunariaClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.MOON_WRAITH, MoonWraithRenderer::new);
		EntityRendererRegistry.register(ModEntities.MOON_SPIDER, MoonSpiderRenderer::new);
	}
}
