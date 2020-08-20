package com.example

import com.example.ingredients._

object Main extends App {
  val tiramisu = Cooking.makeTiramisu(
    new Eggs,
    new Sugar,
    new Wine,
    new Cheese,
    new Cream,
    new Fingers,
    new Espresso,
    new Sugar,
    new Cocoa
  )
  println(tiramisu)
}
