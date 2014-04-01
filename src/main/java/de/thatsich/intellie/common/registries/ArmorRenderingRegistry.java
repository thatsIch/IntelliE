package de.thatsich.intellie.common.registries;

import cpw.mods.fml.client.registry.RenderingRegistry;
import de.thatsich.intellie.common.util.logging.ILog;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.HashSet;

/**
 Registry for armor rendering
 Add an armor to it which
 will be registered into the actual registry
 in pre-init automatically

 @author thatsIch
 @since 24.03.2014. */
@Singleton
public class ArmorRenderingRegistry implements IRegistry<String>
{
	// Fields
	private final Collection<String> armorRenderers;
	private final ILog log;

	@Inject
	public ArmorRenderingRegistry ( final ILog log )
	{
		this.log = log;
		this.armorRenderers = new HashSet<>( 1 );
	}

	@Override
	public void add ( final String armor )
	{
		this.armorRenderers.add( armor );
		this.log.debug( "Added ArmorRenderer %s", armor );
	}

	@Override
	public void register ()
	{
		for ( String armor : this.armorRenderers )
		{
			RenderingRegistry.addNewArmourRendererPrefix( armor );
		}
		this.log.info( "Registered all ArmorRenderers" );
	}
}
