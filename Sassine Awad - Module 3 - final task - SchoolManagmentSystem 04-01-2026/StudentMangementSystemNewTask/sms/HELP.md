# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/maven-plugin/build-image.html)
* [Spring Integration JDBC Module Reference Guide](https://docs.spring.io/spring-integration/reference/jdbc.html)
* [Spring Integration JPA Module Reference Guide](https://docs.spring.io/spring-integration/reference/jpa.html)
* [Spring Integration Test Module Reference Guide](https://docs.spring.io/spring-integration/reference/testing.html)
* [Spring Integration Apache Kafka Module Reference Guide](https://docs.spring.io/spring-integration/reference/kafka.html)
* [Spring Integration Security Module Reference Guide](https://docs.spring.io/spring-integration/reference/security.html)
* [Spring Integration HTTP Module Reference Guide](https://docs.spring.io/spring-integration/reference/http.html)
* [Spring Integration WebFlux Module Reference Guide](https://docs.spring.io/spring-integration/reference/webflux.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/reference/web/servlet.html)
* [Spring Security](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/reference/web/spring-security.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Config Client](https://docs.spring.io/spring-cloud-config/reference/client.html)
* [Spring Integration](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/reference/messaging/spring-integration.html)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/reference/messaging/kafka.html)
* [Spring Batch](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/how-to/batch.html)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/reference/web/reactive.html)
* [Rest Repositories](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/how-to/data-access.html#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Spring Session for JDBC](https://docs.spring.io/spring-session/reference/)
* [JDBC API](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/reference/data/sql.html)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/reference/data/sql.html#data.sql.jdbc)
* [Spring Batch JDBC](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/how-to/batch.html)
* [Thymeleaf](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/reference/web/servlet.html#web.servlet.spring-mvc.template-engines)
* [Validation](https://docs.spring.io/spring-boot/4.0.2-SNAPSHOT/reference/io/validation.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Integrating Data](https://spring.io/guides/gs/integration/)
* [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/main/jdbc/basics)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

