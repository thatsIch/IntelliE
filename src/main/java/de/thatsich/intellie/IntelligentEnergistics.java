package de.thatsich.intellie;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.thatsich.common.ADIMod;
import de.thatsich.common.module.IModule;

import java.util.Collection;

@Mod(modid = "intellie", name = "IntelligentEnergistics", version = "${version}", dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,);required-after:appliedenergistics2")
public class IntelligentEnergistics extends ADIMod
{
	//	@Mod.Instance(value = "intellie")
	//	public static IntelligentEnergistics s_instance;
	//
	//	@SidedProxy(clientSide = "de.thatsich.intellie.common.proxies.ClientProxy", serverSide = "de.thatsich.intellie.common.proxies.CommonProxy")
	//	public static CommonProxy s_proxy;

	@Override
	protected void initModules ( Collection<? extends IModule> modules )
	{
//		modules.add( ModuleTest.class );
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
