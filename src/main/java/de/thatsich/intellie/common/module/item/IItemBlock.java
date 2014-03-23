package de.thatsich.intellie.common.module.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 @author thatsIch
 @date 21.03.2014. */
public interface IItemBlock extends IItem
{
	/**
	 Sets the unlocalized name of this item to the string passed as the parameter, prefixed by "item."
	 */
	@Override
	ItemBlock setUnlocalizedName ( String name );

	@SideOnly(Side.CLIENT)
	boolean func_150936_a ( World p_150936_1_, int p_150936_2_, int p_150936_3_, int p_150936_4_, int p_150936_5_, EntityPlayer p_150936_6_, ItemStack p_150936_7_ );

	/**
	 Called to actually place the block, after the location is determined
	 and all permission checks have been made.

	 @param stack  The item stack that was used to place the block. This can be changed inside the method.
	 @param player The player who is placing the block. Can be null if the block is not being placed by a player.
	 @param side   The side the player (or machine) right-clicked on.
	 */
	boolean placeBlockAt ( ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata );
}
