package de.thatsich.intellie.common.registries;

import com.google.common.base.CaseFormat;

/**
 * All seperate configfiles with enum access
 *
 * @author thatsIch
 * @date 07.03.14.
 */
public enum EConfigs
{
	APPLIED_AERODYNAMICS,
	APPLIED_AGGROCULTURE,
	APPLIED_INTELLIGENCE;

	/**
	 * Converts the config names into a Java documented way.
	 * THAT_IS_AN_EXAMPLE will result into ThatIsAnExample.
	 * Will be used to convert this enum to normal config names.
	 *
	 * @return CamelCase enum name
	 */
	@Override
	public String toString ()
	{
		final String name = this.name();

		return CaseFormat.UPPER_UNDERSCORE.to( CaseFormat.UPPER_CAMEL, name );
	}
}
