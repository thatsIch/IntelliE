package de.thatsich.intellie.common.module.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.config.Configuration;

public abstract class ATileEntity extends TileEntity implements ITileEntity
{
	private final String category;
	private final String key;
	private final String tileEntityID;

	protected ATileEntity ( String category, String key, String tileEntityID )
	{
		super();
		this.category = category;
		this.key = key;
		this.tileEntityID = tileEntityID;
	}

	public String getCategory () { return this.category; }

	public String getKey () { return this.key; }

	public String getTileEntityID () { return this.tileEntityID; }

	public abstract void register ( final Configuration config );
}
