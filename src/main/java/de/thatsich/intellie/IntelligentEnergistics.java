package de.thatsich.intellie;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.thatsich.common.AGuiceMod;
import de.thatsich.common.AMinecraftModule;
import de.thatsich.intellie.common.proxies.CommonProxy;
import de.thatsich.intellie.decorative.test.ModuleTest;

import java.util.LinkedList;
import java.util.List;

@Mod(modid = "intellie", name = "IntelligentEnergistics", version = "${version}", dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,)")
public class IntelligentEnergistics extends AGuiceMod
{
	@SidedProxy(clientSide = "de.thatsich.intellie.common.proxies.ClientProxy", serverSide = "de.thatsich.intellie.common.proxies.CommonProxy")
	public static CommonProxy s_proxy;

	@Override
	public List<Class<? extends AMinecraftModule>> initModules ()
	{
		final List<Class<? extends AMinecraftModule>> classModules = new LinkedList<>();

		classModules.add( ModuleTest.class );

		return classModules;
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
