package com.example

import com.example.ingredients._

case class Mixture(eggs: Eggs,
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
                   siftedCocoa: Option[Cocoa] = None)
