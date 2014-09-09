package de.thatsich.minecraft.intellie.applied.aerodynamics


import scala.reflect.runtime.universe


/**
 * Entry Point of Aero API
 *
 * @author thatsIch
 * @since 07.09.2014.
 */
object AppliedAerodynamicsAPI
{
	private var api: AeroAPI = null

	/**
		 * Access to the API object of Applied Aerodynamics
		 *
		 * @return the {@link AeroAPI}
		 */
	def instance: AeroAPI =
	{
		if (this.api == null)
		{
			val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)
			val module = runtimeMirror.staticModule("de.thatsich.minecraft.intellie.applied.aerodynamics.AppliedAerodynamics")
			val obj = runtimeMirror.reflectModule(module)
			val instance = obj.instance

			this.api = instance.asInstanceOf[AeroAPI]
		}

		this.api
	}
}
