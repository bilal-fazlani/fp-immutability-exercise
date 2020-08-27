package com.example

import java.util.concurrent.Executors

import com.example.Util.delay

import scala.concurrent.{ExecutionContext, Future}

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
  ): Future[Tiramisu] = {
    implicit val executionService: ExecutionContext =
      ExecutionContext.fromExecutor(Executors.newWorkStealingPool(2))

    val beatCheeseF             = beat(cheese)
    val whippedCreamF           = whip(cream)
    val sugarDissolvedEspressoF = dissolve(sugar2, espresso)

    for {
      mixtureWithEggs        <- whisk(eggs)
      beatWithSugarAndWine   <- beat(mixtureWithEggs, sugar1, wine)
      whiskedMixture         <- whisk(beatWithSugarAndWine)
      beatCheese             <- beatCheeseF
      mixtureBeatWithCheese  <- beat(whiskedMixture, beatCheese)
      whippedCream           <- whippedCreamF
      mixtureFoldedWithCream <- fold(mixtureBeatWithCheese, whippedCream)
      sugarDissolvedEspresso <- sugarDissolvedEspressoF
      espressoSoakedFingers  <- soak2seconds(fingers, sugarDissolvedEspresso)
      assembledMixture       <- assemble(mixtureFoldedWithCream, espressoSoakedFingers)
      cocoaSiftedMixture     <- sift(assembledMixture, cocoa)
      tiramisu               <- refrigerate(cocoaSiftedMixture)
    } yield tiramisu
  }

  private def dissolve(
      sugar: Sugar,
      espresso: Espresso
  ): Future[SugarDissolvedEspresso] =
    delay {
      SugarDissolvedEspresso(espresso, sugar)
    }

  private def whisk(eggs: Eggs): Future[MixtureOfEggs] =
    delay {
      MixtureOfEggs(eggs)
    }

  private def whisk(mixture: MixtureBeatWithSugarAndWine): Future[WhiskedMixture] =
    delay {
      WhiskedMixture(mixture)
    }

  private def beat(
      mixture: MixtureOfEggs,
      sugar: Sugar,
      wine: Wine
  ): Future[MixtureBeatWithSugarAndWine] =
    delay {
      MixtureBeatWithSugarAndWine(mixture, sugar, wine)
    }

  private def whip(cream: Cream): Future[WhippedCream] =
    delay {
      WhippedCream(cream)
    }

  private def beat(cheese: Cheese): Future[BeatCheese] =
    delay {
      BeatCheese(cheese)
    }

  private def beat(
      mixture: WhiskedMixture,
      cheese: BeatCheese
  ): Future[MixtureBeatWithCheese] =
    delay {
      MixtureBeatWithCheese(mixture, cheese)
    }

  private def fold(
      mixture: MixtureBeatWithCheese,
      cream: WhippedCream
  ): Future[MixtureFoldedWithWhippedCream] =
    delay {
      MixtureFoldedWithWhippedCream(mixture, cream)
    }

  private def soak2seconds(
      fingers: Fingers,
      sugarDissolvedEspresso: SugarDissolvedEspresso
  ): Future[EspressoSoakedFingers] =
    delay {
      EspressoSoakedFingers(sugarDissolvedEspresso, fingers)
    }

  private def assemble(
      mixtureFoldedWithWhippedCream: MixtureFoldedWithWhippedCream,
      espressoSoakedFingers: EspressoSoakedFingers
  ): Future[AssembledMixture] =
    delay {
      AssembledMixture(mixtureFoldedWithWhippedCream, espressoSoakedFingers)
    }

  private def sift(
      assembledMixture: AssembledMixture,
      cocoa: Cocoa
  ): Future[CocoaSiftedMixture] =
    delay {
      CocoaSiftedMixture(assembledMixture, cocoa)
    }

  private def refrigerate(cocoaSiftedMixture: CocoaSiftedMixture): Future[Tiramisu] =
    delay {
      Tiramisu(cocoaSiftedMixture)
    }
}
