package de.thatsich.minecraft.intellie.applied.intelligences

import de.thatsich.minecraft.intellie.applied.aerodynamics.{AeroAPI, AeroProxy}


/**
  * Created by thatsIch on 04.08.2016.
  */
object AppliedIntelligencesAPI extends IntelligencesAPI{
	/**
	  * Access to the API object of Applied Aerodynamics
	  *
	  * @return the [[IntelligencesProxy]]
	  */
	lazy val proxy: IntelligencesProxy =
	{
		val clazz = Class.forName("de.thatsich.minecraft.intellie.applied.intelligences.AppliedIntelligences$")
		val modulefield = clazz.getField("MODULE$")
		val instance = modulefield.get(clazz).asInstanceOf[IntelligencesAPI]

		instance.proxy
	}
}
