
package me.fcrh.omniwarprologue.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;

import me.fcrh.omniwarprologue.procedures.ElementalBladePassiveProcedure;
import me.fcrh.omniwarprologue.itemgroup.ArtifactTabItemGroup;
import me.fcrh.omniwarprologue.OmniwarPrologueModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@OmniwarPrologueModElements.ModElement.Tag
public class ElementalBladeItem extends OmniwarPrologueModElements.ModElement {
	@ObjectHolder("omniwar_prologue:elemental_blade")
	public static final Item block = null;
	public ElementalBladeItem(OmniwarPrologueModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 4096;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(FireArtifactItem.block), new ItemStack(WaterArtifactItem.block));
			}
		}, 3, -3f, new Item.Properties().group(ArtifactTabItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent(
						"The four elements forged with the power of the Netherite sword to form the Elemental Blade,a blade only mentioned in the legends..."));
				list.add(new StringTextComponent("You feel the elements empower you when you wield it."));
			}

			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (selected) {
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ElementalBladePassiveProcedure.executeProcedure($_dependencies);
				}
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("elemental_blade"));
	}
}
