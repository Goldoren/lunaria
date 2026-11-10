package fr.lunaria;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

/**
 * Bâton de Lune : clic droit = vision nocturne, chute lente et saut amélioré.
 * La nuit, ses pouvoirs durent deux fois plus longtemps et il régénère aussi son porteur.
 */
public class MoonStaffItem extends Item {
	private static final int COOLDOWN_TICKS = 20 * 20;

	public MoonStaffItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack stack = user.getStackInHand(hand);

		if (!world.isClient) {
			boolean night = world.isNight();
			int seconds = night ? 120 : 60;

			user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, seconds * 20, 0));
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, seconds * 10, 0));
			user.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, seconds * 10, 1));
			if (night) {
				user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10 * 20, 0));
			}

			if (world instanceof ServerWorld serverWorld) {
				serverWorld.spawnParticles(ParticleTypes.END_ROD,
					user.getX(), user.getY() + 1.0, user.getZ(), 30, 0.5, 0.8, 0.5, 0.02);
			}
			world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_AMETHYST_CLUSTER_CHIME,
				SoundCategory.PLAYERS, 1.0f, 0.8f);

			EquipmentSlot slot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
			stack.damage(1, user, slot);
		}

		user.getItemCooldownManager().set(this, COOLDOWN_TICKS);
		return TypedActionResult.success(stack, world.isClient());
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		tooltip.add(Text.translatable("item.lunaria.moon_staff.tooltip").formatted(Formatting.AQUA));
		tooltip.add(Text.translatable("item.lunaria.moon_staff.tooltip_night").formatted(Formatting.GRAY));
	}
}
