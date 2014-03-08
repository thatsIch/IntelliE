package de.thatsich.common.registries;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * @author thatsIch
 * @date 07.03.14.
 */
@RunWith(JUnit4.class)
public class EConfigsTest
{
	@Test
	public void toStringShouldCamelCase ()
	{
		final String actual = EConfigs.APPLIED_AERODYNAMICS.toString();
		assertEquals( "Objects should be equal", "AppliedAerodynamics", actual );
	}
}
