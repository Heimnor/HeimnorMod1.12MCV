package com.heimnor.proxy;

import java.io.File;
import java.util.ArrayList;

import com.heimnor.client.FichesGui;
import com.heimnor.common.Heimnor;
import com.heimnor.packet.IMessageCSSync;
import com.heimnor.utils.NbtCsFile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {

	public static ArrayList<String> CHATTING_PLAYERS_USERNAME = new ArrayList<String>();
	public static int renderID;

	public ClientProxy() {

		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void preInit(File configFile) {

		super.preInit(configFile); //Ecrire en dessous du super
	}

	@Override
	public void init() {

		super.init();
	}

	@SubscribeEvent
	public void onInitGuiEvent(InitGuiEvent.Post event) {

		if (event.getGui() instanceof GuiInventory) {

			event.getButtonList().add(new GuiButton(30, event.getGui().width / 2 - 60, 0, 120, 20, "Fiche de personnage"));
		}

		if (event.getGui() instanceof GuiContainerCreative) {

			event.getButtonList().add(new GuiButton(31, event.getGui().width / 2 - 60, 220, 120, 20, "Fiche de personnage"));
		}

		if (event.getGui() instanceof FichesGui) {
			File permissions = new File("Heimnor/Permissions.dat");
			Heimnor.network.sendToServer(new IMessageCSSync(new NBTTagCompound(), "perm",
					Minecraft.getMinecraft().player.getDisplayNameString(), "false"));
			NBTTagCompound index = NbtCsFile.getNbtTagCompound(permissions, "index");
			if (index.getString(Minecraft.getMinecraft().player.getDisplayNameString()).equals("MJ")) {

				event.getButtonList().add(
						new GuiButton(32, event.getGui().width / 2 + 61, event.getGui().height / 2 - 125, 60, 20, "Importer"));
			}

		}
	}

	@SubscribeEvent
	public void onActionPerformed(ActionPerformedEvent.Pre event) {

		EntityPlayer player = Minecraft.getMinecraft().player;
		World world = Minecraft.getMinecraft().world;

		if (event.getGui() instanceof GuiInventory && event.getButton().id == 30) {

			player.openGui(Heimnor.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		}

		if (event.getGui() instanceof GuiContainerCreative && event.getButton().id == 31)

			player.openGui(Heimnor.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);

		if (event.getGui() instanceof FichesGui && event.getButton().id == 32)

			player.openGui(Heimnor.instance, 2, world, (int) player.posX, (int) player.posY, (int) player.posZ);
	}
}
