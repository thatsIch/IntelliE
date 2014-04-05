package de.thatsich.intellie.common.module.item;

import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

import java.util.List;
import java.util.Random;
import java.util.Set;

public interface IItem
{
	Item setMaxStackSize( int par1 );

	/**
	 Returns 0 for /terrain.png, 1 for /gui/items.png
	 */
	@SideOnly( Side.CLIENT )
	int getSpriteNumber();

	/**
	 Returns the icon index of the stack given as argument.
	 */
	@SideOnly( Side.CLIENT )
	IIcon getIconIndex( ItemStack par1ItemStack );

	/**
	 Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
	 True if something happen and false if it don't. This is for ITEMS, not BLOCKS
	 */
	boolean onItemUse( ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10 );

	/**
	 Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	ItemStack onItemRightClick( ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer );

	ItemStack onEaten( ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer );

	/**
	 Returns the metadata of the block which this Item (ItemBlock) can place
	 */
	int getMetadata( int par1 );

	boolean getHasSubtypes();

	Item setHasSubtypes( boolean par1 );

	/**
	 set max damage of an Item
	 */
	Item setMaxDamage( int par1 );

	/**
	 Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
	 the damage on the stack.
	 */
	boolean hitEntity( ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase );

	boolean onBlockDestroyed( ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_ );

	/**
	 Returns true if the item can be used on the given entity, e.g. shears on sheep.
	 */
	boolean itemInteractionForEntity( ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase );

	/**
	 Sets bFull3D to True and return the object.
	 */
	Item setFull3D();

	/**
	 Returns True is the item is renderer in full 3D when hold.
	 */
	@SideOnly( Side.CLIENT )
	boolean isFull3D();

	/**
	 Returns true if this item should be rotated by 180 degrees around the Y axis when being held in an entities
	 hands.
	 */
	@SideOnly( Side.CLIENT )
	boolean shouldRotateAroundWhenRendering();

	/**
	 Sets the unlocalized name of this item to the string passed as the parameter, prefixed by "item."
	 */
	Item setUnlocalizedName( String par1Str );

	/**
	 Returns the unlocalized name of this item.
	 */
	String getUnlocalizedName();

	Item setContainerItem( Item par1Item );

	/**
	 If this returns true, after a recipe involving this item is crafted the container item will be added to the
	 player's inventory instead of remaining in the crafting grid.
	 */
	boolean doesContainerItemLeaveCraftingGrid( ItemStack par1ItemStack );

	/**
	 If this function returns true (or the item is damageable), the ItemStack's NBT tag will be sent to the client.
	 */
	boolean getShareTag();

	@SideOnly( Side.CLIENT )
	int getColorFromItemStack( ItemStack par1ItemStack, int par2 );

	/**
	 Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
	 update it's contents.
	 */
	void onUpdate( ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5 );

	/**
	 Called when item is crafted/smelted. Used only by maps so far.
	 */
	void onCreated( ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer );

	/**
	 false for all Items except sub-classes of ItemMapBase
	 */
	boolean isMap();

	/**
	 returns the action that specifies what animation to play when the items is being used
	 */
	EnumAction getItemUseAction( ItemStack par1ItemStack );

	/**
	 How long it takes to use or consume an item
	 */
	int getMaxItemUseDuration( ItemStack par1ItemStack );

	/**
	 called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	 */
	void onPlayerStoppedUsing( ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4 );

	/**
	 Sets the string representing this item's effect on a potion when used as an ingredient.
	 */
	Item setPotionEffect( String par1Str );

	/**
	 Returns true if this item serves as a potion ingredient (its ingredient information is not null).
	 */
	boolean isPotionIngredient( ItemStack p_150892_1_ );

	/**
	 Returns a string representing what this item does to a potion.
	 */
	String getPotionEffect( ItemStack p_150896_1_ );

	/**
	 allows items to add custom lines of information to the mouseover description
	 */
	@SideOnly( Side.CLIENT )
	void addInformation( ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List<?> par3List, boolean par4 );

	String getItemStackDisplayName( ItemStack par1ItemStack );

	/**
	 Translates the unlocalized name of this item, but without the .name suffix, so the translation fails and the
	 unlocalized name itself is returned.
	 */
	String getUnlocalizedNameInefficiently( ItemStack par1ItemStack );

	/**
	 Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
	 different names based on their damage or NBT.
	 */
	String getUnlocalizedName( ItemStack par1ItemStack );

	/**
	 Return an item rarity from EnumRarity
	 */
	EnumRarity getRarity( ItemStack par1ItemStack );

	/**
	 Checks isDamagable and if it cannot be stacked
	 */
	boolean isItemTool( ItemStack par1ItemStack );

	/**
	 Gets the maximum number of items that this stack should be able to hold.
	 This is a ItemStack (and thus NBT) sensitive version of Item.getItemStackLimit()

	 @param stack The ItemStack

	 @return THe maximum number this item can be stacked to
	 */
	int getItemStackLimit( ItemStack stack );

	/**
	 Returns the maximum size of the stack for a specific item.
	 */
	@Deprecated
	int getItemStackLimit();

	/**
	 Return the enchantability factor of the item, most of the time is based on material.
	 */
	int getItemEnchantability();

	/**
	 returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	 */
	@SideOnly( Side.CLIENT )
	void getSubItems( Item p_150895_1_, CreativeTabs p_150895_2_, List<?> p_150895_3_ );

	/**
	 returns this;
	 */
	Item setCreativeTab( CreativeTabs par1CreativeTabs );

	/**
	 Returns true if players can use this item to affect the world (e.g. placing blocks, placing ender eyes in portal)
	 when not in creative
	 */
	boolean canItemEditBlocks();

	/**
	 Return whether this item is repairable in an anvil.
	 */
	boolean getIsRepairable( ItemStack par1ItemStack, ItemStack par2ItemStack );

	@SideOnly( Side.CLIENT )
	void registerIcons( IIconRegister par1IconRegister );

	/**
	 Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
	 */
	Multimap<?, ?> getItemAttributeModifiers();

	Item setTextureName( String par1Str );

	/**
	 Called when a player drops the item into the world,
	 returning false from this will prevent the item from
	 being removed from the players inventory and spawning
	 in the world

	 @param player The player that dropped the item
	 @param item   The item stack, before the item is removed.
	 */
	boolean onDroppedByPlayer( ItemStack item, EntityPlayer player );

	/**
	 This is called when the item is used, before the block is activated.

	 @param stack  The Item Stack
	 @param player The Player that used the item
	 @param world  The Current World
	 @param x      Target X Position
	 @param y      Target Y Position
	 @param z      Target Z Position
	 @param side   The side of the target hit

	 @return Return true to prevent any further processing.
	 */
	boolean onItemUseFirst( ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ );

	/**
	 Metadata-sensitive version of getStrVsBlock

	 @param itemstack The Item Stack
	 @param block     The block the item is trying to break
	 @param metadata  The items current metadata

	 @return The damage strength
	 */
	float getDigSpeed( ItemStack itemstack, Block block, int metadata );

	float func_150893_a( ItemStack p_150893_1_, Block p_150893_2_ );

	/**
	 Called by CraftingManager to determine if an item is reparable.

	 @return True if reparable
	 */
	boolean isRepairable();

	boolean isDamageable();

	/**
	 Call to disable repair recipes.

	 @return The current Item instance
	 */
	Item setNoRepair();

	/**
	 Called before a block is broken.  Return true to prevent default block harvesting.

	 Note: In SMP, this is called on both client and server sides!

	 @param itemstack The current ItemStack
	 @param X         The X Position
	 @param Y         The X Position
	 @param Z         The X Position
	 @param player    The Player that is wielding the item

	 @return True to prevent harvesting, false to continue as normal
	 */
	boolean onBlockStartBreak( ItemStack itemstack, int X, int Y, int Z, EntityPlayer player );

    /* ======================================== FORGE START =====================================*/

	/**
	 Called each tick while using an item.

	 @param stack  The Item being used
	 @param player The Player using the item
	 @param count  The amount of time in tick the item has been used for continuously
	 */
	void onUsingTick( ItemStack stack, EntityPlayer player, int count );

	/**
	 Called when the player Left Clicks (attacks) an entity.
	 Processed before damage is done, if return value is true further processing is canceled
	 and the entity is not attacked.

	 @param stack  The Item being used
	 @param player The player that is attacking
	 @param entity The entity being attacked

	 @return True to cancel the rest of the interaction.
	 */
	boolean onLeftClickEntity( ItemStack stack, EntityPlayer player, Entity entity );

	/**
	 Player, Render pass, and item usage sensitive version of getIconIndex.

	 @param stack        The item stack to get the icon for. (Usually this, and usingItem will be the same if usingItem is not null)
	 @param renderPass   The pass to get the icon for, 0 is default.
	 @param player       The player holding the item
	 @param usingItem    The item the player is actively using. Can be null if not using anything.
	 @param useRemaining The ticks remaining for the active item.

	 @return The icon index
	 */
	IIcon getIcon( ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining );

	/**
	 Return the correct icon for rendering based on the supplied ItemStack and render pass.

	 Defers to ;

	 @param stack to render for
	 @param pass  the multi-render pass

	 @return the icon
	 */
	IIcon getIcon( ItemStack stack, int pass );

	/**
	 Gets an icon index based on an item's damage value and the given render pass
	 */
	@SideOnly( Side.CLIENT )
	IIcon getIconFromDamageForRenderPass( int par1, int par2 );

	/**
	 Gets an icon index based on an item's damage value
	 */
	@SideOnly( Side.CLIENT )
	IIcon getIconFromDamage( int par1 );

	/**
	 Returns the number of render passes/layers this item has.
	 Usually equates to ItemRenderer.renderItem being called for this many passes.
	 Does not get called unless requiresMultipleRenderPasses() is true;

	 @param metadata The item's metadata

	 @return The number of passes to run.
	 */
	int getRenderPasses( int metadata );

	@SideOnly( Side.CLIENT )
	boolean requiresMultipleRenderPasses();

	/**
	 ItemStack sensitive version of getContainerItem.
	 Returns a full ItemStack instance of the result.

	 @param itemStack The current ItemStack

	 @return The resulting ItemStack
	 */
	ItemStack getContainerItem( ItemStack itemStack );

	Item getContainerItem();

	/**
	 ItemStack sensitive version of hasContainerItem

	 @param stack The current item stack

	 @return True if this item has a 'container'
	 */
	boolean hasContainerItem( ItemStack stack );

	/**
	 True if this Item has a container item (a.k.a. crafting result)
	 */
	@Deprecated
	// Use ItemStack sensitive version below.
	boolean hasContainerItem();

	/**
	 Retrieves the normal 'lifespan' of this item when it is dropped on the ground as a EntityItem.
	 This is in ticks, standard result is 6000, or 5 mins.

	 @param itemStack The current ItemStack
	 @param world     The world the entity is in

	 @return The normal lifespan in ticks.
	 */
	int getEntityLifespan( ItemStack itemStack, World world );

	/**
	 Determines if this Item has a special entity for when they are in the world.
	 Is called when a EntityItem is spawned in the world, if true and Item#createCustomEntity
	 returns non null, the EntityItem will be destroyed and the new Entity will be added to the world.

	 @param stack The current item stack

	 @return True of the item has a custom entity, If true, Item#createCustomEntity will be called
	 */
	boolean hasCustomEntity( ItemStack stack );

	/**
	 This function should return a new entity to replace the dropped item.
	 Returning null here will not kill the EntityItem and will leave it to function normally.
	 Called when the item it placed in a world.

	 @param world     The world object
	 @param location  The EntityItem object, useful for getting the position of the entity
	 @param itemstack The current item stack

	 @return A new Entity object to spawn or null
	 */
	Entity createEntity( World world, Entity location, ItemStack itemstack );

	/**
	 Called by the default implemetation of EntityItem's onUpdate method, allowing for cleaner
	 control over the update of the item without having to write a subclass.

	 @param entityItem The entity Item

	 @return Return true to skip any further update code.
	 */
	boolean onEntityItemUpdate( EntityItem entityItem );

	/**
	 Gets a list of tabs that items belonging to this class can display on,
	 combined properly with getSubItems allows for a single item to span
	 many sub-items across many tabs.

	 @return A list of all tabs that this item could possibly be one.
	 */
	CreativeTabs[] getCreativeTabs();

	/**
	 gets the CreativeTab this item is displayed on
	 */
	@SideOnly( Side.CLIENT )
	CreativeTabs getCreativeTab();

	/**
	 Determines the base experience for a player when they remove this item from a furnace slot.
	 This number must be between 0 and 1 for it to be valid.
	 This number will be multiplied by the stack size to get the total experience.

	 @param item The item stack the player is picking up.

	 @return The amount to award for each item.
	 */
	float getSmeltingExperience( ItemStack item );

	/**
	 Generates the base Random item for a specific instance of the chest gen,
	 Enchanted books use this to pick a random enchantment.

	 @param chest    The chest category to generate for
	 @param rnd      World RNG
	 @param original Original result registered with the chest gen hooks.

	 @return New values to use as the random item, typically this will be original
	 */
	WeightedRandomChestContent getChestGenBase( ChestGenHooks chest, Random rnd, WeightedRandomChestContent original );

	/**
	 Should this item, when held, allow sneak-clicks to pass through to the underlying block?

	 @param world  The world
	 @param x      The X Position
	 @param y      The X Position
	 @param z      The X Position
	 @param player The Player that is wielding the item

	 @return true if item allows to sneak-click to pass through underlying block
	 */
	boolean doesSneakBypassUse( World world, int x, int y, int z, EntityPlayer player );

	/**
	 Called to tick armor in the armor slot. Override to do something

	 @param world     The current world
	 @param player    The player wearing the armor
	 @param itemStack Wearing itemstack
	 */
	void onArmorTick( World world, EntityPlayer player, ItemStack itemStack );

	/**
	 Determines if the specific ItemStack can be placed in the specified armor slot.

	 @param stack     The ItemStack
	 @param armorType Armor slot ID: 0: Helmet, 1: Chest, 2: Legs, 3: Boots
	 @param entity    The entity trying to equip the armor

	 @return True if the given ItemStack can be inserted in the slot
	 */
	boolean isValidArmor( ItemStack stack, int armorType, Entity entity );

	/**
	 Allow or forbid the specific book/item combination as an anvil enchant

	 @param stack The item
	 @param book  The book

	 @return if the enchantment is allowed
	 */
	boolean isBookEnchantable( ItemStack stack, ItemStack book );

	/**
	 Called by RenderBiped and RenderPlayer to determine the armor texture that
	 should be use for the currently equiped item.
	 This will only be called on instances of ItemArmor.

	 Returning null from this function will use the default value.

	 @param stack  ItemStack for the equpt armor
	 @param entity The entity wearing the armor
	 @param slot   The slot the armor is in
	 @param type   The subtype, can be null or "overlay"

	 @return Path of texture to bind, or null to use default
	 */
	String getArmorTexture( ItemStack stack, Entity entity, int slot, String type );

	/**
	 Returns the font renderer used to render tooltips and overlays for this item.
	 Returning null will use the standard font renderer.

	 @param stack The current item stack

	 @return A instance of FontRenderer or null to use default
	 */
	@SideOnly( Side.CLIENT )
	FontRenderer getFontRenderer( ItemStack stack );

	/**
	 Override this method to have an item handle its own armor rendering.

	 @param entityLiving The entity wearing the armor
	 @param itemStack    The itemStack to render the model of
	 @param armorSlot    0=head, 1=torso, 2=legs, 3=feet

	 @return A ModelBiped to render instead of the default
	 */
	@SideOnly( Side.CLIENT )
	ModelBiped getArmorModel( EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot );

	/**
	 Called when a entity tries to play the 'swing' animation.

	 @param entityLiving The entity swinging the item.
	 @param stack        The Item stack

	 @return True to cancel any further processing by EntityLiving
	 */
	boolean onEntitySwing( EntityLivingBase entityLiving, ItemStack stack );

	/**
	 Called when the client starts rendering the HUD, for whatever item the player currently has as a helmet.
	 This is where pumpkins would render there overlay.

	 @param stack        The ItemStack that is equipped
	 @param player       Reference to the current client entity
	 @param resolution   Resolution information about the current viewport and configured GUI Scale
	 @param partialTicks Partial ticks for the renderer, useful for interpolation
	 @param hasScreen    If the player has a screen up, which will be rendered after this.
	 @param mouseX       Mouse's X position on screen
	 @param mouseY       Mouse's Y position on screen
	 */
	@SideOnly( Side.CLIENT )
	void renderHelmetOverlay( ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY );

	/**
	 Return the itemDamage represented by this ItemStack. Defaults to the itemDamage field on ItemStack, but can be overridden here for other sources such as NBT.

	 @param stack The itemstack that is damaged

	 @return the damage value
	 */
	int getDamage( ItemStack stack );

	/**
	 Return the itemDamage display value represented by this itemstack.

	 @param stack the stack

	 @return the damage value
	 */
	int getDisplayDamage( ItemStack stack );

	/**
	 Return the maxDamage for this ItemStack. Defaults to the maxDamage field in this item,
	 but can be overridden here for other sources such as NBT.

	 @param stack The itemstack that is damaged

	 @return the damage value
	 */
	int getMaxDamage( ItemStack stack );

	/**
	 Returns the maximum damage an item can take.
	 */
	int getMaxDamage();

	/**
	 Return if this itemstack is damaged. Note only called if ; is true.

	 @param stack the stack

	 @return if the stack is damaged
	 */
	boolean isDamaged( ItemStack stack );

	/**
	 Set the damage for this itemstack. Note, this method is responsible for zero checking.

	 @param stack  the stack
	 @param damage the new damage value
	 */
	void setDamage( ItemStack stack, int damage );

	/**
	 ItemStack sensitive version of ;

	 @param par1Block The block trying to harvest
	 @param itemStack The itemstack used to harvest the block

	 @return true if can harvest the block
	 */
	boolean canHarvestBlock( Block par1Block, ItemStack itemStack );

	boolean func_150897_b( Block p_150897_1_ );

	/**
	 Render Pass sensitive version of hasEffect()
	 */
	@SideOnly( Side.CLIENT )
	boolean hasEffect( ItemStack par1ItemStack, int pass );

	@SideOnly( Side.CLIENT )
	@Deprecated
	boolean hasEffect( ItemStack par1ItemStack );

	/**
	 Sets or removes the harvest level for the specified tool class.

	 @param toolClass Class
	 @param level     Harvest level:
	 Wood:    0
	 Stone:   1
	 Iron:    2
	 Diamond: 3
	 Gold:    0
	 */
	void setHarvestLevel( String toolClass, int level );

	Set<String> getToolClasses( ItemStack stack );

	/**
	 Queries the harvest level of this item stack for the specifred tool class,
	 Returns -1 if this tool is not of the specified type

	 @param stack     This item stack instance
	 @param toolClass Tool Class

	 @return Harvest level, or -1 if not the specified tool type.
	 */
	int getHarvestLevel( ItemStack stack, String toolClass );
}
