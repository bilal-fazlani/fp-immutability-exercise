package com.example

import munit.FunSuite

class CookingTest extends FunSuite {
  test("makeTiramisu should return Tiramisu") {
    val eggs = new Eggs
    val sugar1 = new Sugar
    val wine = new Wine
    val cheese = new Cheese
    val cream = new Cream
    val fingers = new Fingers
    val espresso = new Espresso
    val sugar2 = new Sugar
    val cocoa = new Cocoa

    val tiramisu = Cooking.makeTiramisu(
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

    assert(espresso.dissolvedSugar.contains(sugar2))
    assert(cream.whipped)
    assert(fingers.soakedWithEspresso)
    assert(fingers.espresso.contains(espresso))
    assert(cheese.beat)

    assert(tiramisu.assembledFingers.contains(fingers))
    assert(tiramisu.beatCheese.contains(cheese))
    assert(tiramisu.beatSugar.contains(sugar1))
    assert(tiramisu.beatWine.contains(wine))
    assert(tiramisu.foldedCream.contains(cream))
    assert(tiramisu.siftedCocoa.contains(cocoa))
  }
}
