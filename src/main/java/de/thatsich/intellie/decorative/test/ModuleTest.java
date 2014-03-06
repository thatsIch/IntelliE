package de.thatsich.intellie.decorative.test;

import de.thatsich.common.AMinecraftModule;
import de.thatsich.intellie.decorative.test.module.BlockTest;

import javax.inject.Inject;

/**
 * @author thatsIch
 * @date 18.02.14.
 */
public class ModuleTest extends AMinecraftModule
{
	@Inject
	public ModuleTest ( final BlockTest block )
	{
		super( null, block, null, null );
	}
}
