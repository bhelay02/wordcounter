package com.exercise


import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

final case class Word(words: Seq[String])

object WordJsonSupport extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val wordFormat: RootJsonFormat[Word] = jsonFormat1(Word.apply)
}