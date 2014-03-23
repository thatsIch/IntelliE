package de.thatsich.intellie.common.module.block.info;

import java.util.Locale;
import java.util.regex.Pattern;

public abstract class ABlockName implements IBlockName
{
	private static final Pattern COMPILE = Pattern.compile( "\\s+" );

	private final String name;
	private final String unlocalizedName;

	protected ABlockName ( String name )
	{
		// process information
		final Locale locale = Locale.getDefault();

		// unlocalized name is first letter small and no space
		this.name = name;
		this.unlocalizedName = ABlockName.COMPILE.matcher( name ).replaceAll( "" ).toUpperCase( locale );
	}

	@Override
	public String getUnlocalizedName () { return this.unlocalizedName; }

	@Override
	public String getName () { return this.name; }
}
