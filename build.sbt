lazy val versions = new {
  val scala = "2.11.11"
  val jackson = "2.8.4"
  val specs = "3.7.2"
}

name := "json-util"
organization := "com.logicstack.util"
version := "0.0.7"
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
  "Artifactory" at s"${artifactory}/lib-local/"
)

publishTo := {
  if (isSnapshot.value) {
    Some("Artifactory Realm" at s"${artifactory}/lib-local;build.timestamp=" + new java.util.Date().getTime)
  }
  else {
    Some("Artifactory Realm" at s"${artifactory}/lib-local")
  }
}

credentials += Credentials("Artifactory Realm", "logicstack.jfrog.io", "admin", "AP7GNvG4SqsADXdfxo3yGg9bTDy")
