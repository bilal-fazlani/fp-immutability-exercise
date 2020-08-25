package com.example

import com.example.ingredients._

object Cooking1 {
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

  private def dissolve(sugar: Sugar, espresso: Espresso): Espresso =
    espresso.copy(dissolvedSugar = Some(sugar))

  private def whisk(eggs: Eggs): Mixture = Mixture(eggs)

  private def whisk(mixture: Mixture): Mixture = mixture.copy(whisked = true)

  private def beat(mixture: Mixture, sugar1: Sugar, wine: Wine): Mixture =
    mixture.copy(beatWithSugarAndWine = true,
                 beatSugar = Some(sugar1),
                 beatWine = Some(wine))

  private def whip(cream: Cream): Cream = cream.copy(whipped = true)

  private def beat(cheese: Cheese): Cheese = cheese.copy(beat = true)

  private def beat(mixture: Mixture, cheese: Cheese): Mixture =
    mixture.copy(beatCheese = Some(cheese), beatWithCheese = true)

  private def fold(mixture: Mixture, cream: Cream): Mixture =
    mixture.copy(foldedWithCream = true, foldedCream = Some(cream))

  private def soak2seconds(fingers: Fingers, espresso: Espresso): Fingers =
    fingers.copy(soakedWithEspresso = true, espresso = Some(espresso))

  private def assemble(mixture: Mixture, fingers: Fingers): Mixture =
    mixture.copy(assembledWithFingers = true, assembledFingers = Some(fingers))

  private def sift(mixture: Mixture, cocoa: Cocoa): Mixture =
    mixture.copy(cocoaSifted = true, siftedCocoa = Some(cocoa))

  private def refrigerate(mixture: Mixture): Mixture =
    mixture.copy(refrigerated = true)
}
