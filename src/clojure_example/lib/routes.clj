(ns clojure-example.lib.routes
	(:require
		[compojure.core :refer :all]
		[compojure.route :as route]
		[clojure.pprint :as pp]
		[clojure.string :as str]
		[clojure.data.json :as json]
		[clojure-example.lib.api :as api])
	(:gen-class))

(defn echo-route [req]
	"Echo back the request"
	{:status 200
		:headers {"Content-Type" "text/html"}
		:body (-> (str "GET '/' " req))})

(defn get-friends-route [req]
	"Echo back a name"
	{:status 200
		:headers {"Content-Type" "text/html"}
		:body (-> 
		(api/get-friends))})
		; (str "Hello " (:name (:params req) )))})

(defn add-friend-route [req]
	"Endpoint for adding a friend"
	{:status 200
		:headers {"Content-Type" "application/json"}
		:body (-> (api/add-friend (req :params)))})