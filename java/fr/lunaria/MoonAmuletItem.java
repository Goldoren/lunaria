package fr.lunaria;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

/** Amulette lunaire : vision nocturne permanente tant qu'elle est dans la barre d'accès rapide. */
public class MoonAmuletItem extends Item {
	public MoonAmuletItem(Settings settings) {
		super(settings);
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient && entity instanceof PlayerEntity player && slot >= 0 && slot < 9
			&& world.getTime() % 20 == 0) {
			player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 260, 0, true, false, true));
		}
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		tooltip.add(Text.translatable("item.lunaria.moon_amulet.tooltip").formatted(Formatting.AQUA));
	}
}
