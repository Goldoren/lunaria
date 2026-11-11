package fr.lunaria;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
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
 * Il possède une barre d'énergie lunaire (toujours visible) : chaque utilisation coûte 8 points,
 * et il se recharge tout seul dans l'inventaire (3 fois plus vite la nuit). Il ne casse jamais.
 */
public class MoonStaffItem extends Item {
	public static final int MAX_CHARGE = 64;
	private static final int COST = 8;
	private static final int COOLDOWN_TICKS = 20 * 3;

	public MoonStaffItem(Settings settings) {
		super(settings);
	}

	private static int charge(ItemStack stack) {
		return stack.getMaxDamage() - stack.getDamage();
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack stack = user.getStackInHand(hand);

		if (charge(stack) < COST) {
			if (!world.isClient) {
				user.sendMessage(Text.translatable("item.lunaria.moon_staff.empty").formatted(Formatting.RED), true);
			}
			return TypedActionResult.fail(stack);
		}

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
			world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME,
				SoundCategory.PLAYERS, 1.0f, 0.8f);

			stack.setDamage(stack.getDamage() + COST);
		}

		user.getItemCooldownManager().set(this, COOLDOWN_TICKS);
		return TypedActionResult.success(stack, world.isClient());
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient && stack.getDamage() > 0) {
			int interval = world.isNight() ? 100 : 300;
			if (world.getTime() % interval == 0) {
				stack.setDamage(stack.getDamage() - 1);
			}
		}
	}

	// ----- barre d'énergie lunaire -----
	@Override
	public boolean isItemBarVisible(ItemStack stack) {
		return true;
	}

	@Override
	public int getItemBarStep(ItemStack stack) {
		return Math.round(13.0f * charge(stack) / stack.getMaxDamage());
	}

	@Override
	public int getItemBarColor(ItemStack stack) {
		return 0x6FA8FF;
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		tooltip.add(Text.translatable("item.lunaria.moon_staff.tooltip").formatted(Formatting.AQUA));
		tooltip.add(Text.translatable("item.lunaria.moon_staff.tooltip_night").formatted(Formatting.GRAY));
		tooltip.add(Text.translatable("item.lunaria.moon_staff.charge", charge(stack), stack.getMaxDamage())
			.formatted(Formatting.BLUE));
	}
}
