(defproject aotb-2013 "0.1.0-SNAPSHOT"
  :description "A conference attendee registration system"
  :url "http://jimbarritt.com/conferences"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.novemberain/monger "1.4.1"]
                 [cheshire "5.0.0"]
                 [clj-time "0.4.4"]
                 [clj-http "0.6.3"]
                 [compojure "1.1.1"]
                 [ring-mock "0.1.3"]
                 [ring/ring-json "0.1.2"]
                 [ring/ring-jetty-adapter "1.1.7" :exclusions [org.slf4j/slf4j-nop
                                                               org.slf4j/slf4j-log4j12]]
                 ]

  :ring {:handler clojure-intro.server/app}
  :main clojure-intro.server
  :aot [clojure-intro.server]
  :plugins [[lein-ring "0.8.6"]]
  :profiles {:dev {
                   :dependencies [[midje "1.6-alpha2"]]}})
