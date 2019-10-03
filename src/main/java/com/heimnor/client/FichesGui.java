package com.heimnor.client;

import java.io.File;
import java.io.IOException;

import org.lwjgl.opengl.GL11;

import com.heimnor.common.Heimnor;
import com.heimnor.gui.GuiTextFieldInt;
import com.heimnor.packet.IMessageCSSync;
import com.heimnor.utils.NbtCsFile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class FichesGui extends GuiScreen {

	private GuiTextField nomRPtext;
	private GuiTextField peuple;

	private GuiTextFieldInt pv;
	private GuiTextFieldInt moral;
	private GuiTextFieldInt prodige;
	private GuiTextFieldInt force;
	private GuiTextFieldInt agilite;
	private GuiTextFieldInt esprit;
	private GuiTextFieldInt erudition;
	private GuiTextFieldInt presence;
	private GuiTextFieldInt discours;
	private GuiTextFieldInt volonte;
	private GuiTextFieldInt melee;
	private GuiTextFieldInt distance;
	private GuiTextFieldInt discretion;
	private GuiTextFieldInt veulerie;
	private GuiTextFieldInt faune;
	private GuiTextFieldInt medecine;
	private GuiTextFieldInt alchimie;
	private GuiTextFieldInt litterature;
	private GuiTextFieldInt persuasion;
	private GuiTextFieldInt negociation;
	private GuiTextFieldInt comprehension;
	private GuiTextFieldInt forge;
	private GuiTextFieldInt cuisine;
	private GuiTextFieldInt hommedupays;
	private GuiTextFieldInt maitredoeuvre;
	private GuiTextFieldInt commandement;
	private GuiTextFieldInt intendance;
	private GuiTextFieldInt blessuresText;

	private GuiButton modifyButton;
	private GuiButton saveButton;
	private GuiButton iPlus;
	private GuiButton iMinus;
	private GuiButton pvPlus;
	private GuiButton pvMinus;
	private GuiButton moralPlus;
	private GuiButton moralMinus;
	private GuiButton prodigePlus;
	private GuiButton prodigeMinus;
	private GuiButton blessuresPlus;
	private GuiButton blessuresMinus;

	private int i = 0;
	private int maluspv;
	private int malusmoral;
	private int malusprodige;
	private int blessures;
	private String peupleSelect;
	private boolean modif;

	String playerName = Minecraft.getMinecraft().player.getDisplayNameString();

	NBTTagCompound indexj = NbtCsFile.getData(new File("Heimnor/Joueurs.dat")).getCompoundTag("index");
	NBTTagCompound jCompound = indexj.getCompoundTag(playerName);
	String persoName = jCompound.getString("perso");

	NBTTagCompound indexf = NbtCsFile.getData(new File("Heimnor/Fiches.dat")).getCompoundTag("index");
	NBTTagCompound compound = indexf.getCompoundTag(persoName);

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();

		int pix = width / 2 + 45;
		int pixh = height / 2 - 15;

		mc.renderEngine.bindTexture(new ResourceLocation(Heimnor.MODID + ":textures/gui/backgroundh.png"));
		float scale = 1.79F;
		GL11.glPushMatrix();
		GL11.glScalef(scale, scale, scale);
		this.drawTexturedModalRect(pix - 281, pixh - 98, 0, 0, 256, 220);
		GL11.glPopMatrix();
		this.pv.drawTextBox();
		this.nomRPtext.drawTextBox();
		this.moral.drawTextBox();
		this.peuple.drawTextBox();
		this.prodige.drawTextBox();
		this.force.drawTextBox();
		this.agilite.drawTextBox();
		this.esprit.drawTextBox();
		this.erudition.drawTextBox();
		this.presence.drawTextBox();
		this.discours.drawTextBox();
		this.volonte.drawTextBox();
		this.melee.drawTextBox();
		this.distance.drawTextBox();
		this.discretion.drawTextBox();
		this.veulerie.drawTextBox();
		this.faune.drawTextBox();
		this.medecine.drawTextBox();
		this.alchimie.drawTextBox();
		this.litterature.drawTextBox();
		this.persuasion.drawTextBox();
		this.negociation.drawTextBox();
		this.comprehension.drawTextBox();
		this.forge.drawTextBox();
		this.maitredoeuvre.drawTextBox();
		this.cuisine.drawTextBox();
		this.intendance.drawTextBox();
		this.hommedupays.drawTextBox();
		this.commandement.drawTextBox();
		this.blessuresText.drawTextBox(); 
		this.fontRenderer.drawString("Nom RP :", width / 2 - 65 - this.fontRenderer.getStringWidth("Nom RP :"),
				height / 2 - 119, 0xFFFFFF, true);

		this.fontRenderer.drawString("PV :", pix - 255, pixh - 51, 0xFFFFFF, true);
		this.fontRenderer.drawString("Peuple :", pix - 215, pixh - 75, 0xFFFFFF, true);
		this.fontRenderer.drawString("Moral :", pix - 255, pixh - 27, 0xFFFFFF, true);
		this.fontRenderer.drawString("Prodiges :", pix - 255, pixh - 3, 0xFFFFFF, true);
		this.fontRenderer.drawString("Force :", pix - 130, pixh - 51, 0xFE2E2E, true);
		this.fontRenderer.drawString("Agilite :", pix - 130, pixh - 27, 0xFE2E2E, true);
		this.fontRenderer.drawString("Esprit :", pix - 130, pixh - 3, 0x0080FF, true);
		this.fontRenderer.drawString("Erudition :", pix - 130, pixh + 21, 0x0080FF, true);
		this.fontRenderer.drawString("Presence :", pix - 130, pixh + 45, 0x04B404, true);
		this.fontRenderer.drawString("Discours :", pix - 130, pixh + 69, 0x04B404, true);
		this.fontRenderer.drawString("Volonte :", pix - 130, pixh + 93, 0xFFFF00, true);

		this.fontRenderer.drawString("Melee :", pix - 42, pixh - 75, 0xFFFFFF, true);
		this.fontRenderer.drawString("Distance :", pix - 42, pixh - 51, 0xFFFFFF, true);
		this.fontRenderer.drawString("Discretion :", pix - 42, pixh - 27, 0xFFFFFF, true);
		this.fontRenderer.drawString("Veulerie :", pix - 42, pixh - 3, 0xFFFFFF, true);
		this.fontRenderer.drawString("Faune :", pix - 42, pixh + 21, 0xFFFFFF, true);
		this.fontRenderer.drawString("Medecine :", pix - 42, pixh + 45, 0xFFFFFF, true);
		this.fontRenderer.drawString("Alchimie :", pix - 42, pixh + 93, 0xFFFFFF, true);
		this.fontRenderer.drawString("Litterature :", pix + 48, pixh - 51, 0xFFFFFF, true);
		this.fontRenderer.drawString("Persuasion :", pix + 48, pixh - 27, 0xFFFFFF, true);
		this.fontRenderer.drawString("Negociation :", pix + 48, pixh - 3, 0xFFFFFF, true);
		this.fontRenderer.drawString("Comprehension :", pix + 48, pixh + 21, 0xFFFFFF, true);
		this.fontRenderer.drawString("Forge :", pix + 48, pixh + 45, 0xFFFFFF, true);
		this.fontRenderer.drawString("Cuisine :", pix - 42, pixh + 69, 0xFFFFFF, true);
		this.fontRenderer.drawString("Commandement :", pix + 48, pixh - 75, 0xFFFFFF, true); // pix + 48, pixh + 45
		this.fontRenderer.drawString("Homme du Pays :", pix + 48, pixh + 93, 0xFFFFFF, true);
		this.fontRenderer.drawString("Maitre d'oeuvre :", pix + 48, pixh + 69, 0xFFFFFF, true);
		this.fontRenderer.drawString("Intendance :", pix + 48, pixh + 117, 0xFFFFFF, true);
		this.fontRenderer.drawString("Blessures :", pix - 255, pixh + 21, 0xFFFFFF, true);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}

	@Override
	public void initGui() {

		this.drawTextBoxes();
		this.modif = false;

	}

	@Override
	public void onGuiClosed() {

		this.sync(compound);
	}

	private void drawTextBoxes() {

		int pix = width / 2 + 45;
		int pixh = height / 2 - 15;

		this.pv = new GuiTextFieldInt(0, this.fontRenderer, pix - 177, pixh - 85 + 30, 20, 16);
		this.pv.setMaxStringLength(2);
		this.pv.setEnabled(false);

		this.nomRPtext = new GuiTextField(1, this.fontRenderer, width / 2 - 60, height / 2 - 123, 120, 16);
		this.nomRPtext.setEnabled(false);

		this.moral = new GuiTextFieldInt(2, this.fontRenderer, pix - 177, pixh - 31, 20, 16);
		this.moral.setEnabled(false);
		this.moral.setMaxStringLength(2);

		this.peuple = new GuiTextField(1,this.fontRenderer, pix - 155, pixh - 79, 80, 16);
		this.peuple.setEnabled(false);
		this.peupleSelection();

		this.prodige = new GuiTextFieldInt(3,this.fontRenderer, pix - 177, pixh - 8, 20, 16);
		this.prodige.setEnabled(false);
		this.prodige.setMaxStringLength(2);

		this.force = new GuiTextFieldInt(4, this.fontRenderer, pix - 74, pixh - 85 + 30, 20, 16);
		this.force.setEnabled(false);
		this.force.setMaxStringLength(2);

		this.agilite = new GuiTextFieldInt(5,this.fontRenderer, pix - 74, pixh - 31, 20, 16);
		this.agilite.setEnabled(false);
		this.agilite.setMaxStringLength(2);

		this.esprit = new GuiTextFieldInt(6,this.fontRenderer, pix - 74, pixh - 8, 20, 16);
		this.esprit.setEnabled(false);
		this.esprit.setMaxStringLength(2);

		this.erudition = new GuiTextFieldInt(7, this.fontRenderer, pix - 74, pixh + 16, 20, 16);
		this.erudition.setEnabled(false);
		this.erudition.setMaxStringLength(2);

		this.presence = new GuiTextFieldInt(8, this.fontRenderer, pix - 74, pixh + 40, 20, 16);
		this.presence.setEnabled(false);
		this.presence.setMaxStringLength(2);

		this.discours = new GuiTextFieldInt(9, this.fontRenderer, pix - 74, pixh + 64, 20, 16);
		this.discours.setEnabled(false);
		this.discours.setMaxStringLength(2);

		this.volonte = new GuiTextFieldInt(10, this.fontRenderer, pix - 74, pixh + 88, 20, 16);
		this.volonte.setEnabled(false);
		this.volonte.setMaxStringLength(2);

		this.melee = new GuiTextFieldInt(11, this.fontRenderer, pix + 16, pixh - 79, 20, 16);
		this.melee.setEnabled(false);
		this.melee.setMaxStringLength(2);

		this.distance = new GuiTextFieldInt(12, this.fontRenderer, pix + 16, pixh - 85 + 30, 20, 16);
		this.distance.setEnabled(false);
		this.distance.setMaxStringLength(2);

		this.discretion = new GuiTextFieldInt(13, this.fontRenderer, pix + 16, pixh - 31, 20, 16);
		this.discretion.setEnabled(false);
		this.discretion.setMaxStringLength(2);

		this.veulerie = new GuiTextFieldInt(14,this.fontRenderer, pix + 16, pixh - 8, 20, 16);
		this.veulerie.setEnabled(false);
		this.veulerie.setMaxStringLength(2);

		this.faune = new GuiTextFieldInt(15, this.fontRenderer, pix + 16, pixh + 16, 20, 16);
		this.faune.setEnabled(false);
		this.faune.setMaxStringLength(2);

		this.medecine = new GuiTextFieldInt(16, this.fontRenderer, pix + 16, pixh + 40, 20, 16);
		this.medecine.setEnabled(false);
		this.medecine.setMaxStringLength(2);

		this.alchimie = new GuiTextFieldInt(17, this.fontRenderer, pix + 16, pixh + 88, 20, 16);
		this.alchimie.setEnabled(false);
		this.alchimie.setMaxStringLength(2);

		this.maitredoeuvre = new GuiTextFieldInt(18, this.fontRenderer, pix + 140, pixh + 64, 20, 16);
		this.maitredoeuvre.setEnabled(false);
		this.maitredoeuvre.setMaxStringLength(2);

		this.litterature = new GuiTextFieldInt(19, this.fontRenderer, pix + 140, pixh - 85 + 30, 20, 16);
		this.litterature.setEnabled(false);
		this.litterature.setMaxStringLength(2);

		this.persuasion = new GuiTextFieldInt(20, this.fontRenderer, pix + 140, pixh - 31, 20, 16);
		this.persuasion.setEnabled(false);
		this.persuasion.setMaxStringLength(2);

		this.negociation = new GuiTextFieldInt(21, this.fontRenderer, pix + 140, pixh - 8, 20, 16);
		this.negociation.setEnabled(false);
		this.negociation.setMaxStringLength(2);

		this.comprehension = new GuiTextFieldInt(22, this.fontRenderer, pix + 140, pixh + 16, 20, 16);
		this.comprehension.setEnabled(false);
		this.comprehension.setMaxStringLength(2);

		this.forge = new GuiTextFieldInt(23, this.fontRenderer, pix + 140, pixh + 40, 20, 16);
		this.forge.setEnabled(false);
		this.forge.setMaxStringLength(2);

		this.commandement = new GuiTextFieldInt(24, this.fontRenderer, pix + 140, pixh + -79, 20, 16);
		this.commandement.setEnabled(false);
		this.commandement.setMaxStringLength(2);

		this.cuisine = new GuiTextFieldInt(25, this.fontRenderer, pix + 16, pixh + 64, 20, 16);
		this.cuisine.setEnabled(false);
		this.cuisine.setMaxStringLength(2);

		this.intendance = new GuiTextFieldInt(26, this.fontRenderer, pix + 140, pixh + 112, 20, 16);
		this.intendance.setEnabled(false);
		this.intendance.setMaxStringLength(2);

		this.hommedupays = new GuiTextFieldInt(27, this.fontRenderer, pix + 140, pixh + 88, 20, 16);
		this.hommedupays.setEnabled(false);
		this.hommedupays.setMaxStringLength(2);

		this.blessuresText = new GuiTextFieldInt(28, this.fontRenderer, pix - 177, pixh + 16, 20, 16);
		this.blessuresText.setEnabled(false);
		this.blessuresText.setMaxStringLength(2);

		if (jCompound.hasKey("perso")) {
			this.assignValuesToTextboxes();
		}

		this.buttonList.add(modifyButton = new GuiButton(1, width / 2 - 65, height / 2 + 97, 60, 18, "Modifier"));
		this.buttonList.add(saveButton = new GuiButton(2, width / 2 - 5, height / 2 + 97, 75, 18, "Sauvegarder"));
		this.buttonList.add(iMinus = new GuiButton(3, pix - 174, pixh - 80, 18, 18, "<"));
		this.buttonList.add(iPlus = new GuiButton(4, pix - 74, pixh - 80, 18, 18, ">"));

		this.buttonList.add(pvMinus = new GuiButton(5, pix - 196, pixh - 56, 18, 18, "-"));
		this.buttonList.add(pvPlus = new GuiButton(6, pix - 156, pixh - 56, 18, 18, "+"));
		this.buttonList.add(moralMinus = new GuiButton(7, pix - 196, pixh - 32, 18, 18, "-"));
		this.buttonList.add(moralPlus = new GuiButton(8, pix - 156, pixh - 32, 18, 18, "+"));
		this.buttonList.add(prodigeMinus = new GuiButton(9, pix - 196, pixh - 9, 18, 18, "-"));
		this.buttonList.add(prodigePlus = new GuiButton(10, pix - 156, pixh - 9, 18, 18, "+"));
		this.buttonList.add(new GuiButton(11, pix - 248, pixh + 39, 100, 20, "Restaurer Malus"));
		this.buttonList.add(blessuresMinus = new GuiButton(12, pix - 196, pixh + 15, 18, 18, "-"));
		this.buttonList.add(blessuresPlus = new GuiButton(13, pix - 156, pixh + 15, 18, 18, "+"));

		if (jCompound.hasKey("perso")) {
			pvMinus.enabled = true;
			pvPlus.enabled = true;
			moralMinus.enabled = true;
			moralPlus.enabled = true;
			prodigeMinus.enabled = true;
			prodigePlus.enabled = true;
			blessuresMinus.enabled = true;
			blessuresMinus.enabled = true;
		} else {
			pvMinus.enabled = false;
			pvPlus.enabled = false;
			moralMinus.enabled = false;
			moralPlus.enabled = false;
			prodigeMinus.enabled = false;
			prodigePlus.enabled = false;
			blessuresMinus.enabled = false;
			blessuresPlus.enabled = false;
		}

		this.saveButton.enabled = false;
		this.iMinus.enabled = false;
		this.iPlus.enabled = false;
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
		
		this.pv.textboxKeyTyped(par1, par2);
		this.nomRPtext.textboxKeyTyped(par1, par2);
		this.moral.textboxKeyTyped(par1, par2);
		this.prodige.textboxKeyTyped(par1, par2);
		this.force.textboxKeyTyped(par1, par2);
		this.agilite.textboxKeyTyped(par1, par2);
		this.esprit.textboxKeyTyped(par1, par2);
		this.erudition.textboxKeyTyped(par1, par2);
		this.presence.textboxKeyTyped(par1, par2);
		this.discours.textboxKeyTyped(par1, par2);
		this.volonte.textboxKeyTyped(par1, par2);
		this.melee.textboxKeyTyped(par1, par2);
		this.distance.textboxKeyTyped(par1, par2);
		this.discretion.textboxKeyTyped(par1, par2);
		this.veulerie.textboxKeyTyped(par1, par2);
		this.faune.textboxKeyTyped(par1, par2);
		this.medecine.textboxKeyTyped(par1, par2);
		this.cuisine.textboxKeyTyped(par1, par2);
		this.alchimie.textboxKeyTyped(par1, par2);
		this.litterature.textboxKeyTyped(par1, par2);
		this.persuasion.textboxKeyTyped(par1, par2);
		this.negociation.textboxKeyTyped(par1, par2);
		this.comprehension.textboxKeyTyped(par1, par2);
		this.forge.textboxKeyTyped(par1, par2);
		this.hommedupays.textboxKeyTyped(par1, par2);
		this.maitredoeuvre.textboxKeyTyped(par1, par2);
		this.commandement.textboxKeyTyped(par1, par2);
		this.intendance.textboxKeyTyped(par1, par2);
		this.pv.onlyInt();
		this.moral.onlyInt();
		this.prodige.onlyInt();
		this.force.onlyInt();
		this.agilite.onlyInt();
		this.esprit.onlyInt();
		this.erudition.onlyInt();
		this.presence.onlyInt();
		this.discours.onlyInt();
		this.volonte.onlyInt();
		this.melee.onlyInt();
		this.distance.onlyInt();
		this.discretion.onlyInt();
		this.veulerie.onlyInt();
		this.faune.onlyInt();
		this.medecine.onlyInt();
		this.cuisine.onlyInt();
		this.alchimie.onlyInt();
		this.persuasion.onlyInt();
		this.litterature.onlyInt();
		this.negociation.onlyInt();
		this.comprehension.onlyInt();
		this.forge.onlyInt();
		this.hommedupays.onlyInt();
		this.maitredoeuvre.onlyInt();
		this.commandement.onlyInt();
		this.intendance.onlyInt();
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
		this.pv.updateCursorCounter();
		this.nomRPtext.updateCursorCounter();
		this.moral.updateCursorCounter();
		this.prodige.updateCursorCounter();
		this.force.updateCursorCounter();
		this.agilite.updateCursorCounter();
		this.esprit.updateCursorCounter();
		this.erudition.updateCursorCounter();
		this.presence.updateCursorCounter();
		this.discours.updateCursorCounter();
		this.volonte.updateCursorCounter();
		this.melee.updateCursorCounter();
		this.distance.updateCursorCounter();
		this.discretion.updateCursorCounter();
		this.veulerie.updateCursorCounter();
		this.faune.updateCursorCounter();
		this.medecine.updateCursorCounter();
		this.alchimie.updateCursorCounter();
		this.litterature.updateCursorCounter();
		this.persuasion.updateCursorCounter();
		this.negociation.updateCursorCounter();
		this.comprehension.updateCursorCounter();
		this.forge.updateCursorCounter();
		this.cuisine.updateCursorCounter();
		this.hommedupays.updateCursorCounter();
		this.maitredoeuvre.updateCursorCounter();
		this.commandement.updateCursorCounter();
		this.intendance.updateCursorCounter();

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
		this.pv.mouseClicked(x, y, btn);
		this.nomRPtext.mouseClicked(x, y, btn);
		this.moral.mouseClicked(x, y, btn);
		this.prodige.mouseClicked(x, y, btn);
		this.force.mouseClicked(x, y, btn);
		this.agilite.mouseClicked(x, y, btn);
		this.esprit.mouseClicked(x, y, btn);
		this.erudition.mouseClicked(x, y, btn);
		this.presence.mouseClicked(x, y, btn);
		this.discours.mouseClicked(x, y, btn);
		this.volonte.mouseClicked(x, y, btn);
		this.melee.mouseClicked(x, y, btn);
		this.distance.mouseClicked(x, y, btn);
		this.discretion.mouseClicked(x, y, btn);
		this.veulerie.mouseClicked(x, y, btn);
		this.faune.mouseClicked(x, y, btn);
		this.medecine.mouseClicked(x, y, btn);
		this.alchimie.mouseClicked(x, y, btn);
		this.litterature.mouseClicked(x, y, btn);
		this.persuasion.mouseClicked(x, y, btn);
		this.negociation.mouseClicked(x, y, btn);
		this.comprehension.mouseClicked(x, y, btn);
		this.forge.mouseClicked(x, y, btn);
		this.cuisine.mouseClicked(x, y, btn);
		this.hommedupays.mouseClicked(x, y, btn);
		this.maitredoeuvre.mouseClicked(x, y, btn);
		this.commandement.mouseClicked(x, y, btn);
		this.intendance.mouseClicked(x, y, btn);
	}

	private void assignValuesToTextboxes() {

		this.nomRPtext.setText(compound.getString("nomRP"));
		this.peuple.setText(compound.getString("peuple"));

		this.force.setText("" + compound.getInteger("force"));
		this.blessuresUpdate(compound);
		this.pvMalusUpdate(compound);
		this.moralMalusUpdate(compound);
		this.prodigeMalusUpdate(compound);

		this.agilite.setText("" + compound.getInteger("agilite"));
		this.esprit.setText("" + compound.getInteger("esprit"));
		this.erudition.setText("" + compound.getInteger("erudition"));
		this.presence.setText("" + compound.getInteger("presence"));
		this.discours.setText("" + compound.getInteger("discours"));
		this.volonte.setText("" + compound.getInteger("volonte"));
		this.melee.setText("" + compound.getInteger("melee"));
		this.distance.setText("" + compound.getInteger("distance"));
		this.discretion.setText("" + compound.getInteger("discretion"));
		this.veulerie.setText("" + compound.getInteger("veulerie"));
		this.faune.setText("" + compound.getInteger("faune"));
		this.medecine.setText("" + compound.getInteger("medecine"));
		this.cuisine.setText("" + compound.getInteger("cuisine"));
		this.alchimie.setText("" + compound.getInteger("alchimie"));
		this.commandement.setText("" + compound.getInteger("commandement"));
		this.litterature.setText("" + compound.getInteger("litterature"));
		this.persuasion.setText("" + compound.getInteger("persuasion"));
		this.negociation.setText("" + compound.getInteger("negociation"));
		this.comprehension.setText("" + compound.getInteger("comprehension"));
		this.forge.setText("" + compound.getInteger("forge"));
		this.cuisine.setText("" + compound.getInteger("cuisine"));
		this.hommedupays.setText("" + compound.getInteger("hommedupays"));
		this.maitredoeuvre.setText("" + compound.getInteger("maitredoeuvre"));
		this.commandement.setText("" + compound.getInteger("commandement"));
		this.intendance.setText("" + compound.getInteger("intendance"));
	}

	@Override
	protected void actionPerformed(GuiButton button) {

		if (button.id == 1) {

			this.nomRPtext.setEnabled(true);
			this.pv.setEnabled(true);
			this.moral.setEnabled(true);
			this.prodige.setEnabled(true);
			this.force.setEnabled(true);
			this.agilite.setEnabled(true);
			this.esprit.setEnabled(true);
			this.erudition.setEnabled(true);
			this.presence.setEnabled(true);
			this.discours.setEnabled(true);
			this.volonte.setEnabled(true);
			this.melee.setEnabled(true);
			this.distance.setEnabled(true);
			this.discretion.setEnabled(true);
			this.veulerie.setEnabled(true);
			this.faune.setEnabled(true);
			this.medecine.setEnabled(true);
			this.alchimie.setEnabled(true);
			this.litterature.setEnabled(true);
			this.persuasion.setEnabled(true);
			this.negociation.setEnabled(true);
			this.comprehension.setEnabled(true);
			this.forge.setEnabled(true);
			this.cuisine.setEnabled(true);
			this.hommedupays.setEnabled(true);
			this.maitredoeuvre.setEnabled(true);
			this.commandement.setEnabled(true);
			this.intendance.setEnabled(true);
			this.iMinus.enabled = true;
			this.iPlus.enabled = true;
			this.saveButton.enabled = true;
			this.modifyButton.enabled = false;
		}

		if (button.id == 2) {
			File fiches = new File("Heimnor/Fiches.dat");

			if (!fiches.exists()) {

				try {
					fiches.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			this.saveDataToNBT(compound, jCompound);
			this.modif = true;
			this.nomRPtext.setEnabled(false);
			this.pv.setEnabled(false);
			this.moral.setEnabled(false);
			this.prodige.setEnabled(false);
			this.force.setEnabled(false);
			this.agilite.setEnabled(false);
			this.esprit.setEnabled(false);
			this.erudition.setEnabled(false);
			this.presence.setEnabled(false);
			this.discours.setEnabled(false);
			this.volonte.setEnabled(false);
			this.melee.setEnabled(false);
			this.distance.setEnabled(false);
			this.discretion.setEnabled(false);
			this.veulerie.setEnabled(false);
			this.faune.setEnabled(false);
			this.medecine.setEnabled(false);
			this.alchimie.setEnabled(false);
			this.litterature.setEnabled(false);
			this.persuasion.setEnabled(false);
			this.negociation.setEnabled(false);
			this.comprehension.setEnabled(false);
			this.forge.setEnabled(false);
			this.cuisine.setEnabled(false);
			this.hommedupays.setEnabled(false);
			this.maitredoeuvre.setEnabled(false);
			this.commandement.setEnabled(false);
			this.intendance.setEnabled(false);
			this.modifyButton.enabled = true;
			this.saveButton.enabled = false;
			this.iMinus.enabled = false;
			this.iPlus.enabled = false;
			
		}
		if (button.id == 3) {
			if (i == 0 && button.id == 3) {
				i = 7;
			} else {

				i -= 1;
			}
			this.peupleSelection();
		}

		if (button.id == 4) {
			if (i == 7 && button.id == 4) {
				i = 0;
			} else {

				i += 1;
			}
			this.peupleSelection();
		}

		if (button.id == 5) {

			if (compound.hasKey("maluspv"))
				maluspv = compound.getInteger("maluspv");

			maluspv -= 1;

			compound.setInteger("maluspv", maluspv);
			this.modif = true;
			indexf.setTag(persoName, compound);

			this.pvMalusUpdate(compound);

		}

		if (button.id == 6) {
			if (compound.hasKey("maluspv"))
				maluspv = compound.getInteger("maluspv");

			maluspv += 1;

			compound.setInteger("maluspv", maluspv);
			this.modif = true;
			indexf.setTag(persoName, compound);

			this.pvMalusUpdate(compound);

		}
		if (button.id == 7) {

			if (compound.hasKey("malusmoral"))
				malusmoral = compound.getInteger("malusmoral");

			malusmoral -= 1;

			compound.setInteger("malusmoral", malusmoral);
			this.modif = true;
			indexf.setTag(persoName, compound);

			this.moralMalusUpdate(compound);

		}
		if (button.id == 8) {

			if (compound.hasKey("malusmoral"))
				malusmoral = compound.getInteger("malusmoral");

			malusmoral += 1;
			compound.setInteger("malusmoral", malusmoral);
			this.modif = true;
			indexf.setTag(persoName, compound);

			this.moralMalusUpdate(compound);

		}
		if (button.id == 9) {

			if (compound.hasKey("malusprodige"))
				malusprodige = compound.getInteger("malusprodige");

			malusprodige -= 1;
			compound.setInteger("malusprodige", malusprodige);
			this.modif = true;
			indexf.setTag(persoName, compound);

			this.prodigeMalusUpdate(compound);

		}
		if (button.id == 10) {

			if (compound.hasKey("malusprodige"))
				malusprodige = compound.getInteger("malusprodige");

			malusprodige += 1;
			compound.setInteger("malusprodige", malusprodige);
			this.modif = true;
			indexf.setTag(persoName, compound);

			this.prodigeMalusUpdate(compound);

		}
		if (button.id == 11) {
			if (compound.getInteger("malusprodige") != 0) {
				malusprodige = 0;
				compound.setInteger("malusprodige", 0);
				indexf.setTag(this.nomRPtext.getText(), compound);
				this.prodigeMalusUpdate(compound);

			}
			if (compound.getInteger("malusmoral") != 0) {

				malusmoral = 0;
				compound.setInteger("malusmoral", 0);
				indexf.setTag(this.nomRPtext.getText(), compound);

				this.moralMalusUpdate(compound);

			}
			if (compound.getInteger("maluspv") != 0) {
				maluspv = 0;
				compound.setInteger("maluspv", 0);
				indexf.setTag(this.nomRPtext.getText(), compound);
				this.pvMalusUpdate(compound);

			}
			if (compound.getInteger("blessures") != 0) {
				blessures = 0;
				compound.setInteger("blessures", 0);
				indexf.setTag(this.nomRPtext.getText(), compound);
				this.blessuresUpdate(compound);

			}
			this.modif = true;
		}
		if (button.id == 12) {

			if (compound.hasKey("blessures"))
				blessures = compound.getInteger("blessures");
			blessures -= 1;

			compound.setInteger("blessures", blessures);
			this.modif = true;
			indexf.setTag(persoName, compound);

			this.blessuresUpdate(compound);
		}
		if (button.id == 13) {

			if (compound.hasKey("blessures"))
				blessures = compound.getInteger("blessures");
			blessures += 1;

			compound.setInteger("blessures", blessures);
			this.modif = true;
			indexf.setTag(persoName, compound);

			this.blessuresUpdate(compound);

		}
	}

	private void saveDataToNBT(NBTTagCompound compound, NBTTagCompound nbtJoueur) {

		if (!(this.nomRPtext.getText().length() == 0)) {
			this.compound.setString("nomRP", nomRPtext.getText());
			this.jCompound.setString("perso", nomRPtext.getText());

			if (!(this.pv.getText().length() == 0))
				compound.setInteger("pv", Integer.parseInt(this.pv.getText()));

			if (!(this.blessuresText.getText().length() == 0))
				compound.setInteger("blessures", Integer.parseInt(this.blessuresText.getText()));

			if (!(this.moral.getText().length() == 0))
				compound.setInteger("moral", Integer.parseInt(this.moral.getText()));

			if (!(this.prodige.getText().length() == 0))
				compound.setInteger("prodige", Integer.parseInt(this.prodige.getText()));

			if (!(this.force.getText().length() == 0))
				compound.setInteger("force", Integer.parseInt(this.force.getText()));

			if (!(this.agilite.getText().length() == 0))
				compound.setInteger("agilite", Integer.parseInt(this.agilite.getText()));

			if (!(this.esprit.getText().length() == 0))
				compound.setInteger("esprit", Integer.parseInt(this.esprit.getText()));

			if (!(this.erudition.getText().length() == 0))
				compound.setInteger("erudition", Integer.parseInt(this.erudition.getText()));

			if (!(this.presence.getText().length() == 0))
				compound.setInteger("presence", Integer.parseInt(this.presence.getText()));

			if (!(this.discours.getText().length() == 0))
				compound.setInteger("discours", Integer.parseInt(this.discours.getText()));

			if (!(this.volonte.getText().length() == 0))
				compound.setInteger("volonte", Integer.parseInt(this.volonte.getText()));

			if (!(this.melee.getText().length() == 0))
				compound.setInteger("melee", Integer.parseInt(this.melee.getText()));

			if (!(this.distance.getText().length() == 0))
				compound.setInteger("distance", Integer.parseInt(this.distance.getText()));

			if (!(this.discretion.getText().length() == 0))
				compound.setInteger("discretion", Integer.parseInt(this.discretion.getText()));

			if (!(this.veulerie.getText().length() == 0))
				compound.setInteger("veulerie", Integer.parseInt(this.veulerie.getText()));

			if (!(this.faune.getText().length() == 0))
				compound.setInteger("faune", Integer.parseInt(this.faune.getText()));

			if (!(this.medecine.getText().length() == 0))
				compound.setInteger("medecine", Integer.parseInt(this.medecine.getText()));

			if (!(this.alchimie.getText().length() == 0))
				compound.setInteger("alchimie", Integer.parseInt(this.alchimie.getText()));

			if (!(this.litterature.getText().length() == 0))
				compound.setInteger("litterature", Integer.parseInt(this.litterature.getText()));

			if (!(this.persuasion.getText().length() == 0))
				compound.setInteger("persuasion", Integer.parseInt(this.persuasion.getText()));

			if (!(this.negociation.getText().length() == 0))
				compound.setInteger("negociation", Integer.parseInt(this.negociation.getText()));

			if (!(this.comprehension.getText().length() == 0))
				compound.setInteger("comprehension", Integer.parseInt(this.comprehension.getText()));

			if (!(this.forge.getText().length() == 0))
				compound.setInteger("forge", Integer.parseInt(this.forge.getText()));

			if (!(this.cuisine.getText().length() == 0))
				compound.setInteger("cuisine", Integer.parseInt(this.cuisine.getText()));

			if (!(this.hommedupays.getText().length() == 0))
				compound.setInteger("hommedupays", Integer.parseInt(this.hommedupays.getText()));

			if (!(this.maitredoeuvre.getText().length() == 0))
				compound.setInteger("maitredoeuvre", Integer.parseInt(this.maitredoeuvre.getText()));

			if (!(this.commandement.getText().length() == 0))
				compound.setInteger("commandement", Integer.parseInt(this.commandement.getText()));

			if (!(this.intendance.getText().length() == 0))
				compound.setInteger("intendance", Integer.parseInt(this.intendance.getText()));

			compound.setString("peuple", this.peuple.getText());
			

			indexj.setTag(playerName, this.jCompound);
			indexf.setTag(nomRPtext.getText(), this.compound);
			this.modif = true;

			Heimnor.network.sendToServer(new IMessageCSSync(indexj, "true", this.playerName, "true"));
		}
	}

	private void peupleSelection() {
		String[] listePeuple = { "Oronne", "Shaal", "Djarnnedin", "Adamante", "Jihan", "Feral", "Lordannien", "Autre" };
		peupleSelect = listePeuple[i];
		this.peuple.setText(peupleSelect);
	}

	private void pvMalusUpdate(NBTTagCompound compound) {

		int malus = compound.getInteger("maluspv");
		int pv = compound.getInteger("pv");
		int result = pv + malus;
		this.pv.setText("" + result);

	}

	private void moralMalusUpdate(NBTTagCompound compound) {

		int malus = compound.getInteger("malusmoral");
		int moral = compound.getInteger("moral");
		int result = moral + malus;
		this.moral.setText("" + result);

	}

	private void prodigeMalusUpdate(NBTTagCompound compound) {
		int malus = compound.getInteger("malusprodige");
		int prodige = compound.getInteger("prodige");
		int result = prodige + malus;
		this.prodige.setText("" + result);

	}

	private void blessuresUpdate(NBTTagCompound compound) {
		int malus = compound.getInteger("blessures");
		int result = malus;
		this.blessuresText.setText("" + result);
	}

	public void sync(NBTTagCompound compound) {

		indexf.setTag(this.nomRPtext.getText(), this.compound);

		String tern = (this.modif == true) ? "true" : "false";
		Heimnor.network.sendToServer(new IMessageCSSync(this.indexf, "false", this.nomRPtext.getText(), tern));

	}
}
