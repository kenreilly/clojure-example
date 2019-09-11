#!/usr/bin/env bash
curl localhost:3000/friends -X POST -H "Content-Type: application/json" -d $1