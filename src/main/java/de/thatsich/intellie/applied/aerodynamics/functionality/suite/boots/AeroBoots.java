package de.thatsich.intellie.applied.aerodynamics.functionality.suite.boots;

import de.thatsich.intellie.common.IInstantiate;
import de.thatsich.intellie.common.module.item.AItemArmor;
import net.minecraft.item.ItemArmor;

/**
 @author thatsIch
 @since 30.03.2014. */
public class AeroBoots extends AItemArmor implements IInstantiate
{
	public AeroBoots ( final ItemArmor.ArmorMaterial material, final int renderIndex, final int armorType )
	{
		super( material, renderIndex, armorType );
	}
}
