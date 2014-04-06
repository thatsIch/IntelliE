package de.thatsich.minecraft.common.module.item

import net.minecraft.item.{EnumRarity, EnumAction, ItemStack, Item}
import cpw.mods.fml.relauncher.{SideOnly, Side}
import net.minecraft.util.{WeightedRandomChestContent, IIcon}
import net.minecraft.entity.{EntityLivingBase, Entity}
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.client.gui.{ScaledResolution, FontRenderer}
import net.minecraft.client.model.ModelBiped
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraft.block.Block
import net.minecraft.client.renderer.texture.IIconRegister
import com.google.common.collect.Multimap
import net.minecraft.entity.item.EntityItem
import net.minecraftforge.common.ChestGenHooks
import java.util.Random

/**
 *
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
trait IItem
{
	def setMaxStackSize(par1: Int): Item

	/**
	Returns 0 for /terrain.png, 1 for /gui/items.png
	  */
	@SideOnly(Side.CLIENT) def getSpriteNumber: Int

	/**
	Returns the icon index of the stack given as argument.
	  */
	@SideOnly(Side.CLIENT) def getIconIndex(par1ItemStack: ItemStack): IIcon

	/**
	Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
	 True if something happen and false if it don't. This is for ITEMS, not BLOCKS
	  */
	def onItemUse(par1ItemStack: ItemStack, par2EntityPlayer: EntityPlayer, par3World: World, par4: Int, par5: Int, par6: Int, par7: Int, par8: Float, par9: Float, par10: Float): Boolean

	/**
	Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	  */
	def onItemRightClick(par1ItemStack: ItemStack, par2World: World, par3EntityPlayer: EntityPlayer): ItemStack

	def onEaten(par1ItemStack: ItemStack, par2World: World, par3EntityPlayer: EntityPlayer): ItemStack

	/**
	Returns the metadata of the block which this Item (ItemBlock) can place
	  */
	def getMetadata(par1: Int): Int

	def getHasSubtypes: Boolean

	def setHasSubtypes(par1: Boolean): Item

	/**
	set max damage of an Item
	  */
	def setMaxDamage(par1: Int): Item

	/**
	Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
	 the damage on the stack.
	  */
	def hitEntity(par1ItemStack: ItemStack, par2EntityLivingBase: EntityLivingBase, par3EntityLivingBase: EntityLivingBase): Boolean

	def onBlockDestroyed(p_150894_1_ : ItemStack, p_150894_2_ : World, p_150894_3_ : Block, p_150894_4_ : Int, p_150894_5_ : Int, p_150894_6_ : Int, p_150894_7_ : EntityLivingBase): Boolean

	/**
	Returns true if the item can be used on the given entity, e.g. shears on sheep.
	  */
	def itemInteractionForEntity(par1ItemStack: ItemStack, par2EntityPlayer: EntityPlayer, par3EntityLivingBase: EntityLivingBase): Boolean

	/**
	Sets bFull3D to True and return the object.
	  */
	def setFull3D(): Item

	/**
	Returns True is the item is renderer in full 3D when hold.
	  */
	@SideOnly(Side.CLIENT) def isFull3D: Boolean

	/**
	Returns true if this item should be rotated by 180 degrees around the Y axis when being held in an entities
	 hands.
	  */
	@SideOnly(Side.CLIENT) def shouldRotateAroundWhenRendering: Boolean

	/**
	Sets the unlocalized name of this item to the string passed as the parameter, prefixed by "item."
	  */
	def setUnlocalizedName(par1Str: String): Item

	/**
	Returns the unlocalized name of this item.
	  */
	def getUnlocalizedName: String

	def setContainerItem(par1Item: Item): Item

	/**
	If this returns true, after a recipe involving this item is crafted the container item will be added to the
	 player's inventory instead of remaining in the crafting grid.
	  */
	def doesContainerItemLeaveCraftingGrid(par1ItemStack: ItemStack): Boolean

	/**
	If this function returns true (or the item is damageable), the ItemStack's NBT tag will be sent to the client.
	  */
	def getShareTag: Boolean

	@SideOnly(Side.CLIENT) def getColorFromItemStack(par1ItemStack: ItemStack, par2: Int): Int

	/**
	Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
	 update it's contents.
	  */
	def onUpdate(par1ItemStack: ItemStack, par2World: World, par3Entity: Entity, par4: Int, par5: Boolean)

	/**
	Called when item is crafted/smelted. Used only by maps so far.
	  */
	def onCreated(par1ItemStack: ItemStack, par2World: World, par3EntityPlayer: EntityPlayer)

	/**
	false for all Items except sub-classes of ItemMapBase
	  */
	def isMap: Boolean

	/**
	returns the action that specifies what animation to play when the items is being used
	  */
	def getItemUseAction(par1ItemStack: ItemStack): EnumAction

	/**
	How long it takes to use or consume an item
	  */
	def getMaxItemUseDuration(par1ItemStack: ItemStack): Int

	/**
	called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	  */
	def onPlayerStoppedUsing(par1ItemStack: ItemStack, par2World: World, par3EntityPlayer: EntityPlayer, par4: Int)

	/**
	Sets the string representing this item's effect on a potion when used as an ingredient.
	  */
	def setPotionEffect(par1Str: String): Item

	/**
	Returns true if this item serves as a potion ingredient (its ingredient information is not null).
	  */
	def isPotionIngredient(p_150892_1_ : ItemStack): Boolean

	/**
	Returns a string representing what this item does to a potion.
	  */
	def getPotionEffect(p_150896_1_ : ItemStack): String

	/**
	allows items to add custom lines of information to the mouseover description
	  */
	@SideOnly(Side.CLIENT) def addInformation(par1ItemStack: ItemStack, par2EntityPlayer: EntityPlayer, par3List: List[ _ ], par4: Boolean)

	def getItemStackDisplayName(par1ItemStack: ItemStack): String

	/**
	Translates the unlocalized name of this item, but without the .name suffix, so the translation fails and the
	 unlocalized name itself is returned.
	  */
	def getUnlocalizedNameInefficiently(par1ItemStack: ItemStack): String

	/**
	Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
	 different names based on their damage or NBT.
	  */
	def getUnlocalizedName(par1ItemStack: ItemStack): String

	/**
	Return an item rarity from EnumRarity
	  */
	def getRarity(par1ItemStack: ItemStack): EnumRarity

	/**
	Checks isDamagable and if it cannot be stacked
	  */
	def isItemTool(par1ItemStack: ItemStack): Boolean

	/**
	Gets the maximum number of items that this stack should be able to hold.
	 This is a ItemStack (and thus NBT) sensitive version of Item.getItemStackLimit()

	 @param stack The ItemStack

	@return THe maximum number this item can be stacked to
	  */
	def getItemStackLimit(stack: ItemStack): Int

	/**
	Returns the maximum size of the stack for a specific item.
	  */
	@Deprecated def getItemStackLimit: Int

	/**
	Return the enchantability factor of the item, most of the time is based on material.
	  */
	def getItemEnchantability: Int

	/**
	returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	  */
	@SideOnly(Side.CLIENT) def getSubItems(p_150895_1_ : Item, p_150895_2_ : CreativeTabs, p_150895_3_ : List[ _ ])

	/**
	returns this;
	  */
	def setCreativeTab(par1CreativeTabs: CreativeTabs): Item

	/**
	Returns true if players can use this item to affect the world (e.g. placing blocks, placing ender eyes in portal)
	 when not in creative
	  */
	def canItemEditBlocks: Boolean

	/**
	Return whether this item is repairable in an anvil.
	  */
	def getIsRepairable(par1ItemStack: ItemStack, par2ItemStack: ItemStack): Boolean

	@SideOnly(Side.CLIENT) def registerIcons(par1IconRegister: IIconRegister)

	/**
	Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
	  */
	def getItemAttributeModifiers: Multimap[ _, _ ]

	def setTextureName(par1Str: String): Item

	/**
	Called when a player drops the item into the world,
	 returning false from this will prevent the item from
	 being removed from the players inventory and spawning
	 in the world

	 @param player The player that dropped the item
	@param item   The item stack, before the item is removed.
	  */
	def onDroppedByPlayer(item: ItemStack, player: EntityPlayer): Boolean

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
	def onItemUseFirst(stack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, hitX: Float, hitY: Float, hitZ: Float): Boolean

	/**
	Metadata-sensitive version of getStrVsBlock

	 @param itemstack The Item Stack
	@param block     The block the item is trying to break
	@param metadata  The items current metadata

	@return The damage strength
	  */
	def getDigSpeed(itemstack: ItemStack, block: Block, metadata: Int): Float

	def func_150893_a(p_150893_1_ : ItemStack, p_150893_2_ : Block): Float

	/**
	Called by CraftingManager to determine if an item is reparable.

	 @return True if reparable
	  */
	def isRepairable: Boolean

	def isDamageable: Boolean

	/**
	Call to disable repair recipes.

	 @return The current Item instance
	  */
	def setNoRepair(): Item

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
	def onBlockStartBreak(itemstack: ItemStack, X: Int, Y: Int, Z: Int, player: EntityPlayer): Boolean

	/* ======================================== FORGE START =====================================*/
	/**
	Called each tick while using an item.

	 @param stack  The Item being used
	@param player The Player using the item
	@param count  The amount of time in tick the item has been used for continuously
	  */
	def onUsingTick(stack: ItemStack, player: EntityPlayer, count: Int)

	/**
	Called when the player Left Clicks (attacks) an entity.
	 Processed before damage is done, if return value is true further processing is canceled
	 and the entity is not attacked.

	 @param stack  The Item being used
	@param player The player that is attacking
	@param entity The entity being attacked

	@return True to cancel the rest of the interaction.
	  */
	def onLeftClickEntity(stack: ItemStack, player: EntityPlayer, entity: Entity): Boolean

	/**
	Player, Render pass, and item usage sensitive version of getIconIndex.

	 @param stack        The item stack to get the icon for. (Usually this, and usingItem will be the same if usingItem is not null)
	@param renderPass   The pass to get the icon for, 0 is default.
	@param player       The player holding the item
	@param usingItem    The item the player is actively using. Can be null if not using anything.
	@param useRemaining The ticks remaining for the active item.

	@return The icon index
	  */
	def getIcon(stack: ItemStack, renderPass: Int, player: EntityPlayer, usingItem: ItemStack, useRemaining: Int): IIcon

	/**
	Return the correct icon for rendering based on the supplied ItemStack and render pass.

	 Defers to ;

	 @param stack to render for
	@param pass  the multi-render pass

	@return the icon
	  */
	def getIcon(stack: ItemStack, pass: Int): IIcon

	/**
	Gets an icon index based on an item's damage value and the given render pass
	  */
	@SideOnly(Side.CLIENT) def getIconFromDamageForRenderPass(par1: Int, par2: Int): IIcon

	/**
	Gets an icon index based on an item's damage value
	  */
	@SideOnly(Side.CLIENT) def getIconFromDamage(par1: Int): IIcon

	/**
	Returns the number of render passes/layers this item has.
	 Usually equates to ItemRenderer.renderItem being called for this many passes.
	 Does not get called unless requiresMultipleRenderPasses() is true;

	 @param metadata The item's metadata

	@return The number of passes to run.
	  */
	def getRenderPasses(metadata: Int): Int

	@SideOnly(Side.CLIENT) def requiresMultipleRenderPasses: Boolean

	/**
	ItemStack sensitive version of getContainerItem.
	 Returns a full ItemStack instance of the result.

	 @param itemStack The current ItemStack

	@return The resulting ItemStack
	  */
	def getContainerItem(itemStack: ItemStack): ItemStack

	def getContainerItem: Item

	/**
	ItemStack sensitive version of hasContainerItem

	 @param stack The current item stack

	@return True if this item has a 'container'
	  */
	def hasContainerItem(stack: ItemStack): Boolean

	/**
	True if this Item has a container item (a.k.a. crafting result)
	  */
	@Deprecated def hasContainerItem: Boolean

	/**
	Retrieves the normal 'lifespan' of this item when it is dropped on the ground as a EntityItem.
	 This is in ticks, standard result is 6000, or 5 mins.

	 @param itemStack The current ItemStack
	@param world     The world the entity is in

	@return The normal lifespan in ticks.
	  */
	def getEntityLifespan(itemStack: ItemStack, world: World): Int

	/**
	Determines if this Item has a special entity for when they are in the world.
	 Is called when a EntityItem is spawned in the world, if true and Item#createCustomEntity
	 returns non null, the EntityItem will be destroyed and the new Entity will be added to the world.

	 @param stack The current item stack

	@return True of the item has a custom entity, If true, Item#createCustomEntity will be called
	  */
	def hasCustomEntity(stack: ItemStack): Boolean

	/**
	This function should return a new entity to replace the dropped item.
	 Returning null here will not kill the EntityItem and will leave it to function normally.
	 Called when the item it placed in a world.

	 @param world     The world object
	@param location  The EntityItem object, useful for getting the position of the entity
	@param itemstack The current item stack

	@return A new Entity object to spawn or null
	  */
	def createEntity(world: World, location: Entity, itemstack: ItemStack): Entity

	/**
	Called by the default implemetation of EntityItem's onUpdate method, allowing for cleaner
	 control over the update of the item without having to write a subclass.

	 @param entityItem The entity Item

	@return Return true to skip any further update code.
	  */
	def onEntityItemUpdate(entityItem: EntityItem): Boolean

	/**
	Gets a list of tabs that items belonging to this class can display on,
	 combined properly with getSubItems allows for a single item to span
	 many sub-items across many tabs.

	 @return A list of all tabs that this item could possibly be one.
	  */
	def getCreativeTabs: Array[ CreativeTabs ]

	/**
	gets the CreativeTab this item is displayed on
	  */
	@SideOnly(Side.CLIENT) def getCreativeTab: CreativeTabs

	/**
	Determines the base experience for a player when they remove this item from a furnace slot.
	 This number must be between 0 and 1 for it to be valid.
	 This number will be multiplied by the stack size to get the total experience.

	 @param item The item stack the player is picking up.

	@return The amount to award for each item.
	  */
	def getSmeltingExperience(item: ItemStack): Float

	/**
	Generates the base Random item for a specific instance of the chest gen,
	 Enchanted books use this to pick a random enchantment.

	 @param chest    The chest category to generate for
	@param rnd      World RNG
	@param original Original result registered with the chest gen hooks.

	@return New values to use as the random item, typically this will be original
	  */
	def getChestGenBase(chest: ChestGenHooks, rnd: Random, original: WeightedRandomChestContent): WeightedRandomChestContent

	/**
	Should this item, when held, allow sneak-clicks to pass through to the underlying block?

	 @param world  The world
	@param x      The X Position
	@param y      The X Position
	@param z      The X Position
	@param player The Player that is wielding the item

	@return true if item allows to sneak-click to pass through underlying block
	  */
	def doesSneakBypassUse(world: World, x: Int, y: Int, z: Int, player: EntityPlayer): Boolean

	/**
	Called to tick armor in the armor slot. Override to do something

	 @param world     The current world
	@param player    The player wearing the armor
	@param itemStack Wearing itemstack
	  */
	def onArmorTick(world: World, player: EntityPlayer, itemStack: ItemStack)

	/**
	Determines if the specific ItemStack can be placed in the specified armor slot.

	 @param stack     The ItemStack
	@param armorType Armor slot ID: 0: Helmet, 1: Chest, 2: Legs, 3: Boots
	@param entity    The entity trying to equip the armor

	@return True if the given ItemStack can be inserted in the slot
	  */
	def isValidArmor(stack: ItemStack, armorType: Int, entity: Entity): Boolean

	/**
	Allow or forbid the specific book/item combination as an anvil enchant

	 @param stack The item
	@param book  The book

	@return if the enchantment is allowed
	  */
	def isBookEnchantable(stack: ItemStack, book: ItemStack): Boolean

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
	def getArmorTexture(stack: ItemStack, entity: Entity, slot: Int, `type`: String): String

	/**
	Returns the font renderer used to render tooltips and overlays for this item.
	 Returning null will use the standard font renderer.

	 @param stack The current item stack

	@return A instance of FontRenderer or null to use default
	  */
	@SideOnly(Side.CLIENT) def getFontRenderer(stack: ItemStack): FontRenderer

	/**
	Override this method to have an item handle its own armor rendering.

	 @param entityLiving The entity wearing the armor
	@param itemStack    The itemStack to render the model of
	@param armorSlot    0=head, 1=torso, 2=legs, 3=feet

	@return A ModelBiped to render instead of the default
	  */
	@SideOnly(Side.CLIENT) def getArmorModel(entityLiving: EntityLivingBase, itemStack: ItemStack, armorSlot: Int): ModelBiped

	/**
	Called when a entity tries to play the 'swing' animation.

	 @param entityLiving The entity swinging the item.
	@param stack        The Item stack

	@return True to cancel any further processing by EntityLiving
	  */
	def onEntitySwing(entityLiving: EntityLivingBase, stack: ItemStack): Boolean

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
	@SideOnly(Side.CLIENT) def renderHelmetOverlay(stack: ItemStack, player: EntityPlayer, resolution: ScaledResolution, partialTicks: Float, hasScreen: Boolean, mouseX: Int, mouseY: Int)

	/**
	Return the itemDamage represented by this ItemStack. Defaults to the itemDamage field on ItemStack, but can be overridden here for other sources such as NBT.

	 @param stack The itemstack that is damaged

	@return the damage value
	  */
	def getDamage(stack: ItemStack): Int

	/**
	Return the itemDamage display value represented by this itemstack.

	 @param stack the stack

	@return the damage value
	  */
	def getDisplayDamage(stack: ItemStack): Int

	/**
	Return the maxDamage for this ItemStack. Defaults to the maxDamage field in this item,
	 but can be overridden here for other sources such as NBT.

	 @param stack The itemstack that is damaged

	@return the damage value
	  */
	def getMaxDamage(stack: ItemStack): Int

	/**
	Returns the maximum damage an item can take.
	  */
	def getMaxDamage: Int

	/**
	Return if this itemstack is damaged. Note only called if ; is true.

	 @param stack the stack

	@return if the stack is damaged
	  */
	def isDamaged(stack: ItemStack): Boolean

	/**
	Set the damage for this itemstack. Note, this method is responsible for zero checking.

	 @param stack  the stack
	@param damage the new damage value
	  */
	def setDamage(stack: ItemStack, damage: Int)

	/**
	ItemStack sensitive version of ;

	 @param par1Block The block trying to harvest
	@param itemStack The itemstack used to harvest the block

	@return true if can harvest the block
	  */
	def canHarvestBlock(par1Block: Block, itemStack: ItemStack): Boolean

	def func_150897_b(p_150897_1_ : Block): Boolean

	/**
	Render Pass sensitive version of hasEffect()
	  */
	@SideOnly(Side.CLIENT) def hasEffect(par1ItemStack: ItemStack, pass: Int): Boolean

	@SideOnly(Side.CLIENT)
	@Deprecated def hasEffect(par1ItemStack: ItemStack): Boolean

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
	def setHarvestLevel(toolClass: String, level: Int)

	def getToolClasses(stack: ItemStack): Set[ String ]

	/**
	Queries the harvest level of this item stack for the specifred tool class,
	 Returns -1 if this tool is not of the specified type

	 @param stack     This item stack instance
	@param toolClass Tool Class

	@return Harvest level, or -1 if not the specified tool type.
	  */
	def getHarvestLevel(stack: ItemStack, toolClass: String): Int
}
