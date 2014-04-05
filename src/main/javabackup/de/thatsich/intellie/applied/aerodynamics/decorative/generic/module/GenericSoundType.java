package de.thatsich.intellie.applied.aerodynamics.decorative.generic.module;

import net.minecraft.block.Block;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 @author thatsIch
 @since 01.04.2014. */
@Singleton
public class GenericSoundType extends Block.SoundType
{
	@Inject
	public GenericSoundType()
	{
		super( "gravel", 1.0F, 1.0F );
	}
}
