name := "Anagram Evalation"

version := "0.1"

scalaVersion := "2.10.4"

scalaSource in Compile <<= baseDirectory(_ / "src")

javaSource in Compile <<= baseDirectory(_ / "src")

scalaSource in Test <<= baseDirectory(_ / "test")

javaSource in Test <<= baseDirectory(_ / "test")

scalacOptions ++= Seq(
  "-deprecation"          // Emit warning and location for usages of deprecated APIs.
  , "-feature"              // Emit warning and location for usages of features that should be imported explicitly.
  , "-unchecked"            // Enable additional warnings where generated code depends on assumptions.
  , "-Xfatal-warnings"      // Fail the compilation if there are any warnings.
  , "-Xlint"                // Enable recommended additional warnings.
  , "-Yno-adapted-args"     // Do not adapt an argument list to match the receiver.
  , "-Ywarn-dead-code"      // Warn when dead code is identified.
)

resolvers += "IESL Release" at "http://dev-iesl.cs.umass.edu/nexus/content/groups/public"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "latest.release" % "test",
  "cc.factorie" % "factorie" % "1.0",
  "cc.factorie.app.nlp" % "pos" % "1.0-RC5"
  //	, "com.typesafe"  %  "config"    % "1.2.0"
)

incOptions := incOptions.value.withNameHashing(true)

// Download and create Eclipse source attachments for library dependencies
// EclipseKeys.withSource := true

showSuccess := true

showTiming := true
