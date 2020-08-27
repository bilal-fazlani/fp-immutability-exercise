package com.example

object Cooking {
  def makeTiramisu(
      eggs: Eggs,
      sugar1: Sugar,
      wine: Wine,
      cheese: Cheese,
      cream: Cream,
      fingers: Fingers,
      espresso: Espresso,
      sugar2: Sugar,
      cocoa: Cocoa
  ): Mixture = {
    dissolve(sugar2, espresso)
    val mixture = whisk(eggs)
    beat(mixture, sugar1, wine)
    whisk(mixture)
    whip(cream)
    beat(cheese)
    beat(mixture, cheese)
    fold(mixture, cream)
    soak2seconds(fingers, espresso)
    assemble(mixture, fingers)
    sift(mixture, cocoa)
    refrigerate(mixture)
    mixture
  }

  private def dissolve(sugar: Sugar, espresso: Espresso): Unit =
    espresso.dissolvedSugar = Some(sugar)

  private def whisk(eggs: Eggs): Mixture = new Mixture(eggs)

  private def whisk(mixture: Mixture): Unit = mixture.whisked = true

  private def beat(mixture: Mixture, sugar1: Sugar, wine: Wine): Unit = {
    mixture.beatWithSugarAndWine = true
    mixture.beatSugar = Some(sugar1)
    mixture.beatWine = Some(wine)
  }

  private def whip(cream: Cream): Unit = cream.whipped = true

  private def beat(cheese: Cheese): Unit = cheese.beat = true

  private def beat(mixture: Mixture, cheese: Cheese): Unit = {
    mixture.beatWithCheese = true
    mixture.beatCheese = Some(cheese)
  }

  private def fold(mixture: Mixture, cream: Cream): Unit = {
    mixture.foldedWithCream = true
    mixture.foldedCream = Some(cream)
  }

  private def soak2seconds(fingers: Fingers, espresso: Espresso): Unit = {
    fingers.soakedWithEspresso = true
    fingers.espresso = Some(espresso)
  }

  private def assemble(mixture: Mixture, fingers: Fingers): Unit = {
    mixture.assembledWithFingers = true
    mixture.assembledFingers = Some(fingers)
  }

  private def sift(mixture: Mixture, cocoa: Cocoa): Unit = {
    mixture.cocoaSifted = true
    mixture.siftedCocoa = Some(cocoa)
  }

  private def refrigerate(mixture: Mixture): Unit =
    mixture.refrigerated = true
}
