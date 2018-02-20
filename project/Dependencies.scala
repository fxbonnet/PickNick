import sbt._

object Dependencies {

  val specsVersion = "3.9.0"

  val testDependencies = Seq(
    "org.specs2" % "specs2-core_2.12" % specsVersion % "test",
    "org.specs2" % "specs2-mock_2.12" % specsVersion % "test"
  )

  lazy val coreDependencies: Seq[ModuleID] = testDependencies

}