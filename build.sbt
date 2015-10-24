name := "scala-tour"

version := "1.0"

scalaVersion := "2.11.7"

val akkaVersion =  "2.4.0"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "com.typesafe.akka" % "akka-actor_2.11" % akkaVersion,
  "com.typesafe.akka" % "akka-testkit_2.11" % akkaVersion,
  "com.typesafe.akka" % "akka-remote_2.11" % akkaVersion,
  "commons-beanutils" % "commons-beanutils" % "1.9.2",
  "org.json4s" % "json4s-native_2.11" % "3.3.0",
  "org.json4s" % "json4s-jackson_2.11" % "3.3.0",
  "org.specs2" %% "specs2-core" % "3.6.5"
)



    