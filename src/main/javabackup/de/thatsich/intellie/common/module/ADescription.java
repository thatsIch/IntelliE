package de.thatsich.intellie.common.module;

/**
 Simple description displayed be

 @author thatsIch
 @since 02.04.2014. */
public class ADescription implements IDescription
{
	private final String desc;

	protected ADescription( final String desc ) { this.desc = desc; }

	public String getDesc() { return this.desc; }
}
