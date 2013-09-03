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

(defn get-attendees [request]
  (let [items (retrieve-collection "attendees")]
    (response (array-map :is [:attendee :list] 
                         :count (count items)
                         :items items))))

(defn post-attendees [request] 
  (store-document "attendees" (:form-params request))
  (redirect (local-url request "/attendees")))

(defn get-attendee [id request]
  (response (array-map :is [:attendee :contact]
                       :id id
                       :name "Jim Barritt"
                       :postcode "TZ34 5DF"
                       :email "jimb@thoughtworks.com"
                       :twitter "https://twitter.com/jimbarritt")))
