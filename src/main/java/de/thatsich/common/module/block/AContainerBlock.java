package de.thatsich.common.module.block;

import com.google.inject.Inject;
import com.google.inject.Injector;
import de.thatsich.common.module.block.info.ABlockInfo;
import de.thatsich.common.module.block.info.ABlockName;
import de.thatsich.common.module.item.AItemBlock;
import de.thatsich.common.module.tileentity.ATileEntity;
import lombok.Getter;
import net.minecraft.block.BlockContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public abstract class AContainerBlock extends BlockContainer
{
	@Getter
	private final Class<? extends AItemBlock>	itemBlockClass;

	private final Class<? extends ATileEntity> tileEntityClass;

	@Inject
	private Injector injector;
	
	@Inject
	protected AContainerBlock ( ABlockInfo info, ABlockConfig config, ABlockGui gui, ABlockNetwork network, ABlockTexture texture, Class<? extends ATileEntity> tileEntityClass, Class<? extends AItemBlock> itemBlockClass )
	{
		super( info.getMaterial() );

		this.tileEntityClass = tileEntityClass;
		this.itemBlockClass = itemBlockClass;

		final ABlockName blockName = info.getBlockName();
		final String name = blockName.getName();
		final float hardness = info.getHardness();

		this.setBlockName( name );
		this.setHardness( hardness );
//		this.setBlockBounds(  );
		this.setCreativeTab( info.getCreativeTab() );
//		Player player = null;
//		InventoryPlayer play = null;
//		play.
	}

	@Override
	public TileEntity createNewTileEntity ( World world, int metadata )
	{
		return this.injector.getInstance( this.tileEntityClass );
	}
}
