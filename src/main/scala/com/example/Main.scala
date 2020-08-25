package com.example

import com.example.ingredients._

object Main extends App {
  val tiramisu = Cooking1.makeTiramisu(
    Eggs(),
    Sugar(),
    Wine(),
    Cheese(),
    Cream(),
    Fingers(),
    Espresso(),
    Sugar(),
    Cocoa()
  )
  println(tiramisu)
}
