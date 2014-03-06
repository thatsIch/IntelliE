package de.thatsich.common.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.common.module.tileentity.ATileEntity;
import de.thatsich.common.util.ILog;
import net.minecraftforge.common.config.Configuration;

import javax.inject.Inject;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Registry for TileEntities
 */
public class RegistryTileEntity
{
	private final Collection<ATileEntity> tileEntities;
	private final ILog log;

	/**
	 * @param log Injected Logger
	 */
	@Inject
	RegistryTileEntity ( ILog log )
	{
		this.tileEntities = new LinkedList<>();
		this.log = log;
	}

	/**
	 * Adds a TileEntity
	 *
	 * @param tileEntity added TileEntity
	 */
	public void addTileEntity ( ATileEntity tileEntity )
	{
		this.log.info( "Added Tile Entity: %s", tileEntity );
		this.tileEntities.add( tileEntity );
	}

	/**
	 * Loads each config through their own responsibility
	 *
	 * @param config Configuration
	 */
	public void loadConfig ( final Configuration config )
	{
		for ( ATileEntity tileEntity : this.tileEntities )
		{
			tileEntity.register( config );
		}
	}

	/**
	 * Registers all added TileEntites through their clas and key
	 */
	public void registerTileEntities ()
	{
		for ( ATileEntity tileEntity : this.tileEntities )
		{
			final Class<? extends ATileEntity> tileEntityClass = tileEntity.getClass();
			final String tileEntityKey = tileEntity.getTileEntityID();

			GameRegistry.registerTileEntity( tileEntityClass, tileEntityKey );
		}
	}
}
