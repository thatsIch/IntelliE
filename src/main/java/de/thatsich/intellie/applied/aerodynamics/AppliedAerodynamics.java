package de.thatsich.intellie.applied.aerodynamics;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.intellie.applied.aerodynamics.functionality.suite.chest.ItemGraviChestPlate;
import de.thatsich.intellie.applied.aerodynamics.functionality.suite.chest.KeyHandler;
import de.thatsich.intellie.applied.aerodynamics.functionality.tool.vajra.ItemVajra;
import de.thatsich.intellie.common.ABaseMod;
import de.thatsich.intellie.common.util.ICommonProxy;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 @author thatsIch
 @since 16.03.14. */
@Mod(
		modid = "appaero",
		name = "AppliedAerodynamics",
		version = "${version}",
		dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,) ;after:appliedenergistics2")
public class AppliedAerodynamics extends ABaseMod
{
	public static final ItemArmor ITEM_GRAVI_CHEST_PLATE = new ItemGraviChestPlate( ItemArmor.ArmorMaterial.DIAMOND, 1, 1 );
	public static final Item ITEM_VAJRA = new ItemVajra();
	//	public static ItemArmor ITEM_AERO_CHEST;

	@SidedProxy(clientSide = "de.thatsich.intellie.applied.aerodynamics.common.proxies.ClientProxy", serverSide = "de.thatsich.intellie.applied.aerodynamics.common.proxies.CommonProxy")
	public static ICommonProxy s_proxy;

	@Override
	@Mod.EventHandler
	public void preInit( FMLPreInitializationEvent event )
	{
		super.preInit( event );

		System.out.println( "Props: " + event.getVersionProperties() );

		//		AppliedAerodynamics.ITEM_AERO_CHEST

		GameRegistry.registerItem( AppliedAerodynamics.ITEM_GRAVI_CHEST_PLATE, AppliedAerodynamics.ITEM_GRAVI_CHEST_PLATE.getUnlocalizedName() );
		//		GameRegistry.registerBlock( AppliedAerodynamics.BLOCK_GENERIC, AppliedAerodynamics.BLOCK_GENERIC.getUnlocalizedName() );
	}

	@Override
	@Mod.EventHandler
	public void init( final FMLInitializationEvent event )
	{
		super.init( event );

		final ItemStack stone = new ItemStack( Blocks.stone );
		// block, size, damage value
		final ItemStack result = new ItemStack( Blocks.stone, 9 );
		GameRegistry.addRecipe( result, "xxx", "x x", "xxx", 'x', stone );
//		GameRegistry.addRecipe(new VajraRecipe());
		// IREcipe mal angucken
//		ClientRegistry.registerKeyBinding(  );
		FMLCommonHandler.instance().bus().register( new KeyHandler() );
	}

	@Override
	@Mod.EventHandler
	public void postInit( final FMLPostInitializationEvent event )
	{
		super.postInit( event );
	}
}
