# spring-boot-graylog2

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-graylog2/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-graylog2/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen?logo=springboot)
![Graylog](https://img.shields.io/badge/Graylog-6.1-blue)

A sample Spring Boot application that ships its logs to [Graylog](https://graylog.org/) using the
GELF (Graylog Extended Log Format) appender from [logstash-gelf](https://logging.paluch.biz/).

## Tech Stack

- Java 25
- Spring Boot 4.1.1 (Web, DevTools, Docker Compose support)
- logstash-gelf 1.15.1 (Logback GELF appender)
- Lombok
- Maven (via the Maven Wrapper)
- Docker Compose: MongoDB 8, Graylog Data Node 6.1, Graylog 6.1

## Prerequisites

- JDK 25
- Docker and Docker Compose

## Getting Started

1. Clone the repository

   ```shell
   git clone https://github.com/hendisantika/spring-boot-graylog2.git
   cd spring-boot-graylog2
   ```

2. Run the application

   ```shell
   ./mvnw spring-boot:run
   ```

   Thanks to `spring-boot-docker-compose`, the services in [`compose.yaml`](compose.yaml) (MongoDB,
   Graylog Data Node and Graylog) start automatically. You can also start them yourself:

   ```shell
   docker compose up -d
   ```

3. Open Graylog at <http://127.0.0.1:9000> and log in with `admin` / `admin`.

4. Create a **GELF UDP** input on port `12201` in Graylog
   (*System → Inputs → GELF UDP → Launch new input*) so it can receive the application logs.

## Endpoints

| Method | Path     | Description                                                                 |
|--------|----------|-----------------------------------------------------------------------------|
| GET    | `/hello` | Returns `{"msg":"HelloWorld"}` and writes info logs from controller/service |
| GET    | `/log`   | Writes error/warn/info/debug logs, then throws an `ArithmeticException`     |

```shell
curl http://localhost:8080/hello
curl http://localhost:8080/log
```

Then search the messages in Graylog (*Search*), e.g. by `facility:springboot-with-graylog`.

## Logging Configuration

The GELF appender is configured in [`src/main/resources/logback.xml`](src/main/resources/logback.xml):

| Setting              | Value                     |
|----------------------|---------------------------|
| Host                 | `udp:127.0.0.1`           |
| Port                 | `12201`                   |
| Facility             | `springboot-with-graylog` |
| Maximum message size | `8192`                    |

Logs are also written to the console.

## Build & Test

```shell
./mvnw clean package
```

## CI/CD & Dependency Updates

- **GitHub Actions** ([`maven.yml`](.github/workflows/maven.yml)) builds and tests the project with
  Temurin JDK 25 on every push and pull request to `main`.
- **Dependabot** ([`dependabot.yml`](.github/dependabot.yml)) keeps Maven dependencies,
  GitHub Actions and Docker Compose images up to date, with grouped pull requests and
  conventional commit messages.

## Author

Hendi Santika — [hendisantika@gmail.com](mailto:hendisantika@gmail.com) · Telegram: @hendisantika34
