#!/usr/bin/env bash
psql clojure_pg_example -f db/reset.sql 
psql clojure_pg_example -f db/friends-table.sql 