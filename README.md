Test_Driven_Development_2014
============================

[![Analytics](https://ga-beacon.appspot.com/UA-68658653-1/test_driven_development_2014/readme)](https://github.com/igrigorik/ga-beacon)

### Ejercicios del curso "Metodologías Ágiles - BeCode".

#### Grafo del repositorio

##### Source
```
Se han hecho participes unas premisas para el desarrollo de código ágil tales como:
No documentar el código. Éste debe de ser lo suficientemente expresivo.
No utilizar primitivas en el interior de los métodos privados siempre que se pueda.
Identificar lo máximo posible el espacio de los nombres de los método y de las variables.
Uso de interfaces siempre que se pueda para reforzar el código.
Con el uso de objetos intentar no usar switch/[if/else] y buscar otras técnicas como poliformismo...
Injección de dependencias manual.
Evitar usar mierd@$ de terceros sin saber cómo funciona por dentro.
Código simple, fácil de entender, mantenible, robusto y reutiliable.
```

```java


  Katas
    |
    |
    |__ src.com.akamon.tdd
                        |
                        |__ fizBuzz -> FizzBuzz.java (100% classes, 94% lines covered)
                        |
                        |__ countLines (83% classes, 96% lines covered)
                        |    |
                        |    |__ api
                        |    |    |
                        |    |    |__ reader -> IReader.java (100% classes, 100% lines covered)
                        |    |         |
                        |    |         |__ processor -> IReaderProcessor.java (100% classes, 100% lines covered)
                        |    |
                        |    |__ src (80% classes, 96% lines covered)
                        |          |
                        |          |__ utils -> LineMapper.java (100% classes, 100% lines covered)
                        |          |
                        |          |__ pattern -> Pattern.java (0% classes, 0% lines covered)
                        |          |
                        |          |__ reader -> Reader.java (100% classes, 100% lines covered)
                        |              |
                        |              |__ processor -> ReaderProcessor.java (100% classes, 100% lines covered)
                        |                    |
                        |                    |__ internal -> InternalParser.java (100% classes, 97% lines covered)
                        |
                        |__ auth
                              |
                              |__ api
                              |    |
                              |    |__ auth -> [ IAuth.java (100% classes, 100% lines covered)
                              |         |        ISocialMedia.java ] (100% classes, 100% lines covered)
                              |         |
                              |         |__ internal -> IInternal.java (100% classes, 100% lines covered)
                              |
                              |
                              |__ src
                                   |
                                   |__ auth -> [ Auth.java (100% classes, 81% lines covered)
                                        |        SocialMedia.java (100% classes, 100% lines covered) ]
                                        |
                                        |__ internal -> [ DBA.java (66% classes, 71% lines covered)
                                                          Internal.java (100% classes, 100% lines covered) ]
 
 ```


##### Test

```
 En el ejercicio de "auth" los Test contienen mocks, stabs y código en bloque usando las clases
 sin mockear. Se ha hecho así para poder ver la evolución de los Test. Puede que tarde un poco en
 pasar los UT porque el acceso a la "BDA" no se ha mockeado en algunos Test.
```

```

   Katas
    |
    |
    |__ test.com.akamon.tdd
                         |
                         |__ fizBuzz -> FizzBuzzTest.java (9/9 Passed)
                         |
                         |__ countLines (31/31 Passed)
                         |     |
                         |     |__ src
                         |            |
                         |            |__ utils -> LineMapperTest.java (5/5 Passed)
                         |            |
                         |            |
                         |            |__ reader -> ReaderTest.java (8/8 Passed)
                         |                 |
                         |                 |__ processor -> ReaderProcessorTest.java (15/15 Passed)
                         |                      |
                         |                      |__ internal -> InternalParserTest.java (3/3 Passed)
                         |
                         |
                         |__ auth
                              |
                              |__ src
                                   |
                                   |__ auth -> [ AuthTest.java (11/11 Passed)
                                        |        SocialMediaTest.java (8/8 Passed) ]
                                        |
                                        |__ internal -> [ DBATest.java (4/4 Passed)
                                                          InternalTest.java (6/6 Passed) ]
```



