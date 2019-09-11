#!/usr/bin/env bash
psql postgres -c "CREATE USER clojure_pg_user WITH LOGIN SUPERUSER INHERIT CREATEDB CREATEROLE NOREPLICATION PASSWORD 'insecure_password'"
psql postgres -c "CREATE DATABASE clojure_pg_example WITH OWNER = clojure_pg_user ENCODING = 'UTF8' CONNECTION LIMIT = -1;"
psql clojure_pg_example -f db/friends-table.sql 