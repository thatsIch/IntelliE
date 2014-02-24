package de.thatsich.common.module.block;

public abstract class ABlockConfig
{
	// Fields
	private final String blockKey;

	protected ABlockConfig ( String blockKey )
	{
		this.blockKey = blockKey;
	}

	public String getBlockKey ()
	{
		return this.blockKey;
	}
}
