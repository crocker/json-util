name := "json-util"
organization := "com.logicstack.util"
version := "0.0.11-SNAPSHOT"
scalaVersion := versions.scala

lazy val versions = new {
  val scala = "2.12.5"
  val jackson = "2.11.1"
}

libraryDependencies ++= Seq(
  // json
  "com.fasterxml.jackson.core" % "jackson-annotations" % versions.jackson,
  "com.fasterxml.jackson.core" % "jackson-core" % versions.jackson,
  "com.fasterxml.jackson.core" % "jackson-databind" % versions.jackson,
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % versions.jackson,
  "com.fasterxml.jackson.module" % "jackson-module-paranamer" % versions.jackson,
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % versions.jackson,
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jdk8" % versions.jackson,
  "com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % versions.jackson,
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-cbor" % versions.jackson
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
//
//publishTo := {
//  if (isSnapshot.value) {
//    Some("Artifactory Realm" at s"${artifactory}/lib-local;build.timestamp=" + new java.util.Date().getTime)
//  }
//  else {
//    Some("Artifactory Realm" at s"${artifactory}/lib-local")
//  }
//}
//
//credentials += Credentials("Artifactory Realm", "logicstack.jfrog.io", "admin", "AP7GNvG4SqsADXdfxo3yGg9bTDy")
