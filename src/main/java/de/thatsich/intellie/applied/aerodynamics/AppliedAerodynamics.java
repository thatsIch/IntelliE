package de.thatsich.intellie.applied.aerodynamics;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.thatsich.intellie.common.ABaseMod;
import de.thatsich.intellie.common.util.ICommonProxy;

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
	@SidedProxy(clientSide = "de.thatsich.intellie.applied.aerodynamics.common.proxies.ClientProxy", serverSide = "de.thatsich.intellie.applied.aerodynamics.common.proxies.CommonProxy")
	public static ICommonProxy s_proxy;

	@Override
	protected ICommonProxy getProxy () { return AppliedAerodynamics.s_proxy; }

	@Override
	@Mod.EventHandler
	public void preInit ( FMLPreInitializationEvent event )
	{
		super.preInit( event );
	}

	@Override
	@Mod.EventHandler
	public void init ( final FMLInitializationEvent event )
	{
		super.init( event );
	}

	@Override
	@Mod.EventHandler
	public void postInit ( final FMLPostInitializationEvent event )
	{
		super.postInit( event );
	}
}
