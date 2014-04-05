package de.thatsich.intellie.applied.intelligences.common.proxies;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler
{

	@Override
	public Object getServerGuiElement( int ID, EntityPlayer player, World world, int x, int y, int z )
	{
		return new Object();
	}

	@Override
	public Object getClientGuiElement( int ID, EntityPlayer player, World world, int x, int y, int z )
	{
		return new Object();
	}
}
