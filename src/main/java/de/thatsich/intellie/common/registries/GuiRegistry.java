package de.thatsich.intellie.common.registries;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import de.thatsich.intellie.common.ABaseMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiRegistry implements IGuiHandler
{
	public void init ( ABaseMod instance )
	{
		NetworkRegistry.INSTANCE.registerGuiHandler( instance, this );
	}

	@Override
	public Object getServerGuiElement ( int ID, EntityPlayer player, World world, int x, int y, int z )
	{
		return null;
	}

	@Override
	public Object getClientGuiElement ( int ID, EntityPlayer player, World world, int x, int y, int z )
	{
		return null;
	}
}