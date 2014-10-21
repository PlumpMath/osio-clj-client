(ns osio-clojure-client.core-test
  (:require [clojure.test :refer :all]
            [osio-clojure-client.core :refer :all]
            [osio-clojure-client.devices :refer :all]
            [osio-clojure-client.topics :refer :all]
            [osio-clojure-client.messages :refer :all]))

(def access-token "97a8b6b1-06f4-408e-9d84-02f7680fca6f")

(deftest test-whoami
  (let [response (whoami access-token)]
    (println (response :body) (response :error))))

(deftest test-get-device-list
  (let [response (get-device-list access-token)]
    (println (response :body))))

(deftest test-create-device
  (let [response (create-device access-token)]
    (println (response :body))))

(deftest test-update-device
  (let [response (update-device access-token 1003 "name3" "description3")]
    (println (response :body))))

(deftest test-get-topic-list
  (let [response (get-topic-list access-token)]
    (println (response :body))))

(deftest test-get-messages-by-owner
  (let [response (get-messages-by-owner access-token)]
    (println (response :body))))

(deftest test-get-messages-by-topic
  (let [response (get-messages-by-owner access-token)]
    (println (response :body))))
