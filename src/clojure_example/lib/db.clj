(ns clojure-example.lib.db
	(:require 
		[dotenv :refer [env app-env]]
		[clojure.java.jdbc :as jdbc]
		[clojure.pprint :as pp]
		[clojure.string :as str])
	(:gen-class))

(def -db {
	:dbtype "postgresql"
	:dbname (env :DB_NAME)
	:host (env :DB_HOST)
	:user (env :DB_USER)
	:password (env :DB_PASS)
})

(defn concat-fields
	"Concat field names for SQL"
	[fields]
	(clojure.string/join ", " (map name fields)))

(defn insert
	"Insert a record into a table"
	[table record]
	(first (jdbc/insert! -db table record)))

(defn select
	"Select records from a table"
	[table fields]
	(jdbc/query -db [(str "select " (concat-fields fields)  " from " (name table))] ))