package de.thatsich.intellie.applied.aerodynamics;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

/**
 @author thatsIch
 @since 30.03.2014. */
public class VajraRecipe implements IRecipe
{
	@Override
	public boolean matches ( final InventoryCrafting var1, final World world )
	{
		return true;
	}

	@Override
	public ItemStack getCraftingResult ( final InventoryCrafting inv )
	{
		final String inventoryName = inv.getInventoryName();
		//		inv.get
		System.out.println( "inventoryName = " + inventoryName );

		return null;
	}

	@Override
	public int getRecipeSize ()
	{
		return 9;
	}

	@Override
	public ItemStack getRecipeOutput ()
	{
		return null;
	}
}
