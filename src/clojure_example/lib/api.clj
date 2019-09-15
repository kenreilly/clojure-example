(ns clojure-example.lib.api
  (:require 
    [compojure.core :refer :all]
    [compojure.route :as route]
    [clojure.pprint :as pp]
    [clojure.string :as str]
    [clojure.data.json :as cjson]
    [clojure-example.lib.db :as db])
  (:gen-class))

(defn get-friends 
  "Retrieve a list of records from friends"
  []
  (db/select :friends [:id :name :nickname :occupation]))

(defn add-friend 
  "Add a record to friends"
  [{ name :name nickname :nickname occupation :occupation :as record }]
  (db/insert :friends record))