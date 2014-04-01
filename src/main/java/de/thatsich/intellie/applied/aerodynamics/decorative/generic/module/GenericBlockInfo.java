package de.thatsich.intellie.applied.aerodynamics.decorative.generic.module;

import de.thatsich.intellie.common.module.block.info.ABlockInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author thatsIch
 * @since 01.04.2014.
 */
@Singleton
public class GenericBlockInfo extends ABlockInfo {

	@Inject
	public GenericBlockInfo(GenericBlockName blockName, GenericSoundType blockSound, GenericCreativeTabs creativeTab) {
		super(blockName, blockSound, creativeTab);
	}
}
