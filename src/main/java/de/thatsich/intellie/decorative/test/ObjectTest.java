package de.thatsich.intellie.decorative.test;

import de.thatsich.common.AMinecraftObject;
import de.thatsich.intellie.decorative.test.module.BlockTest;

import javax.inject.Inject;

/**
 * @author thatsIch
 * @date 18.02.14.
 */
public class ObjectTest extends AMinecraftObject
{
	@Inject
	public ObjectTest ( final BlockTest block )
	{
		super( block );
	}
}
