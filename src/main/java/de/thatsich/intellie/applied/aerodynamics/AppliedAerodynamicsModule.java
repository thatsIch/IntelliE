package de.thatsich.intellie.applied.aerodynamics;

import dagger.Module;
import de.thatsich.common.module.IModule;
import de.thatsich.common.registries.RegistryModule;
import de.thatsich.intellie.applied.aerodynamics.functionality.suite.chest.AeroChest;

/**
 * @author thatsIch
 * @date 20.03.2014.
 */
@Module(injects = AeroChest.class, includes = RegistryModule.class, library = true)
public class AppliedAerodynamicsModule implements IModule
{

}
