package de.thatsich.intellie.common.module.block;

import de.thatsich.intellie.common.module.ATexture;
import de.thatsich.intellie.common.module.IName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


public abstract class ABlockInfo
{
	private final IName blockName;
	private final ATexture texture;
	private final float hardness;
	private final Material mat;
	private final Block.SoundType blockSound;
	private final CreativeTabs creativeTab;

	protected ABlockInfo(
			IName blockName,
			ATexture texture,
			float hardness,
			Material mat,
			Block.SoundType blockSound,
			CreativeTabs creativeTab )
	{
		this.blockName = blockName;
		this.hardness = hardness;
		this.texture = texture;
		this.mat = mat;
		this.blockSound = blockSound;
		this.creativeTab = creativeTab;
	}

	public IName getName()
	{
		return this.blockName;
	}

	public Block.SoundType getBlockSound()
	{
		return this.blockSound;
	}

	public CreativeTabs getCreativeTab()
	{
		return this.creativeTab;
	}

	public Material getMaterial()
	{
		return this.mat;
	}

	public float getHardness() { return this.hardness; }

	public ATexture getTexture() { return this.texture; }
}
