package de.thatsich.minecraft.api.mod.module.block

import java.util
import java.util.Random

import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.minecraft.block.Block
import net.minecraft.block.material.{MapColor, Material}
import net.minecraft.client.particle.EffectRenderer
import net.minecraft.client.renderer.texture.IIconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLivingBase, EnumCreatureType}
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.{AxisAlignedBB, ChunkCoordinates, IIcon, MovingObjectPosition, Vec3}
import net.minecraft.world.{Explosion, IBlockAccess, World}
import net.minecraftforge.common.IPlantable
import net.minecraftforge.common.util.ForgeDirection

/**
 *
 *
 * @author thatsIch
 * @since 07.04.2014.
 */
trait Block
{
	def getLightOpacity: Int

	@SideOnly( Side.CLIENT ) def getCanBlockGrass: Boolean

	/**
	Should block use the brightest neighbor light value as its own
	  */
	def getUseNeighborBrightness: Boolean

	def getMapColor( p_149728_1_ : Int ): MapColor

	/**
	Sets the footstep sound for the block. Returns the object for convenience in constructing.
	  */
	def setStepSound( p_149672_1_ : Block.SoundType ): Block

	/**
	Sets how much light is blocked going through this block. Returns the object for convenience in constructing.
	  */
	def setLightOpacity( p_149713_1_ : Int ): Block

	/**
	Sets the light value that the block emits. Returns resulting block instance for constructing convenience. Args:
	 level
	  */
	def setLightLevel( p_149715_1_ : Float ): Block

	/**
	Sets the the blocks resistance to explosions. Returns the object for convenience in constructing.
	  */
	def setResistance( p_149752_1_ : Float ): Block

	def isNormalCube: Boolean

	def getBlocksMovement( p_149655_1_ : IBlockAccess, p_149655_2_ : Int, p_149655_3_ : Int, p_149655_4_ : Int ): Boolean

	/**
	The type of render function that is called for this block
	  */
	def getRenderType: Int

	/**
	This method will set the hardness of the block to -1, making it indestructible
	  */
	def setBlockUnbreakable( ): Block

	/**
	Sets how many hits it takes to break a block.
	  */
	def setHardness( p_149711_1_ : Float ): Block

	/**
	Returns the block hardness at a location. Args: world, x, y, z
	  */
	def getBlockHardness( p_149712_1_ : World, p_149712_2_ : Int, p_149712_3_ : Int, p_149712_4_ : Int ): Float

	/**
	Sets whether this block type will receive random update ticks
	  */
	def setTickRandomly( p_149675_1_ : Boolean ): Block

	/**
	Returns whether or not this block is of a type that needs random ticking. Called for ref-counting purposes by
	 ExtendedBlockStorage in order to broadly cull a chunk from the random chunk update list for efficiency's sake.
	  */
	def getTickRandomly: Boolean

	@Deprecated def hasTileEntity: Boolean

	/**
	Sets the bounds of the block.  minX, minY, minZ, maxX, maxY, maxZ
	  */
	def setBlockBounds( p_149676_1_ : Float, p_149676_2_ : Float, p_149676_3_ : Float, p_149676_4_ : Float, p_149676_5_ : Float, p_149676_6_ : Float ): Unit

	/**
	How bright to render this block based on the light its receiving. Args: iBlockAccess, x, y, z
	  */
	@SideOnly( Side.CLIENT ) def getMixedBrightnessForBlock( p_149677_1_ : IBlockAccess, p_149677_2_ : Int, p_149677_3_ : Int, p_149677_4_ : Int ): Int

	/**
	Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	 coordinates.  Args: blockAccess, x, y, z, side
	  */
	@SideOnly( Side.CLIENT ) def shouldSideBeRendered( p_149646_1_ : IBlockAccess, p_149646_2_ : Int, p_149646_3_ : Int, p_149646_4_ : Int, p_149646_5_ : Int ): Boolean

	/**
	Returns true if the given side of this block type should be rendered (if it's solid or not), if the adjacent
	 block is at the given coordinates. Args: blockAccess, x, y, z, side
	  */
	def isBlockSolid( p_149747_1_ : IBlockAccess, p_149747_2_ : Int, p_149747_3_ : Int, p_149747_4_ : Int, p_149747_5_ : Int ): Boolean

	@SideOnly( Side.CLIENT ) def getIcon( p_149673_1_ : IBlockAccess, p_149673_2_ : Int, p_149673_3_ : Int, p_149673_4_ : Int, p_149673_5_ : Int ): IIcon

	/**
	Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
	 mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
	  */
	def addCollisionBoxesToList( p_149743_1_ : World, p_149743_2_ : Int, p_149743_3_ : Int, p_149743_4_ : Int, p_149743_5_ : AxisAlignedBB, p_149743_6_ : List[ _ ], p_149743_7_ : Entity ): Unit

	/**
	Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
	 cleared to be reused)
	  */
	def getCollisionBoundingBoxFromPool( p_149668_1_ : World, p_149668_2_ : Int, p_149668_3_ : Int, p_149668_4_ : Int ): AxisAlignedBB

	/**
	Returns the block texture based on the side being looked at.  Args: side
	  */
	@SideOnly( Side.CLIENT ) def getBlockTextureFromSide( p_149733_1_ : Int ): IIcon

	/**
	Returns the bounding box of the wired rectangular prism to render.
	  */
	@SideOnly( Side.CLIENT ) def getSelectedBoundingBoxFromPool( p_149633_1_ : World, p_149633_2_ : Int, p_149633_3_ : Int, p_149633_4_ : Int ): AxisAlignedBB

	/**
	Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	 adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	  */
	def isOpaqueCube: Boolean

	/**
	Returns whether this block is collideable based on the arguments passed in n@param par1 block metaData n@param
	 par2 whether the player right-clicked while holding a boat
	  */
	def canCollideCheck( p_149678_1_ : Int, p_149678_2_ : Boolean ): Boolean

	/**
	Returns if this block is collidable (only used by Fire). Args: x, y, z
	  */
	def isCollidable: Boolean

	/**
	Ticks the block if it's been scheduled
	  */
	def updateTick( p_149674_1_ : World, p_149674_2_ : Int, p_149674_3_ : Int, p_149674_4_ : Int, p_149674_5_ : Random ): Unit

	/**
	A randomly called display update to be able to add particles or other items for display
	  */
	@SideOnly( Side.CLIENT ) def randomDisplayTick( p_149734_1_ : World, p_149734_2_ : Int, p_149734_3_ : Int, p_149734_4_ : Int, p_149734_5_ : Random ): Unit

	/**
	Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
	  */
	def onBlockDestroyedByPlayer( p_149664_1_ : World, p_149664_2_ : Int, p_149664_3_ : Int, p_149664_4_ : Int, p_149664_5_ : Int ): Unit

	/**
	Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 their own) Args: x, y, z, neighbor Block
	  */
	def onNeighborBlockChange( p_149695_1_ : World, p_149695_2_ : Int, p_149695_3_ : Int, p_149695_4_ : Int, p_149695_5_ : Block ): Unit

	/**
	How many world ticks before ticking
	  */
	def tickRate( p_149738_1_ : World ): Int

	/**
	Called whenever the block is added into the world. Args: world, x, y, z
	  */
	def onBlockAdded( p_149726_1_ : World, p_149726_2_ : Int, p_149726_3_ : Int, p_149726_4_ : Int ): Unit

	def breakBlock( p_149749_1_ : World, p_149749_2_ : Int, p_149749_3_ : Int, p_149749_4_ : Int, p_149749_5_ : Block, p_149749_6_ : Int ): Unit

	/**
	Gets the hardness of block at the given coordinates in the given world, relative to the ability of the given
	 EntityPlayer.
	  */
	def getPlayerRelativeBlockHardness( p_149737_1_ : EntityPlayer, p_149737_2_ : World, p_149737_3_ : Int, p_149737_4_ : Int, p_149737_5_ : Int ): Float

	/**
	called by spawner, ore, redstoneOre blocks
	  */
	def dropXpOnBlockBreak( p_149657_1_ : World, p_149657_2_ : Int, p_149657_3_ : Int, p_149657_4_ : Int, p_149657_5_ : Int ): Unit

	/**
	Ray traces through the blocks collision from start vector to end vector returning a ray trace hit. Args: world,
	 x, y, z, startVec, endVec
	  */
	def collisionRayTrace( p_149731_1_ : World, p_149731_2_ : Int, p_149731_3_ : Int, p_149731_4_ : Int, p_149731_5_ : Vec3, p_149731_6_ : Vec3 ): MovingObjectPosition

	/**
	Updates the blocks bounds based on its current state. Args: world, x, y, z
	  */
	def setBlockBoundsBasedOnState( p_149719_1_ : IBlockAccess, p_149719_2_ : Int, p_149719_3_ : Int, p_149719_4_ : Int ): Unit

	def canReplace( p_149705_1_ : World, p_149705_2_ : Int, p_149705_3_ : Int, p_149705_4_ : Int, p_149705_5_ : Int, p_149705_6_ : ItemStack ): Boolean

	/**
	checks to see if you can place this block can be placed on that side of a block: BlockLever overrides
	  */
	def canPlaceBlockOnSide( p_149707_1_ : World, p_149707_2_ : Int, p_149707_3_ : Int, p_149707_4_ : Int, p_149707_5_ : Int ): Boolean

	/**
	Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	  */
	def canPlaceBlockAt( p_149742_1_ : World, p_149742_2_ : Int, p_149742_3_ : Int, p_149742_4_ : Int ): Boolean

	/**
	Called upon block activation (right click on the block.)
	  */
	def onBlockActivated( p_149727_1_ : World, p_149727_2_ : Int, p_149727_3_ : Int, p_149727_4_ : Int, p_149727_5_ : EntityPlayer, p_149727_6_ : Int, p_149727_7_ : Float, p_149727_8_ : Float, p_149727_9_ : Float ): Boolean

	/**
	Called whenever an entity is walking on top of this block. Args: world, x, y, z, entity
	  */
	def onEntityWalking( p_149724_1_ : World, p_149724_2_ : Int, p_149724_3_ : Int, p_149724_4_ : Int, p_149724_5_ : Entity ): Unit

	/**
	Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
	  */
	def onBlockPlaced( p_149660_1_ : World, p_149660_2_ : Int, p_149660_3_ : Int, p_149660_4_ : Int, p_149660_5_ : Int, p_149660_6_ : Float, p_149660_7_ : Float, p_149660_8_ : Float, p_149660_9_ : Int ): Int

	/**
	Called when a player hits the block. Args: world, x, y, z, player
	  */
	def onBlockClicked( p_149699_1_ : World, p_149699_2_ : Int, p_149699_3_ : Int, p_149699_4_ : Int, p_149699_5_ : EntityPlayer ): Unit

	/**
	Can add to the passed in vector for a movement vector to be applied to the entity. Args: x, y, z, entity, vec3d
	  */
	def velocityToAddToEntity( p_149640_1_ : World, p_149640_2_ : Int, p_149640_3_ : Int, p_149640_4_ : Int, p_149640_5_ : Entity, p_149640_6_ : Vec3 ): Unit

	/**
	returns the block bounderies minX value
	  */
	def getBlockBoundsMinX: Double

	/**
	returns the block bounderies maxX value
	  */
	def getBlockBoundsMaxX: Double

	/**
	returns the block bounderies minY value
	  */
	def getBlockBoundsMinY: Double

	/**
	returns the block bounderies maxY value
	  */
	def getBlockBoundsMaxY: Double

	/**
	returns the block bounderies minZ value
	  */
	def getBlockBoundsMinZ: Double

	/**
	returns the block bounderies maxZ value
	  */
	def getBlockBoundsMaxZ: Double

	@SideOnly( Side.CLIENT ) def getBlockColor: Int

	/**
	Returns the color this block should be rendered. Used by leaves.
	  */
	@SideOnly( Side.CLIENT ) def getRenderColor( p_149741_1_ : Int ): Int

	/**
	Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
	 when first determining what to render.
	  */
	@SideOnly( Side.CLIENT ) def colorMultiplier( p_149720_1_ : IBlockAccess, p_149720_2_ : Int, p_149720_3_ : Int, p_149720_4_ : Int ): Int

	def isProvidingWeakPower( p_149709_1_ : IBlockAccess, p_149709_2_ : Int, p_149709_3_ : Int, p_149709_4_ : Int, p_149709_5_ : Int ): Int

	/**
	Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
	  */
	def onEntityCollidedWithBlock( p_149670_1_ : World, p_149670_2_ : Int, p_149670_3_ : Int, p_149670_4_ : Int, p_149670_5_ : Entity ): Unit

	def isProvidingStrongPower( p_149748_1_ : IBlockAccess, p_149748_2_ : Int, p_149748_3_ : Int, p_149748_4_ : Int, p_149748_5_ : Int ): Int

	/**
	Sets the block's bounds for rendering it as an item
	  */
	def setBlockBoundsForItemRender( ): Unit

	/**
	Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
	 block and l is the block's subtype/damage.
	  */
	def harvestBlock( p_149636_1_ : World, p_149636_2_ : EntityPlayer, p_149636_3_ : Int, p_149636_4_ : Int, p_149636_5_ : Int, p_149636_6_ : Int ): Unit

	/**
	Drops the specified block items
	  */
	def dropBlockAsItem( p_149697_1_ : World, p_149697_2_ : Int, p_149697_3_ : Int, p_149697_4_ : Int, p_149697_5_ : Int, p_149697_6_ : Int ): Unit

	/**
	Drops the block items with a specified chance of dropping the specified items
	  */
	def dropBlockAsItemWithChance( p_149690_1_ : World, p_149690_2_ : Int, p_149690_3_ : Int, p_149690_4_ : Int, p_149690_5_ : Int, p_149690_6_ : Float, p_149690_7_ : Int ): Unit

	/**
	This returns a complete list of items dropped from this block.

	 @param world    The current world
	@param x        X Position
	@param y        Y Position
	@param z        Z Position
	@param metadata Current metadata
	@param fortune  Breakers fortune level

	@return A ArrayList containing all items this block drops
	  */
	def getDrops( world: World, x: Int, y: Int, z: Int, metadata: Int, fortune: Int ): util.ArrayList[ ItemStack ]

	def getItemDropped( p_149650_1_ : Int, p_149650_2_ : Random, p_149650_3_ : Int ): Item

	/**
	Metadata and fortune sensitive version, this replaces the old (int meta, Random rand)
	 version in 1.1.

	 @param meta    Blocks Metadata
	@param fortune Current item fortune level
	@param random  Random number generator

	@return The number of items to drop
	  */
	def quantityDropped( meta: Int, fortune: Int, random: Random ): Int

	/**
	Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
	  */
	def quantityDroppedWithBonus( p_149679_1_ : Int, p_149679_2_ : Random ): Int

	/**
	Returns the quantity of items to drop on block destruction.
	  */
	def quantityDropped( p_149745_1_ : Random ): Int

	/**
	Return true from this function if the player with silk touch can harvest this block directly, and not it's normal drops.

	 @param world    The world
	@param player   The player doing the harvesting
	@param x        X Position
	@param y        Y Position
	@param z        Z Position
	@param metadata The metadata

	@return True if the block can be directly harvested using silk touch
	  */
	def canSilkHarvest( world: World, player: EntityPlayer, x: Int, y: Int, z: Int, metadata: Int ): Boolean

	/**
	Called throughout the code as a replacement for block instanceof BlockContainer
	 Moving this to the Block base class allows for mods that wish to extend vanilla
	 blocks, and also want to have a tile entity on that block, may.
	 <p/>
	 Return true from this function to specify this block has a tile entity.

	 @param metadata Metadata of the current block

	@return True if block has a tile entity, false otherwise
	  */
	def hasTileEntity( metadata: Int ): Boolean

	/**
	Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
	  */
	def canBlockStay( p_149718_1_ : World, p_149718_2_ : Int, p_149718_3_ : Int, p_149718_4_ : Int ): Boolean

	/**
	Called when the block is placed in the world.
	  */
	def onBlockPlacedBy( p_149689_1_ : World, p_149689_2_ : Int, p_149689_3_ : Int, p_149689_4_ : Int, p_149689_5_ : EntityLivingBase, p_149689_6_ : ItemStack ): Unit

	/**
	Called after a block is placed
	  */
	def onPostBlockPlaced( p_149714_1_ : World, p_149714_2_ : Int, p_149714_3_ : Int, p_149714_4_ : Int, p_149714_5_ : Int ): Unit

	/**
	Sets the mod-specific block name
	  */
	def setBlockName( p_149663_1_ : String ): Block

	/**
	Gets the localized name of this block. Used for the statistics page.
	  */
	def getLocalizedName: String

	/**
	Returns the unlocalized name of the block with "tile." appended to the front.
	  */
	def getUnlocalizedName: String

	def onBlockEventReceived( p_149696_1_ : World, p_149696_2_ : Int, p_149696_3_ : Int, p_149696_4_ : Int, p_149696_5_ : Int, p_149696_6_ : Int ): Boolean

	/**
	Return the state of blocks statistics flags - if the block is counted for mined and placed.
	  */
	def getEnableStats: Boolean

	/**
	Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility
	 and stop pistons
	  */
	def getMobilityFlag: Int

	/**
	Returns the default ambient occlusion value based on block opacity
	  */
	@SideOnly( Side.CLIENT ) def getAmbientOcclusionLightValue: Float

	/**
	Indicate if a material is a normal solid opaque cube
	  */
	@SideOnly( Side.CLIENT ) def isBlockNormalCube: Boolean

	/**
	Block's chance to react to an entity falling on it.
	  */
	def onFallenUpon( p_149746_1_ : World, p_149746_2_ : Int, p_149746_3_ : Int, p_149746_4_ : Int, p_149746_5_ : Entity, p_149746_6_ : Float ): Unit

	/**
	Gets an item for the block being called on. Args: world, x, y, z
	  */
	@SideOnly( Side.CLIENT ) def getItem( p_149694_1_ : World, p_149694_2_ : Int, p_149694_3_ : Int, p_149694_4_ : Int ): Item

	/**
	Get the block's damage value (for use with pick block).
	  */
	def getDamageValue( p_149643_1_ : World, p_149643_2_ : Int, p_149643_3_ : Int, p_149643_4_ : Int ): Int

	/**
	Determines the damage on the item the block drops. Used in cloth and wood.
	  */
	def damageDropped( p_149692_1_ : Int ): Int

	/**
	returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	  */
	@SideOnly( Side.CLIENT ) def getSubBlocks( p_149666_1_ : Item, p_149666_2_ : CreativeTabs, p_149666_3_ : List[ _ ] ): Unit

	def setCreativeTab( p_149647_1_ : CreativeTabs ): Block

	/**
	Called when the block is attempted to be harvested
	  */
	def onBlockHarvested( p_149681_1_ : World, p_149681_2_ : Int, p_149681_3_ : Int, p_149681_4_ : Int, p_149681_5_ : Int, p_149681_6_ : EntityPlayer ): Unit

	/**
	Returns the CreativeTab to display the given block on.
	  */
	@SideOnly( Side.CLIENT ) def getCreativeTabToDisplayOn: CreativeTabs

	/**
	Called on server worlds only when the block is about to be replaced by a different block or the same block with a
	 different metadata value. Args: world, x, y, z, old metadata
	  */
	def onBlockPreDestroy( p_149725_1_ : World, p_149725_2_ : Int, p_149725_3_ : Int, p_149725_4_ : Int, p_149725_5_ : Int ): Unit

	/**
	currently only used by BlockCauldron to incrament meta-data during rain
	  */
	def fillWithRain( p_149639_1_ : World, p_149639_2_ : Int, p_149639_3_ : Int, p_149639_4_ : Int ): Unit

	/**
	Returns true only if block is flowerPot
	  */
	@SideOnly( Side.CLIENT ) def isFlowerPot: Boolean

	def func_149698_L: Boolean

	/**
	Return whether this block can drop from an explosion.
	  */
	def canDropFromExplosion( p_149659_1_ : Explosion ): Boolean

	def isAssociatedBlock( p_149667_1_ : Block ): Boolean

	/**
	If this returns true, then comparators facing away from this block will use the value from
	 getComparatorInputOverride instead of the actual redstone signal strength.
	  */
	def hasComparatorInputOverride: Boolean

	/**
	If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
	 strength when this block inputs to a comparator.
	  */
	def getComparatorInputOverride( p_149736_1_ : World, p_149736_2_ : Int, p_149736_3_ : Int, p_149736_4_ : Int, p_149736_5_ : Int ): Int

	def setBlockTextureName( p_149658_1_ : String ): Block

	@SideOnly( Side.CLIENT ) def func_149735_b( p_149735_1_ : Int, p_149735_2_ : Int ): IIcon

	/**
	Gets the block's texture. Args: side, meta
	  */
	@SideOnly( Side.CLIENT ) def getIcon( p_149691_1_ : Int, p_149691_2_ : Int ): IIcon

	@SideOnly( Side.CLIENT ) def registerBlockIcons( p_149651_1_ : IIconRegister ): Unit

	/**
	Gets the icon name of the ItemBlock corresponding to this block. Used by hoppers.
	  */
	@SideOnly( Side.CLIENT ) def getItemIconName: String

	/**
	Get a light value for the block at the specified coordinates, normal ranges are between 0 and 15

	 @param world The current world
	@param x     X Position
	@param y     Y position
	@param z     Z position

	@return The light value
	  */
	def getLightValue( world: IBlockAccess, x: Int, y: Int, z: Int ): Int

	/**
	Gets the light value of the specified block coords. Args: x, y, z
	  */
	def getLightValue: Int

	/**
	Checks if a player or entity can use this block to 'climb' like a ladder.

	 @param world  The current world
	@param x      X Position
	@param y      Y position
	@param z      Z position
	@param entity The entity trying to use the ladder, CAN be null.

	@return True if the block should act like a ladder
	  */
	def isLadder( world: IBlockAccess, x: Int, y: Int, z: Int, entity: EntityLivingBase ): Boolean

	/**
	Determines if a new block can be replace the space occupied by this one,
	 Used in the player's placement code to make the block act like water, and lava.

	 @param world The current world
	@param x     X Position
	@param y     Y position
	@param z     Z position

	@return True if the block is replaceable by another block
	  */
	def isReplaceable( world: IBlockAccess, x: Int, y: Int, z: Int ): Boolean

	/**
	Determines if this block should set fire and deal fire damage
	 to entities coming into contact with it.

	 @param world The current world
	@param x     X Position
	@param y     Y position
	@param z     Z position

	@return True if the block should deal damage
	  */
	def isBurning( world: IBlockAccess, x: Int, y: Int, z: Int ): Boolean

	/**
	Determines this block should be treated as an air block
	 by the rest of the code. This method is primarily
	 useful for creating pure logic-blocks that will be invisible
	 to the player and otherwise interact as air would.

	 @param world The current world
	@param x     X Position
	@param y     Y position
	@param z     Z position

	@return True if the block considered air
	  */
	def isAir( world: IBlockAccess, x: Int, y: Int, z: Int ): Boolean

	def getMaterial: Material

	/**
	Determines if the player can harvest this block, obtaining it's drops when the block is destroyed.

	 @param player The player damaging the block, may be null
	@param meta   The block's current metadata

	@return True to spawn the drops
	  */
	def canHarvestBlock( player: EntityPlayer, meta: Int ): Boolean

	/**
	Called when a player removes a block.  This is responsible for
	 actually destroying the block, and the block is intact at time of call.
	 This is called regardless of whether the player can harvest the block or
	 not.
	 <p/>
	 Return true if the block is actually destroyed.
	 <p/>
	 Note: When used in multiplayer, this is called on both client and
	 server sides!

	 @param world  The current world
	@param player The player damaging the block, may be null
	@param x      X Position
	@param y      Y position
	@param z      Z position

	@return True if the block is actually destroyed.
	  */
	def removedByPlayer( world: World, player: EntityPlayer, x: Int, y: Int, z: Int ): Boolean

	/**
	Called when fire is updating, checks if a block face can catch fire.

	 @param world The current world
	@param x     The blocks X position
	@param y     The blocks Y position
	@param z     The blocks Z position
	@param face  The face that the fire is coming from

	@return True if the face can be on fire, false otherwise.
	  */
	def isFlammable( world: IBlockAccess, x: Int, y: Int, z: Int, face: ForgeDirection ): Boolean

	/**
	Chance that fire will spread and consume this block.
	 300 being a 100% chance, 0, being a 0% chance.

	 @param world The current world
	@param x     The blocks X position
	@param y     The blocks Y position
	@param z     The blocks Z position
	@param face  The face that the fire is coming from

	@return A number ranging from 0 to 300 relating used to determine if the block will be consumed by fire
	  */
	def getFlammability( world: IBlockAccess, x: Int, y: Int, z: Int, face: ForgeDirection ): Int

	/**
	Called when fire is updating on a neighbor block.
	 The higher the number returned, the faster fire will spread around this block.

	 @param world The current world
	@param x     The blocks X position
	@param y     The blocks Y position
	@param z     The blocks Z position
	@param face  The face that the fire is coming from

	@return A number that is used to determine the speed of fire growth around the block
	  */
	def getFireSpreadSpeed( world: IBlockAccess, x: Int, y: Int, z: Int, face: ForgeDirection ): Int

	/**
	Currently only called by fire when it is on top of this block.
	 Returning true will prevent the fire from naturally dying during updating.
	 Also prevents firing from dying from rain.

	 @param world The current world
	@param x     The blocks X position
	@param y     The blocks Y position
	@param z     The blocks Z position
	@param side  The face that the fire is coming from

	@return True if this block sustains fire, meaning it will never go out.
	  */
	def isFireSource( world: World, x: Int, y: Int, z: Int, side: ForgeDirection ): Boolean

	/**
	Called throughout the code as a replacement for ITileEntityProvider.createNewTileEntity
	 Return the same thing you would from that function.
	 This will fall back to ITileEntityProvider.createNewTileEntity(World) if this block is a ITileEntityProvider

	 @param metadata The Metadata of the current block

	@return A instance of a class extending TileEntity
	  */
	def createTileEntity( world: World, metadata: Int ): TileEntity

	/**
	Determines if a specified mob type can spawn on this block, returning false will
	 prevent any mob from spawning on the block.

	 @param type  The Mob Category Type
	@param world The current world
	@param x     The X Position
	@param y     The Y Position
	@param z     The Z Position

	@return True to allow a mob of the specified category to spawn, false to prevent it.
	  */
	def canCreatureSpawn( `type`: EnumCreatureType, world: IBlockAccess, x: Int, y: Int, z: Int ): Boolean

	def func_149730_j: Boolean

	/**
	Checks if the block is a solid face on the given side, used by placement logic.

	 @param world The current world
	@param x     X Position
	@param y     Y position
	@param z     Z position
	@param side  The side to check

	@return True if the block is solid on the specified side.
	  */
	def isSideSolid( world: IBlockAccess, x: Int, y: Int, z: Int, side: ForgeDirection ): Boolean

	/**
	Return true if the block is a normal, solid cube.  This
	 determines indirect power state, entity ejection from blocks, and a few
	 others.

	 @param world The current world
	@param x     X Position
	@param y     Y position
	@param z     Z position

	@return True if the block is a full cube
	  */
	def isNormalCube( world: IBlockAccess, x: Int, y: Int, z: Int ): Boolean

	/**
	If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	  */
	def renderAsNormalBlock: Boolean

	/**
	Can this block provide power. Only wire currently seems to have this change based on its state.
	  */
	def canProvidePower: Boolean

	/**
	Determines if this block is classified as a Bed, Allowing
	 players to sleep in it, though the block has to specifically
	 perform the sleeping functionality in it's activated event.

	 @param world  The current world
	@param x      X Position
	@param y      Y Position
	@param z      Z Position
	@param player The player or camera entity, null in some cases.

	@return True to treat this as a bed
	  */
	def isBed( world: IBlockAccess, x: Int, y: Int, z: Int, player: EntityLivingBase ): Boolean

	/**
	Returns the position that the player is moved to upon
	 waking up, or respawning at the bed.

	 @param world  The current world
	@param x      X Position
	@param y      Y Position
	@param z      Z Position
	@param player The player or camera entity, null in some cases.

	@return The spawn position
	  */
	def getBedSpawnPosition( world: IBlockAccess, x: Int, y: Int, z: Int, player: EntityPlayer ): ChunkCoordinates

	/**
	Called when a user either starts or stops sleeping in the bed.

	 @param world    The current world
	@param x        X Position
	@param y        Y Position
	@param z        Z Position
	@param player   The player or camera entity, null in some cases.
	@param occupied True if we are occupying the bed, or false if they are stopping use of the bed
	  */
	def setBedOccupied( world: IBlockAccess, x: Int, y: Int, z: Int, player: EntityPlayer, occupied: Boolean ): Unit

	/**
	Returns the direction of the block. Same values that
	 are returned by BlockDirectional

	 @param world The current world
	@param x     X Position
	@param y     Y Position
	@param z     Z Position

	@return Bed direction
	  */
	def getBedDirection( world: IBlockAccess, x: Int, y: Int, z: Int ): Int

	/**
	Determines if the current block is the foot half of the bed.

	 @param world The current world
	@param x     X Position
	@param y     Y Position
	@param z     Z Position

	@return True if the current block is the foot side of a bed.
	  */
	def isBedFoot( world: IBlockAccess, x: Int, y: Int, z: Int ): Boolean

	/**
	Called when a leaf should start its decay process.

	 @param world The current world
	@param x     X Position
	@param y     Y Position
	@param z     Z Position
	  */
	def beginLeavesDecay( world: World, x: Int, y: Int, z: Int ): Unit

	/**
	Determines if this block can prevent leaves connected to it from decaying.

	 @param world The current world
	@param x     X Position
	@param y     Y Position
	@param z     Z Position

	@return true if the presence this block can prevent leaves from decaying.
	  */
	def canSustainLeaves( world: IBlockAccess, x: Int, y: Int, z: Int ): Boolean

	/**
	Determines if this block is considered a leaf block, used to apply the leaf decay and generation system.

	 @param world The current world
	@param x     X Position
	@param y     Y Position
	@param z     Z Position

	@return true if this block is considered leaves.
	  */
	def isLeaves( world: IBlockAccess, x: Int, y: Int, z: Int ): Boolean

	/**
	Used during tree growth to determine if newly generated leaves can replace this block.

	 @param world The current world
	@param x     X Position
	@param y     Y Position
	@param z     Z Position

	@return true if this block can be replaced by growing leaves.
	  */
	def canBeReplacedByLeaves( world: IBlockAccess, x: Int, y: Int, z: Int ): Boolean

	/**
	@param world The current world
	@param x     X Position
	@param y     Y Position
	@param z     Z Position

	@return true if the block is wood (logs)
	  */
	def isWood( world: IBlockAccess, x: Int, y: Int, z: Int ): Boolean

	/**
	Determines if the current block is replaceable by Ore veins during world generation.

	 @param world  The current world
	@param x      X Position
	@param y      Y Position
	@param z      Z Position
	@param target The generic target block the gen is looking for, Standards define stone
	 for overworld generation, and neatherack for the nether.

	@return True to allow this block to be replaced by a ore
	  */
	def isReplaceableOreGen( world: World, x: Int, y: Int, z: Int, target: Block ): Boolean

	/**
	Location sensitive version of getExplosionRestance

	 @param par1Entity The entity that caused the explosion
	@param world      The current world
	@param x          X Position
	@param y          Y Position
	@param z          Z Position
	@param explosionX Explosion source X Position
	@param explosionY Explosion source X Position
	@param explosionZ Explosion source X Position

	@return The amount of the explosion absorbed.
	  */
	def getExplosionResistance( par1Entity: Entity, world: World, x: Int, y: Int, z: Int, explosionX: Double, explosionY: Double, explosionZ: Double ): Float

	/**
	Returns how much this block can resist explosions from the passed in entity.
	  */
	def getExplosionResistance( p_149638_1_ : Entity ): Float

	/**
	Called when the block is destroyed by an explosion.
	 Useful for allowing the block to take into account tile entities,
	 metadata, etc. when exploded, before it is removed.

	 @param world     The current world
	@param x         X Position
	@param y         Y Position
	@param z         Z Position
	@param explosion The explosion instance affecting the block
	  */
	def onBlockExploded( world: World, x: Int, y: Int, z: Int, explosion: Explosion ): Unit

	/**
	Called upon the block being destroyed by an explosion
	  */
	def onBlockDestroyedByExplosion( p_149723_1_ : World, p_149723_2_ : Int, p_149723_3_ : Int, p_149723_4_ : Int, p_149723_5_ : Explosion ): Unit

	/**
	Determine if this block can make a redstone connection on the side provided,
	 Useful to control which sides are inputs and outputs for redstone wires.
	 <p/>
	 Side:
	 -1: UP
	 0: NORTH
	 1: EAST
	 2: SOUTH
	 3: WEST

	 @param world The current world
	@param x     X Position
	@param y     Y Position
	@param z     Z Position
	@param side  The side that is trying to make the connection

	@return True to make the connection
	  */
	def canConnectRedstone( world: IBlockAccess, x: Int, y: Int, z: Int, side: Int ): Boolean

	/**
	Determines if a torch can be placed on the top surface of this block.
	 Useful for creating your own block that torches can be on, such as fences.

	 @param world The current world
	@param x     X Position
	@param y     Y Position
	@param z     Z Position

	@return True to allow the torch to be placed
	  */
	def canPlaceTorchOnTop( world: World, x: Int, y: Int, z: Int ): Boolean

	/**
	Determines if this block should render in this pass.

	 @param pass The pass in question

	@return True to render
	  */
	def canRenderInPass( pass: Int ): Boolean

	/**
	Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	  */
	@SideOnly( Side.CLIENT ) def getRenderBlockPass: Int

	/**
	Called when a user uses the creative pick block button on this block

	 @param target The full target the player is looking at

	@return A ItemStack to add to the player's inventory, Null if nothing should be added.
	  */
	def getPickBlock( target: MovingObjectPosition, world: World, x: Int, y: Int, z: Int ): ItemStack

	/**
	Used by getTopSolidOrLiquidBlock while placing biome decorations, villages, etc
	 Also used to determine if the player can spawn on this block.

	 @return False to disallow spawning
	  */
	def isFoliage( world: IBlockAccess, x: Int, y: Int, z: Int ): Boolean

	/**
	Spawn a digging particle effect in the world, this is a wrapper
	 around EffectRenderer.addBlockHitEffects to allow the block more
	 control over the particles. Useful when you have entirely different
	 texture sheets for different sides/locations in the world.

	 @param world          The current world
	@param target         The target the player is looking at {x/y/z/side/sub}
	@param effectRenderer A reference to the current effect renderer.

	@return True to prevent vanilla digging particles form spawning.
	  */
	@SideOnly( Side.CLIENT ) def addHitEffects( world: World, target: MovingObjectPosition, effectRenderer: EffectRenderer ): Boolean

	/**
	Spawn particles for when the block is destroyed. Due to the nature
	 of how this is invoked, the x/y/z locations are not always guaranteed
	 to host your block. So be sure to do proper sanity checks before assuming
	 that the location is this block.

	 @param world          The current world
	@param x              X position to spawn the particle
	@param y              Y position to spawn the particle
	@param z              Z position to spawn the particle
	@param meta           The metadata for the block before it was destroyed.
	@param effectRenderer A reference to the current effect renderer.

	@return True to prevent vanilla break particles from spawning.
	  */
	@SideOnly( Side.CLIENT ) def addDestroyEffects( world: World, x: Int, y: Int, z: Int, meta: Int, effectRenderer: EffectRenderer ): Boolean

	/**
	Determines if this block can support the passed in plant, allowing it to be planted and grow.
	 Some examples:
	 Reeds check if its a reed, or if its sand/dirt/grass and adjacent to water
	 Cacti checks if its a cacti, or if its sand
	 Nether types check for soul sand
	 Crops check for tilled soil
	 Caves check if it's a solid surface
	 Plains check if its grass or dirt
	 Water check if its still water

	 @param world     The current world
	@param x         X Position
	@param y         Y Position
	@param z         Z position
	@param direction The direction relative to the given position the plant wants to be, typically its UP
	@param plantable The plant that wants to check

	@return True to allow the plant to be planted/stay.
	  */
	def canSustainPlant( world: IBlockAccess, x: Int, y: Int, z: Int, direction: ForgeDirection, plantable: IPlantable ): Boolean

	/**
	Called when a plant grows on this block, only implemented for saplings using the WorldGen*Trees classes right now.
	 Modder may implement this for custom plants.
	 This does not use ForgeDirection, because large/huge trees can be located in non-representable direction,
	 so the source location is specified.
	 Currently this just changes the block to dirt if it was grass.
	 <p/>
	 Note: This happens DURING the generation, the generation may not be complete when this is called.

	 @param world   Current world
	@param x       Soil X
	@param y       Soil Y
	@param z       Soil Z
	@param sourceX Plant growth location X
	@param sourceY Plant growth location Y
	@param sourceZ Plant growth location Z
	  */
	def onPlantGrow( world: World, x: Int, y: Int, z: Int, sourceX: Int, sourceY: Int, sourceZ: Int ): Unit

	/**
	Checks if this soil is fertile, typically this means that growth rates
	 of plants on this soil will be slightly sped up.
	 Only vanilla case is tilledField when it is within range of water.

	 @param world The current world
	@param x     X Position
	@param y     Y Position
	@param z     Z position

	@return True if the soil should be considered fertile.
	  */
	def isFertile( world: World, x: Int, y: Int, z: Int ): Boolean

	/**
	Location aware and overrideable version of the lightOpacity array,
	 return the number to subtract from the light value when it passes through this block.
	 <p/>
	 This is not guaranteed to have the tile entity in place before this is called, so it is
	 Recommended that you have your tile entity call relight after being placed if you
	 rely on it for light info.

	 @param world The current world
	@param x     X Position
	@param y     Y Position
	@param z     Z position

	@return The amount of light to block, 0 for air, 255 for fully opaque.
	  */
	def getLightOpacity( world: IBlockAccess, x: Int, y: Int, z: Int ): Int

	/**
	Determines if this block is can be destroyed by the specified entities normal behavior.

	 @param world The current world
	@param x     X Position
	@param y     Y Position
	@param z     Z position

	@return True to allow the ender dragon to destroy this block
	  */
	def canEntityDestroy( world: IBlockAccess, x: Int, y: Int, z: Int, entity: Entity ): Boolean

	/**
	Determines if this block can be used as the base of a beacon.

	 @param world   The current world
	@param x       X Position
	@param y       Y Position
	@param z       Z position
	@param beaconX Beacons X Position
	@param beaconY Beacons Y Position
	@param beaconZ Beacons Z Position

	@return True, to support the beacon, and make it active with this block.
	  */
	def isBeaconBase( world: IBlockAccess, x: Int, y: Int, z: Int, beaconX: Int, beaconY: Int, beaconZ: Int ): Boolean

	/**
	Rotate the block. For vanilla blocks this rotates around the axis passed in (generally, it should be the "face" that was hit).
	 Note: for mod blocks, this is up to the block and modder to decide. It is not mandated that it be a rotation around the
	 face, but could be a rotation to orient *to* that face, or a visiting of possible rotations.
	 The method should return true if the rotation was successful though.

	 @param worldObj The world
	@param x        X position
	@param y        Y position
	@param z        Z position
	@param axis     The axis to rotate around

	@return True if the rotation was successful, False if the rotation failed, or is not possible
	  */
	def rotateBlock( worldObj: World, x: Int, y: Int, z: Int, axis: ForgeDirection ): Boolean

	/**
	Get the rotations that can apply to the block at the specified coordinates. Null means no rotations are possible.
	 Note, this is up to the block to decide. It may not be accurate or representative.

	 @param worldObj The world
	@param x        X position
	@param y        Y position
	@param z        Z position

	@return An array of valid axes to rotate around, or null for none or unknown
	  */
	def getValidRotations( worldObj: World, x: Int, y: Int, z: Int ): Array[ ForgeDirection ]

	/**
	Determines the amount of enchanting power this block can provide to an enchanting table.

	 @param world The World
	@param x     X position
	@param y     Y position
	@param z     Z position

	@return The amount of enchanting power this block produces.
	  */
	def getEnchantPowerBonus( world: World, x: Int, y: Int, z: Int ): Float

	/**
	Common way to recolour a block with an external tool

	 @param world  The world
	@param x      X Coord
	@param y      Y Coord
	@param z      Z Coord
	@param side   The side hit with the colouring tool
	@param colour The colour to change to

	@return If the recolouring was successful
	  */
	def recolourBlock( world: World, x: Int, y: Int, z: Int, side: ForgeDirection, colour: Int ): Boolean

	/**
	Gathers how much experience this block drops when broken.

	 @param world    The world
	@param metadata Metadata
	@param fortune  Fortune

	@return Amount of XP from breaking this block.
	  */
	def getExpDrop( world: IBlockAccess, metadata: Int, fortune: Int ): Int

	/**
	Called when a tile entity on a side of this block changes is created or is destroyed.

	 @param world The world
	@param x     The x position of this block instance
	@param y     The y position of this block instance
	@param z     The z position of this block instance
	@param tileX The x position of the tile that changed
	@param tileY The y position of the tile that changed
	@param tileZ The z position of the tile that changed
	  */
	def onNeighborChange( world: IBlockAccess, x: Int, y: Int, z: Int, tileX: Int, tileY: Int, tileZ: Int ): Unit

	/**
	Called to determine whether to allow the a block to handle its own indirect power rather than using the default rules.

	 @param world The world
	@param x     The x position of this block instance
	@param y     The y position of this block instance
	@param z     The z position of this block instance
	@param side  The INPUT side of the block to be powered - ie the opposite of this block's output side

	@return Whether Block#isProvidingWeakPower should be called when determining indirect power
	  */
	def shouldCheckWeakPower( world: IBlockAccess, x: Int, y: Int, z: Int, side: Int ): Boolean

	/**
	If this block should be notified of weak changes.
	 Weak changes are changes 1 block away through a solid block.
	 Similar to comparators.

	 @param world The current world
	@param x     X Position
	@param y     Y position
	@param z     Z position

	@return true To be notified of changes
	  */
	def getWeakChanges( world: IBlockAccess, x: Int, y: Int, z: Int ): Boolean

	/**
	Sets or removes the tool and level required to harvest this block.

	 @param toolClass Class
	@param level     Harvest level:
	 Wood:    0
	 Stone:   1
	 Iton:    2
	 Diamond: 3
	 Gold:    0
	  */
	def setHarvestLevel( toolClass: String, level: Int ): Unit

	/**
	Sets or removes the tool and level required to harvest this block.

	 @param toolClass Class
	@param level     Harvest level:
	 Wood:    0
	 Stone:   1
	 Iton:    2
	 Diamond: 3
	 Gold:    0
	@param metadata  The specific metadata to set
	  */
	def setHarvestLevel( toolClass: Nothing, level: Int, metadata: Int ): Unit

	/**
	Queries the class of tool required to harvest this block, if null is returned
	 we assume that anything can harvest this block.

	 @param metadata Information about required tool to harvest this block

	@return Class of tool required to harvest this block
	  */
	def getHarvestTool( metadata: Int ): String

	/**
	Queries the harvest level of this item stack for the specifred tool class,
	 Returns -1 if this tool is not of the specified type

	 @param metadata This item stack instance

	@return Harvest level, or -1 if not the specified tool type.
	  */
	def getHarvestLevel( metadata: Int ): Int

	/**
	Checks if the specified tool type is efficient on this block,
	 meaning that it digs at full speed.

	 @param type     Type of Tool
	@param metadata Metadata

	@return True, if tool is effective
	  */
	def isToolEffective( `type`: String, metadata: Int ): Boolean
}
