package de.thatsich.minecraft.core

/**
 *
 *
 * @author thatsIch
 * @since 22.06.2014.
 */
object EMods
{

	sealed trait Mod
	{
		def id: String

		def name: String

		def version: String

		def dependencies: String
	}

	case object AERO extends Mod
	{
		final val id = "appaero";
		final val name = "AppliedAerodynamics";
		final val version = "${version}";
		final val dependencies = "required-after:intellie"
	}

	case object IE extends Mod
	{
		final val id = "intellie";
		final val name = "IntelligentEnergistics";
		final val version = "${version}";
		final val dependencies = "required-after:Forge@[7.0,);required-after:FML@[5.0.5,);after:appliedenergistics2"
	}

	case object AE2 extends Mod
	{
		final val id = "appliedenergistics2";
		final val name = "";
		final val version = "";
		final val dependencies = ""
	}


}
