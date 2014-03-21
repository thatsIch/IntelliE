package de.thatsich.common.module.item;

import net.minecraft.item.ItemArmor;

/**
 * @author thatsIch
 * @date 21.03.2014.
 */
public class AItemArmor extends ItemArmor
{
	private static final int MAX_CHARGE = 3000000;
	private static final int TRANSFER_LIMIT = 60000;
	private static final int MIN_CHARGE = 80000;
	private static final int DISCHARGE_PER_TICK = 250;
	private static final float BOOST_SPEED = 0.11F;
	private static final int BOOST_MULTIPLIER = 2;

	public AItemArmor ( final ItemArmor.ArmorMaterial material, final int renderIndex, final int armorType )
	{
		super( material, renderIndex, armorType );

	}
}
