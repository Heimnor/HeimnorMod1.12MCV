package com.heimnor.common;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.core.Logger;

import com.heimnor.capabilities.CapabilityHandler;
import com.heimnor.capabilities.CharacterRP;
import com.heimnor.capabilities.CharacterStorage;
import com.heimnor.capabilities.ICharacterRP;
import com.heimnor.client.PlayerDataEventHandler;
import com.heimnor.command.player.CommandAJ;
import com.heimnor.command.player.CommandJet;
import com.heimnor.command.staff.HPerm;
import com.heimnor.creativetabs.HeimnorArmorCreativeTabs;
import com.heimnor.creativetabs.HeimnorBlockCreativeTabs;
import com.heimnor.creativetabs.HeimnorBlocksDecoTabs;
import com.heimnor.creativetabs.HeimnorFoodCreativeTabs;
import com.heimnor.creativetabs.HeimnorMiscCreativeTab;
import com.heimnor.creativetabs.HeimnorWeaponCreativeTabs;
import com.heimnor.events.ChatEvents;
import com.heimnor.events.LivingEventHandler;
import com.heimnor.events.PropertiesEvent;
import com.heimnor.events.ServerEvents;
import com.heimnor.packet.IMessageCSSync;
import com.heimnor.packet.IMessageCSSyncRep;
import com.heimnor.packet.IMessageChat;
import com.heimnor.packet.IMessageChatClose;
import com.heimnor.packet.IMessageChatCloseReponse;
import com.heimnor.packet.IMessageChatReponse;
import com.heimnor.packet.IMessageDes;
import com.heimnor.packet.IMessageLog;
import com.heimnor.packet.PacketPerm;
import com.heimnor.packet.SyncFood;
import com.heimnor.proxy.CommonProxy;
import com.heimnor.utils.NbtCsFile;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;
import registry.RegisteringHandler;

/**
 * 
 * @author Joe 25 nov. 2018
 *
 */

@Mod(modid = Heimnor.MODID, name = Heimnor.NAME, version = Heimnor.VERSION)
public class Heimnor
{
	public static final String MODID = "heimnormod";
	public static final String VERSION = "1.0.0";
	public static final String NAME = "Heimnor";
	public static SimpleNetworkWrapper network;
	// A modifier pour modifier tout le mod

	public static Logger logger;

	public static CreativeTabs HeimnorMiscCreativeTabs = new HeimnorMiscCreativeTab("heimnor_misc_creative_tabs");
	public static CreativeTabs HeimnorArmorCreativeTabs = new HeimnorArmorCreativeTabs("heimnor_armor_creative_tabs");
	public static CreativeTabs HeimnorWeaponCreativeTabs = new HeimnorWeaponCreativeTabs("heimnor_weapon_creative_tabs");
	public static CreativeTabs HeimnorFoodTabs = new HeimnorFoodCreativeTabs("heimnor_food_tabs");
	public static CreativeTabs HeimnorBlockTabs = new HeimnorBlockCreativeTabs("heimnor_block_tabs");
	public static CreativeTabs HeimnorBlockDecoTabs = new HeimnorBlocksDecoTabs("heimnor_blockdeco_tabs");

	@Instance("heimnormod")
	public static Heimnor instance;
	// Instance du Mod d'Heimnor

	@SidedProxy(clientSide = "com.heimnor.proxy.ClientProxy", serverSide = "com.heimnor.proxy.ServerProxy")
	public static CommonProxy proxy;
	// Proxy

	public Heimnor()
	{

		MinecraftForge.EVENT_BUS.register(new RegisteringHandler());

	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{// Pré Initialisation

		event.getModLog();

		proxy.preInit(event.getSuggestedConfigurationFile());
		proxy.registerRender();

		// paramètres item (class)
		// itemverre_vin = new AlcoolHeimnor(1, "verre_vin", false,
		// MiscRegistry.verre_vin_vide, 5);
		// itemnourritureminerale1 = new NourritureMinerale1(8, 0.5F,
		// false).setUnlocalizedName("NourritureMinerale1")
		// .setCreativeTab(Heimnor.HeimnorFoodTabs).setTextureName(Heimnor.MODID +
		// ":nourritureminerale1");

		network = NetworkRegistry.INSTANCE.newSimpleChannel("chatChannel");
		network.registerMessage(com.heimnor.packet.IMessageChat.IMessageHandlerChat.class, IMessageChat.class, 1, Side.SERVER);
		network.registerMessage(com.heimnor.packet.IMessageChatReponse.IMessageHandlerChatReponse.class, IMessageChatReponse.class, 2, Side.CLIENT);
		network.registerMessage(com.heimnor.packet.IMessageChatClose.IMessageHandlerChatClose.class, IMessageChatClose.class, 3, Side.SERVER);
		network.registerMessage(com.heimnor.packet.IMessageChatCloseReponse.IMessageHandlerChatReponseClose.class, IMessageChatCloseReponse.class, 4, Side.CLIENT);
		network.registerMessage(com.heimnor.packet.IMessageDes.IMesageDesHandler.class, IMessageDes.class, 5, Side.SERVER);
		network.registerMessage(com.heimnor.packet.IMessageCSSync.CommonHandler.class, IMessageCSSync.class, 6, Side.SERVER);
		network.registerMessage(com.heimnor.packet.IMessageCSSyncRep.ClientHandler.class, IMessageCSSyncRep.class, 7, Side.CLIENT);
		network.registerMessage(com.heimnor.packet.IMessageLog.Handler.class, IMessageLog.class, 8, Side.SERVER);
		network.registerMessage(com.heimnor.packet.PacketPerm.Handler.class, PacketPerm.class, 9, Side.CLIENT);
		network.registerMessage(com.heimnor.packet.SyncFood.Handler.class, SyncFood.class, 10, Side.CLIENT);
		// Network Packets
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{// Initialisation

		proxy.init();
		
		CapabilityManager.INSTANCE.register(ICharacterRP.class, new CharacterStorage(), CharacterRP::new);
		
		MinecraftForge.EVENT_BUS.register(new LivingEventHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerDataEventHandler());
		MinecraftForge.EVENT_BUS.register(new ServerEvents());
		MinecraftForge.EVENT_BUS.register(new PropertiesEvent());
		MinecraftForge.EVENT_BUS.register(new ChatEvents());
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(Heimnor.instance, new CSGuiHandler());

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{// Post Initialisation

	}
	


	@EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		// Executer au démarrage du serveur
		event.registerServerCommand(new CommandJet());
		event.registerServerCommand(new HPerm());
		event.registerServerCommand(new CommandAJ());
		PermissionAPI.registerNode("com.heimnor.command.staff", DefaultPermissionLevel.OP, "Donne accès aux fonctionnalités de MJ");
		PermissionAPI.registerNode("com.heimnor.command.player", DefaultPermissionLevel.NONE, "Donne accès aux commandes joueurs");
		
		File permissions = new File("Heimnor/Permissions.dat");

		if (!permissions.exists())
		{
			permissions.getParentFile().mkdirs();
			System.out.println("Permissions.dat crée");
			try
			{
				permissions.createNewFile();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			NbtCsFile.setNbtTagCompound(permissions, "index", new NBTTagCompound());
		}
	}
}
