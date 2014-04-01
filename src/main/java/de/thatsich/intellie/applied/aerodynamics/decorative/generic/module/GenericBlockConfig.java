package de.thatsich.intellie.applied.aerodynamics.decorative.generic.module;

import de.thatsich.intellie.common.module.block.ABlockConfig;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author thatsIch
 * @since 01.04.2014.
 */
@Singleton
public class GenericBlockConfig extends ABlockConfig {

	@Inject
	GenericBlockConfig() {
		super("blub");
	}
}
