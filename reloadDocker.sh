#!/bin/bash

echo "Removing any existing photo-gallery docker container:"
docker rm -f photo-gallery || true

echo "Rebuilding app:"
./gradlew clean build

echo "Rebuilding docker image:"
docker build -t photo-gallery .

echo "Running docker container:"
docker run -d -p 8081:8081 photo-gallery

echo "Finished"