package de.thatsich.intellie.applied.intelligences.functionality.router;

import de.thatsich.common.AMinecraftObject;
import de.thatsich.intellie.applied.intelligences.functionality.router.module.BlockRouter;
import de.thatsich.intellie.applied.intelligences.functionality.router.module.ItemBlockRouter;

import javax.inject.Inject;


public class ObjectRouter extends AMinecraftObject
{
	@Inject
	ObjectRouter ( ItemBlockRouter item, BlockRouter block )
	{
		super( item, null, block );
	}
}
