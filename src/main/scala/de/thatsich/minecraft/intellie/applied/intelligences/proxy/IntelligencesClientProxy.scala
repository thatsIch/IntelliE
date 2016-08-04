package de.thatsich.minecraft.intellie.applied.intelligences.proxy

import cpw.mods.fml.common.event.FMLPreInitializationEvent
import de.thatsich.minecraft.intellie.applied.intelligences.IntelligencesCommonProxy

/**
  * Created by thatsIch on 04.08.2016.
  */
class IntelligencesClientProxy extends IntelligencesCommonProxy {

	override def onInheritatedPreInit(event: FMLPreInitializationEvent): Unit = {
		this.initRenderers()
		this.initSounds()

		super.onInheritatedPreInit(event)
	}

	private def initSounds(): Unit = {
	}

	private def initRenderers(): Unit = {
	}
}
