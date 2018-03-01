import sbt._

object Dependencies {

  val specsVersion = "4.0.3"

  val testDependencies = Seq(
    "org.specs2" %% "specs2-core" % specsVersion % Test,
    "org.specs2" %% "specs2-mock" % specsVersion % Test,
    "junit" % "junit" % "4.12" % Test,
    "com.novocode" % "junit-interface" % "0.11" % Test
  )

  val coreDependencies: Seq[ModuleID] = testDependencies ++ Seq(
    "org.apache.commons" % "commons-lang3" % "3.7",
    "commons-codec" % "commons-codec" % "1.11")

}