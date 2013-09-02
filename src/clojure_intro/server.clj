(ns clojure-intro.server
  (:use [compojure.core]
        [ring.util.response])
  (:require [compojure.handler :as handler]
            [ring.middleware.json :as json]
            [compojure.route :as route]                        
            [ring.adapter.jetty :as jetty]
            [clojure-intro.views :as v]
            [clojure-intro.mongo-api :as mongo])
  (:gen-class))

(defroutes app-routes
  (route/resources "/")

  (GET "/" request (v/get-index request))

  (context "/attendees" []
           (defroutes attendees-routes
             (GET "/" request (v/get-attendees request))
             (POST "/" request (v/post-attendees request))))

  (context "/attendees/:id" [id]
           (defroutes api-sketch-route
             (GET "/" request (v/get-attendee id request))))
)


(def app
  (-> (handler/api app-routes)
      (json/wrap-json-body)
      (json/wrap-json-response)))

(defn -main [& args]
  (mongo/connect-mongo! "clojure-intro")
  (if (not (empty? args))
    (jetty/run-jetty app {:port (read-string (first args))})
    (jetty/run-jetty app {:port 8097})))

