#!/bin/bash

# Esperar a que Kafka esté listo
echo "Esperando a que Kafka esté disponible..."
until nc -z -v -w30 kafka 9092
do
  echo "Esperando Kafka..."
  sleep 5
done

echo "Kafka está disponible. Continuando..."
