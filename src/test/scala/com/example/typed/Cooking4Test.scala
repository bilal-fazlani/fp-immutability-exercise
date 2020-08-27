package com.example.typed

import munit.FunSuite

import scala.concurrent.ExecutionContext.Implicits.global

class Cooking4Test extends FunSuite {
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

    val tiramisuF = Cooking4.makeTiramisu(
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

    tiramisuF.map(
      t =>
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
      ))
  }
}
