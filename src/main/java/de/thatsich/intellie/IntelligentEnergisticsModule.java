package de.thatsich.intellie;

import dagger.Module;
import de.thatsich.intellie.applied.aerodynamics.AppliedAerodynamicsModule;

/**
 Not getting used
 Its just there to make use of the compile time verification of Dagger

 @author thatsIch
 @date 24.03.2014. */
@Module(
	includes = AppliedAerodynamicsModule.class)
public class IntelligentEnergisticsModule
{}
