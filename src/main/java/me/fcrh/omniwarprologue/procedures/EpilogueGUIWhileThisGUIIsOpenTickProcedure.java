package me.fcrh.omniwarprologue.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import me.fcrh.omniwarprologue.OmniwarPrologueMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

public class EpilogueGUIWhileThisGUIIsOpenTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OmniwarPrologueMod.LOGGER.warn("Failed to load dependency entity for procedure EpilogueGUIWhileThisGUIIsOpenTick!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				OmniwarPrologueMod.LOGGER.warn("Failed to load dependency guistate for procedure EpilogueGUIWhileThisGUIIsOpenTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if ((new Object() {
			public boolean getValue() {
				CheckboxButton checkbox = (CheckboxButton) guistate.get("checkbox:epilogue_teaser");
				if (checkbox != null) {
					return checkbox.isChecked();
				}
				return false;
			}
		}.getValue())) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("omniwar_prologue:season_two_teaser"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
	}
}
