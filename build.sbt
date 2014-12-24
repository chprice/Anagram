name := "Anagram Evalation"

version := "0.1"

conflictManager := ConflictManager.latestRevision

conflictWarning := ConflictWarning.disable

//scalaVersion := "2.10.4"
scalaVersion := "2.11.4"

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

resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Scala Tools Snapshots" at "http://scala-tools.org/repo-snapshots/"

resolvers += "ScalaNLP Maven2" at "http://repo.scalanlp.org/repo"

resolvers += "Maven2" at "http://repo1.maven.org/maven2"

resolvers += "Twitter" at "http://maven.twttr.com"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "latest.release",
  //"cc.factorie" % "factorie" % "1.0.0-RC1",
  //"cc.factorie.app.nlp" % "all-core.models" % "1.0.0"
  //"cc.factorie.app.nlp" % "pos" % "1.0-RC5"
  //"org.scalanlp" % "chalk" % "1.3-SNAPSHOT",
  //"org.scalanlp" %% "nak" % "1.2.0-SNAPSHOT",
  //"org.scalanlp" %% "breeze" % "0.8.1",
  //"org.scalanlp" % "breeze-natives_2.10" % "0.8.1",
  //"org.scalanlp" % "epic_2.10" % "0.1" exclude ("com.typesafe.sbt", "sbt-pgp"),
  //"org.scalanlp" %% "epic-parser-en-span" % "2014.9.15" exclude ("com.typesafe.sbt", "sbt-pgp"),
  //"org.scalanlp" %% "epic-pos-en" % "2014.6.3-SNAPSHOT"
  //"org.scalanlp" % "epic-all-models_2.10" % "0.1" exclude ("com.typesafe.sbt", "sbt-pgp")
  "edu.stanford.nlp" % "stanford-corenlp" % "3.4",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.4" artifacts(Artifact("stanford-corenlp", "models") ), //artifacts(Artifact("stanford-corenlp", "core/models") ),
  "edu.stanford.nlp" % "stanford-parser" % "3.4",
  "net.fwbrasil" %% "activate-core" % "1.7",
  "net.fwbrasil" %% "activate-jdbc" % "1.7",
  "com.twitter" % "finatra_2.10" % "1.5.4" //exclude("org.scalatest", "scalatest_2.10")
)

incOptions := incOptions.value.withNameHashing(true)

// Download and create Eclipse source attachments for library dependencies
// EclipseKeys.withSource := true

showSuccess := true

showTiming := true

javaOptions += "-Xmx2g -Xmx1500M -XX:-UseGCOverheadLimit -XX:-UseConcMarkSweepGC"
