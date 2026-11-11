package fr.lunaria;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SpiderEntityRenderer;
import net.minecraft.util.Identifier;

public class MoonSpiderRenderer extends SpiderEntityRenderer<MoonSpiderEntity> {
	private static final Identifier TEXTURE = Identifier.of(Lunaria.MOD_ID, "textures/entity/moon_spider.png");

	public MoonSpiderRenderer(EntityRendererFactory.Context context) {
		super(context);
	}

	@Override
	public Identifier getTexture(MoonSpiderEntity entity) {
		return TEXTURE;
	}
}
