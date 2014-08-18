package de.thatsich.minecraft.common.string.id


import org.scalatest.{FlatSpec, Matchers}


/**
 *
 *
 * @author thatsIch
 * @since 18.08.2014.
 */
class IDSpec extends FlatSpec with Matchers
{
	"An ID" should "translate to a String representation" in {
		val idName = "test"
		val id = new SimpleID(idName)
		val stringID: String = id

		stringID should be (idName)
	}
}
