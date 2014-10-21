(ns osio-clojure-client.devices
  (:require [osio-clojure-client.core :as core]
            [clojure.string :as str]
            [clojure.data.json :as json]))

(defn get-device-list
  "Get device list for logged user."
  [access-token]
  (let [userid ((core/whoami access-token) :body) 
        url (str core/api-url "users/" userid "/devices/")]
    (core/sync-get url access-token)))

(defn create-device
  "Create new device"
  [access-token]
  (let [userid ((core/whoami access-token) :body)
        url (str core/api-url "users/" userid "/devices/")]
    (core/sync-post url access-token (json/write-str {}))))

(defn update-device
  "Update existing device"
  [access-token deviceid name description]
  (let [userid ((core/whoami access-token) :body)
        url (str core/api-url "users/" userid "/devices/" deviceid)]
    (core/sync-put url access-token (json/write-str {:name name :description description}))))
