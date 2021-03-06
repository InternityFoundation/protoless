package io.protoless.tag

import org.scalatest.FreeSpec
import shapeless.test.illTyped

class NumericTaggingSuite extends FreeSpec {

  "Numeric tagging must be allowed on" - {

    "Int" in {
      signed(1)
      unsigned(1)
      fixed(1)
      signedFixed(1)
    }

    "Long" in {
      signed(1L)
      unsigned(1L)
      fixed(1L)
      signedFixed(1L)
    }

    "no other numeric type" in {
      illTyped("""signed(1f)""")
      illTyped("""signed(1d)""")
      illTyped("""signed(1.toShort)""")
      illTyped("""signed(BigDecimal(1))""")
    }

    "no other exotic type" in {
      illTyped("""signed("1")""")
      illTyped("""signed(Seq(1, 2, 3))""")
      illTyped("""signed(true)""")
    }
  }
}
