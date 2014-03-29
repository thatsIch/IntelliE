package de.thatsich.intellie.applied.aerodynamics;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import de.thatsich.intellie.applied.aerodynamics.common.AppliedAerodynamicsCreativeTab;
import de.thatsich.intellie.common.ABaseMod;
import de.thatsich.intellie.common.util.ICommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 @author thatsIch
 @date 16.03.14. */
@Mod(
	modid = "appaero",
	name = "AppliedAerodynamics",
	version = "${version}",
	dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,) ;after:appliedenergistics2")
public class AppliedAerodynamics extends ABaseMod
{
	public static final ItemArmor ITEM_GRAVI_CHEST_PLATE = new ItemGraviChestPlate( ItemArmor.ArmorMaterial.DIAMOND, 1, 1 );
	public static final Block BLOCK_GENERIC = new GenericBlock( Material.ground );
	public static final Item ITEM_VAJRA = new ItemVajra();

	@SidedProxy(clientSide = "de.thatsich.intellie.applied.aerodynamics.common.proxies.ClientProxy", serverSide = "de.thatsich.intellie.applied.aerodynamics.common.proxies.CommonProxy")
	public static ICommonProxy s_proxy;

	public AppliedAerodynamics ()
	{
		super();
		super.addTab( AppliedAerodynamicsCreativeTab.class );
	}

	@Override
	@Mod.EventHandler
	public void preInit ( FMLPreInitializationEvent event )
	{
		super.preInit( event );
		GameRegistry.registerItem( AppliedAerodynamics.ITEM_GRAVI_CHEST_PLATE, AppliedAerodynamics.ITEM_GRAVI_CHEST_PLATE.getUnlocalizedName() );
		GameRegistry.registerBlock( AppliedAerodynamics.BLOCK_GENERIC, AppliedAerodynamics.BLOCK_GENERIC.getUnlocalizedName() );
	}

	@Override
	@Mod.EventHandler
	public void init ( final FMLInitializationEvent event )
	{
		super.init( event );

		final ItemStack stone = new ItemStack( Blocks.stone );
		// block, size, damage value
		final ItemStack result = new ItemStack( Blocks.stone, 9 );
		GameRegistry.addRecipe( result, "xxx", "x x", "xxx", 'x', stone );
		// IREcipe mal angucken
		FMLCommonHandler.instance().bus().register( new KeyHandler() );
	}

	@Override
	@Mod.EventHandler
	public void postInit ( final FMLPostInitializationEvent event )
	{
		super.postInit( event );
	}
}
