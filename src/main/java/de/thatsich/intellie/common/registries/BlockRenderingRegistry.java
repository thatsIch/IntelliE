package de.thatsich.intellie.common.registries;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import de.thatsich.intellie.common.util.logging.ILogger;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.LinkedList;

/**
 @author thatsIch
 @date 24.03.2014. */
@Singleton
public class BlockRenderingRegistry
{
	private final Collection<ISimpleBlockRenderingHandler> blockRenderers;
	private final ILogger log;

	@Inject
	public BlockRenderingRegistry ( final ILogger log )
	{
		this.log = log;
		this.blockRenderers = new LinkedList<>();
	}

	public void addRenderer ( ISimpleBlockRenderingHandler handler )
	{
		this.blockRenderers.add( handler );
		this.log.debug( "Added BlockRenderer %s", handler );
	}

	public void registerRenderers ()
	{
		for ( ISimpleBlockRenderingHandler handler : this.blockRenderers )
		{
			RenderingRegistry.registerBlockHandler( handler );
		}
		this.log.info( "Registered all BlockRenderers" );
	}
}
