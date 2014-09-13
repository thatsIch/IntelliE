package de.thatsich.minecraft.common.util.string


/**
 *
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
class BaseResourcePath(pathPart: String*) extends BaseStringWrapper(pathPart.mkString("/", "/", ""))
                                                  with ResourcePath