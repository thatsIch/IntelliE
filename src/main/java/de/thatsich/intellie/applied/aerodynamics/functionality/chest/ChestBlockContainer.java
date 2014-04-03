package de.thatsich.intellie.applied.aerodynamics.functionality.chest;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.thatsich.intellie.common.ABaseMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 @author thatsIch
 @since 03.04.2014. */
public class ChestBlockContainer extends BlockContainer
{
	private static int[] sideMapping = { 0, 0, 2, 1, 2, 2, 2 };
	private static String[] sideNames = { "top", "front", "side" };
	private final Random random;
	@SideOnly( Side.CLIENT )
	private final IIcon[] icons;
	private final ABaseMod instance;

	public ChestBlockContainer( ABaseMod instance )
	{
		super( Material.iron );

		this.random = new Random();
		this.icons = new IIcon[3];
		this.instance = instance;

		this.setBlockName( "Chest" );
		this.setHardness( 3.0F );
		this.setBlockBounds( 0.0625F, 0F, 0.0625F, 0.9375F, 0.875F, 0.9375F );
		this.setCreativeTab( CreativeTabs.tabDecorations );
	}

	@Override
	public TileEntity createNewTileEntity( final World world, final int i )
	{
		return null;
	}

	@Override
	public boolean renderAsNormalBlock() { return false; }

	@Override
	public int getRenderType() { return 22; }

	@SideOnly( Side.CLIENT )
	@Override
	public IIcon getIcon( int side, int j )
	{
		return this.icons[sideMapping[side]];
	}

	@Override
	public boolean isOpaqueCube() { return false; }

	@Override
	public int damageDropped( int i )
	{
		return i;
	}

	@Override
	public boolean onBlockActivated( World world, int i, int j, int k, EntityPlayer player, int i1, float f1, float f2, float f3 )
	{
		TileEntity te = world.getTileEntity( i, j, k );

		if( te == null || !( te instanceof ChestTileEntity ) )
		{
			return true;
		}

		if( world.isSideSolid( i, j + 1, k, ForgeDirection.DOWN ) )
		{
			return true;
		}

		if( world.isRemote )
		{
			return true;
		}

		player.openGui( instance, 0, world, i, j, k );
		return true;
	}

	@Override
	public void onBlockPlacedBy( World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack itemStack )
	{
		byte chestFacing = 0;
		int facing = MathHelper.floor_double( (double) ( ( entityliving.rotationYaw * 4F ) / 360F ) + 0.5D ) & 3;
		if( facing == 0 )
		{
			chestFacing = 2;
		}
		if( facing == 1 )
		{
			chestFacing = 5;
		}
		if( facing == 2 )
		{
			chestFacing = 3;
		}
		if( facing == 3 )
		{
			chestFacing = 4;
		}
		TileEntity te = world.getTileEntity( i, j, k );
		if( te != null && te instanceof ChestTileEntity )
		{
			ChestTileEntity teic = (ChestTileEntity) te;
			teic.setFacing( chestFacing );
			world.markBlockForUpdate( i, j, k );
		}
	}

	@Override
	@SuppressWarnings( { "rawtypes", "unchecked" } )
	@SideOnly(Side.CLIENT)
	public void getSubBlocks( Item par1, CreativeTabs par2CreativeTabs, List list )
	{
		list.add( new ItemStack( this, 1 ) );
	}

	@Override
	public int getComparatorInputOverride( World world, int x, int y, int z, int par5 )
	{
		final ChestTileEntity te = (ChestTileEntity) world.getTileEntity( x, y, z );

		return Container.calcRedstoneFromInventory( te );
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons( IIconRegister register )
	{
		int i = 0;
		for( final String side : sideNames )
		{
			final String name = String.format( "appaero:chest_%s", side );
			this.icons[i++] = register.registerIcon( name );
		}
	}

	@Override
	public TileEntity createTileEntity( World world, int metadata )
	{
		try
		{
			return ChestTileEntity.class.newInstance();
		}
		catch( InstantiationException | IllegalAccessException e )
		{
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<ItemStack> getDrops( World world, int x, int y, int z, int metadata, int fortune )
	{
		final ArrayList<ItemStack> items = Lists.newArrayList();
		final ItemStack stack = new ItemStack( this, 1, metadata );
		items.add( stack );

		return items;
	}

	@Override
	public void onBlockAdded( World world, int i, int j, int k )
	{
		super.onBlockAdded( world, i, j, k );
		world.markBlockForUpdate( i, j, k );
	}

	@Override
	public void breakBlock( World world, int i, int j, int k, Block i1, int i2 )
	{
		ChestTileEntity tileentitychest = (ChestTileEntity) world.getTileEntity( i, j, k );
		if( tileentitychest != null )
		{
			dropContent( 0, tileentitychest, world, tileentitychest.xCoord, tileentitychest.yCoord, tileentitychest.zCoord );
		}
		super.breakBlock( world, i, j, k, i1, i2 );
	}

	public void dropContent( int newSize, IInventory chest, World world, int xCoord, int yCoord, int zCoord )
	{
		for( int l = newSize; l < chest.getSizeInventory(); l++ )
		{
			ItemStack itemstack = chest.getStackInSlot( l );
			if( itemstack == null )
			{
				continue;
			}
			float f = random.nextFloat() * 0.8F + 0.1F;
			float f1 = random.nextFloat() * 0.8F + 0.1F;
			float f2 = random.nextFloat() * 0.8F + 0.1F;
			while( itemstack.stackSize > 0 )
			{
				int i1 = random.nextInt( 21 ) + 10;
				if( i1 > itemstack.stackSize )
				{
					i1 = itemstack.stackSize;
				}
				itemstack.stackSize -= i1;
				EntityItem entityitem = new EntityItem( world, (float) xCoord + f, (float) yCoord + ( newSize > 0 ? 1 : 0 ) + f1, (float) zCoord + f2,
						new ItemStack( itemstack.getItem(), i1, itemstack.getItemDamage() ) );
				float f3 = 0.05F;
				entityitem.motionX = (float) random.nextGaussian() * f3;
				entityitem.motionY = (float) random.nextGaussian() * f3 + 0.2F;
				entityitem.motionZ = (float) random.nextGaussian() * f3;
				if( itemstack.hasTagCompound() )
				{
					entityitem.getEntityItem().setTagCompound( (NBTTagCompound) itemstack.getTagCompound().copy() );
				}
				world.spawnEntityInWorld( entityitem );
			}
		}
	}
}
