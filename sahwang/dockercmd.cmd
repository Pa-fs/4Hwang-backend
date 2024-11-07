:: BuildKit
export DOCKER_BUILDKIT=1

:: docker build --build-arg MAVEN_OPTS="-Dmaven.repo.local=/root/.m2/repository" -t sahwang-app .
docker build -t sahwang-app .

docker tag sahwang-app taeyoungk/sahwang-app:latest

docker push taeyoungk/sahwang-app:latest


docker-compose -f .\docker-compose.yaml down

docker-compose -f .\docker-compose.yaml up -d