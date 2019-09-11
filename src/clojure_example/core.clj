(ns clojure-example.core
	(:require 
		[dotenv :refer [env app-env]]
		[compojure.core :refer :all]
		[compojure.route :as route]
		[org.httpkit.server :as server]
		[ring.middleware.json :as js]
		[ring.middleware.defaults :refer :all]
		[ring.middleware.reload :refer [wrap-reload]]
		[clojure.pprint :as pp]
		[clojure.string :as str]
		[clojure.data.json :as json]
		[clojure-example.lib.routes :as routes])
	(:gen-class))

(defroutes app-routes
	(GET "/" [] routes/echo-route)
	(GET "/friends" [] routes/get-friends-route)
	(POST "/friends" [] routes/add-friend-route))

(defn -main
	"Production"
	[& args]
		(let [port (Integer/parseInt (env :PORT))]
		(server/run-server (wrap-defaults #'app-routes api-defaults) {:port port})
		(println (str "Running webserver at http:/127.0.0.1:" port "/"))))

(defn -dev-main
	"Dev/Test (auto reload watch enabled)"
	[& args]
		(let [port (Integer/parseInt (env :PORT))]
		(server/run-server (wrap-reload (js/wrap-json-params (js/wrap-json-response (wrap-defaults #'app-routes api-defaults)))) {:port port})
		(println (str "Running webserver at http:/127.0.0.1:" port "/"))))