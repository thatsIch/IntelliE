package de.thatsich.intellie.applied.aerodynamics.decorative.generic.module;

import de.thatsich.intellie.applied.aerodynamics.common.AppliedAerodynamicsCreativeTab;
import de.thatsich.intellie.common.module.block.ABlockInfo;
import net.minecraft.block.material.Material;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 @author thatsIch
 @since 01.04.2014. */
@Singleton
public class GenericBlockInfo extends ABlockInfo
{
	@Inject
	public GenericBlockInfo(
			final GenericBlockName blockName,
			final GenericTexture texture,
			final GenericSoundType blockSound,
			final AppliedAerodynamicsCreativeTab creativeTab )
	{
		super( blockName, texture, 3.0F, Material.iron, blockSound, creativeTab );
	}
}
