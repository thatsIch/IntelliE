package de.thatsich.minecraft.intellie.applied.aerodynamics.intern.module.dissembler.item


import appeng.api.AEApi
import net.minecraft.block.Block
import net.minecraft.entity.player.{EntityPlayer, EntityPlayerMP}
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.world.World


/**
 *
 *
 * @author thatsIch
 * @since 28.07.2014.
 */
private[dissembler] trait PrecisionHarvester extends Item
                                                     with MouseEventHandler
{
	/**
	 * harvests block into inventory
	 * returns false to process server side too
	 *
	 * @param stack using item
	 * @param player using player
	 * @param world current world of player
	 * @param x x coord
	 * @param y y coord
	 * @param z z coord
	 * @param side side of interacting block
	 * @param hitX hitbox x
	 * @param hitY hitbox y
	 * @param hitZ hitbox z
	 * @return true to stop further processing
	 */
	override def onItemUseFirst(stack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, hitX: Float, hitY: Float, hitZ: Float): Boolean =
	{
		val block: Block = world.getBlock(x, y, z)
		val blockCharger = AEApi.instance().blocks().blockCharger

		if (blockCharger.sameAs(new ItemStack(block)))
		{
			false
		}
		else if (this.canHarvestBlock(block, stack))
		{
			this.precisionHarvest(stack, world, player, x, y, z)
		}
		else
		{
			true
		}
	}

	private def precisionHarvest(is: ItemStack, world: World, player: EntityPlayer, x: Int, y: Int, z: Int): Boolean =
	{
		val block: Block = world.getBlock(x, y, z)
		val meta: Int = world.getBlockMetadata(x, y, z)

		precondition(is, world, player, block, x, y, z, meta) ||
			precisionHarvestBoth(is, player) ||
			precisionHarvestServer(is, world, player, x, y, z)
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
	private def precondition(is: ItemStack, world: World, player: EntityPlayer, block: Block, x: Int, y: Int, z: Int, meta: Int): Boolean =
	{
		block == null ||
			block.isAir(world, x, y, z) ||
			block.getBlockHardness(world, x, y, z) < 0 ||
			!block.canHarvestBlock(player, meta) ||
			(this.inUse && world.isRemote)
	}

	private def precisionHarvestBoth(is: ItemStack, player: EntityPlayer): Boolean =
	{
		player.swingItem()
		player.setItemInUse(is, 1000)
		this.inUse = true

		false
	}

	private def precisionHarvestServer(is: ItemStack, world: World, player: EntityPlayer, x: Int, y: Int, z: Int): Boolean =
	{
		if (!world.isRemote || player.isInstanceOf[EntityPlayerMP])
		{
			val playerMP: EntityPlayerMP = player.asInstanceOf[EntityPlayerMP]
			playerMP.theItemInWorldManager.tryHarvestBlock(x, y, z)

			playerMP.mcServer.getConfigurationManager.syncPlayerInventory(playerMP)
		}

		false
	}
}
