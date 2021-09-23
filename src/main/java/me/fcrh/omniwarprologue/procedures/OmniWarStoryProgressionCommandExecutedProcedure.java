package me.fcrh.omniwarprologue.procedures;

import net.minecraft.entity.Entity;

import me.fcrh.omniwarprologue.OmniwarPrologueMod;

import java.util.Map;
import java.util.HashMap;

public class OmniWarStoryProgressionCommandExecutedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				OmniwarPrologueMod.LOGGER.warn("Failed to load dependency entity for procedure OmniWarStoryProgressionCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				OmniwarPrologueMod.LOGGER.warn("Failed to load dependency cmdparams for procedure OmniWarStoryProgressionCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("war"))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							(("advancement grant ") + "" + ((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())) + "" + ("omniwar_prologue:war_advancement")));
				}
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("glitchwar"))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							(("advancement grant ") + "" + ((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())) + "" + ("omniwar_prologue:glitch_war_advancement")));
				}
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("endgame"))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							(("advancement grant ") + "" + ((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())) + "" + ("omniwar_prologue:endgame_beginning_advancement")));
				}
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("finalbattle"))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							(("advancement grant ") + "" + ((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())) + "" + ("omniwar_prologue:final_battle_advancement")));
				}
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("theend"))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							(("advancement grant ") + "" + ((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())) + "" + ("omniwar_prologue:the_end_advancement")));
				}
			}
		}
	}
}
