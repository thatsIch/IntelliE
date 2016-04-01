package de.thatsich.minecraft.common.util.string.id


import org.junit.runner.RunWith

import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

/**
 *
 *
 * @author thatsIch
 * @since 18.08.2014.
 */
@RunWith(classOf[JUnitRunner])
class IDSpec extends FlatSpec with Matchers
{
	"An ID" should "translate to a String representation" in {
		val idName = "test"
		val id = new SimpleID(idName)
		val stringID: String = id

		stringID should be (idName)
	}
}
