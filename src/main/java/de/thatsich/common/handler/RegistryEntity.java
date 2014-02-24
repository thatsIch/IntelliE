package de.thatsich.common.handler;

import com.google.inject.Inject;
import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.common.module.tileentity.ATileEntity;
import de.thatsich.intellie.common.util.IELog;
import net.minecraftforge.common.config.Configuration;

import java.util.Collection;
import java.util.LinkedList;


public class RegistryEntity
{
	private final Collection<ATileEntity> tileEntites;
	private final IELog log;

	@Inject
	public RegistryEntity ( IELog log)
	{
		this.tileEntites = new LinkedList<>();
		this.log = log;
	}

	public void addTileEntity ( ATileEntity tileEntity )
	{
		this.tileEntites.add( tileEntity );
		this.log.info( "Added TileEntitiy %s", tileEntity );
	}

	public void register ()
	{
		for ( ATileEntity tileEntity : this.tileEntites )
		{
			final Class<? extends ATileEntity> tileEntityClass = tileEntity.getClass();
			final String tileEntityKey = tileEntity.getTileEntityID();

			GameRegistry.registerTileEntity( tileEntityClass, tileEntityKey );
		}
	}

	public void loadConfig ( final Configuration config )
	{

	}
}
