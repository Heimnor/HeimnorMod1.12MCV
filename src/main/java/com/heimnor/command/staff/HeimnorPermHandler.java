package com.heimnor.command.staff;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import com.mojang.authlib.GameProfile;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.IPermissionHandler;
import net.minecraftforge.server.permission.context.IContext;

public enum HeimnorPermHandler implements IPermissionHandler
{
	INSTANCE;
    private static final HashMap<String, DefaultPermissionLevel> PERMISSION_LEVEL_MAP = new HashMap<String, DefaultPermissionLevel>();
    private static final HashMap<String, String> DESCRIPTION_MAP = new HashMap<String, String>();

	@Override
	public void registerNode(String node, DefaultPermissionLevel level, String desc)
	{
		PERMISSION_LEVEL_MAP.put(node, level);

        if(!desc.isEmpty())
        {
            DESCRIPTION_MAP.put(node, desc);
        }
	}

	@Override
	public Collection<String> getRegisteredNodes()
	{
		
		return Collections.unmodifiableSet(PERMISSION_LEVEL_MAP.keySet());
	}

	@Override
	public boolean hasPermission(GameProfile profile, String node, IContext context)
	{
		DefaultPermissionLevel level = getDefaultPermissionLevel(node);

        if(level == DefaultPermissionLevel.NONE)
        {
            return false;
        }
        else if(level == DefaultPermissionLevel.ALL)
        {
            return true;
        }

        MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
        return server != null && server.getPlayerList().canSendCommands(profile);
	}

    @Override
    public String getNodeDescription(String node)
    {
        String desc = DESCRIPTION_MAP.get(node);
        return desc == null ? "" : desc;
    }

    /**
     * @return The default permission level of a node. If the permission isn't registred, it will return NONE
     */
    public DefaultPermissionLevel getDefaultPermissionLevel(String node)
    {
        DefaultPermissionLevel level = PERMISSION_LEVEL_MAP.get(node);
        return level == null ? DefaultPermissionLevel.NONE : level;
    }
}
