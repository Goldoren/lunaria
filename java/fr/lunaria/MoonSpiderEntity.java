package fr.lunaria;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.world.World;

/** Araignée lunaire : plus résistante qu'une araignée normale, elle hante les obélisques. */
public class MoonSpiderEntity extends SpiderEntity {
	public MoonSpiderEntity(EntityType<? extends SpiderEntity> type, World world) {
		super(type, world);
	}

	public static DefaultAttributeContainer.Builder createMoonAttributes() {
		return SpiderEntity.createSpiderAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 24.0)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0);
	}
}
