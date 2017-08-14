name := "json-util"

organization := "com.logicstack.util"

version := "0.0.4-SNAPSHOT"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  // json
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.4",
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.8.4",
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-cbor" % "2.8.4",

  //testing
  "org.specs2" %% "specs2-core" % "3.7.2" % "test"
)