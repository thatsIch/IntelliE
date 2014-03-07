package de.thatsich.common.registries;

import com.google.common.base.CaseFormat;

/**
 * @author thatsIch
 * @date 07.03.14.
 */
public enum EConfigs
{
	APPLIED_AERODYNAMICS,
	APPLIED_AGGROCULTURE,
	APPLIED_INTELLIGENCE;

	private static final char SEPARATOR = '_';

	@Override
	public String toString ()
	{
		final String name = this.name();

		return CaseFormat.UPPER_UNDERSCORE.to( CaseFormat.UPPER_CAMEL, name);
	}
}
