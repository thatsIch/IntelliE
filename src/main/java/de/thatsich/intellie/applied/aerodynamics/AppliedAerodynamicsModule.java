package de.thatsich.intellie.applied.aerodynamics;

import dagger.Module;
import de.thatsich.intellie.applied.aerodynamics.functionality.suite.chest.AeroChest;
import de.thatsich.intellie.common.module.IModule;
import de.thatsich.intellie.common.registries.RegistryModule;

/**
 * @author thatsIch
 * @date 20.03.2014.
 */
@Module(injects = AeroChest.class, includes = RegistryModule.class, library = true)
public class AppliedAerodynamicsModule implements IModule
{

}
