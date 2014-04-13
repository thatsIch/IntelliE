package de.thatsich.minecraft.core.module

/**
 * all module collections need to be able to
 * add and get a module
 *
 * @author thatsIch
 * @since 13.04.2014.
 */
trait IModules
{
	/**
	 * adds a new module
	 *
	 * @param module new Module
	 */
	protected def add(module: AModule)

	/**
	 * gets the stored module via class of the module
	 *
	 * @param moduleClass class of the module
	 */
	protected def get(moduleClass: Class[ _ <: AModule ]): Option[ AModule ]
}
