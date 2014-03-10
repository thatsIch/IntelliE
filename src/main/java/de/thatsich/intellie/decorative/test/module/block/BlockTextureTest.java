package de.thatsich.intellie.decorative.test.module.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.thatsich.common.module.block.ABlockTexture;

import javax.inject.Inject;


@SideOnly(Side.CLIENT)
public class BlockTextureTest extends ABlockTexture
{
	@Inject
	BlockTextureTest ()
	{
		super( "intellie:test" );
	}


	//	private Icon	topIcon;
	//	private Icon	sideIcon;
	//	private Icon	botIcon;
	//
	//	@Override
	//	public void register( IconRegister register )
	//	{
	//		final String namespace = "intellie:";
	//		this.topIcon = register.registerIcon( namespace + "router_top" );
	//		this.sideIcon = register.registerIcon( namespace + "router_side" );
	//		this.botIcon = register.registerIcon( namespace + "router_bottom" );
	//	}
	//
	//	@Override
	//	public Icon getTopIcon( int meta )
	//	{
	//		return this.topIcon;
	//	}
	//
	//	@Override
	//	public Icon getBotIcon( int meta )
	//	{
	//		return this.botIcon;
	//	}
	//
	//	@Override
	//	public Icon getNorthIcon( int meta )
	//	{
	//		return this.sideIcon;
	//	}
	//
	//	@Override
	//	public Icon getSouthIcon( int meta )
	//	{
	//		return this.sideIcon;
	//	}
	//
	//	@Override
	//	public Icon getWestIcon( int meta )
	//	{
	//		return this.sideIcon;
	//	}
	//
	//	@Override
	//	public Icon getEastIcon( int meta )
	//	{
	//		return this.sideIcon;
	//	}
}
