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
    val sugarDissolvedEspresso = dissolve(sugar2, espresso)
    val mixtureWithEggs        = whisk(eggs)
    val beatWithSugarAndWine   = beat(mixtureWithEggs, sugar1, wine)
    val whiskedMixture         = whisk(beatWithSugarAndWine)
    val whippedCream           = whip(cream)
    val beatCheese             = beat(cheese)
    val mixtureBeatWithCheese  = beat(whiskedMixture, beatCheese)
    val mixtureFoldedWithCream = fold(mixtureBeatWithCheese, whippedCream)
    val espressoSoakedFingers  = soak2seconds(fingers, sugarDissolvedEspresso)
    val assembledMixture       =
      assemble(mixtureFoldedWithCream, espressoSoakedFingers)
    val cocoaSiftedMixture     = sift(assembledMixture, cocoa)
    val refrigeratedMixture    = refrigerate(cocoaSiftedMixture)
    refrigeratedMixture
  }

  private def dissolve(sugar: Sugar, espresso: Espresso): Espresso =
    espresso.copy(dissolvedSugar = Some(sugar))

  private def whisk(eggs: Eggs): Mixture = Mixture(eggs)

  private def whisk(mixture: Mixture): Mixture = mixture.copy(whisked = true)

  private def beat(mixture: Mixture, sugar1: Sugar, wine: Wine): Mixture =
    mixture.copy(beatWithSugarAndWine = true, beatSugar = Some(sugar1), beatWine = Some(wine))

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
