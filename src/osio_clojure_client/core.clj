(ns osio-clojure-client.core
  (:require [org.httpkit.client :as http]
            [clojure.string :as str]))

;; Root API url.
(def api-url "https://staging.opensensors.io/api/1.0/")

(defn sync-get 
  "Make synchronous HTTP GET request"
  [url access-token]  
  (let [options {:headers {"Authorization" (str/join " " ["Bearer" access-token]) "Content-Type" "application/json"}}
        {:keys [status headers body error] :as response} @(http/get url options)]
    response))

(defn async-get
  "Make asynchronous HTTP GET request"
  [url access-token callback]
  (let [options {:headers {"Authorization" (str/join " " ["Bearer" access-token]) "Content-Type" "application/json"}}]
    (http/get url options callback)))

(defn sync-post 
  "Make synchronous HTTP POST request"
  [url access-token form-data]
  (let [options {:headers {"Authorization" (str/join " " ["Bearer" access-token]) "Content-Type" "application/json"} 
                 :body form-data}
        {:keys [status headers body error] :as response} @(http/post url options)]
    response))

(defn sync-put 
  "Make synchronous HTTP PUT request"
  [url access-token form-data]
  (let [options {:headers {"Authorization" (str/join " " ["Bearer" access-token]) "Content-Type" "application/json"} 
                 :body form-data}
        {:keys [status headers body error] :as response} @(http/put url options)]
    response))

(defn whoami
  "Get info about logged user"
  [access-token]
  (sync-get (str api-url "whoami") access-token))
