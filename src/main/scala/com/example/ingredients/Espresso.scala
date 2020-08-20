package com.example.ingredients

class Espresso {
  var dissolvedSugar: Option[Sugar] = None
  override def toString: String = s"Espresso(dissolvedSugar: $dissolvedSugar)"
}
