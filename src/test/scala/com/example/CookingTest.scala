package com.example

import munit.FunSuite

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt

class CookingTest extends FunSuite {
  override val munitTimeout = 19.seconds
  test("makeTiramisu should return Tiramisu") {
    val eggs     = Eggs()
    val sugar1   = Sugar()
    val wine     = Wine()
    val cheese   = Cheese()
    val cream    = Cream()
    val fingers  = Fingers()
    val espresso = Espresso()
    val sugar2   = Sugar()
    val cocoa    = Cocoa()

    val tiramisuF = Cooking.makeTiramisu(
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

    tiramisuF.map(t =>
      assertEquals(
        t,
        Tiramisu(
          CocoaSiftedMixture(
            AssembledMixture(
              MixtureFoldedWithWhippedCream(
                MixtureBeatWithCheese(
                  WhiskedMixture(
                    MixtureBeatWithSugarAndWine(
                      MixtureOfEggs(
                        Eggs()
                      ),
                      Sugar(),
                      Wine()
                    )
                  ),
                  BeatCheese(Cheese())
                ),
                WhippedCream(Cream())
              ),
              EspressoSoakedFingers(
                SugarDissolvedEspresso(Espresso(), Sugar()),
                Fingers()
              )
            ),
            Cocoa()
          )
        )
      )
    )
  }
}
