
package me.fcrh.omniwarprologue.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.CheckboxButton;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class EpilogueGUIGuiWindow extends ContainerScreen<EpilogueGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = EpilogueGUIGui.guistate;
	CheckboxButton epilogue_teaser;
	public EpilogueGUIGuiWindow(EpilogueGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	private static final ResourceLocation texture = new ResourceLocation("omniwar_prologue:textures/epilogue_gui.png");
	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "OmniWar", 123, 7, -12829636);
		this.font.drawString(ms, "Season 1: Prologue", 69, 25, -16226159);
		this.font.drawString(ms, "\"Let us go then, you and I", 6, 115, -12829636);
		this.font.drawString(ms, "When the !VOID! eats the sky", 6, 124, -12829636);
		this.font.drawString(ms, "Like a humanoid melting like", 6, 133, -12829636);
		this.font.drawString(ms, "clams upon the table.\"", 15, 142, -12829636);
		this.font.drawString(ms, "Adapted from SCP-3999", 24, 151, -8684677);
		this.font.drawString(ms, "Modpack by ", 15, 61, -12829636);
		this.font.drawString(ms, "Prologue Mod by ", 15, 70, -12829636);
		this.font.drawString(ms, "EpicOmanyte", 105, 61, -4323408);
		this.font.drawString(ms, "PUMPkinNET", 105, 70, -4323408);
		this.font.drawString(ms, "Thanks for playing :)", 33, 88, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		epilogue_teaser = new CheckboxButton(this.guiLeft + 6, this.guiTop + 7, 150, 20, new StringTextComponent("Read?"), false);
		EpilogueGUIGui.guistate.put("checkbox:epilogue_teaser", epilogue_teaser);
		this.addButton(epilogue_teaser);
	}
}
