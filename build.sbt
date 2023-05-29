ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"
val AkkaVersion = "2.7.0"
val AkkaHttpVersion = "10.5.2"

lazy val root = (project in file("."))
  .settings(
    name := "wordcounter",
    idePackagePrefix := Some("com.exercise")
  )

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream-testkit" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
  "org.scalatest" %% "scalatest" % "3.2.11" % Test
)