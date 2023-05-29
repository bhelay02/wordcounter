**Word Counter**

It provides functionality to add words in memory with efficient-memory and faster processing times with scalable concurrent insert.

It uses  hash array mapped trie for achieving the same and uses the scala collection providing same feature in a thread safe / lock free mechanism i.e. TrieMap.


**Design Principles**
Follows SOLID principles
Actor based system for Microservice

**Design Patterns**
Uses microservices which allows independent scalability along with other features
Reactive design patterns as service is async in nature - It uses Akka Http to expose library functionality as REST API

**REST API**

```
To Add word(s)

POST /words

{"words" : ["test word", "another"]}
```

```
To Get word count

GET /words/{word}
```

**To Run**

You can run it via IDE like IntelliJ or using command line 

```sbt run```