package de.thatsich.intellie.common.module.block.info;

import de.thatsich.intellie.common.BaseModID;

public abstract class ABlockName implements IBlockName
{
	private final String unlocalizedName;

	protected ABlockName( BaseModID id )
	{
		this.unlocalizedName = id + "." + this.getClass().getSimpleName().replaceFirst( "BlockName", "" ).toLowerCase();
	}

	@Override
	public String getUnlocalizedName() { return this.unlocalizedName; }
}
