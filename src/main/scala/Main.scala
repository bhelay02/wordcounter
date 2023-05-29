package com.exercise

import WordJsonSupport._

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._


object Main {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem(Behaviors.empty, "word-counting-system")
    implicit val executionContext = system.executionContext
    Http().newServerAt("localhost", 8080).bind(WordCounterRoutes.routes)
  }
}