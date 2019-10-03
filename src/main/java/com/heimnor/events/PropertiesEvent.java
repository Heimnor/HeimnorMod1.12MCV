package com.heimnor.events;

public class PropertiesEvent {

	/*@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {

		if (event.getEntity() instanceof EntityPlayer && EPAlcohol.get((EntityPlayer) event.entity) == null)

			EPAlcohol.register((EntityPlayer) event.entity);
	}

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if (!event.getEntity().world.isRemote && event.getEntity() instanceof EntityPlayer) {
			NBTTagCompound playerData = new NBTTagCompound();
			((EPAlcohol) (event.getEntity().getExtendedProperties(EPAlcohol.EXT_PROP_NAME)))
					.saveNBTData(playerData);
			Heimnor.proxy.storeEntityData(((EntityPlayer) event.entity).getDisplayName(), playerData);
			EPAlcohol.saveProxyData((EntityPlayer) event.entity);
		} else {

		}
	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			NBTTagCompound playerData = Heimnor.proxy.getEntityData(((EntityPlayer) event.entity).getDisplayName());
			if (playerData != null) {
				((EPAlcohol) (event.entity.getExtendedProperties(EPAlcohol.EXT_PROP_NAME)))
						.loadNBTData(playerData);
			}

			((EPAlcohol) (event.entity.getExtendedProperties(EPAlcohol.EXT_PROP_NAME))).sync();
		}
	}*/
}
