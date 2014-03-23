package de.thatsich.common.module.entity;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

/**
 * @author thatsIch
 * @date 22.03.2014.
 */
public abstract class AEntity extends Entity implements IEntity
{
	protected AEntity ( final World world )
	{
		super( world );
	}
}
