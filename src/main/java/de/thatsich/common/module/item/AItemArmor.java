package de.thatsich.common.module.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * @author thatsIch
 * @date 21.03.2014.
 */
public class AItemArmor extends ItemArmor implements IItemArmor
{
	private static final int MAX_CHARGE = 3000000;
	private static final int TRANSFER_LIMIT = 60000;
	private static final int MIN_CHARGE = 80000;
	private static final int DISCHARGE_PER_TICK = 250;
	private static final float BOOST_SPEED = 0.11F;
	private static final int BOOST_MULTIPLIER = 2;

	private final int textureID;

	public AItemArmor ( final ItemArmor.ArmorMaterial material, final int renderIndex, final int armorType )
	{
		super( material, renderIndex, armorType );

		this.textureID = armorType;

		this.setCreativeTab( CreativeTabs.tabCombat );


		//		GameRegistry.registerItem( item, item.getUnlocalizedName().replace( "item.", "" ) );

		//		CreativeTabs

		//		Recipe

		//		Texture


		//		@Override in proxy
		//		public int addArmor(String armor)
		//		{
		//			return RenderingRegistry.addNewArmourRendererPrefix( armor );
		//		}
	}

	@Override
	public boolean getIsRepairable ( final ItemStack itemToRepair, final ItemStack itemToRepairWith )
	{
		return false;
	}

	@Override
	public String getArmorTexture ( final ItemStack stack, final Entity entity, final int slot, final String type )
	{
		return "appaero:textures/suite/armor.png";
	}
}
