(ns clojure-intro.mongo-api
  (:require [monger.collection :as mc])
  (:use [monger.core :only [connect! connect set-db! connect-via-uri! get-db]])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern]))

(defn connect-mongo! [dbname]
  (println "TRYING TO CONNECTING TO MONGOHQ @ " (System/getenv "MONGOHQ_URL"))
  (let [mongohq_url (System/getenv "MONGOHQ_URL")]
    (if (nil? mongohq_url)
      (do (connect!)
          (set-db! (get-db dbname)))
      (connect-via-uri! mongohq_url))))

(defn store-document [collection-name document]
  (let [oid (ObjectId.)]
    (mc/insert collection-name (merge document {:_id oid}))
    (str oid)))

(defn normalise-mongo-id [data]
  "Swaps _id for id in the map"
  (let [{:keys [_id]} data]
    (->
     (dissoc data :_id)
     (merge {:id (str _id)}))))

(defn format-document [document]
  (let [tags (:is document)]
    (-> (dissoc document :is)
        (merge {:is [tags]}))))


(defn add-tags [data tags]
  "Add the list of tags to the data"
  (merge data {:is (map name tags)}))

(defn process-document [document]
  (-> (normalise-mongo-id document)
      (format-document)))

(defn retrieve-collection 
  ([collection-name] (retrieve-collection collection-name {}))
  ([collection-name query] (map process-document (mc/find-maps collection-name query))))

(defn retrieve-document [collection-name id]
  (let [data (mc/find-map-by-id collection-name (ObjectId. id))]
    (process-document data)))








