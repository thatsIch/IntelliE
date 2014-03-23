package de.thatsich.common.module.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author thatsIch
 * @date 06.03.14.
 */
public interface IBlock
{
	int getLightOpacity ();

	@SideOnly(Side.CLIENT)
	boolean getCanBlockGrass ();

	/**
	 * Should block use the brightest neighbor light value as its own
	 */
	boolean getUseNeighborBrightness ();

	MapColor getMapColor ( int p_149728_1_ );

	/**
	 * Sets the footstep sound for the block. Returns the object for convenience in constructing.
	 */
	Block setStepSound ( Block.SoundType p_149672_1_ );

	/**
	 * Sets how much light is blocked going through this block. Returns the object for convenience in constructing.
	 */
	Block setLightOpacity ( int p_149713_1_ );

	/**
	 * Sets the light value that the block emits. Returns resulting block instance for constructing convenience. Args:
	 * level
	 */
	Block setLightLevel ( float p_149715_1_ );

	/**
	 * Sets the the blocks resistance to explosions. Returns the object for convenience in constructing.
	 */
	Block setResistance ( float p_149752_1_ );

	boolean isNormalCube ();

	boolean getBlocksMovement ( IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_ );

	/**
	 * The type of render function that is called for this block
	 */
	int getRenderType ();

	/**
	 * This method will set the hardness of the block to -1, making it indestructible
	 */
	Block setBlockUnbreakable ();

	/**
	 * Sets how many hits it takes to break a block.
	 */
	Block setHardness ( float p_149711_1_ );

	/**
	 * Returns the block hardness at a location. Args: world, x, y, z
	 */
	float getBlockHardness ( World p_149712_1_, int p_149712_2_, int p_149712_3_, int p_149712_4_ );

	/**
	 * Sets whether this block type will receive random update ticks
	 */
	Block setTickRandomly ( boolean p_149675_1_ );

	/**
	 * Returns whether or not this block is of a type that needs random ticking. Called for ref-counting purposes by
	 * ExtendedBlockStorage in order to broadly cull a chunk from the random chunk update list for efficiency's sake.
	 */
	boolean getTickRandomly ();

	@Deprecated
		//Forge: New Metadata sensitive version.
	boolean hasTileEntity ();

	/**
	 * Sets the bounds of the block.  minX, minY, minZ, maxX, maxY, maxZ
	 */
	void setBlockBounds ( float p_149676_1_, float p_149676_2_, float p_149676_3_, float p_149676_4_, float p_149676_5_, float p_149676_6_ );

	/**
	 * How bright to render this block based on the light its receiving. Args: iBlockAccess, x, y, z
	 */
	@SideOnly(Side.CLIENT)
	int getMixedBrightnessForBlock ( IBlockAccess p_149677_1_, int p_149677_2_, int p_149677_3_, int p_149677_4_ );

	/**
	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	 * coordinates.  Args: blockAccess, x, y, z, side
	 */
	@SideOnly(Side.CLIENT)
	boolean shouldSideBeRendered ( IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_ );

	/**
	 * Returns true if the given side of this block type should be rendered (if it's solid or not), if the adjacent
	 * block is at the given coordinates. Args: blockAccess, x, y, z, side
	 */
	boolean isBlockSolid ( IBlockAccess p_149747_1_, int p_149747_2_, int p_149747_3_, int p_149747_4_, int p_149747_5_ );

	@SideOnly(Side.CLIENT)
	IIcon getIcon ( IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_ );

	/**
	 * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
	 * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
	 */
	void addCollisionBoxesToList ( World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List<?> p_149743_6_, Entity p_149743_7_ );

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
	 * cleared to be reused)
	 */
	AxisAlignedBB getCollisionBoundingBoxFromPool ( World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_ );

	/**
	 * Returns the block texture based on the side being looked at.  Args: side
	 */
	@SideOnly(Side.CLIENT)
	IIcon getBlockTextureFromSide ( int p_149733_1_ );

	/**
	 * Returns the bounding box of the wired rectangular prism to render.
	 */
	@SideOnly(Side.CLIENT)
	AxisAlignedBB getSelectedBoundingBoxFromPool ( World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_ );

	/**
	 * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	boolean isOpaqueCube ();

	/**
	 * Returns whether this block is collideable based on the arguments passed in n@param par1 block metaData n@param
	 * par2 whether the player right-clicked while holding a boat
	 */
	boolean canCollideCheck ( int p_149678_1_, boolean p_149678_2_ );

	/**
	 * Returns if this block is collidable (only used by Fire). Args: x, y, z
	 */
	boolean isCollidable ();

	/**
	 * Ticks the block if it's been scheduled
	 */
	void updateTick ( World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_ );

	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	@SideOnly(Side.CLIENT)
	void randomDisplayTick ( World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_ );

	/**
	 * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
	 */
	void onBlockDestroyedByPlayer ( World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_ );

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor Block
	 */
	void onNeighborBlockChange ( World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_ );

	/**
	 * How many world ticks before ticking
	 */
	int tickRate ( World p_149738_1_ );

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	void onBlockAdded ( World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_ );

	void breakBlock ( World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_ );

	/**
	 * Gets the hardness of block at the given coordinates in the given world, relative to the ability of the given
	 * EntityPlayer.
	 */
	float getPlayerRelativeBlockHardness ( EntityPlayer p_149737_1_, World p_149737_2_, int p_149737_3_, int p_149737_4_, int p_149737_5_ );

	/**
	 * called by spawner, ore, redstoneOre blocks
	 */
	void dropXpOnBlockBreak ( World p_149657_1_, int p_149657_2_, int p_149657_3_, int p_149657_4_, int p_149657_5_ );

	/**
	 * Ray traces through the blocks collision from start vector to end vector returning a ray trace hit. Args: world,
	 * x, y, z, startVec, endVec
	 */
	MovingObjectPosition collisionRayTrace ( World p_149731_1_, int p_149731_2_, int p_149731_3_, int p_149731_4_, Vec3 p_149731_5_, Vec3 p_149731_6_ );

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	void setBlockBoundsBasedOnState ( IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_ );

	boolean canReplace ( World p_149705_1_, int p_149705_2_, int p_149705_3_, int p_149705_4_, int p_149705_5_, ItemStack p_149705_6_ );

	/**
	 * checks to see if you can place this block can be placed on that side of a block: BlockLever overrides
	 */
	boolean canPlaceBlockOnSide ( World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_ );

	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	boolean canPlaceBlockAt ( World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_ );

	/**
	 * Called upon block activation (right click on the block.)
	 */
	boolean onBlockActivated ( World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_ );

	/**
	 * Called whenever an entity is walking on top of this block. Args: world, x, y, z, entity
	 */
	void onEntityWalking ( World p_149724_1_, int p_149724_2_, int p_149724_3_, int p_149724_4_, Entity p_149724_5_ );

	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
	 */
	int onBlockPlaced ( World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_ );

	/**
	 * Called when a player hits the block. Args: world, x, y, z, player
	 */
	void onBlockClicked ( World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_ );

	/**
	 * Can add to the passed in vector for a movement vector to be applied to the entity. Args: x, y, z, entity, vec3d
	 */
	void velocityToAddToEntity ( World p_149640_1_, int p_149640_2_, int p_149640_3_, int p_149640_4_, Entity p_149640_5_, Vec3 p_149640_6_ );

	/**
	 * returns the block bounderies minX value
	 */
	double getBlockBoundsMinX ();


	/**
	 * returns the block bounderies maxX value
	 */
	double getBlockBoundsMaxX ();

	/**
	 * returns the block bounderies minY value
	 */
	double getBlockBoundsMinY ();

	/**
	 * returns the block bounderies maxY value
	 */
	double getBlockBoundsMaxY ();

	/**
	 * returns the block bounderies minZ value
	 */
	double getBlockBoundsMinZ ();

	/**
	 * returns the block bounderies maxZ value
	 */
	double getBlockBoundsMaxZ ();

	@SideOnly(Side.CLIENT)
	int getBlockColor ();

	/**
	 * Returns the color this block should be rendered. Used by leaves.
	 */
	@SideOnly(Side.CLIENT)
	int getRenderColor ( int p_149741_1_ );

	/**
	 * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
	 * when first determining what to render.
	 */
	@SideOnly(Side.CLIENT)
	int colorMultiplier ( IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_ );

	int isProvidingWeakPower ( IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_ );

	/**
	 * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
	 */
	void onEntityCollidedWithBlock ( World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_ );

	int isProvidingStrongPower ( IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_ );

	/**
	 * Sets the block's bounds for rendering it as an item
	 */
	void setBlockBoundsForItemRender ();

	/**
	 * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
	 * block and l is the block's subtype/damage.
	 */
	void harvestBlock ( World p_149636_1_, EntityPlayer p_149636_2_, int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_ );

	/**
	 * Drops the specified block items
	 */
	void dropBlockAsItem ( World p_149697_1_, int p_149697_2_, int p_149697_3_, int p_149697_4_, int p_149697_5_, int p_149697_6_ );

	/**
	 * Drops the block items with a specified chance of dropping the specified items
	 */
	void dropBlockAsItemWithChance ( World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_ );

	/**
	 * This returns a complete list of items dropped from this block.
	 *
	 * @param world    The current world
	 * @param x        X Position
	 * @param y        Y Position
	 * @param z        Z Position
	 * @param metadata Current metadata
	 * @param fortune  Breakers fortune level
	 *
	 * @return A ArrayList containing all items this block drops
	 */
	ArrayList<ItemStack> getDrops ( World world, int x, int y, int z, int metadata, int fortune );

	Item getItemDropped ( int p_149650_1_, Random p_149650_2_, int p_149650_3_ );

	/**
	 * Metadata and fortune sensitive version, this replaces the old (int meta, Random rand)
	 * version in 1.1.
	 *
	 * @param meta    Blocks Metadata
	 * @param fortune Current item fortune level
	 * @param random  Random number generator
	 *
	 * @return The number of items to drop
	 */
	int quantityDropped ( int meta, int fortune, Random random );

	/**
	 * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
	 */
	int quantityDroppedWithBonus ( int p_149679_1_, Random p_149679_2_ );

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	int quantityDropped ( Random p_149745_1_ );

	/**
	 * Return true from this function if the player with silk touch can harvest this block directly, and not it's normal drops.
	 *
	 * @param world    The world
	 * @param player   The player doing the harvesting
	 * @param x        X Position
	 * @param y        Y Position
	 * @param z        Z Position
	 * @param metadata The metadata
	 *
	 * @return True if the block can be directly harvested using silk touch
	 */
	boolean canSilkHarvest ( World world, EntityPlayer player, int x, int y, int z, int metadata );

	/**
	 * Called throughout the code as a replacement for block instanceof BlockContainer
	 * Moving this to the Block base class allows for mods that wish to extend vanilla
	 * blocks, and also want to have a tile entity on that block, may.
	 *
	 * Return true from this function to specify this block has a tile entity.
	 *
	 * @param metadata Metadata of the current block
	 *
	 * @return True if block has a tile entity, false otherwise
	 */


	boolean hasTileEntity ( int metadata );

	/**
	 * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
	 */
	boolean canBlockStay ( World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_ );

	/**
	 * Called when the block is placed in the world.
	 */
	void onBlockPlacedBy ( World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_ );

	/**
	 * Called after a block is placed
	 */
	void onPostBlockPlaced ( World p_149714_1_, int p_149714_2_, int p_149714_3_, int p_149714_4_, int p_149714_5_ );

	/**
	 * Sets the mod-specific block name
	 */
	Block setBlockName ( String p_149663_1_ );

	/**
	 * Gets the localized name of this block. Used for the statistics page.
	 */
	String getLocalizedName ();

	/**
	 * Returns the unlocalized name of the block with "tile." appended to the front.
	 */
	String getUnlocalizedName ();

	boolean onBlockEventReceived ( World p_149696_1_, int p_149696_2_, int p_149696_3_, int p_149696_4_, int p_149696_5_, int p_149696_6_ );

	/**
	 * Return the state of blocks statistics flags - if the block is counted for mined and placed.
	 */
	boolean getEnableStats ();

	/**
	 * Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility
	 * and stop pistons
	 */
	int getMobilityFlag ();

	/**
	 * Returns the default ambient occlusion value based on block opacity
	 */
	@SideOnly(Side.CLIENT)
	float getAmbientOcclusionLightValue ();

	/**
	 * Indicate if a material is a normal solid opaque cube
	 */
	@SideOnly(Side.CLIENT)
	boolean isBlockNormalCube ();

	/**
	 * Block's chance to react to an entity falling on it.
	 */
	void onFallenUpon ( World p_149746_1_, int p_149746_2_, int p_149746_3_, int p_149746_4_, Entity p_149746_5_, float p_149746_6_ );

	/**
	 * Gets an item for the block being called on. Args: world, x, y, z
	 */
	@SideOnly(Side.CLIENT)
	Item getItem ( World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_ );

	/**
	 * Get the block's damage value (for use with pick block).
	 */
	int getDamageValue ( World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_ );

	/**
	 * Determines the damage on the item the block drops. Used in cloth and wood.
	 */
	int damageDropped ( int p_149692_1_ );

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@SideOnly(Side.CLIENT)
	void getSubBlocks ( Item p_149666_1_, CreativeTabs p_149666_2_, List<?> p_149666_3_ );

	Block setCreativeTab ( CreativeTabs p_149647_1_ );

	/**
	 * Called when the block is attempted to be harvested
	 */
	void onBlockHarvested ( World p_149681_1_, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer p_149681_6_ );

	/**
	 * Returns the CreativeTab to display the given block on.
	 */
	@SideOnly(Side.CLIENT)
	CreativeTabs getCreativeTabToDisplayOn ();

	/**
	 * Called on server worlds only when the block is about to be replaced by a different block or the same block with a
	 * different metadata value. Args: world, x, y, z, old metadata
	 */
	void onBlockPreDestroy ( World p_149725_1_, int p_149725_2_, int p_149725_3_, int p_149725_4_, int p_149725_5_ );

	/**
	 * currently only used by BlockCauldron to incrament meta-data during rain
	 */
	void fillWithRain ( World p_149639_1_, int p_149639_2_, int p_149639_3_, int p_149639_4_ );

	/**
	 * Returns true only if block is flowerPot
	 */
	@SideOnly(Side.CLIENT)
	boolean isFlowerPot ();

	boolean func_149698_L ();

	/**
	 * Return whether this block can drop from an explosion.
	 */
	boolean canDropFromExplosion ( Explosion p_149659_1_ );

	boolean isAssociatedBlock ( Block p_149667_1_ );

	/**
	 * If this returns true, then comparators facing away from this block will use the value from
	 * getComparatorInputOverride instead of the actual redstone signal strength.
	 */
	boolean hasComparatorInputOverride ();

	/**
	 * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
	 * strength when this block inputs to a comparator.
	 */
	int getComparatorInputOverride ( World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_ );

	Block setBlockTextureName ( String p_149658_1_ );

	@SideOnly(Side.CLIENT)
	IIcon func_149735_b ( int p_149735_1_, int p_149735_2_ );

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	IIcon getIcon ( int p_149691_1_, int p_149691_2_ );

	@SideOnly(Side.CLIENT)
	void registerBlockIcons ( IIconRegister p_149651_1_ );

	/**
	 * Gets the icon name of the ItemBlock corresponding to this block. Used by hoppers.
	 */
	@SideOnly(Side.CLIENT)
	String getItemIconName ();

	/**
	 * Get a light value for the block at the specified coordinates, normal ranges are between 0 and 15
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y position
	 * @param z     Z position
	 *
	 * @return The light value
	 */
	int getLightValue ( IBlockAccess world, int x, int y, int z );

	/**
	 * Gets the light value of the specified block coords. Args: x, y, z
	 */
	int getLightValue ();

	/**
	 * Checks if a player or entity can use this block to 'climb' like a ladder.
	 *
	 * @param world  The current world
	 * @param x      X Position
	 * @param y      Y position
	 * @param z      Z position
	 * @param entity The entity trying to use the ladder, CAN be null.
	 *
	 * @return True if the block should act like a ladder
	 */
	boolean isLadder ( IBlockAccess world, int x, int y, int z, EntityLivingBase entity );

	/**
	 * Determines if a new block can be replace the space occupied by this one,
	 * Used in the player's placement code to make the block act like water, and lava.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y position
	 * @param z     Z position
	 *
	 * @return True if the block is replaceable by another block
	 */
	boolean isReplaceable ( IBlockAccess world, int x, int y, int z );

	/**
	 * Determines if this block should set fire and deal fire damage
	 * to entities coming into contact with it.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y position
	 * @param z     Z position
	 *
	 * @return True if the block should deal damage
	 */
	boolean isBurning ( IBlockAccess world, int x, int y, int z );

	/**
	 * Determines this block should be treated as an air block
	 * by the rest of the code. This method is primarily
	 * useful for creating pure logic-blocks that will be invisible
	 * to the player and otherwise interact as air would.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y position
	 * @param z     Z position
	 *
	 * @return True if the block considered air
	 */
	boolean isAir ( IBlockAccess world, int x, int y, int z );

	Material getMaterial ();

	/**
	 * Determines if the player can harvest this block, obtaining it's drops when the block is destroyed.
	 *
	 * @param player The player damaging the block, may be null
	 * @param meta   The block's current metadata
	 *
	 * @return True to spawn the drops
	 */
	boolean canHarvestBlock ( EntityPlayer player, int meta );

	/**
	 * Called when a player removes a block.  This is responsible for
	 * actually destroying the block, and the block is intact at time of call.
	 * This is called regardless of whether the player can harvest the block or
	 * not.
	 *
	 * Return true if the block is actually destroyed.
	 *
	 * Note: When used in multiplayer, this is called on both client and
	 * server sides!
	 *
	 * @param world  The current world
	 * @param player The player damaging the block, may be null
	 * @param x      X Position
	 * @param y      Y position
	 * @param z      Z position
	 *
	 * @return True if the block is actually destroyed.
	 */
	boolean removedByPlayer ( World world, EntityPlayer player, int x, int y, int z );

	/**
	 * Called when fire is updating, checks if a block face can catch fire.
	 *
	 * @param world The current world
	 * @param x     The blocks X position
	 * @param y     The blocks Y position
	 * @param z     The blocks Z position
	 * @param face  The face that the fire is coming from
	 *
	 * @return True if the face can be on fire, false otherwise.
	 */
	boolean isFlammable ( IBlockAccess world, int x, int y, int z, ForgeDirection face );

	/**
	 * Chance that fire will spread and consume this block.
	 * 300 being a 100% chance, 0, being a 0% chance.
	 *
	 * @param world The current world
	 * @param x     The blocks X position
	 * @param y     The blocks Y position
	 * @param z     The blocks Z position
	 * @param face  The face that the fire is coming from
	 *
	 * @return A number ranging from 0 to 300 relating used to determine if the block will be consumed by fire
	 */
	int getFlammability ( IBlockAccess world, int x, int y, int z, ForgeDirection face );

	/**
	 * Called when fire is updating on a neighbor block.
	 * The higher the number returned, the faster fire will spread around this block.
	 *
	 * @param world The current world
	 * @param x     The blocks X position
	 * @param y     The blocks Y position
	 * @param z     The blocks Z position
	 * @param face  The face that the fire is coming from
	 *
	 * @return A number that is used to determine the speed of fire growth around the block
	 */
	int getFireSpreadSpeed ( IBlockAccess world, int x, int y, int z, ForgeDirection face );

	/**
	 * Currently only called by fire when it is on top of this block.
	 * Returning true will prevent the fire from naturally dying during updating.
	 * Also prevents firing from dying from rain.
	 *
	 * @param world The current world
	 * @param x     The blocks X position
	 * @param y     The blocks Y position
	 * @param z     The blocks Z position
	 * @param side  The face that the fire is coming from
	 *
	 * @return True if this block sustains fire, meaning it will never go out.
	 */
	boolean isFireSource ( World world, int x, int y, int z, ForgeDirection side );

	/**
	 * Called throughout the code as a replacement for ITileEntityProvider.createNewTileEntity
	 * Return the same thing you would from that function.
	 * This will fall back to ITileEntityProvider.createNewTileEntity(World) if this block is a ITileEntityProvider
	 *
	 * @param metadata The Metadata of the current block
	 *
	 * @return A instance of a class extending TileEntity
	 */
	TileEntity createTileEntity ( World world, int metadata );

	/**
	 * Determines if a specified mob type can spawn on this block, returning false will
	 * prevent any mob from spawning on the block.
	 *
	 * @param type  The Mob Category Type
	 * @param world The current world
	 * @param x     The X Position
	 * @param y     The Y Position
	 * @param z     The Z Position
	 *
	 * @return True to allow a mob of the specified category to spawn, false to prevent it.
	 */
	boolean canCreatureSpawn ( EnumCreatureType type, IBlockAccess world, int x, int y, int z );

	boolean func_149730_j ();

	/**
	 * Checks if the block is a solid face on the given side, used by placement logic.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y position
	 * @param z     Z position
	 * @param side  The side to check
	 *
	 * @return True if the block is solid on the specified side.
	 */
	boolean isSideSolid ( IBlockAccess world, int x, int y, int z, ForgeDirection side );

	/**
	 * Return true if the block is a normal, solid cube.  This
	 * determines indirect power state, entity ejection from blocks, and a few
	 * others.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y position
	 * @param z     Z position
	 *
	 * @return True if the block is a full cube
	 */
	boolean isNormalCube ( IBlockAccess world, int x, int y, int z );

	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	boolean renderAsNormalBlock ();

	/**
	 * Can this block provide power. Only wire currently seems to have this change based on its state.
	 */
	boolean canProvidePower ();

	/**
	 * Determines if this block is classified as a Bed, Allowing
	 * players to sleep in it, though the block has to specifically
	 * perform the sleeping functionality in it's activated event.
	 *
	 * @param world  The current world
	 * @param x      X Position
	 * @param y      Y Position
	 * @param z      Z Position
	 * @param player The player or camera entity, null in some cases.
	 *
	 * @return True to treat this as a bed
	 */
	boolean isBed ( IBlockAccess world, int x, int y, int z, EntityLivingBase player );

	/**
	 * Returns the position that the player is moved to upon
	 * waking up, or respawning at the bed.
	 *
	 * @param world  The current world
	 * @param x      X Position
	 * @param y      Y Position
	 * @param z      Z Position
	 * @param player The player or camera entity, null in some cases.
	 *
	 * @return The spawn position
	 */
	ChunkCoordinates getBedSpawnPosition ( IBlockAccess world, int x, int y, int z, EntityPlayer player );

	/**
	 * Called when a user either starts or stops sleeping in the bed.
	 *
	 * @param world    The current world
	 * @param x        X Position
	 * @param y        Y Position
	 * @param z        Z Position
	 * @param player   The player or camera entity, null in some cases.
	 * @param occupied True if we are occupying the bed, or false if they are stopping use of the bed
	 */
	void setBedOccupied ( IBlockAccess world, int x, int y, int z, EntityPlayer player, boolean occupied );

	/**
	 * Returns the direction of the block. Same values that
	 * are returned by BlockDirectional
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y Position
	 * @param z     Z Position
	 *
	 * @return Bed direction
	 */
	int getBedDirection ( IBlockAccess world, int x, int y, int z );

	/**
	 * Determines if the current block is the foot half of the bed.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y Position
	 * @param z     Z Position
	 *
	 * @return True if the current block is the foot side of a bed.
	 */
	boolean isBedFoot ( IBlockAccess world, int x, int y, int z );

	/**
	 * Called when a leaf should start its decay process.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y Position
	 * @param z     Z Position
	 */
	void beginLeavesDecay ( World world, int x, int y, int z );

	/**
	 * Determines if this block can prevent leaves connected to it from decaying.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y Position
	 * @param z     Z Position
	 *
	 * @return true if the presence this block can prevent leaves from decaying.
	 */
	boolean canSustainLeaves ( IBlockAccess world, int x, int y, int z );

	/**
	 * Determines if this block is considered a leaf block, used to apply the leaf decay and generation system.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y Position
	 * @param z     Z Position
	 *
	 * @return true if this block is considered leaves.
	 */
	boolean isLeaves ( IBlockAccess world, int x, int y, int z );

	/**
	 * Used during tree growth to determine if newly generated leaves can replace this block.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y Position
	 * @param z     Z Position
	 *
	 * @return true if this block can be replaced by growing leaves.
	 */
	boolean canBeReplacedByLeaves ( IBlockAccess world, int x, int y, int z );

	/**
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y Position
	 * @param z     Z Position
	 *
	 * @return true if the block is wood (logs)
	 */
	boolean isWood ( IBlockAccess world, int x, int y, int z );

	/**
	 * Determines if the current block is replaceable by Ore veins during world generation.
	 *
	 * @param world  The current world
	 * @param x      X Position
	 * @param y      Y Position
	 * @param z      Z Position
	 * @param target The generic target block the gen is looking for, Standards define stone
	 *               for overworld generation, and neatherack for the nether.
	 *
	 * @return True to allow this block to be replaced by a ore
	 */
	boolean isReplaceableOreGen ( World world, int x, int y, int z, Block target );

	/**
	 * Location sensitive version of getExplosionRestance
	 *
	 * @param par1Entity The entity that caused the explosion
	 * @param world      The current world
	 * @param x          X Position
	 * @param y          Y Position
	 * @param z          Z Position
	 * @param explosionX Explosion source X Position
	 * @param explosionY Explosion source X Position
	 * @param explosionZ Explosion source X Position
	 *
	 * @return The amount of the explosion absorbed.
	 */
	float getExplosionResistance ( Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ );

	/**
	 * Returns how much this block can resist explosions from the passed in entity.
	 */
	float getExplosionResistance ( Entity p_149638_1_ );

	/**
	 * Called when the block is destroyed by an explosion.
	 * Useful for allowing the block to take into account tile entities,
	 * metadata, etc. when exploded, before it is removed.
	 *
	 * @param world     The current world
	 * @param x         X Position
	 * @param y         Y Position
	 * @param z         Z Position
	 * @param explosion The explosion instance affecting the block
	 */
	void onBlockExploded ( World world, int x, int y, int z, Explosion explosion );

	/**
	 * Called upon the block being destroyed by an explosion
	 */
	void onBlockDestroyedByExplosion ( World p_149723_1_, int p_149723_2_, int p_149723_3_, int p_149723_4_, Explosion p_149723_5_ );

	/**
	 * Determine if this block can make a redstone connection on the side provided,
	 * Useful to control which sides are inputs and outputs for redstone wires.
	 *
	 * Side:
	 * -1: UP
	 * 0: NORTH
	 * 1: EAST
	 * 2: SOUTH
	 * 3: WEST
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y Position
	 * @param z     Z Position
	 * @param side  The side that is trying to make the connection
	 *
	 * @return True to make the connection
	 */
	boolean canConnectRedstone ( IBlockAccess world, int x, int y, int z, int side );

	/**
	 * Determines if a torch can be placed on the top surface of this block.
	 * Useful for creating your own block that torches can be on, such as fences.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y Position
	 * @param z     Z Position
	 *
	 * @return True to allow the torch to be placed
	 */
	boolean canPlaceTorchOnTop ( World world, int x, int y, int z );

	/**
	 * Determines if this block should render in this pass.
	 *
	 * @param pass The pass in question
	 *
	 * @return True to render
	 */
	boolean canRenderInPass ( int pass );

	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	@SideOnly(Side.CLIENT)
	int getRenderBlockPass ();

	/**
	 * Called when a user uses the creative pick block button on this block
	 *
	 * @param target The full target the player is looking at
	 *
	 * @return A ItemStack to add to the player's inventory, Null if nothing should be added.
	 */
	ItemStack getPickBlock ( MovingObjectPosition target, World world, int x, int y, int z );

	/**
	 * Used by getTopSolidOrLiquidBlock while placing biome decorations, villages, etc
	 * Also used to determine if the player can spawn on this block.
	 *
	 * @return False to disallow spawning
	 */
	boolean isFoliage ( IBlockAccess world, int x, int y, int z );

	/**
	 * Spawn a digging particle effect in the world, this is a wrapper
	 * around EffectRenderer.addBlockHitEffects to allow the block more
	 * control over the particles. Useful when you have entirely different
	 * texture sheets for different sides/locations in the world.
	 *
	 * @param world          The current world
	 * @param target         The target the player is looking at {x/y/z/side/sub}
	 * @param effectRenderer A reference to the current effect renderer.
	 *
	 * @return True to prevent vanilla digging particles form spawning.
	 */
	@SideOnly(Side.CLIENT)
	boolean addHitEffects ( World world, MovingObjectPosition target, EffectRenderer effectRenderer );

	/**
	 * Spawn particles for when the block is destroyed. Due to the nature
	 * of how this is invoked, the x/y/z locations are not always guaranteed
	 * to host your block. So be sure to do proper sanity checks before assuming
	 * that the location is this block.
	 *
	 * @param world          The current world
	 * @param x              X position to spawn the particle
	 * @param y              Y position to spawn the particle
	 * @param z              Z position to spawn the particle
	 * @param meta           The metadata for the block before it was destroyed.
	 * @param effectRenderer A reference to the current effect renderer.
	 *
	 * @return True to prevent vanilla break particles from spawning.
	 */
	@SideOnly(Side.CLIENT)
	boolean addDestroyEffects ( World world, int x, int y, int z, int meta, EffectRenderer effectRenderer );

	/**
	 * Determines if this block can support the passed in plant, allowing it to be planted and grow.
	 * Some examples:
	 * Reeds check if its a reed, or if its sand/dirt/grass and adjacent to water
	 * Cacti checks if its a cacti, or if its sand
	 * Nether types check for soul sand
	 * Crops check for tilled soil
	 * Caves check if it's a solid surface
	 * Plains check if its grass or dirt
	 * Water check if its still water
	 *
	 * @param world     The current world
	 * @param x         X Position
	 * @param y         Y Position
	 * @param z         Z position
	 * @param direction The direction relative to the given position the plant wants to be, typically its UP
	 * @param plantable The plant that wants to check
	 *
	 * @return True to allow the plant to be planted/stay.
	 */
	boolean canSustainPlant ( IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable );

	/**
	 * Called when a plant grows on this block, only implemented for saplings using the WorldGen*Trees classes right now.
	 * Modder may implement this for custom plants.
	 * This does not use ForgeDirection, because large/huge trees can be located in non-representable direction,
	 * so the source location is specified.
	 * Currently this just changes the block to dirt if it was grass.
	 *
	 * Note: This happens DURING the generation, the generation may not be complete when this is called.
	 *
	 * @param world   Current world
	 * @param x       Soil X
	 * @param y       Soil Y
	 * @param z       Soil Z
	 * @param sourceX Plant growth location X
	 * @param sourceY Plant growth location Y
	 * @param sourceZ Plant growth location Z
	 */
	void onPlantGrow ( World world, int x, int y, int z, int sourceX, int sourceY, int sourceZ );

	/**
	 * Checks if this soil is fertile, typically this means that growth rates
	 * of plants on this soil will be slightly sped up.
	 * Only vanilla case is tilledField when it is within range of water.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y Position
	 * @param z     Z position
	 *
	 * @return True if the soil should be considered fertile.
	 */
	boolean isFertile ( World world, int x, int y, int z );

	/**
	 * Location aware and overrideable version of the lightOpacity array,
	 * return the number to subtract from the light value when it passes through this block.
	 *
	 * This is not guaranteed to have the tile entity in place before this is called, so it is
	 * Recommended that you have your tile entity call relight after being placed if you
	 * rely on it for light info.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y Position
	 * @param z     Z position
	 *
	 * @return The amount of light to block, 0 for air, 255 for fully opaque.
	 */
	int getLightOpacity ( IBlockAccess world, int x, int y, int z );

	/**
	 * Determines if this block is can be destroyed by the specified entities normal behavior.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y Position
	 * @param z     Z position
	 *
	 * @return True to allow the ender dragon to destroy this block
	 */
	boolean canEntityDestroy ( IBlockAccess world, int x, int y, int z, Entity entity );

	/**
	 * Determines if this block can be used as the base of a beacon.
	 *
	 * @param world   The current world
	 * @param x       X Position
	 * @param y       Y Position
	 * @param z       Z position
	 * @param beaconX Beacons X Position
	 * @param beaconY Beacons Y Position
	 * @param beaconZ Beacons Z Position
	 *
	 * @return True, to support the beacon, and make it active with this block.
	 */
	boolean isBeaconBase ( IBlockAccess world, int x, int y, int z, int beaconX, int beaconY, int beaconZ );

	/**
	 * Rotate the block. For vanilla blocks this rotates around the axis passed in (generally, it should be the "face" that was hit).
	 * Note: for mod blocks, this is up to the block and modder to decide. It is not mandated that it be a rotation around the
	 * face, but could be a rotation to orient *to* that face, or a visiting of possible rotations.
	 * The method should return true if the rotation was successful though.
	 *
	 * @param worldObj The world
	 * @param x        X position
	 * @param y        Y position
	 * @param z        Z position
	 * @param axis     The axis to rotate around
	 *
	 * @return True if the rotation was successful, False if the rotation failed, or is not possible
	 */
	boolean rotateBlock ( World worldObj, int x, int y, int z, ForgeDirection axis );

	/**
	 * Get the rotations that can apply to the block at the specified coordinates. Null means no rotations are possible.
	 * Note, this is up to the block to decide. It may not be accurate or representative.
	 *
	 * @param worldObj The world
	 * @param x        X position
	 * @param y        Y position
	 * @param z        Z position
	 *
	 * @return An array of valid axes to rotate around, or null for none or unknown
	 */
	ForgeDirection[] getValidRotations ( World worldObj, int x, int y, int z );

	/**
	 * Determines the amount of enchanting power this block can provide to an enchanting table.
	 *
	 * @param world The World
	 * @param x     X position
	 * @param y     Y position
	 * @param z     Z position
	 *
	 * @return The amount of enchanting power this block produces.
	 */
	float getEnchantPowerBonus ( World world, int x, int y, int z );

	/**
	 * Common way to recolour a block with an external tool
	 *
	 * @param world  The world
	 * @param x      X
	 * @param y      Y
	 * @param z      Z
	 * @param side   The side hit with the colouring tool
	 * @param colour The colour to change to
	 *
	 * @return If the recolouring was successful
	 */
	boolean recolourBlock ( World world, int x, int y, int z, ForgeDirection side, int colour );

	/**
	 * Gathers how much experience this block drops when broken.
	 *
	 * @param world    The world
	 * @param metadata Metadata
	 * @param fortune  Fortune
	 *
	 * @return Amount of XP from breaking this block.
	 */
	int getExpDrop ( IBlockAccess world, int metadata, int fortune );

	/**
	 * Called when a tile entity on a side of this block changes is created or is destroyed.
	 *
	 * @param world The world
	 * @param x     The x position of this block instance
	 * @param y     The y position of this block instance
	 * @param z     The z position of this block instance
	 * @param tileX The x position of the tile that changed
	 * @param tileY The y position of the tile that changed
	 * @param tileZ The z position of the tile that changed
	 */
	void onNeighborChange ( IBlockAccess world, int x, int y, int z, int tileX, int tileY, int tileZ );

	/**
	 * Called to determine whether to allow the a block to handle its own indirect power rather than using the default rules.
	 *
	 * @param world The world
	 * @param x     The x position of this block instance
	 * @param y     The y position of this block instance
	 * @param z     The z position of this block instance
	 * @param side  The INPUT side of the block to be powered - ie the opposite of this block's output side
	 *
	 * @return Whether Block#isProvidingWeakPower should be called when determining indirect power
	 */
	boolean shouldCheckWeakPower ( IBlockAccess world, int x, int y, int z, int side );

	/**
	 * If this block should be notified of weak changes.
	 * Weak changes are changes 1 block away through a solid block.
	 * Similar to comparators.
	 *
	 * @param world The current world
	 * @param x     X Position
	 * @param y     Y position
	 * @param z     Z position
	 *
	 * @return true To be notified of changes
	 */
	boolean getWeakChanges ( IBlockAccess world, int x, int y, int z );

	/**
	 * Sets or removes the tool and level required to harvest this block.
	 *
	 * @param toolClass Class
	 * @param level     Harvest level:
	 *                  Wood:    0
	 *                  Stone:   1
	 *                  Iton:    2
	 *                  Diamond: 3
	 *                  Gold:    0
	 */
	void setHarvestLevel ( String toolClass, int level );

	/**
	 * Sets or removes the tool and level required to harvest this block.
	 *
	 * @param toolClass Class
	 * @param level     Harvest level:
	 *                  Wood:    0
	 *                  Stone:   1
	 *                  Iton:    2
	 *                  Diamond: 3
	 *                  Gold:    0
	 * @param metadata  The specific metadata to set
	 */
	void setHarvestLevel ( String toolClass, int level, int metadata );

	/**
	 * Queries the class of tool required to harvest this block, if null is returned
	 * we assume that anything can harvest this block.
	 *
	 * @param metadata Information about required tool to harvest this block
	 *
	 * @return Class of tool required to harvest this block
	 */
	String getHarvestTool ( int metadata );

	/**
	 * Queries the harvest level of this item stack for the specifred tool class,
	 * Returns -1 if this tool is not of the specified type
	 *
	 * @param metadata This item stack instance
	 *
	 * @return Harvest level, or -1 if not the specified tool type.
	 */
	int getHarvestLevel ( int metadata );

	/**
	 * Checks if the specified tool type is efficient on this block,
	 * meaning that it digs at full speed.
	 *
	 * @param type     Type of Tool
	 * @param metadata Metadata
	 *
	 * @return True, if tool is effective
	 */
	boolean isToolEffective ( String type, int metadata );
}
