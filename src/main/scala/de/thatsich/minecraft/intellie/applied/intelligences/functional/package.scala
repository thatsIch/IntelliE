package de.thatsich.minecraft.intellie.applied.intelligences


/**
 * bore constructed with pipes
 * and need water to flood up the blocks
 *
 * @author thatsIch
 * @since 16.03.14.
 */
package object bore
{}

/**
 * Builder Block
 * hook up pattern via Spatial Pylon
 * provide it with network
 *
 * @author thatsIch
 * @since 16.03.14.
 */
package object builder

/**
 * sees incoming mats and outcoming, can reset
 *
 * @author thatsIch
 * @since 30.03.2014.
 */
package object diff

/**
 * vllt mit inventory muster sodass man verschiedene Blöcke machen kann
 * zB Stone, Dirt, Dirt, Stone
 * vllt neue Feld öffnet sich, wenn man in erstes Feld einträgt
 *
 * @author thatsIch
 * @since 30.03.2014.
 */
package object drawbridge

/**
 * Wand of Equal Trade nur mit System
 * requires INetworkEncodable für tools mit Zugang zum Netzwerk
 *
 * @author thatsIch
 * @since 16.03.14.
 */
package object exchanger

/**
 * Filler Block
 * use OpenBlocks pattern to see outcome
 * different choices to build
 * kannst bestimmten Block aus Netzwerk auswählen und baut dann alle ab die einem anderen bestehen den der berührt
 * Sand > Wasser
 *
 * @author thatsIch
 * @since 16.03.14.
 */
package object filler

/**
 * ME Interface like auto refill
 * 3 seeds + 1 water bottle converts dirt into gras
 *
 * @author thatsIch
 * @since 30.03.2014.
 */
package object grassifier

package object implosionsingularity

/**
 * Intersection Block > Network Block but can define 3 channels with liquid, redstone, power, item
 *
 * @author thatsIch
 * @since 16.03.14.
 */
package object intersection

/**
 * tool to lay down wire smartly without need to place them manually, just need startpoint, endpoint and then apply
 *
 * maybe TE duper, uses a "fresh" one up though
 *
 * @author thatsIch
 * @since 16.03.14.
 */
package object laywire

/**
 * Tries to dissembler preconfigured stuff into 3x3 or 2x2 pattern
 *
 * @author thatsIch
 * @since 30.03.2014.
 */
package object packager

/**
 * Provides Classes and Interfaces necessary to create a Router.
 * <p>
 * The Router involves:
 * - ItemBlock
 * - Block
 * - TileEntity
 *
 * You can use the Router to imprint a specific Inventory or Block.
 * This will act as a Proxy-Dummy which needs to reside near it.
 * Using Upgrades you can enhance the max Distance. The block itself
 * is not part of the ME Network and thus needs to be provided by
 * AE itself or other automation but it can use ME Interfaces to simplify
 * the interaction.
 *
 * It provides a Fuzzy Mode, which lets you chain all of the same inventory
 * touching the imprinted inventory.
 *
 * name: connected distribution
 * </p>
 */
package object router