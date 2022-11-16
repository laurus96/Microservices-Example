#! /bin/bash

echo "Creating Eureka Service Image ..."

cd eurekaserver || exit
./mvnw package
docker build -t palla/eureka-service .
cd ..

echo "Creating Gateway Service Image ..."

cd gatewayservice || exit
./mvnw package
docker build -t palla/gateway-service .
cd ..

echo "Creating Image Service Image ..."

cd imageservice || exit
./mvnw package
docker build -t palla/image-service .

cd ..

echo "Creating Gallery Service Image ..."

cd galleryservice || exit
./mvnw package
docker build -t palla/gallery-service .
cd ..

echo "Images created... "

docker compose up -d
echo "Docker Compose Created. Ending Script."