package de.thatsich.intellie.common.module.tileentity;

import net.minecraftforge.common.config.Configuration;

/**
 @author thatsIch
 @date 22.03.2014. */
public interface ITileEntity
{
	void register ( Configuration config );

	String getTileEntityID ();
}
