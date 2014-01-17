Test_Driven_Development_2014
============================

Ejercicios del curso "Metodologías Ágiles - BeCode".

Se pretende usar técnicas de ingenería del software para el uso de Test-driven development (TDD).

```java
Grafo del repositorio

/**
 * Katas
 *   |
 *   |
 *   |__ src.com.akamon.tdd
 *   |                   |
 *   |                   |__ fizBuzz -> FizzBuzz.java
 *   |                   |
 *   |                   |__ countLines
 *   |                        |
 *   |                        |__ api 
 *   |                        |    |
 *   |                        |    |__ reader -> IReader.java
 *   |                        |         |
 *   |                          |         |__ processor -> IReaderProcessor.java
 *   |                          |
 *   |                          |__ src
 *   |                               |
 *   |                               |__ utils -> LineMapper.java
 *   |                               |
 *   |                               |__ pattern -> Pattern.java
 *   |                               |
 *   |                               |__ reader -> Reader.java
 *   |                                    |
 *   |                                    |__ processor -> ReaderProcessor.java
 *   |                                         |
 *   |                                         |__ internal -> InternalParser.java
 *   |
 *   |
 *   |__ test.com.akamon.tdd
 *                        |
 *                        |__ fizBuzz -> FizzBuzzTest.java
 *                        |
 *                        |__ countLines
 *                             |
 *                             |__ api 
 *                             |    |
 *                             |    |__ reader -> IReaderTest.java
 *                             |         |
 *                             |         |__ processor -> IReaderProcessor.java
 *                             |
 *                             |__ src
 *                                    |
 *                                    |__ utils -> LineMapperTest.java
 *                                    |
 *                                    |__ pattern -> PatternTest.java
 *                                    |
 *                                    |__ reader -> ReaderTest.java
 *                                         |
 *                                         |__ processor -> ReaderProcessorTest.java
 *                                              |
 *                                              |__ internal -> InternalParserTest.java
 *           
 *     
 *     
 */   
 ```
