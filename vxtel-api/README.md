# VxTel - API 

Api desenvolvida em Java 1.8 e com Spring Boot 2.4.1

## Iniciando a Api

1. Importar o projeto no eclipse ou intelli j;
2. Executar a classe `Application.java`;

## Usando a Api

1. Via postman:
    Exemplo de Request:

    url: http://loclhost:8080/tariffs
    metodo: POST
    body (Json): {
	                  "origin": 11,
	                  "destiny": 17,
	                  "minutes": 80,
	                  "plan": 60
                  }

    Exemplo de Response:

    {
      "valueWithPlan": 37.40,
      "valueWithoutPlan": 136.00
    }             

2. Via Swegger:

    url: http://localhost:8080/swagger-ui.html

## Testando a Api

Executar as classes de testes `CalculateTariffServiceTests.java` e `CalculateTariffControllerTests.java` com o JUnit Test

## Contatos

[LinkedIn](https://www.linkedin.com/in/ricardohcl/)
[GitHub](https://github.com/RicardoHCL)
[Email](ricardolima.dev@gmail.com)
