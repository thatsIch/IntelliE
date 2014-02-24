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

@Mod(modid = "intellie", name = "IntelligentEnergistics", version = "${version}")
public class IntelligentEnergistics extends AGuiceMod
{
	@Override
	public List<Class<? extends AMinecraftModule>> initModules (  )
	{
		final List<Class<? extends AMinecraftModule>> classModules = new LinkedList<>(  );

		classModules.add( ModuleTest.class );

		return classModules;
	}

	@SidedProxy( clientSide = "de.thatsich.intellie.common.proxies.ClientProxy", serverSide = "de.thatsich.intellie.common.proxies.CommonProxy" )
	public static CommonProxy proxy;

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
