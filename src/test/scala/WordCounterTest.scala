package com.exercise

import org.scalatest.funsuite.AnyFunSuite

class WordCounterTest extends AnyFunSuite {

  test("Add a valid word should add the count") {
    val wordCounter = new WordCounters()
    wordCounter.addWords(List("test"))
    assert(wordCounter.countWords("test") === 1)
  }

  test("Add a valid word should update the count") {
    val wordCounter = new WordCounters()
    wordCounter.addWords(List("test"))
    wordCounter.addWords(List("test"))
    assert(wordCounter.countWords("test") === 2)
  }

  test("Add a Invalid word should not add the count") {
    val wordCounter = new WordCounters()
    wordCounter.addWords(List("test@"))
    assert(wordCounter.countWords("test@") === 0)
  }
}
