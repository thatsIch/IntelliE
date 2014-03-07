package de.thatsich.common.registries;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
		Assert.assertEquals( "Objects should be equal", "AppliedAerodynamics", actual );
	}
}
