(defproject osio-clojure-client "0.1.0-SNAPSHOT"
  :description "osio-client-library helps third-party applications get access to OSIO API."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 ;; Security
                 [cylon "0.5.0-20141007.225717-7"]
                 ;; HTTP client/server
                 [http-kit "2.1.16"]
                 ;; JSON converter
                 [org.clojure/data.json "0.2.5"]])
