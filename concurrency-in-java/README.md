# Concurrent Programming #
* with Java
* with Clojure's STM
* with Akka's Actor

# Resources #
* NFJS Magazine 2011 March: Options to Program Concurrency in Pure Java
* All source code is referenced from there.

# Conclusion #
* The author says he prefer Actor model, but I think, It's not well supperted by Java IDE and perfomance is lower than Other's. And I have to add some immutable data classes for that.
* So I think, using the STM model with Clojure is better then others. It's easy to use and well suppoerted by Java IDE(I have tested it with IntelliJ IDEA). The performace is better than Actor model(with Akka) and simiral to Java Concurrrency.