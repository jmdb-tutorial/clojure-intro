(ns clojure-intro.views
  (:use [ring.util.response]))

(defn local-url 
  ([request] (local-url request ""))
  ([request path] (let [{:keys [server-name server-port]} request]
                    (format "http://%s:%s%s" server-name server-port path))))


(defn get-index [request]
  (response  (array-map  :is [:attendees :home]
                         :attendees (local-url request "/attendees"))))

(defn get-attendees [request]
  (response (array-map :is [:attendee :list]
                       :count 3
                       :items [ 
                               { :name "Jim Barritt" :more (local-url request "/attendees/234234234") }
                               { :name "Foo Bar" :more (local-url request "/attendees/6545674567") }
                               { :name "Some Other" :more (local-url request "/attendees/23452345") }
                               ])))

(defn post-attendees [request]
  (get-attendees request))

(defn get-attendee [id request]
  (response (array-map :is [:attendee :contact]
                       :id id
                       :name "Jim Barritt"
                       :postcode "TZ34 5DF"
                       :email "jimb@thoughtworks.com"
                       :twitter "https://twitter.com/jimbarritt")))
