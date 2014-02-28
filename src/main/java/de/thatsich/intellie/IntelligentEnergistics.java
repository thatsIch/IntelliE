package de.thatsich.intellie;

import com.google.inject.Inject;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import de.thatsich.common.AGuiceMod;
import de.thatsich.common.AMinecraftModule;
import de.thatsich.common.util.IELog;
import de.thatsich.intellie.decorative.test.ModuleTest;

import java.util.Collection;
import java.util.LinkedList;

@Mod(modid = "intellie", name = "IntelligentEnergistics", version = "${version}", dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,);required-after:appliedenergistics2")
public class IntelligentEnergistics extends AGuiceMod
{
	@Inject private IELog log;
//	@Mod.Instance(value = "intellie")
//	public static IntelligentEnergistics s_instance;
//
//	@SidedProxy(clientSide = "de.thatsich.intellie.common.proxies.ClientProxy", serverSide = "de.thatsich.intellie.common.proxies.CommonProxy")
//	public static CommonProxy s_proxy;

	@Override
	public Collection<Class<? extends AMinecraftModule>> initModules ()
	{
		final Collection<Class<? extends AMinecraftModule>> classModules = new LinkedList<>();

		classModules.add( ModuleTest.class );

		return classModules;
	}

	@Override
	@Mod.EventHandler
	public void preInit ( FMLPreInitializationEvent event )
	{
		this.log.info( "PreInit " );
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
