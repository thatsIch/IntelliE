package de.thatsich.intellie.common.module;

import de.thatsich.intellie.common.BaseModID;

/**
 @author thatsIch
 @since 22.03.2014. */
public abstract class ATexture
{
	private final String texture;

	protected ATexture( BaseModID id )
	{
		this.texture = id + ":" + this.getClass().getSimpleName().replaceFirst( "Texture", "" ).toLowerCase();
	}

	public String getTexture()
	{
		return this.texture;
	}
}
