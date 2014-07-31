package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.functional.dissembler

import net.minecraft.block.Block
import net.minecraft.entity.player.{EntityPlayer, EntityPlayerMP}
import net.minecraft.item.ItemStack
import net.minecraft.world.World

/**
 *
 *
 * @author thatsIch
 * @since 28.07.2014.
 */
trait PrecisionHarvester extends MouseEventHandler //PlayerUseItemEventHandler
{
	def precisionHarvest( is: ItemStack, world: World, player: EntityPlayer, x: Int, y: Int, z: Int ): Boolean =
	{
		val block: Block = world.getBlock( x, y, z )
		val meta: Int = world.getBlockMetadata( x, y, z )

		precondition( is, world, player, block, x, y, z, meta ) ||
			precisionHarvestBoth( is, player ) ||
			precisionHarvestServer( is, world, player, x, y, z )
	}

	/**
	 * Performance optimization.
	 * Results in early true if
	 * - block is null
	 * - block is air
	 * - block is indestructible
	 * - block can not be harvested by player
	 *
	 * @param is using item
	 * @param world current world
	 * @param player player using item
	 * @param block block using on
	 *
	 * @return true if server does not need to process further
	 */
	private def precondition( is: ItemStack, world: World, player: EntityPlayer, block: Block, x: Int, y: Int, z: Int, meta: Int ): Boolean =
	{
		block == null ||
			block.isAir( world, x, y, z ) ||
			block.getBlockHardness( world, x, y, z ) < 0 ||
			!block.canHarvestBlock( player, meta ) ||
			(this.inUse && world.isRemote)
	}

	private def precisionHarvestBoth( is: ItemStack, player: EntityPlayer ): Boolean =
	{
		player.swingItem( )
		player.setItemInUse( is, 1000 )
		this.inUse = true

		false
	}

	private def precisionHarvestServer( is: ItemStack, world: World, player: EntityPlayer, x: Int, y: Int, z: Int ): Boolean =
	{
		if( !world.isRemote || player.isInstanceOf[ EntityPlayerMP ] )
		{
			val playerMP: EntityPlayerMP = player.asInstanceOf[ EntityPlayerMP ]
			playerMP.theItemInWorldManager.tryHarvestBlock( x, y, z )

			playerMP.mcServer.getConfigurationManager.syncPlayerInventory( playerMP )
		}

		false
	}
}
