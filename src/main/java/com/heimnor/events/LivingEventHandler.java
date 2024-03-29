package com.heimnor.events;

import org.lwjgl.opengl.GL11;

import com.heimnor.client.ChatGui;
import com.heimnor.proxy.ClientProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LivingEventHandler
{

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onPlayersChatOpened(GuiOpenEvent event)
	{
		if (event.getGui() != null && event.getGui() instanceof GuiChat)
			event.setGui(new ChatGui());
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void playerJoinWorld(EntityJoinWorldEvent event)
	{
		if (event.getEntity() instanceof EntityPlayer)
		{
			ClientProxy.CHATTING_PLAYERS_USERNAME.clear();
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void playerRender(RenderPlayerEvent.Pre event)
	{

		double x = event.getEntityPlayer().posX - Minecraft.getMinecraft().player.posX;
		double y = event.getEntityPlayer().posY - Minecraft.getMinecraft().player.posY;
		double z = event.getEntityPlayer().posZ - Minecraft.getMinecraft().player.posZ;

		if (ClientProxy.CHATTING_PLAYERS_USERNAME.contains(event.getEntityPlayer().getDisplayNameString())
				&& event.getEntityPlayer().getDisplayNameString().equals(Minecraft.getMinecraft().player.getDisplayNameString()))
		{
			RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();

			GlStateManager.pushMatrix();
			GlStateManager.disableCull();
			GlStateManager.disableAlpha();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("heimnormod", "textures/items/bulle.png"));
			GlStateManager.translate(x, y, z);
			GlStateManager.translate(0, event.getEntityPlayer().height + 0.5, 0);
			GlStateManager.color(1, 1, 1);
			
			GlStateManager.rotate(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
			GlStateManager.scale(-0.016, -0.016, 0.016);
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder renderer = tessellator.getBuffer();
			tessellator.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
			renderer.pos(-20, 20, 0.0F).tex(1, 1).endVertex();// coin inférieur gauche
            renderer.pos(20, 20, 0).tex(1, 0).endVertex();// coin inférieur droit
            renderer.pos(20, -20, 0).tex(0, 0).endVertex();// coin supérieur droit
            renderer.pos(-20, -20, 0).tex(0, 1).endVertex();// coin supérieur gauche
            
			tessellator.draw();
			GlStateManager.enableAlpha();
			GlStateManager.enableCull();
			GlStateManager.popMatrix();

		} else if (ClientProxy.CHATTING_PLAYERS_USERNAME.contains(event.getEntityPlayer().getDisplayNameString())
				&& event.getEntityPlayer().getDisplayNameString() != Minecraft.getMinecraft().player.getDisplayNameString())
		{

			RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();

			GlStateManager.pushMatrix();
			GlStateManager.disableCull();
			GlStateManager.disableAlpha();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("heimnormod", "textures/items/bulle.png"));
			GlStateManager.translate(x, y, z);
			GlStateManager.translate(0, event.getEntityPlayer().height + 0.5, 0);
			GlStateManager.color(1, 1, 1);
			
			GlStateManager.rotate(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
			GlStateManager.scale(-0.016, -0.016, 0.016);
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder renderer = tessellator.getBuffer();
			tessellator.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
			renderer.pos(-20, 20, 0.0F).tex(1, 1).endVertex();// coin inférieur gauche
            renderer.pos(20, 20, 0).tex(1, 0).endVertex();// coin inférieur droit
            renderer.pos(20, -20, 0).tex(0, 0).endVertex();// coin supérieur droit
            renderer.pos(-20, -20, 0).tex(0, 1).endVertex();// coin supérieur gauche
            
			tessellator.draw();
			GlStateManager.enableAlpha();
			GlStateManager.enableCull();
			GlStateManager.popMatrix();

		}
	}
}