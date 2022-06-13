# Nossas Ofertas
Backend do projeto para Tech Day Carrefour, desenvolvido em java com Springboot e WebFlux

## Abordagem de desenvolvimento

- Recebendo um cep do [frontend](branch frontend) via @PostMapping e concatenando em link para API carrefour e receber o nome 
das lojas mais próximas via WebClient do pacote do WebFlux.

- Com o nome da loja mais próxima , é concatenado com outro endpoint da API carrefour para receber a lista de produtos ,
também via WebClient do pacote do WebFlux.

- Foi usado JSONObject da dependencia configuration-processor para manipular informações especificas da lista de produtos
recebida e modelar o envio das informações para o frontend .

## Help Me
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/#build-image)
* [Validation](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#io.validation)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

