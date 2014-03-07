package de.thatsich.intellie;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.thatsich.common.AInjectionMod;
import de.thatsich.common.module.IModule;
import de.thatsich.intellie.decorative.test.ModuleTest;

import java.util.Collection;

@Mod(modid = "intellie", name = "IntelligentEnergistics", version = "${version}", dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,);required-after:appliedenergistics2")
public class IntelligentEnergistics extends AInjectionMod
{
	//	@Mod.Instance(value = "intellie")
	//	public static IntelligentEnergistics s_instance;
	//
	//	@SidedProxy(clientSide = "de.thatsich.intellie.common.proxies.ClientProxy", serverSide = "de.thatsich.intellie.common.proxies.CommonProxy")
	//	public static CommonProxy s_proxy;

	@Override
	protected void initModules ( final Collection<IModule> modules )
	{
		modules.add( new ModuleTest() );
	}

	@Override
	@Mod.EventHandler
	public void preInit ( FMLPreInitializationEvent event )
	{
		super.preInit( event );
	}

	@Override
	@Mod.EventHandler
	public void init ( FMLInitializationEvent event )
	{
		super.init( event );
	}

	@Override
	@Mod.EventHandler
	protected void modLoaded ( FMLPostInitializationEvent event )
	{
		super.modLoaded( event );
	}
}
