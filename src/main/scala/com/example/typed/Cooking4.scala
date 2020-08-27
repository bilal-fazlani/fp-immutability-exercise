package com.example.typed

import java.util.concurrent.Executors

import scala.concurrent.{ExecutionContext, Future}

case class Cheese()
case class Cocoa()
case class Cream()
case class Eggs()
case class Espresso()
case class Fingers()
case class Sugar()
case class Wine()

case class MixtureOfEggs(eggs: Eggs)
case class MixtureBeatWithSugarAndWine(mixture: MixtureOfEggs,
                                       sugar: Sugar,
                                       wine: Wine)
case class WhiskedMixture(mixture: MixtureBeatWithSugarAndWine)
case class BeatCheese(cheese: Cheese)
case class MixtureBeatWithCheese(whiskedMixture: WhiskedMixture,
                                 beatCheese: BeatCheese)
case class WhippedCream(cream: Cream)
case class MixtureFoldedWithWhippedCream(
    mixtureBeatWithCheese: MixtureBeatWithCheese,
    whippedCream: WhippedCream)
case class SugarDissolvedEspresso(espresso: Espresso, sugar: Sugar)
case class AssembledMixture(
    mixtureFoldedWithWhippedCream: MixtureFoldedWithWhippedCream,
    espressoSoakedFingers: EspressoSoakedFingers)
case class EspressoSoakedFingers(sugarDissolvedEspresso: SugarDissolvedEspresso,
                                 fingers: Fingers)
case class CocoaSiftedMixture(assembledMixture: AssembledMixture, cocoa: Cocoa)
case class Tiramisu(cocoaSiftedMixture: CocoaSiftedMixture)

object Cooking4 {
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
  ): Future[Tiramisu] = {
    implicit val executionService: ExecutionContext =
      ExecutionContext.fromExecutor(Executors.newWorkStealingPool(2))

    val mixtureFoldedWithCreamF = Future {
      val mixtureWithEggs = whisk(eggs)
      val beatWithSugarAndWine = beat(mixtureWithEggs, sugar1, wine)
      val whiskedMixture = whisk(beatWithSugarAndWine)
      val beatCheese = beat(cheese)
      val mixtureBeatWithCheese = beat(whiskedMixture, beatCheese)
      val whippedCream = whip(cream)
      fold(mixtureBeatWithCheese, whippedCream)
    }

    val espressoSoakedFingersF = Future {
      val sugarDissolvedEspresso = dissolve(sugar2, espresso)
      soak2seconds(fingers, sugarDissolvedEspresso)
    }

    for {
      mixtureFoldedWithCream <- mixtureFoldedWithCreamF
      espressoSoakedFingers <- espressoSoakedFingersF
      assembledMixture = assemble(mixtureFoldedWithCream, espressoSoakedFingers)
      cocoaSiftedMixture = sift(assembledMixture, cocoa)
      refrigeratedMixture = refrigerate(cocoaSiftedMixture)
    } yield refrigeratedMixture
  }

  private def dissolve(sugar: Sugar,
                       espresso: Espresso): SugarDissolvedEspresso = {
    SugarDissolvedEspresso(espresso, sugar)
  }

  private def whisk(eggs: Eggs): MixtureOfEggs = MixtureOfEggs(eggs)

  private def whisk(mixture: MixtureBeatWithSugarAndWine): WhiskedMixture =
    WhiskedMixture(mixture)

  private def beat(mixture: MixtureOfEggs,
                   sugar: Sugar,
                   wine: Wine): MixtureBeatWithSugarAndWine =
    MixtureBeatWithSugarAndWine(mixture, sugar, wine)

  private def whip(cream: Cream): WhippedCream = WhippedCream(cream)

  private def beat(cheese: Cheese): BeatCheese = BeatCheese(cheese)

  private def beat(mixture: WhiskedMixture,
                   cheese: BeatCheese): MixtureBeatWithCheese =
    MixtureBeatWithCheese(mixture, cheese)

  private def fold(mixture: MixtureBeatWithCheese,
                   cream: WhippedCream): MixtureFoldedWithWhippedCream =
    MixtureFoldedWithWhippedCream(mixture, cream)

  private def soak2seconds(
      fingers: Fingers,
      sugarDissolvedEspresso: SugarDissolvedEspresso): EspressoSoakedFingers = {
    EspressoSoakedFingers(sugarDissolvedEspresso, fingers)
  }

  private def assemble(
      mixtureFoldedWithWhippedCream: MixtureFoldedWithWhippedCream,
      espressoSoakedFingers: EspressoSoakedFingers) = {
    AssembledMixture(mixtureFoldedWithWhippedCream, espressoSoakedFingers)
  }

  private def sift(assembledMixture: AssembledMixture,
                   cocoa: Cocoa): CocoaSiftedMixture =
    CocoaSiftedMixture(assembledMixture, cocoa)

  private def refrigerate(cocoaSiftedMixture: CocoaSiftedMixture): Tiramisu =
    Tiramisu(cocoaSiftedMixture)
}
