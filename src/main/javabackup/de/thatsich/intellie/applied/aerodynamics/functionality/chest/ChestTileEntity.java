package de.thatsich.intellie.applied.aerodynamics.functionality.chest;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

/**
 @author thatsIch
 @since 03.04.2014. */
public class ChestTileEntity extends TileEntity implements IInventory
{
	public float prevLidAngle;
	public float lidAngle;
	private int facing;
	private ItemStack[] chestContents;
	private int ticksSinceSync = -1;
	private int numUsingPlayers;
	private boolean hadStuff;

	public ChestTileEntity( final int facing )
	{
		super();
		this.chestContents = new ItemStack[54];
	}

	public ItemStack[] getChestContents()
	{
		return this.chestContents;
	}

	public ChestTileEntity updateFromMetadata( int l )
	{
		if( worldObj != null && worldObj.isRemote )
		{
			worldObj.setTileEntity( xCoord, yCoord, zCoord, null );
			return (ChestTileEntity) worldObj.getTileEntity( xCoord, yCoord, zCoord );
		}
		return this;
	}

	public void handlePacketData( int[] intData )
	{
//		final ChestTileEntity chest = this;
//		if( this.type.ordinal() != typeData )
//		{
//			chest = updateFromMetadata( typeData );
//		}
//		if( IronChestType.values()[typeData].isTransparent() && intData != null )
//		{
//			int pos = 0;
//			if( intData.length < chest.topStacks.length * 3 )
//			{
//				return;
//			}
//			for( int i = 0; i < chest.topStacks.length; i++ )
//			{
//				if( intData[pos + 2] != 0 )
//				{
//					Item it = Item.getItemById( intData[pos] );
//					ItemStack is = new ItemStack( it, intData[pos + 2], intData[pos + 1] );
//					chest.topStacks[i] = is;
//				}
//				else
//				{
//					chest.topStacks[i] = null;
//				}
//				pos += 3;
//			}
//		}
	}

	public void setMaxStackSize( int size )
	{

	}

	void rotateAround( ForgeDirection axis )
	{
		setFacing( (byte) ForgeDirection.getOrientation( facing ).getRotation( axis ).ordinal() );
		worldObj.addBlockEvent( this.xCoord, this.yCoord, this.zCoord, null, 2, getFacing() );
	}

	public int getFacing()
	{
		return facing;
	}

	public void setFacing( int facing )
	{
		this.facing = facing;
	}

	public void wasPlaced( EntityLivingBase entityliving, ItemStack itemStack )
	{
	}

	@Override
	public void readFromNBT( final NBTTagCompound nbttagcompound )
	{
		super.readFromNBT( nbttagcompound );
		NBTTagList nbttaglist = nbttagcompound.getTagList( "Items", Constants.NBT.TAG_COMPOUND );
		chestContents = new ItemStack[getSizeInventory()];
		for( int i = 0; i < nbttaglist.tagCount(); i++ )
		{
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt( i );
			int j = nbttagcompound1.getByte( "Slot" ) & 0xff;
			if( j >= 0 && j < chestContents.length )
			{
				chestContents[j] = ItemStack.loadItemStackFromNBT( nbttagcompound1 );
			}
		}
		facing = nbttagcompound.getByte( "facing" );
	}

	@Override
	public int getSizeInventory()
	{
		return 54;
	}

	@Override
	public ItemStack getStackInSlot( final int slotNumber )
	{
		return this.chestContents[slotNumber];
	}

	@Override
	public ItemStack decrStackSize( final int i, final int j )
	{
		if( chestContents[i] != null )
		{
			if( chestContents[i].stackSize <= j )
			{
				ItemStack itemstack = chestContents[i];
				chestContents[i] = null;
				markDirty();
				return itemstack;
			}
			ItemStack itemstack1 = chestContents[i].splitStack( j );
			if( chestContents[i].stackSize == 0 )
			{
				chestContents[i] = null;
			}
			markDirty();
			return itemstack1;
		}
		else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing( int par1 )
	{
		if( this.chestContents[par1] != null )
		{
			ItemStack var2 = this.chestContents[par1];
			this.chestContents[par1] = null;
			return var2;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents( final int i, final ItemStack itemstack )
	{
		chestContents[i] = itemstack;
		if( itemstack != null && itemstack.stackSize > getInventoryStackLimit() )
		{
			itemstack.stackSize = getInventoryStackLimit();
		}
		markDirty();
	}

	@Override
	public String getInventoryName()
	{
		return "Chest";
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer( final EntityPlayer entityPlayer )
	{
		return worldObj == null || worldObj.getTileEntity( xCoord, yCoord, zCoord ) == this && entityPlayer.getDistanceSq( (double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D ) <= 64D;
	}

	@Override
	public void openInventory()
	{
		if( worldObj == null ) { return; }
		numUsingPlayers++;
		worldObj.addBlockEvent( xCoord, yCoord, zCoord, null, 1, numUsingPlayers );
	}

	@Override
	public void closeInventory()
	{
		if( worldObj == null ) { return; }
		numUsingPlayers--;
		worldObj.addBlockEvent( xCoord, yCoord, zCoord, null, 1, numUsingPlayers );
	}

	@Override
	public boolean isItemValidForSlot( int i, ItemStack itemstack )
	{
		return itemstack != null;
	}

	@Override
	public void writeToNBT( final NBTTagCompound nbttagcompound )
	{
		super.writeToNBT( nbttagcompound );
		NBTTagList nbttaglist = new NBTTagList();
		for( int i = 0; i < chestContents.length; i++ )
		{
			if( chestContents[i] != null )
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte( "Slot", (byte) i );
				chestContents[i].writeToNBT( nbttagcompound1 );
				nbttaglist.appendTag( nbttagcompound1 );
			}
		}

		nbttagcompound.setTag( "Items", nbttaglist );
		nbttagcompound.setByte( "facing", (byte) facing );
	}

	@Override
	public void updateEntity()
	{
		super.updateEntity();
		// Resynchronize clients with the server state
		if( worldObj != null && !this.worldObj.isRemote && this.numUsingPlayers != 0 && ( this.ticksSinceSync + this.xCoord + this.yCoord + this.zCoord ) % 200 == 0 )
		{
			this.numUsingPlayers = 0;
			float var1 = 5.0F;
			@SuppressWarnings( "unchecked" )
			List<EntityPlayer> entityPlayers = this.worldObj.getEntitiesWithinAABB( EntityPlayer.class, AxisAlignedBB.getAABBPool().getAABB( (double) ( (float) this.xCoord - var1 ), (double) ( (float) this.yCoord - var1 ), (double) ( (float) this.zCoord - var1 ), (double) ( (float) ( this.xCoord + 1 ) + var1 ), (double) ( (float) ( this.yCoord + 1 ) + var1 ), (double) ( (float) ( this.zCoord + 1 ) + var1 ) ) );

			for( final EntityPlayer entityPlayer : entityPlayers )
			{
				if( entityPlayer.openContainer instanceof ChestContainer )
				{
					++this.numUsingPlayers;
				}
			}
		}

		if( worldObj != null && !worldObj.isRemote && ticksSinceSync < 0 )
		{
			worldObj.addBlockEvent( xCoord, yCoord, zCoord, null, 3, ( ( numUsingPlayers << 3 ) & 0xF8 ) | ( facing & 0x7 ) );
		}

		this.ticksSinceSync++;
		prevLidAngle = lidAngle;
		float f = 0.1F;
		if( numUsingPlayers > 0 && lidAngle == 0.0F )
		{
			double d = (double) xCoord + 0.5D;
			double d1 = (double) zCoord + 0.5D;
			worldObj.playSoundEffect( d, (double) yCoord + 0.5D, d1, "random.chestopen", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F );
		}
		if( numUsingPlayers == 0 && lidAngle > 0.0F || numUsingPlayers > 0 && lidAngle < 1.0F )
		{
			float f1 = lidAngle;
			if( numUsingPlayers > 0 )
			{
				lidAngle += f;
			}
			else
			{
				lidAngle -= f;
			}
			if( lidAngle > 1.0F )
			{
				lidAngle = 1.0F;
			}
			float f2 = 0.5F;
			if( lidAngle < f2 && f1 >= f2 )
			{
				double d2 = (double) xCoord + 0.5D;
				double d3 = (double) zCoord + 0.5D;
				worldObj.playSoundEffect( d2, (double) yCoord + 0.5D, d3, "random.chestclosed", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F );
			}
			if( lidAngle < 0.0F )
			{
				lidAngle = 0.0F;
			}
		}
	}

	@Override
	public Packet getDescriptionPacket()
	{
		return PacketHandler.getPacket( this );
	}

	@Override
	public boolean receiveClientEvent( int i, int j )
	{
		if( i == 1 )
		{
			numUsingPlayers = j;
		}
		else if( i == 2 )
		{
			facing = (byte) j;
		}
		else if( i == 3 )
		{
			facing = (byte) ( j & 0x7 );
			numUsingPlayers = ( j & 0xF8 ) >> 3;
		}
		return true;
	}
}
