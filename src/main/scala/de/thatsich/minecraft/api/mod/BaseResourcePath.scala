package de.thatsich.minecraft.api.mod

/**
 *
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
class BaseResourcePath( pathPart: String* ) extends BaseStringWrapper( pathPart.mkString( "/", "/", "" ) )
                                                    with ResourcePath