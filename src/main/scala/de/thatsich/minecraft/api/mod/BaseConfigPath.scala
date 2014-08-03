package de.thatsich.minecraft.api.mod

import java.io.File

/**
 *
 *
 * @author thatsIch
 * @since 10.07.2014.
 */
abstract class BaseConfigPath( pathPart: String* ) extends BaseStringWrapper( pathPart.mkString( File.separator ) )
                                                           with ConfigPath
