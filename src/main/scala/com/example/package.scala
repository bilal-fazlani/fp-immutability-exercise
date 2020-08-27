package com

package object example {
  case class Cheese()
  case class Cocoa()
  case class Cream()
  case class Eggs()
  case class Espresso()
  case class Fingers()
  case class Sugar()
  case class Wine()

  case class MixtureOfEggs(eggs: Eggs)
  case class MixtureBeatWithSugarAndWine(mixture: MixtureOfEggs, sugar: Sugar, wine: Wine)
  case class WhiskedMixture(mixture: MixtureBeatWithSugarAndWine)
  case class BeatCheese(cheese: Cheese)
  case class MixtureBeatWithCheese(whiskedMixture: WhiskedMixture, beatCheese: BeatCheese)
  case class WhippedCream(cream: Cream)
  case class MixtureFoldedWithWhippedCream(
      mixtureBeatWithCheese: MixtureBeatWithCheese,
      whippedCream: WhippedCream
  )
  case class SugarDissolvedEspresso(espresso: Espresso, sugar: Sugar)
  case class AssembledMixture(
      mixtureFoldedWithWhippedCream: MixtureFoldedWithWhippedCream,
      espressoSoakedFingers: EspressoSoakedFingers
  )
  case class EspressoSoakedFingers(sugarDissolvedEspresso: SugarDissolvedEspresso, fingers: Fingers)
  case class CocoaSiftedMixture(assembledMixture: AssembledMixture, cocoa: Cocoa)
  case class Tiramisu(cocoaSiftedMixture: CocoaSiftedMixture)
}
