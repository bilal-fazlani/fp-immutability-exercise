package com.example

import com.example.ingredients._
import munit.FunSuite

class Cooking1Test extends FunSuite {
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

    val tiramisu = Cooking1.makeTiramisu(
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

    assertEquals(tiramisu.beatWithCheese, true)
    assertEquals(tiramisu.assembledWithFingers, true)
    assertEquals(tiramisu.beatWithSugarAndWine, true)
    assertEquals(tiramisu.cocoaSifted, true)
    assertEquals(tiramisu.foldedWithCream, true)
    assertEquals(tiramisu.whisked, true)
    assertEquals(tiramisu.refrigerated, true)

    assert(tiramisu.assembledFingers.contains(fingers))
    assert(tiramisu.beatCheese.contains(cheese))
    assert(tiramisu.beatSugar.contains(sugar1))
    assert(tiramisu.beatWine.contains(wine))
    assert(tiramisu.foldedCream.contains(cream))
    assert(tiramisu.siftedCocoa.contains(cocoa))
  }
}
