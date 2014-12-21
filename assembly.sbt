import AssemblyKeys._ // put this at the top of the file

assemblySettings

assemblyOption in assembly ~= { _.copy(cacheOutput = false) }

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
{
  case PathList("org", "w3c", "dom", _) => MergeStrategy.first
  case PathList("javax", "xml", "stream", _ *) => MergeStrategy.first
  case PathList("org", "cyberneko", "html", _ *) => MergeStrategy.first
  case x => old(x)
}
}

excludedJars in assembly <<= (fullClasspath in assembly) map { cp =>
  cp filter {x => x.data.getName.matches(".*native.*") || x.data.getName.matches("sbt.*") || x.data.getName.matches(".*macros.*") }
}

// your assembly settings here