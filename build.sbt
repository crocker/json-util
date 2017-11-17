lazy val versions = new {
  val scala = "2.11.11"
  val jackson = "2.9.1"
  val specs = "3.7.2"
}

name := "json-util"
organization := "com.logicstack.util"
version := "0.0.5"
scalaVersion := versions.scala



libraryDependencies ++= Seq(
  // json
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % versions.jackson,
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % versions.jackson,
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-cbor" % versions.jackson,

  //testing
  "org.specs2" %% "specs2-core" % versions.specs % "test"
)

// publish settings
val artifactory = "https://logicstack.jfrog.io/logicstack"

resolvers ++= Seq(
  Resolver.mavenLocal,
  Resolver.defaultLocal,
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"),
  "LogicStack Releases" at s"$artifactory/libs-release-local",
  "LogicStack Snapshots" at s"$artifactory/libs-snapshot-local"
)

publishTo := {
  if (isSnapshot.value) {
    Some("snapshots" at s"$artifactory/libs-snapshot-local")
  }
  else {
    Some("releases" at s"$artifactory/libs-release-local")
  }
}

credentials += Credentials("Artifactory Realm", "logicstack.jfrog.io", "admin", "AP4ChQULGXKGUk7QEoDNPWq9nUu")
