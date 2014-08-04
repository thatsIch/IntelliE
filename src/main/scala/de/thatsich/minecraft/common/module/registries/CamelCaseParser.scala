package de.thatsich.minecraft.common.module.registries

/**
 *
 *
 * @author thatsIch
 * @since 04.08.2014.
 */
trait CamelCaseParser
{
	/**
	 * Splits the incoming camel case string and removes the lasst upper case part
	 * @param string camel case string
	 * @return incoming without last camel case
	 */
	def parseCamelCase( string: String ): String =
	{
		val split: Array[ String ] = string.split( "(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])" )
		val newSplit = split.dropRight( 1 )

		newSplit.mkString( "_" ).toLowerCase
	}
}
