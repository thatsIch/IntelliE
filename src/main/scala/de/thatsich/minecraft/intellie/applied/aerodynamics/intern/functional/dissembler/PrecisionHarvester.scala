package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler

import net.minecraft.block.Block
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.{EntityPlayer, EntityPlayerMP}
import net.minecraft.item.ItemStack
import net.minecraft.world.World

/**
 *
 *
 * @author thatsIch
 * @since 28.07.2014.
 */
trait PrecisionHarvester
{
	val collector = new EntityItemCollector

	/**
	 * Mines the block and tries to add it into the players inventory
	 *
	 * @param player Receiving player
	 * @param world  World in which the overflow will be spawned
	 * @param x      X pos
	 * @param y      Y pos
	 * @param z      Z pos
	 *
	 * @return true if something changed
	 */
	protected def instantHarvestBlockIntoInventory( player: EntityPlayer, world: World, x: Int, y: Int, z: Int ): Boolean =
	{
		println( "instantHarvestBlockIntoInventory" )
		if( this.nothingChanging( player, world, x, y, z ) )
		{
			println( "Nothing Changing" )
			return false
		}
		if( this.clientAnimation( player, world ) )
		{
			println( "Client Animation" )
			return true
		}

		println( "capturing items" )
		this.itemCapturing( player, x, y, z )
		if( this.processCapturedItemsAndCheckForChangedInventory( world, player ) )
		{
			println( "sync player inventory" )
			this.syncPlayerInventory( player )
		}

		true
	}

	/**
	 * Nothing is changing means:
	 * - if the player is sneaking then it means to wrench
	 * - if the block is an air block then there is nothing to harvest
	 * - if the block hardness is below 0 means its indestructible
	 * - if the block is unharvestable
	 * -
	 *
	 * @param player Player using item
	 * @param world  Current world of player
	 * @param x      X pos
	 * @param y      Y pos
	 * @param z      Z pos
	 *
	 * @return true if nothing is changing
	 */
	private def nothingChanging( player: EntityPlayer, world: World, x: Int, y: Int, z: Int ): Boolean =
	{
		val block: Block = world.getBlock( x, y, z )
		val meta: Int = world.getBlockMetadata( x, y, z )

		player.isSneaking || world.isAirBlock( x, y, z ) || block.getBlockHardness( world, x, y, z ) < 0 || !block.canHarvestBlock( player, meta )
	}

	/**
	 * Swings the holding item and checks if this is client side
	 *
	 * @param player swinging player
	 * @param world  current world of player
	 *
	 * @return true if this is some kind of client side
	 */
	private def clientAnimation( player: EntityPlayer, world: World ): Boolean =
	{
		player.swingItem( )

		world.isRemote || !player.isInstanceOf[ EntityPlayerMP ]
	}

	/**
	 * Captures the block the player is mining
	 *
	 * @param player mining player
	 * @param x      X pos
	 * @param y      Y pos
	 * @param z      Z pos
	 */
	private def itemCapturing( player: EntityPlayer, x: Int, y: Int, z: Int ): Unit =
	{
		this.collector.startCollecting( )
		player.asInstanceOf[ EntityPlayerMP ].theItemInWorldManager.tryHarvestBlock( x, y, z )
		this.collector.stopCollecting( )
	}

	/**
	 * Process the captured items
	 * try to add them to the players inventory
	 * and check if it was possible
	 *
	 * @param world  World in which the overflow will be spawned
	 * @param player Receiving player
	 *
	 * @return true if player received some items
	 */
	private def processCapturedItemsAndCheckForChangedInventory( world: World, player: EntityPlayer ): Boolean =
	{
		var changedInventory: Boolean = false
		for( entityItem <- this.collector.getCapturedEntities )
		{
			val itemStack: ItemStack = entityItem.getEntityItem
			changedInventory |= this.tryToaddToPlayerInventory( player, itemStack )
			this.handleOverflowOfItems( world, itemStack, entityItem )
		}

		changedInventory
	}

	/**
	 * If inventory could not fit all items, then spawn the left overs
	 *
	 * @param world      In which world they should spawn
	 * @param itemStack  The left over items
	 * @param entityItem Entity of the left over items
	 */
	private def handleOverflowOfItems( world: World, itemStack: ItemStack, entityItem: EntityItem ): Unit =
	{
		if( itemStack != null && itemStack.stackSize > 0 )
		{
			val newEntityItem: EntityItem = new EntityItem( entityItem.worldObj, entityItem.posX, entityItem.posY, entityItem.posZ, itemStack )
			world.spawnEntityInWorld( newEntityItem )
		}
	}

	/**
	 * Tries to add items to a player inventory
	 *
	 * @param player    receiving player
	 * @param itemStack to be added items
	 *
	 * @return true if added to inventory
	 */
	private def tryToaddToPlayerInventory( player: EntityPlayer, itemStack: ItemStack ): Boolean =
	{
		player.inventory.addItemStackToInventory( itemStack )
	}

	/**
	 * Syncs the inventory of a player with the server
	 *
	 * @param player to be synched player
	 */
	private def syncPlayerInventory( player: EntityPlayer ): Unit =
	{
		val playerMP: EntityPlayerMP = player.asInstanceOf[ EntityPlayerMP ]
		playerMP.mcServer.getConfigurationManager.syncPlayerInventory( playerMP )
	}
}
