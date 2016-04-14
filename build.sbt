lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.11.8"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "scalatrain",
    libraryDependencies ++= Seq(
//      "org.slf4j" % "slf4j-log4j12" % "1.2",
      "org.slf4j" % "slf4j-api" % "1.6.1",
      "ch.qos.logback" % "logback-classic" % "0.9.28"
    )
  )


