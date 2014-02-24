package de.thatsich.common.handler;

import com.google.inject.Singleton;
import net.minecraftforge.common.config.Configuration;

import java.io.File;


@Singleton
public class HandlerConfig
{
//	@Inject
//	private RegistryBlock handlerBlock;
	
//	@Inject
//	private HandlerItem handlerItem;
	
	public void load( File file )
	{
		Configuration config = new Configuration( file);
//		final List<ABlock> blocks = this.handlerBlock.getBlocks();
//		final List<AItem> items = this.handlerItem.getItems();
		
		config.load();
		
		
		
//		for ( IHandling registration : this.tasks )
//		{
//			if (registration.isBlock()) {
//				
//			}
//			else {
//				
//			}
//			
//		}
		
		config.save();
	}
}
