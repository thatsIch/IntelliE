package de.thatsich.intellie.applied.aerodynamics.decorative.generic;

import de.thatsich.intellie.applied.aerodynamics.decorative.generic.module.GenericBlockConfig;
import de.thatsich.intellie.applied.aerodynamics.decorative.generic.module.GenericBlockInfo;
import de.thatsich.intellie.applied.aerodynamics.decorative.generic.module.GenericTexture;
import de.thatsich.intellie.common.module.block.ABlock;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author thatsIch
 * @since 27.03.2014.
 */
@Singleton
public class GenericBlock extends ABlock {
	private static final float HARDNESS = 0.5F;

	@Inject
	public GenericBlock(GenericBlockInfo info, GenericBlockConfig config, GenericTexture blockTexture) {
		super(info, config, blockTexture);

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
