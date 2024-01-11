#!/bin/bash

FILES="./data/*json"
echo "Loading files..."
for f in $FILES
do
  curl -d "@$f" -H "Content-Type: application/json" -X POST http://localhost:8088/api/matches
done

echo "Done!"
