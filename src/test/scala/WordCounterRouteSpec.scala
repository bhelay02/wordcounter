package com.exercise

import akka.http.scaladsl.model.{HttpEntity, HttpMethods, HttpRequest, MediaTypes, StatusCodes}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.server._
import Directives._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class WordCounterRouteSpec extends AnyWordSpec with Matchers with ScalatestRouteTest {
  "Word count service" should {

    "return a zero when word is not present" in {
      Get("/words/test") ~> WordCounterRoutes.routes ~> check {
        responseAs[String] shouldEqual "Word count : 0"
      }
    }

    "add thr word and update count" in {
      val requestBody = """ {"words" : ["test"] } """
      val postRequest = HttpRequest(
        HttpMethods.POST,
        uri = "/words",
        entity = HttpEntity(MediaTypes.`application/json`, requestBody))

      postRequest ~> WordCounterRoutes.routes ~> check {
        responseAs[String] shouldEqual "Words processed"
      }
    }

    "return a 1 when word is present" in {
      Get("/words/test") ~> WordCounterRoutes.routes ~> check {
        responseAs[String] shouldEqual "Word count : 1"
      }
    }
  }
}
