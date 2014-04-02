package de.thatsich.intellie.common.registries;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import de.thatsich.intellie.common.ABaseMod;
import de.thatsich.intellie.common.util.logging.ILog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GuiRegistry implements IGuiHandler
{
	private final ILog log;

	@Inject
	GuiRegistry( final ILog log )
	{
		this.log = log;
	}

	public void init( ABaseMod instance )
	{
		NetworkRegistry.INSTANCE.registerGuiHandler( instance, this );
	}

	@Override
	public Object getServerGuiElement( int ID, EntityPlayer player, World world, int x, int y, int z )
	{
		return null;
	}

	@Override
	public Object getClientGuiElement( int ID, EntityPlayer player, World world, int x, int y, int z )
	{
		return null;
	}
}
