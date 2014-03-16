package de.thatsich.intellie.applied.intelligences;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * @author thatsIch
 * @date 16.03.14.
 */
@Mod(
	modid = "appint",
	name = "AppliedIntelligences",
	version = "${version}",
	dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,)" //;required-after:appliedenergistics2"
)
public class AppliedIntelligences
{
	public AppliedIntelligences ()
	{
		System.out.println( "CTOR" );
	}

	@Mod.EventHandler
	public void preInit ( FMLPreInitializationEvent event )
	{
		System.out.println( "POOOPS" );
	}
}
