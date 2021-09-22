
package me.fcrh.omniwarprologue.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import me.fcrh.omniwarprologue.OmniwarPrologueModElements;

@OmniwarPrologueModElements.ModElement.Tag
public class OmniWarTabItemGroup extends OmniwarPrologueModElements.ModElement {
	public OmniWarTabItemGroup(OmniwarPrologueModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabomni_war_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.IRON_SWORD);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
