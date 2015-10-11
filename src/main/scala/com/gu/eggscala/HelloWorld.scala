package com.gu

import org.http4s._
import org.http4s.server._
import org.http4s.dsl._

import _root_.argonaut._, Argonaut._
import org.http4s.argonaut._

object HelloWorld {
  val service = HttpService {
    case GET -> Root / "management" / "healthcheck" =>
      Ok(jSingleObject("status", jString(s"healthy")))
  }
}
