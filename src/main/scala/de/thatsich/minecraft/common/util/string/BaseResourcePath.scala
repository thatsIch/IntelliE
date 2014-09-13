package de.thatsich.minecraft.common.util.string


import de.thatsich.minecraft.common.util.string.ResourcePath


/**
 *
 *
 * @author thatsIch
 * @since 03.08.2014.
 */
class BaseResourcePath(pathPart: String*) extends BaseStringWrapper(pathPart.mkString("/", "/", ""))
                                                  with ResourcePath