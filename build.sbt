import com.typesafe.sbt.packager.docker.Cmd

organization := "com.gu"
name := "egg-scala"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.11.7"

enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

dockerBaseImage := "frolvlad/alpine-oraclejdk8"

dockerCommands := dockerCommands.value.flatMap{
  case cmd@Cmd("FROM",_) => List(cmd, Cmd("RUN", "apk update && apk add bash"))
  case other => List(other)
}

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-blaze-server" % "0.10.1",
  "org.http4s" %% "http4s-dsl"          % "0.10.1",
  "org.http4s" %% "http4s-argonaut"     % "0.10.1",
  "org.slf4j"  %  "slf4j-simple"        % "1.6.4"
)
