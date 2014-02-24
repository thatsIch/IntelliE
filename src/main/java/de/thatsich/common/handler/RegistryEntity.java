package de.thatsich.common.handler;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.common.module.tileentity.ATileEntity;


public class RegistryEntity
{
	private final List<ATileEntity>	tileEntites	= new ArrayList<>();

	public void addTileEntity( ATileEntity tileEntity )
	{
		this.tileEntites.add( tileEntity );
	}

	public void register()
	{
		for ( ATileEntity tileEntity : this.tileEntites )
		{
			GameRegistry.registerTileEntity( tileEntity.getClass(), tileEntity.getKey() );
		}
	}
}
