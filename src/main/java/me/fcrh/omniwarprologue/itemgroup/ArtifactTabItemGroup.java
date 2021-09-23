
package me.fcrh.omniwarprologue.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import me.fcrh.omniwarprologue.item.FireArtifactItem;
import me.fcrh.omniwarprologue.OmniwarPrologueModElements;

@OmniwarPrologueModElements.ModElement.Tag
public class ArtifactTabItemGroup extends OmniwarPrologueModElements.ModElement {
	public ArtifactTabItemGroup(OmniwarPrologueModElements instance) {
		super(instance, 18);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabartifact_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(FireArtifactItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
