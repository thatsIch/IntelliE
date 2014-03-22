package de.thatsich.common.module;

/**
 * @author thatsIch
 * @date 22.03.2014.
 */
public abstract class ATexture
{
	private final String texture;

	/**
	 * Abstract constructor for a texture
	 *
	 * @param texture Stored texture
	 */
	protected ATexture ( String texture )
	{
		this.texture = texture;
	}

	public String getTexture () { return this.texture; }
}
