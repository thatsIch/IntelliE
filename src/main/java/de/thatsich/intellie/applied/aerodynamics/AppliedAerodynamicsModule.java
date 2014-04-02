package de.thatsich.intellie.applied.aerodynamics;

import dagger.Module;
import de.thatsich.intellie.applied.aerodynamics.common.AppliedAerodynamicsCreativeTabModule;
import de.thatsich.intellie.applied.aerodynamics.decorative.AppliedAerodynamicsDecorativeModule;
import de.thatsich.intellie.applied.aerodynamics.functionality.AppliedAerodynamicsFunctionalityModule;
import de.thatsich.intellie.common.module.IModule;
import de.thatsich.intellie.common.registries.RegistryModule;

/**
 @author thatsIch
 @since 20.03.2014. */
@Module(
		library = true,
		complete = false,
		includes = {
				AppliedAerodynamicsCreativeTabModule.class, AppliedAerodynamicsDecorativeModule.class, AppliedAerodynamicsFunctionalityModule.class, RegistryModule.class
		})
public class AppliedAerodynamicsModule implements IModule
{
}
