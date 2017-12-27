#!/usr/bin/env bash

docker build -t admvotes .

#export DOCKER_ID_USER=$DOCKER_USER

docker login --username=admvotes --password=EGC_1718

docker tag admvotes admvotes/admvotes

docker push admvotes/admvotes