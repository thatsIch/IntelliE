package de.thatsich.common.module.block;

import lombok.Getter;

public abstract class ABlockTexture
{
	@Getter
	private final String texture;

	protected ABlockTexture ( String texture )
	{
		this.texture = texture;
	}
}
