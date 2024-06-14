# Spring Configuration Demo

This demo shows how to use different configuration files in development and production
environment. It also is a good example of Spring cloud and micro-services development. 
It uses idea IDE to develop locally, then develop it using docker. All the configuration files
are hosted on GitHub and Config Server is responsible to retrieve them.

## How to develop the project

1. Download the repository and open it in Idea IDE. If some unhappy things occur, just close the IDE,
delete
the `.idea` folder and re-launch the IDE. Hopefully the problem will be gone. 
2. Edit the run configuration, add environment variable `SPRING_PROFILES_ACTIVE=dev`
3. Once the project can run, test the endpoint `http://127.0.0.1/api/v1/users/1`

## How to deploy the project

The command before is used to deploy.

```shell
cd deploy
chmod +x ./generated_jar_files.sh
./generated_jar_files.sh
docker compose up --build # or start in background: docker compose up --build -d
```

### The `generated_jar_files.sh`
The script generates jar files from gradle or maven project.

#### Usage

1. **Generate all jar files**: `./generated_jar_files.sh`
2. **Generate specific services' jar file**: `./generated_jar_files.sh --service serivce-a, service-b`
3. **Remove all jar files**: `./generated_jar_files.sh --clean`
4. **Remove *one* jar file**: `./generated_jar_files.sh --clean service-name`

> The script may have problem for some reason, if the docker can't start, copy
> the jar built by Idea IDE to `deploy/jars` and rename it to service's name.


## Diagram



## Microservices
| Service          | Port-dev | Port-prod | Description                      |
|------------------|----------|-----------|----------------------------------|
| Config Server    | 8888     | 8080      | Centralized configuration server |
| Discovery Server | 8761     | 8080      | Service discovery server         |
| Gateway          | 8222     | 8080      | API Gateway                      |
| Users            | 8080     | 8080      | User service                     |



----
The scripts below is used to bootstrap the project. just leave here. 
## Generate the configuration files

**For Config Server**
```shell
touch discovery-prod.yml
touch discovery-dev.yml
touch gateway-prod.yml
touch gateway-dev.yml
touch users-prod.yml
touch users-dev.yml
```

**For each service**
```shell
touch config/src/main/resources/application-prod.yml
touch config/src/main/resources/application-dev.yml

touch discovery/src/main/resources/application-prod.yml
touch discovery/src/main/resources/application-dev.yml

touch gateway/src/main/resources/application-prod.yml
touch gateway/src/main/resources/application-dev.yml

touch users/src/main/resources/application-prod.yml
touch users/src/main/resources/application-dev.yml
```

**Copy the content from application.yml to application-prod.yml and application-dev.yml**
```shell
cp config/src/main/resources/application.yml config/src/main/resources/application-prod.yml
cp config/src/main/resources/application.yml config/src/main/resources/application-dev.yml

cp discovery/src/main/resources/application.yml discovery/src/main/resources/application-prod.yml
cp discovery/src/main/resources/application.yml discovery/src/main/resources/application-dev.yml

cp gateway/src/main/resources/application.yml gateway/src/main/resources/application-prod.yml
cp gateway/src/main/resources/application.yml gateway/src/main/resources/application-dev.yml

cp users/src/main/resources/application.yml users/src/main/resources/application-prod.yml
cp users/src/main/resources/application.yml users/src/main/resources/application-dev.yml
```

