package de.thatsich.intellie.common.module.block.info;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public abstract class ABlockInfo
{
	private static final float DEFAULT_BLOCK_HARDNESS = 3.0F;
	private final ABlockName blockName;
	private final CreativeTabs creativeTab;

	protected ABlockInfo ( ABlockName blockName, CreativeTabs creativeTab )
	{
		this.blockName = blockName;
		this.creativeTab = creativeTab;
	}

	public ABlockName getBlockName ()
	{
		return this.blockName;
	}

	public CreativeTabs getCreativeTab ()
	{
		return this.creativeTab;
	}

	public Material getMaterial ()
	{
		return Material.iron;
	}

	public float getHardness () { return ABlockInfo.DEFAULT_BLOCK_HARDNESS; }
}
