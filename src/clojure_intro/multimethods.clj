(ns clojure-intro.multimethods)

(defn say-hello-to [person]
  (format "Hello [%s]" person))

(say-hello-to "Jim")

(def jim {:first-name "Jim" 
          :last-name "Barritt" 
          :email "jimb@thoughtworks.com"})

(say-hello-to jim)

(:first-name jim)

(defmulti say-hello-to class)

(defmethod say-hello-to clojure.lang.PersistentHashMap [person] 
  (let [{:keys first-name} person]
    (say-hello-to first-name)))


(defmethod say-hello-to String [person] 
  (format "Hello [%s]" person))


