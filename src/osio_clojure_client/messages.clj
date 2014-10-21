(ns osio-clojure-client.messages
  (:require [osio-clojure-client.core :as core]
            [clojure.string :as str]
            [clojure.data.json :as json]))

(defn get-messages-by-owner
  "Get list of messages by owner."
  ([access-token]
     (let [userid ((core/whoami access-token) :body)
           url (str core/api-url "users/" userid "/messages-by-owner/")]
       (core/sync-get url access-token)))
  ([access-token start-date end-date]
     (let [userid ((core/whoami access-token) :body)
           url (str core/api-url "users/" userid "/messages-by-owner?start-date=" start-date "&end-date=" end-date)]
       (core/sync-get url access-token))))

(defn get-messages-by-topic
  "Get list of messages by topic."
  ([access-token topic]
     (let [userid ((core/whoami access-token) :body)
           url (str core/api-url "users/" userid "/messages-by-topic?topic=" topic)]
       (core/sync-get url access-token)))
  ([access-token topic start-date end-date]
     (let [userid ((core/whoami access-token) :body)
           url (str core/api-url "users/" userid "/messages-by-topic?topic=" topic "&start-date=" start-date "&end-date=" end-date)]
       (core/sync-get url access-token))))

(defn get-messages-by-client
  "Get list of messages by topic."
  ([access-token client]
     (let [userid ((core/whoami access-token) :body)
           url (str core/api-url "users/" userid "/messages-by-device?client=" client)]
       (core/sync-get url access-token)))
  ([access-token client start-date end-date]
     (let [userid ((core/whoami access-token) :body)
           url (str core/api-url "users/" userid "/messages-by-client?client=" client "&start-date=" start-date "&end-date=" end-date)]
       (core/sync-get url access-token))))
