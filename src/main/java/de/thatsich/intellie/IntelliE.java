package de.thatsich.intellie;

import appeng.api.AEApi;
import com.google.inject.Guice;
import com.google.inject.Injector;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.init.Blocks;

@Mod(modid = IntelliE.MODID, version = IntelliE.VERSION)
public class IntelliE
{
	public static final String MODID = "intellie";
	public static final String VERSION = "1.0";

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		Injector injector = Guice.createInjector();
		System.out.println( injector );
		System.out.println( AEApi.class );

		// some example code
		System.out.println("DIRT BLOCK >> "+ Blocks.dirt.getLocalizedName());
	}
}
