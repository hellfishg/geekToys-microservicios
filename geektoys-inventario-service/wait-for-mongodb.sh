#!/bin/bash

MONGO_HOST="mongodb"
MONGO_PORT=27017
MAX_RETRIES=30
RETRY_INTERVAL=1
COUNT=0

echo "⌛ Esperando a MongoDB en $MONGO_HOST:$MONGO_PORT..."

while ! nc -z "$MONGO_HOST" "$MONGO_PORT"; do
  COUNT=$((COUNT+1))
  if [ "$COUNT" -ge "$MAX_RETRIES" ]; then
    echo "❌ MongoDB no respondió después de $((MAX_RETRIES * RETRY_INTERVAL)) segundos. Abortando..."
    exit 1
  fi
  sleep "$RETRY_INTERVAL"
done

echo "✅ MongoDB está listo. Continuando..."
exec "$@"
