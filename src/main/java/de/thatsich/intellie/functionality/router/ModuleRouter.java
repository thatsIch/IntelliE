package de.thatsich.intellie.functionality.router;

import com.google.inject.Inject;

import de.thatsich.intellie.functionality.router.module.BlockRouter;
import de.thatsich.intellie.functionality.router.module.EntitiyRouter;
import de.thatsich.intellie.functionality.router.module.ItemBlockRouter;
import de.thatsich.common.AMinecraftModule;


public class ModuleRouter extends AMinecraftModule
{
	@Inject
	ModuleRouter( ItemBlockRouter item, BlockRouter block, EntitiyRouter entity )
	{
		super( item, null, block, entity );
	}
}
