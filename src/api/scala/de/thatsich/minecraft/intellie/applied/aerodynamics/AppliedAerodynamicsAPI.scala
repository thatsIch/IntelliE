package de.thatsich.minecraft.intellie.applied.aerodynamics


/**
 * Entry Point of Aero API
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
object AppliedAerodynamicsAPI extends AeroAPI
{
	private var instance: AeroProxy = null

	/**
		 * Access to the API object of Applied Aerodynamics
		 *
		 * @return the {@link AeroAPI}
		 */
	def proxy: AeroProxy =
	{
		if (this.instance == null)
		{
			val clazz = Class.forName("de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics$")
			val modulefield = clazz.getField("MODULE$")
			val instance = modulefield.get(clazz).asInstanceOf[AeroAPI]

			this.instance = instance.proxy
		}

		this.instance
	}
}
