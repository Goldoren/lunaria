package fr.lunaria;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
	// niveau "fer", plus rapide et plus enchantable
	MOONSTONE(BlockTags.INCORRECT_FOR_IRON_TOOL, 700, 7.0f, 2.5f, 18,
		() -> Ingredient.ofItems(ModItems.MOONSTONE));

	private final TagKey<Block> inverseTag;
	private final int durability;
	private final float miningSpeed;
	private final float attackDamage;
	private final int enchantability;
	private final Supplier<Ingredient> repairIngredient;

	ModToolMaterials(TagKey<Block> inverseTag, int durability, float miningSpeed,
					 float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
		this.inverseTag = inverseTag;
		this.durability = durability;
		this.miningSpeed = miningSpeed;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairIngredient = repairIngredient;
	}

	@Override public int getDurability() { return durability; }
	@Override public float getMiningSpeedMultiplier() { return miningSpeed; }
	@Override public float getAttackDamage() { return attackDamage; }
	@Override public TagKey<Block> getInverseTag() { return inverseTag; }
	@Override public int getEnchantability() { return enchantability; }
	@Override public Ingredient getRepairIngredient() { return repairIngredient.get(); }
}
