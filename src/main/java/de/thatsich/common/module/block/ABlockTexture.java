package de.thatsich.common.module.block;

public abstract class ABlockTexture
{
	private final String texture;

	protected ABlockTexture ( String texture )
	{
		this.texture = texture;
	}

	public String getTexture () { return this.texture; }
}
