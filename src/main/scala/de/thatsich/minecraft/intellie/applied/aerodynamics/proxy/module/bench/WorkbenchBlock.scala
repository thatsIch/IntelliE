package de.thatsich.minecraft
package intellie
package applied
package aerodynamics
package intern
package de.thatsich.minecraft.intellie.applied.aerodynamics.module
package bench


import net.minecraft.block.Block
import net.minecraft.entity.item.EntityItem
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World


/**
 *
 *
 * @author thatsIch
 * @since 04.08.2014.
 */
class WorkbenchBlock(modid: ID, name: ID, log: Log) extends BaseBlock(modid, name, log)
                                                            with MultiTexture
                                                            with BlockGuiHasher
{
	final private val guiID: Int = this.hash(this.name)

	override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, side: Int, hitX: Float, hitY: Float, p_149727_9_ : Float): Boolean =
	{
		if (!world.isRemote)
		{
			player.openGui(AppliedAerodynamics, this.guiID, world, x, y, z)
		}

		true
	}

	def createNewTileEntity(world: World, par2int: Int): TileEntity = new WorkbenchTileEntity

	override def breakBlock(world: World, x: Int, y: Int, z: Int, id: Block, meta: Int): Unit =
	{
		val te: TileEntity = world.getTileEntity(x, y, z)
		if (te != null && te.isInstanceOf[IInventory])
		{
			val inventory: IInventory = te.asInstanceOf[IInventory]

			for (index <- 0 until inventory.getSizeInventory)
			{
				val is: ItemStack = inventory.getStackInSlotOnClosing(index)

				if (is != null)
				{
					val spawnX = x + world.rand.nextFloat()
					val spawnY = y + world.rand.nextFloat()
					val spawnZ = z + world.rand.nextFloat()

					val droppedItem: EntityItem = new EntityItem(world, spawnX, spawnY, spawnZ, is)

					val scalar = 0.05

					droppedItem.motionX = scalar * (-0.5 + world.rand.nextFloat())
					droppedItem.motionY = scalar * (4 + world.rand.nextFloat())
					droppedItem.motionZ = scalar * (-0.5 + world.rand.nextFloat())

					world.spawnEntityInWorld(droppedItem)
				}
			}
		}

		super.breakBlock(world, x, y, z, id, meta)
	}
}
