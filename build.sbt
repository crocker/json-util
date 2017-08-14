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
