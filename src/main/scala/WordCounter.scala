package com.exercise

import scala.collection.concurrent.TrieMap

trait WordCounter[A] {
  def addWords(words: Seq[A]): Unit

  def countWords(word: A): Long
}

class WordCounters extends WordCounter[String] {

  private val wordsTrieMap = new TrieMap[String, Long]()

  override def addWords(words: Seq[String]): Unit = {

    for (word <- words) {
      word.forall(_.isLetter) match {
        case true =>
          wordsTrieMap.get(word) match {
            case Some(value) => wordsTrieMap.put(Translator.translate(word), value + 1)
            case None => wordsTrieMap.put(word, 1)
          }
        case false =>
      }
    }

  }

  override def countWords(word: String): Long = {
    wordsTrieMap.get(word) match {
      case Some(value) => value
      case None => 0
    }
  }

}