package com

package object example {
  case class Cheese(beat: Boolean = false)
  case class Cocoa()
  case class Cream(whipped: Boolean = false)
  case class Eggs()
  case class Espresso(dissolvedSugar: Option[Sugar] = None)
  case class Fingers(soakedWithEspresso: Boolean = false, espresso: Option[Espresso] = None)
  case class Sugar()
  case class Wine()

  case class Mixture(
      eggs: Eggs,
      whisked: Boolean = false,
      beatWithSugarAndWine: Boolean = false,
      beatWithCheese: Boolean = false,
      foldedWithCream: Boolean = false,
      assembledWithFingers: Boolean = false,
      cocoaSifted: Boolean = false,
      refrigerated: Boolean = false,
      beatSugar: Option[Sugar] = None,
      beatWine: Option[Wine] = None,
      beatCheese: Option[Cheese] = None,
      foldedCream: Option[Cream] = None,
      assembledFingers: Option[Fingers] = None,
      siftedCocoa: Option[Cocoa] = None
  )
}
