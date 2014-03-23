package de.thatsich.intellie.common.module.item;

import de.thatsich.intellie.common.module.ATexture;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public abstract class AItem extends Item implements IItem
{
	private final ATexture itemTexture;

	protected AItem ( ATexture itemTexture )
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
