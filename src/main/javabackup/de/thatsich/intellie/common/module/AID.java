package de.thatsich.intellie.common.module;

/**
 @author thatsIch
 @since 02.04.2014. */
public abstract class AID
{
	private final String id;

	protected AID()
	{
		this.id = this.getClass().getSimpleName().toLowerCase();
	}

	@Override
	public String toString()
	{
		return this.id;
	}
}
