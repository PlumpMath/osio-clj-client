(ns osio-clojure-client.topics
  (:require [osio-clojure-client.core :as core]
            [clojure.string :as str]
            [clojure.data.json :as json]))

(defn get-topic-list
  "Get topic list for logged user."
  [access-token]
  (let [userid ((core/whoami access-token) :body) 
        url (str core/api-url "users/" userid "/topics/")]
    (core/sync-get url access-token)))
