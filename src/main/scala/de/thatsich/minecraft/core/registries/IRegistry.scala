package de.thatsich.minecraft.core.registries


/**
 * simple registry
 *
 * @author thatsIch
 * @since 06.04.2014.
 */
trait IRegistry[ T ]
{
	/**
	Adds an element to the registry.
	It will get registered later on

	  * @param elem New element in the registry
	  */
	def add(elem: T)

	/**
	Registers that particular part
	  */
	def register()
}
