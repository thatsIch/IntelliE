package de.thatsich.common.handler;

import com.google.inject.Inject;
import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.common.module.tileentity.ATileEntity;
import de.thatsich.intellie.common.util.IELog;
import net.minecraftforge.common.config.Configuration;

import java.util.Collection;
import java.util.LinkedList;

public class RegistryTileEntity
{
	private final Collection<ATileEntity> tileEntities;
	private final IELog log;

	@Inject
	public RegistryTileEntity ( IELog log )
	{
		this.tileEntities = new LinkedList<>();
		this.log = log;
	}

	public void addTileEntity ( ATileEntity tileEntity )
	{
		this.tileEntities.add( tileEntity );
	}

	public void loadConfig ( final Configuration config )
	{
		for ( ATileEntity tileEntity : this.tileEntities )
		{
			tileEntity.register( config );
		}
	}

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
