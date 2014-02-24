package de.thatsich.common.module.tileentity;

import net.minecraft.tileentity.TileEntity;

public abstract class ATileEntity extends TileEntity
{
	@Override
	protected ATileEntity clone() throws CloneNotSupportedException
	{
		return ( ATileEntity ) super.clone();
	}

	public String getKey()
	{
		return null;
	}
}
