package de.thatsich.intellie.applied.aerodynamics.functionality.suite.chest;

import de.thatsich.intellie.common.IInstantiate;
import de.thatsich.intellie.common.module.item.AItemArmor;
import net.minecraft.item.ItemArmor;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 @author thatsIch
 @date 20.03.2014. */
@Singleton
public class AeroChest extends AItemArmor implements IInstantiate
{
	@Inject
	public AeroChest ()
	{
		super( ItemArmor.ArmorMaterial.DIAMOND, 0, 0 );
	}
}
