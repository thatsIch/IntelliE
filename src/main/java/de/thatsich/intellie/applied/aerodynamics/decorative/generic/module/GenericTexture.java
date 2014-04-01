package de.thatsich.intellie.applied.aerodynamics.decorative.generic.module;

import de.thatsich.intellie.common.module.ATexture;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author thatsIch
 * @since 01.04.2014.
 */
@Singleton
public class GenericTexture extends ATexture {

	@Inject
	GenericTexture() {
		super("generic");
	}
}
