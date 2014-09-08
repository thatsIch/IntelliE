package de.thatsich.minecraft.common.string


import java.io.File

import de.thatsich.minecraft.intellie.common.util.string.ConfigPath


/**
 *
 *
 * @author thatsIch
 * @since 10.07.2014.
 */
abstract class BaseConfigPath(pathPart: String*) extends BaseStringWrapper(pathPart.mkString(File.separator))
                                                         with ConfigPath
