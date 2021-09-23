
package me.fcrh.omniwarprologue.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import me.fcrh.omniwarprologue.item.NullCoreArtifactItem;
import me.fcrh.omniwarprologue.OmniwarPrologueModElements;

@OmniwarPrologueModElements.ModElement.Tag
public class GlitchTabItemGroup extends OmniwarPrologueModElements.ModElement {
	public GlitchTabItemGroup(OmniwarPrologueModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabglitch_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(NullCoreArtifactItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
