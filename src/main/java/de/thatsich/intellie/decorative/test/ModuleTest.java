package de.thatsich.intellie.decorative.test;

import dagger.Module;
import dagger.Provides;
import de.thatsich.intellie.decorative.test.module.BlockTest;
import de.thatsich.intellie.decorative.test.module.block.BlockConfigTest;
import de.thatsich.intellie.decorative.test.module.block.BlockInfoTest;
import de.thatsich.intellie.decorative.test.module.block.BlockNameTest;
import de.thatsich.intellie.decorative.test.module.block.BlockTextureTest;

import javax.inject.Singleton;

/**
 * @author thatsIch
 * @date 06.03.14.
 */
@Module(
	injects = {
		Test.class, BlockTest.class, BlockConfigTest.class, BlockInfoTest.class, BlockNameTest.class, BlockTextureTest.class
	}
)
public class ModuleTest
{
	@Provides
	@Singleton
	public Test provideTest ( final Test object )
	{
		return object;
	}
}
