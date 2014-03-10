package de.thatsich.intellie.decorative.test;

import de.thatsich.common.AMinecraftObject;
import de.thatsich.intellie.decorative.test.module.BlockTest;

import javax.inject.Inject;

/**
 * @author thatsIch
 * @date 18.02.14.
 */
public class Test extends AMinecraftObject
{
	@Inject
	public Test ( final BlockTest block )
	{
		super( block );
	}
}
