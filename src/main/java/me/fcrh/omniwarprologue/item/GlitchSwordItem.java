
package me.fcrh.omniwarprologue.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import me.fcrh.omniwarprologue.itemgroup.OmniWarTabItemGroup;
import me.fcrh.omniwarprologue.OmniwarPrologueModElements;

@OmniwarPrologueModElements.ModElement.Tag
public class GlitchSwordItem extends OmniwarPrologueModElements.ModElement {
	@ObjectHolder("omniwar_prologue:glitch_sword")
	public static final Item block = null;
	public GlitchSwordItem(OmniwarPrologueModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(OmniWarTabItemGroup.tab).isImmuneToFire()) {
		}.setRegistryName("glitch_sword"));
	}
}
