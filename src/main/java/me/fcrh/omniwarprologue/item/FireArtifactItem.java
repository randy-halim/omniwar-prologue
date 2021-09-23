
package me.fcrh.omniwarprologue.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import me.fcrh.omniwarprologue.itemgroup.ArtifactTabItemGroup;
import me.fcrh.omniwarprologue.OmniwarPrologueModElements;

import java.util.List;

@OmniwarPrologueModElements.ModElement.Tag
public class FireArtifactItem extends OmniwarPrologueModElements.ModElement {
	@ObjectHolder("omniwar_prologue:fire_artifact")
	public static final Item block = null;
	public FireArtifactItem(OmniwarPrologueModElements instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ArtifactTabItemGroup.tab).maxStackSize(64).isImmuneToFire().rarity(Rarity.RARE));
			setRegistryName("fire_artifact");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("You feel the heat of the Nether pulse in your hands as you hold the artifact."));
			list.add(new StringTextComponent("Perhaps combining it with other artifacts does something..."));
		}
	}
}
