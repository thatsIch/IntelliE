package de.thatsich.common.module.item;

import lombok.Getter;

public class AItemTexture
{
	@Getter
	private final String texture;

	protected AItemTexture ( String texture )
	{
		this.texture = texture;
	}
}
