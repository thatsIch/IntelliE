package de.thatsich.intellie.applied.intelligences.functionality.router.module.block;

import de.thatsich.common.module.tileentity.ATileEntity;
import net.minecraftforge.common.config.Configuration;

public class TileEntityRouter extends ATileEntity
{
	TileEntityRouter ()
	{
		super( Configuration.CATEGORY_GENERAL, "Router", "tileRouter");
	}

	@Override
	public void register ( final Configuration config )
	{

	}
}
