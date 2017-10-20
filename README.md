# spring-boot-starter-shiro-redis-session
A spring boot starter use shiro with oltu as aouth2 client
## How to build and install

1. git clone the code from github

2. run the command in your console with maven:

```
	mvn install
```

## How to use 

- import the config in you `pom.xml`

```xml
<dependency>
    <groupId>com.github.ganity</groupId>
    <artifactId>spring-boot-starter-shiro-redis-session</artifactId>
    <version>1.0.0</version>
</dependency>
```

- add the follow config in you `application.yml` or `application.properties` 

```shell
spring:
  redis:
    database: 4
    host: 172.16.2.88
    port: 6379
#    password:  # Login password of the redis server.
    pool.max-idle: 20
    pool.min-idle: 1
    pool.max-active: 8
    pool.max-wait: 1000
    timeout: 0
```

