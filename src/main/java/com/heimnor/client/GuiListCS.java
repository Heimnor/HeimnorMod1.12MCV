package com.heimnor.client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.heimnor.common.Heimnor;
import com.heimnor.packet.IMessageCSSync;
import com.heimnor.utils.NbtCsFile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants.NBT;

public class GuiListCS extends GuiScreen {

	protected GuiScreen guiScreen;
	private GuiListCS.List listClass;
	private GuiButton importButton;
	private GuiButton supprimerButton;
	private GuiButton confirmButton;
	private boolean smthgSelected;
	private boolean confirmDelete;
	private String nameSelected;
	public int idSlotSupress;

	public GuiListCS() {

		this.allowUserInput = true;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.listClass.drawScreen(mouseX, mouseY, partialTicks);

		if (this.smthgSelected == true) {
			this.drawCenteredString(fontRenderer, this.nameSelected, this.width / 2, this.height / 2 + 70, 0x01DF3A);
			this.importButton.enabled = true;
			this.supprimerButton.enabled = true;
		}
		if (this.confirmDelete == true) {
			this.buttonList.add(
					new GuiButton(2, this.width / 2 + 70, this.height / 2 + 20, 100, 20, "Confirmer la suppression"));
		}

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}

	@Override
	public void initGui() {
		this.buttonList
				.add(importButton = new GuiButton(0, this.width / 2 - 60, this.height / 2 + 90, 60, 20, "Importer"));
		this.buttonList.add(
				this.supprimerButton = new GuiButton(1, this.width / 2, this.height / 2 + 90, 60, 20, "Supprimer"));
		this.buttonList.add(this.confirmButton = new GuiButton(2, this.width / 2 + 70, this.height / 2 - 115, 140, 20,
				"Confirmer la suppression"));
		this.listClass = new GuiListCS.List();
		this.listClass.registerScrollButtons(7, 8);
		this.importButton.enabled = false;
		this.supprimerButton.enabled = false;
		this.confirmButton.enabled = false;

		super.initGui();
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		try
		{
			super.keyTyped(par1, par2);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void updateScreen() {
		super.updateScreen();

	}

	@Override
	protected void mouseClicked(int x, int y, int btn) {
		try
		{
			super.mouseClicked(x, y, btn);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		NBTTagCompound index = NbtCsFile.getData(new File("Heimnor/Joueurs.dat")).getCompoundTag("index");
		NBTTagCompound nbtJoueur = index.getCompoundTag(this.mc.player.getDisplayNameString());

		NBTTagCompound indexf = NbtCsFile.getData(new File("Heimnor/Fiches.dat")).getCompoundTag("index");
		if (button.id == 0) {

			nbtJoueur.setString("perso", this.nameSelected);
			index.setTag(this.mc.player.getDisplayNameString(), nbtJoueur);
			Heimnor.network.sendToServer(new IMessageCSSync(index, "true", this.mc.player.getDisplayNameString(), "true"));
			this.mc.displayGuiScreen(null);
			this.mc.displayGuiScreen(new FichesGui());
		}
		if (button.id == 1) {
			this.confirmButton.enabled = true;

		}

		if (button.id == 2) {

			NBTTagList tagList = indexf.getTagList("list", NBT.TAG_STRING);
			tagList.removeTag(this.idSlotSupress);
			indexf.removeTag(this.nameSelected);
			indexf.setTag("list", tagList);

			Heimnor.network.sendToServer(new IMessageCSSync(indexf, "false", this.nameSelected, "delete"));
			this.initGui();
			this.mc.displayGuiScreen(new FichesGui());

		}

		try
		{
			super.actionPerformed(button);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	class List extends GuiSlot {

		public ArrayList<String> list = new ArrayList<String>();
		public int idSlotSupress;

		public List() {
			super(Minecraft.getMinecraft(), GuiListCS.this.width, GuiListCS.this.height, 32,
					GuiListCS.this.height - 65 + 4, 20);
			NBTTagCompound index = NbtCsFile.getData(new File("Heimnor/Fiches.dat")).getCompoundTag("index");
			NBTTagList list = (NBTTagList) index.getTag("list");

			for (int i = 0; i <= list.tagCount(); i++) {

				this.list.add(list.getStringTagAt(i));
				if (this.list.contains("") || this.list.contains(" ")) {
					this.list.remove("");
					this.list.remove(" ");
				}
			}

		}

		@Override
		protected int getSize() {

			return this.list.size();
		}

		@Override
		protected void elementClicked(int idSlot, boolean flag, int mouseX, int mouseY) {

			GuiListCS.this.nameSelected = (String) this.list.get(idSlot);
			GuiListCS.this.smthgSelected = true;
			GuiListCS.this.idSlotSupress = idSlot;
		}

		@Override
		protected boolean isSelected(int p_148131_1_) {
			return false;
		}

		@Override
		protected void drawBackground() {

			GuiListCS.this.drawDefaultBackground();

		}

		@Override
		protected void drawSlot(int slotIndex, int xPos, int yPos, int heightIn, int mouseXIn, int mouseYIn,
				float partialTicks)
		{
			GuiListCS.this.drawCenteredString(fontRenderer, (String) this.list.get(slotIndex), this.width / 2,
					yPos + 1, 0xFFFFFF);
		}

	}
}
