(ns clojure-intro.views-mongo
  (:use [ring.util.response]
        [clojure-intro.mongo-api]))

(defn local-url 
  ([request] (local-url request ""))
  ([request path] (let [{:keys [server-name server-port]} request]
                    (format "http://%s:%s%s" server-name server-port path))))


(defn get-index [request]
  (response  (array-map  :is [:attendees :home]
                         :for-humans (local-url request "/index.html")
                         :attendees (local-url request "/attendees"))))

(defn attendee-summary [request attendee]
  (let [{:keys [id name]} attendee]
    (array-map :name name
               :more (local-url request (format "/attendees/%s" id)))))

(defn get-attendees [request]
  (let [items (map (partial attendee-summary request) (retrieve-collection "attendees"))]
    (response (array-map :is [:attendee :list] 
                         :count (count items)
                         :items items))))

(defn post-attendees [request] 
  (store-document "attendees" (:form-params request))
  (redirect (local-url request "/attendees")))


(defn get-attendee [id request]
  (response (retrieve-document "attendees" id)))

 
