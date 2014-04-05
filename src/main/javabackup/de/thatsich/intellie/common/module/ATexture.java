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
		final String namespace = id + ":";
		final String name = this.getClass().getSimpleName().replaceFirst( "Texture", "" ).toLowerCase();

		this.texture = namespace + name;
	}

	public String getTexture()
	{
		return this.texture;
	}
}
