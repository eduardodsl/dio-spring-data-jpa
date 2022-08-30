# Gym API

Java Spring Framework API exercise for JPA practice. This exercise includes the following features not implemented in the original proposal:

* Full REST endpoints (GET/POST/PUT/DELETE) for all entities (students, registrations, physical evaluations).
* DTOs when dealing with returning data
* Added exceptions when request is not found or invalid

The following configuration file must be created in `/main/resources/application.yml` in order to test this app:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://{server}:{port}/{database}?useTimezone=true&serverTimezone=UTC&useLegacyDate
    username: {username}
    password: {password}
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: update
    properties:
      hibernate-format-sql: true
```