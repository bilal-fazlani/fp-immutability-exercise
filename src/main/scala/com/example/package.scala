package com

package object example {
  class Cheese   {
    var beat: Boolean = false
  }
  class Cocoa
  class Cream    {
    var whipped: Boolean = false
  }
  class Eggs
  class Espresso {
    var dissolvedSugar: Option[Sugar] = None
  }
  class Fingers  {
    var soakedWithEspresso: Boolean = false
    var espresso: Option[Espresso]  = None
  }
  class Sugar
  class Wine

  class Mixture(val eggs: Eggs) {
    var whisked: Boolean              = false
    var beatWithSugarAndWine: Boolean = false
    var beatWithCheese: Boolean       = false
    var foldedWithCream: Boolean      = false
    var assembledWithFingers: Boolean = false
    var cocoaSifted: Boolean          = false
    var refrigerated: Boolean         = false

    var beatSugar: Option[Sugar]          = None
    var beatWine: Option[Wine]            = None
    var beatCheese: Option[Cheese]        = None
    var foldedCream: Option[Cream]        = None
    var assembledFingers: Option[Fingers] = None
    var siftedCocoa: Option[Cocoa]        = None
  }
}
