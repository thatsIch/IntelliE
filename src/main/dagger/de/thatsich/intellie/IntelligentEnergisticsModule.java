package de.thatsich.intellie;

import dagger.Module;
import de.thatsich.intellie.applied.aerodynamics.AppliedAerodynamicsModule;
import de.thatsich.intellie.applied.agricultures.AppliedAgriculturesModule;
import de.thatsich.intellie.applied.intelligences.AppliedIntelligencesModule;

/**
 Not getting used
 Its just there to make use of the compile time verification of Dagger

 @author thatsIch
 @date 24.03.2014. */
@Module(
	includes = {
		AppliedAerodynamicsModule.class, AppliedAgriculturesModule.class, AppliedIntelligencesModule.class
	},
	library = true)
public class IntelligentEnergisticsModule
{}
