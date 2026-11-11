package fr.lunaria;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

public class MoonWraithRenderer extends ZombieEntityRenderer {
	private static final Identifier TEXTURE = Identifier.of(Lunaria.MOD_ID, "textures/entity/moon_wraith.png");

	public MoonWraithRenderer(EntityRendererFactory.Context context) {
		super(context);
	}

	@Override
	public Identifier getTexture(ZombieEntity entity) {
		return TEXTURE;
	}
}
