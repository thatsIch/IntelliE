package de.thatsich.intellie.functionality.router.module;

import de.thatsich.common.module.item.AItemBlock;
import de.thatsich.common.util.Logger;
import de.thatsich.intellie.functionality.router.module.item.ItemConfigRouter;
import de.thatsich.intellie.functionality.router.module.item.ItemInfoRouter;
import de.thatsich.intellie.functionality.router.module.item.ItemRecipeRouter;

import javax.inject.Inject;


public class ItemBlockRouter extends AItemBlock
{
	@Inject
	public ItemBlockRouter ( ItemInfoRouter info, ItemConfigRouter config, ItemRecipeRouter recipe, Logger logger )
	{
		super( info, config, recipe );

		logger.info( "ItemBlockRouter" );
	}
}
