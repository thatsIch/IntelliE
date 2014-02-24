package de.thatsich.common.module.tileentity;

import lombok.Getter;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.config.Configuration;

public abstract class ATileEntity extends TileEntity
{
	@Getter private final String category;
	@Getter private final String key;
	@Getter private final String tileEntityID;

	protected ATileEntity ( String category, String key, String tileEntityID )
	{
		super();
		this.category = category;
		this.key = key;
		this.tileEntityID = tileEntityID;
	}

	public abstract void register ( final Configuration config );
}
