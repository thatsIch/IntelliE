package de.thatsich.minecraft.intellie.applied.aerodynamics


/**
 * Entry Point of Aero API
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
object AppliedAerodynamicsAPI extends AeroAPI
{
	/**
	 * Access to the API object of Applied Aerodynamics
	 *
	 * @return the {@link AeroProxy}
	 */
	lazy val proxy: AeroProxy =
	{
		val clazz = Class.forName("de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics$")
		val modulefield = clazz.getField("MODULE$")
		val instance = modulefield.get(clazz).asInstanceOf[AeroAPI]

		instance.proxy
	}
}
