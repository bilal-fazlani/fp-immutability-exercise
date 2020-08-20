package com.example

import com.example.ingredients._

class Mixture(val eggs: Eggs) {
  var whisked: Boolean = false
  var beatWithSugarAndWine: Boolean = false
  var beatWithCheese: Boolean = false
  var foldedWithCream: Boolean = false
  var assembledWithFingers: Boolean = false
  var cocoaSifted: Boolean = false
  var refrigerated: Boolean = false

  var beatSugar: Option[Sugar] = None
  var beatWine: Option[Wine] = None
  var beatCheese: Option[Cheese] = None
  var foldedCream: Option[Cream] = None
  var assembledFingers: Option[Fingers] = None
  var siftedCocoa: Option[Cocoa] = None

  override def toString: String =
    s"""========== TIRAMISU ============
       |whisked: $whisked,
       |beatWithSugarAndWine: $beatWithSugarAndWine,
       |beatWithCheese: $beatWithCheese,
       |foldedWithCream: $foldedWithCream,
       |assembledWithFingers: $assembledWithFingers,
       |cocoaSifted: $cocoaSifted,
       |refrigerated: $refrigerated
       |
       |beatSugar:$beatSugar,
       |beatWine: $beatWine,
       |beatCheese: $beatCheese,
       |foldedCream: $foldedCream,
       |assembledFingers: $assembledFingers,
       |siftedCocoa: $siftedCocoa
       |=================================
       |""".stripMargin
}
