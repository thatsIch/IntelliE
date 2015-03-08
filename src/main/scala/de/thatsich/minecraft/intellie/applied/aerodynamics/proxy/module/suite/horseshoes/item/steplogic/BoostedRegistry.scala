package de.thatsich.minecraft.intellie.applied.aerodynamics.proxy.module.suite.horseshoes.item.steplogic

import net.minecraft.entity.player.EntityPlayer

/**
 * Contains all boosted players in the current game.
 * Is not persistent
 */
class BoostedRegistry
{
	private val boostedPlayers = collection.mutable.Set[EntityPlayer]()

	/**
	 * Adds a boosted player. Does not matter if he was already boosted
	 *
	 * @param player boosted player
	 */
	def add(player: EntityPlayer): Unit = this.boostedPlayers += player

	/**
	 * Removes a boosted player.
	 *
	 * @param player to be unboosted player
	 */
	def remove(player: EntityPlayer): Unit = this.boostedPlayers -= player

	/**
	 * Checks if a player is already boosted
	 *
	 * @param player to be checked player
	 *
	 * @return true if the player is already boosted
	 */
	def contains(player: EntityPlayer): Boolean = this.boostedPlayers.contains(player)
}
