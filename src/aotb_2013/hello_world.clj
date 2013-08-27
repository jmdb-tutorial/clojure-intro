(ns aotb-2013.hello-world)

(println "Hello world")

(println (format "Hello [%s]" "jim"))

(defn say-hello-to [person]
  (format "Hello [%s]" person))

(defn sleep-for [ms]
  (println "going to zzzzz...")
  (Thread/sleep ms)
  (println "waking up again!"))

(time (sleep-for 1000))

(spit "/Users/jmdb/Desktop/jims-file.txt" "Hey this is a real easy way to create file!")

(slurp "/Users/jmdb/Desktop/jims-file.txt")





