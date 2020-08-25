package com.example

import com.example.ingredients._
import munit.FunSuite
import scala.concurrent.ExecutionContext.Implicits.global

class Cooking3Test extends FunSuite {
  test("makeTiramisu should return Tiramisu") {
    val eggs = Eggs()
    val sugar1 = Sugar()
    val wine = Wine()
    val cheese = Cheese()
    val cream = Cream()
    val fingers = Fingers()
    val espresso = Espresso()
    val sugar2 = Sugar()
    val cocoa = Cocoa()

    val tiramisuF = Cooking3.makeTiramisu(
      eggs,
      sugar1,
      wine,
      cheese,
      cream,
      fingers,
      espresso,
      sugar2,
      cocoa
    )

    tiramisuF.map { tiramisu =>
      assertEquals(tiramisu.beatWithCheese, true)
      assertEquals(tiramisu.assembledWithFingers, true)
      assertEquals(tiramisu.beatWithSugarAndWine, true)
      assertEquals(tiramisu.cocoaSifted, true)
      assertEquals(tiramisu.foldedWithCream, true)
      assertEquals(tiramisu.whisked, true)
      assertEquals(tiramisu.refrigerated, true)

      assert(
        tiramisu.assembledFingers.contains(
          Fingers(soakedWithEspresso = true, Some(espresso))))

      assert(tiramisu.beatCheese.contains(Cheese(beat = true)))

      assert(tiramisu.beatSugar.contains(Sugar()))

      assert(tiramisu.beatWine.contains(Wine()))

      assert(tiramisu.foldedCream.contains(Cream(whipped = true)))

      assert(tiramisu.siftedCocoa.contains(Cocoa()))
    }
  }
}
