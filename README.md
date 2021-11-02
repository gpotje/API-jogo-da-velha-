# API-jogo-da-velha

Projeto utilizado na exemplificação da palestra no TDC São Paulo, segue o link da apresentação: https://pt.slideshare.net/emmanuelnerisouza/construindo-apis-de-forma-produtiva-com-spring-boot-spring-data-e-spring-mvc
Projeto utilizado na exemplificação da palestra no TDC São Paulo, segue o link da apresentação: https://pt.slideshare.net/emmanuelnerisouza/construindo-apis-de-forma-produtiva-com-spring-boot-spring-data-e-spring-mvc

# Visão geral

O projeto é uma aplicação back-end com objetivo de demonstrar a produtividade de construir APIs utilizando os frameworks [Spring Boot](https://projects.spring.io/spring-boot), [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) e [Spring Data](http://projects.spring.io/spring-data) em conjunto.

## Tecnologias

- [Spring Boot](https://projects.spring.io/spring-boot) é uma ferramenta que simplifica a configuração e execução de aplicações Java stand-alone,  com conceitos de dependências “starters”, auto configuração e servlet container embutidos é proporcionado uma grande produtividade desde o start-up da aplicação até sua ida a produção.
 
- [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) é um framework já consolidado no mercado, que a partir da versão fornece mecanismos simplificados para a criação de APIs RESTful através de anotação, além disso, também possui recursos de serialização e deserialização de objetos de forma transparente 
 
- [Spring Data](http://projects.spring.io/spring-data/) é um framework que abstrai o acesso ao modelo de dados, independente a tecnologia de base de dados.

 
# Setup da aplicação (local)

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 11
```
## Instalação da aplicação

Primeiramente, faça o clone do repositório:
```
https://github.com/gpotje/API-jogo-da-velha-.git
```
Feito isso, acesse o projeto:
```
cd projeto.
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean package
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Pronto. A aplicação está disponível em http://localhost:8080
```
Tomcat started on port(s): 8080 (http)
Started AppConfig in xxxx seconds (JVM running for xxxx)
```
