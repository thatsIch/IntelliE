package de.thatsich.common.module.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public abstract class AItem extends Item implements IItem
{
	private final AItemTexture itemTexture;

	protected AItem( AItemTexture itemTexture )
	{
		super();

		this.itemTexture = itemTexture;
	}

	@Override
	public void registerIcons ( final IIconRegister par1IconRegister )
	{
		final String texture = this.itemTexture.getTexture();
		this.itemIcon = par1IconRegister.registerIcon( texture );
	}
}
