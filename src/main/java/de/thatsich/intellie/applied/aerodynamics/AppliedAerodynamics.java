package de.thatsich.intellie.applied.aerodynamics;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.thatsich.common.ABaseMod;
import de.thatsich.common.module.IModule;

import java.util.Collection;

/**
 * @author thatsIch
 * @date 16.03.14.
 */
@Mod(
	modid = "appaero",
	name = "AppliedAerodynamics",
	version = "${version}",
	dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,) ;after:appliedenergistics2"
)
public class AppliedAerodynamics extends ABaseMod
{
	@Override
	protected void initModules ( final Collection<IModule> modules )
	{

	}

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
