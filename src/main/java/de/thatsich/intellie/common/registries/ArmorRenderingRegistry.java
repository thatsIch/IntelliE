package de.thatsich.intellie.common.registries;

import cpw.mods.fml.client.registry.RenderingRegistry;
import de.thatsich.intellie.common.util.logging.ILog;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.HashSet;

/**
 @author thatsIch
 @date 24.03.2014. */
@Singleton
public class ArmorRenderingRegistry
{
	private final Collection<String> armorRenderers;
	private final ILog log;

	@Inject
	public ArmorRenderingRegistry ( final ILog log )
	{
		this.log = log;
		this.armorRenderers = new HashSet<>( 1 );
	}

	void addRenderer ( String armor )
	{
		this.armorRenderers.add( armor );
		this.log.debug( "Added ArmorRenderer %s", armor );
	}

	private void registerRenderers ()
	{
		for ( String armor : this.armorRenderers )
		{
			RenderingRegistry.addNewArmourRendererPrefix( armor );
		}
		this.log.info( "Registered all ArmorRenderers" );
	}
}
