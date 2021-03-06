(ns clojure-intro.hello-world) 

(println "Hello world")

(+ 1 2)

(- 10 (+ 2 3))

(println (format "Hello [%s]" "jim"))

(defn say-hello-to [person]
  (format "Hello [%s]" person))

(defn sleep-for [ms]
  (println "going to zzzzz...")
  (Thread/sleep ms)
  (println "waking up again!"))

(time (sleep-for 1000))

(spit "/Users/jmdb/Desktop/jims-file.txt" "Hey this is a really easy way to create file!")

(slurp "/Users/jmdb/Desktop/jims-file.txt")

(slurp (clojure.java.io/resource "test-classpath.txt"))


(defn -main [& args]
  (say-hello-to (first args)))
