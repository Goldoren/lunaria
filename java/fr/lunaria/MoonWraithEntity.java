package fr.lunaria;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

/** Spectre lunaire : un mort-vivant pâle, insensible au feu, qui garde les sanctuaires. */
public class MoonWraithEntity extends ZombieEntity {
	public MoonWraithEntity(EntityType<? extends ZombieEntity> type, World world) {
		super(type, world);
	}

	public static DefaultAttributeContainer.Builder createMoonAttributes() {
		return ZombieEntity.createZombieAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.26)
			.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0);
	}
}
