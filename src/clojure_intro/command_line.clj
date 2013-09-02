(ns clojure-intro.command-line
  (:gen-class))

(defn say-hello-to [person]
  (format "Hello [%s]" person))

(defn -main [& args]
  (println (say-hello-to (first args))))
