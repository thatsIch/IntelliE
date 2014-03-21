package de.thatsich.common.module.block.info;

import lombok.Getter;


public abstract class ABlockName implements IBlockName
{
	@Getter
	private final String name;
	@Getter
	private final String unlocalizedName;

	protected ABlockName ( String name )
	{
		// process information
		// unlocalized name is first letter small and no space
		this.name = name;
		this.unlocalizedName = name.replaceAll( "\\s+", "" ).toUpperCase();
	}
}
