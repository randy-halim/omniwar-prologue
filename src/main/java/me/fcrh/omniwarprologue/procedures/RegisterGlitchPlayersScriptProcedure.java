package me.fcrh.omniwarprologue.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import me.fcrh.omniwarprologue.OmniwarPrologueMod;

import java.util.Map;

public class RegisterGlitchPlayersScriptProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OmniwarPrologueMod.LOGGER.warn("Failed to load dependency entity for procedure RegisterGlitchPlayersScript!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"team join Glitches @s");
			}
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Registered yourself in Glitch Players!"), (true));
		}
	}
}
