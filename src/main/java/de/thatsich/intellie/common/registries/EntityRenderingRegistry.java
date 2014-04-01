package de.thatsich.intellie.common.registries;

import de.thatsich.intellie.common.module.entity.IEntity;
import de.thatsich.intellie.common.util.logging.ILog;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author thatsIch
 * @since 24.03.2014.
 */
@Singleton
public class EntityRenderingRegistry implements IRegistry<IEntity> {
	private final Collection<IEntity> entities;
	private final ILog log;

	@Inject
	public EntityRenderingRegistry(ILog log) {
		this.log = log;
		this.entities = new HashSet<>(1);
	}

	@Override
	public void add(final IEntity entity) {
		this.entities.add(entity);
		this.log.debug("Added Entity %s", entity);
	}

	@Override
	public void register() {
		for (IEntity entity : this.entities) {
			//			EntityRegistry.reg
			this.log.debug("Registered %s", entity);
		}
		this.log.info("Registered all Entities");
	}
}
