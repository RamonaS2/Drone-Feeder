# Drone-Feeder
Este projeto foi desenvolvido como desafio final do curso de Java da Trybe em parceria com o Hub Floripa. O objetivo é construir um sistema de entrega de pacotes utilizando drones.

## Funcionamento
O sistema consiste em uma API REST implementada atraves de um CRUD que permite o cadastro de drones, clientes e pacotes. Os drones são responsáveis por buscar e entregar os pacotes nos endereços cadastrados pelos clientes. A API utiliza o framework Spring Boot e banco de dados MySQL.

## Tecnologias utilizadas
* Java
* Spring Boot
* Maven
* MySQL
* Docker
* JUnit

## Configuração do ambiente

### Para rodar o projeto em sua máquina, você precisa ter instalado:
* Java 11
* Docker

### Além disso, você precisa criar um banco de dados MySQL:

Todas as credenciais do banco estão no arquivo secrets.properties

Você pode usar o seguinte comando para criar o banco de dados:

```bash
docker-compose up -d
```

Após criar o banco de dados, você pode rodar o projeto com o seguinte comando:

```bash
mvn spring-boot:run
```

O projeto estará rodando em http://localhost:8080.

## Testes

Para rodar os testes do projeto, execute o seguinte comando:

```bash
mvn test
```

## Autores

- [@DaniellaZuccolotto](https://github.com/DaniellaZuccolotto)
- [@monteiroMS](https://github.com/monteiroMS)
- [@RamonaS2](https://github.com/RamonaS2)

## Contribuição
Esse é um projeto desenvolvido para fins educacionais. Contribuições são bem-vindas, mas lembre-se de respeitar o código de conduta do projeto.
