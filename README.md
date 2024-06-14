# Spring Configuration Demo

## Microservices
| Service          | Port | Description                      |
|------------------|------|----------------------------------|
| Config Server    | 8888 | Centralized configuration server |
| Discovery Server | 8761 | Service discovery server         |
| Gateway          | 8222 | API Gateway                      |
| Users            | 8080 | User service                     |

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

