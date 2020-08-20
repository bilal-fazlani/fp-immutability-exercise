package com.example.ingredients

class Fingers {
  var soakedWithEspresso: Boolean = false
  var espresso: Option[Espresso] = None
  override def toString: String =
    s"Fingers(soakedWithEspresso: $soakedWithEspresso,espresso: $espresso)"
}
