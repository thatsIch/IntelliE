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
 * </p>
 */
package de.thatsich.intellie.applied.intelligences.functionality.router;