name := "fp-immutability-exercise"

version := "0.1.0"

scalaVersion := "2.13.3"

testFrameworks += new TestFramework("munit.Framework")

libraryDependencies ++= Seq(
  "org.scalameta" %% "munit" % "0.7.10"
)
