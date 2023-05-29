package com.exercise

import akka.http.scaladsl.server.Directives.{complete, path}

import WordJsonSupport._

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._

object WordCounterRoutes {
  val wordCounter = new WordCounters

  val routes = {
    concat(
      path("words" / Segment) { word =>
        get {
          complete("Word count : " + wordCounter.countWords(word))
        }
      },
      path("words") {
        post {
          entity(as[Word]) { word =>
            wordCounter.addWords(word.words)
            complete("Words processed")
          }
        }
      }
    )
  }
}
