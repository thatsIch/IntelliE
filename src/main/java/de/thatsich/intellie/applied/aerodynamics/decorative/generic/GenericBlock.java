package de.thatsich.intellie.applied.aerodynamics.decorative.generic;

import de.thatsich.intellie.common.IInstantiate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author thatsIch
 * @since 27.03.2014.
 */
@Singleton
public class GenericBlock extends Block implements IInstantiate {
	private static final float HARDNESS = 0.5F;

	@Inject
	public GenericBlock() {
		super(Material.ground);
		this.setHardness(GenericBlock.HARDNESS);
		this.setStepSound(Block.soundTypeGravel);
		this.setBlockName("genericBlock");
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	protected String getTextureName() {
		return "appaero:genericBlock";
	}
}
