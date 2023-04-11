# Drone-Feeder
Este projeto foi desenvolvido como desafio final do curso de Java da Trybe. Em parceria com o Hub Floripa, o objetivo é construir um sistema de entrega de pacotes utilizando drones.

## Funcionamento
O sistema consiste em uma API REST que permite o cadastro de drones, clientes e pacotes. Os drones são responsáveis por buscar e entregar os pacotes nos endereços cadastrados pelos clientes. A API utiliza o framework Spring Boot e banco de dados MySQL.

## Tecnologias utilizadas
* Java 11
* Spring Boot 2.5.5
* Maven
* MySQL 8
* Docker

## Configuração do ambiente

### Para rodar o projeto em sua máquina, você precisa ter instalado:
* Java 11
* Docker

### Além disso, você precisa criar um banco de dados MySQL com as seguintes credenciais:
- Host: localhost
- Port: 3306
- Database: drone_feeder
- Username: root
- Password: root

Você pode usar o seguinte comando para criar o banco de dados:

```bash
docker run --name mysql-df -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=drone_feeder -p 3306:3306 -d mysql:8
```

Após criar o banco de dados, você pode rodar o projeto com o seguinte comando:

```bash
./mvnw spring-boot:run
```

O projeto estará rodando em http://localhost:8080.

## Rodando o projeto em Docker

Você pode rodar o projeto em um container Docker usando o seguinte comando:

```bash
docker build -t drone-feeder .
```

```bash
docker run -p 8080:8080 --name drone-feeder --link mysql-df:mysql -d drone-feeder
```

## Testes

Para rodar os testes do projeto, execute o seguinte comando:

```bash
./mvnw test
```

Os testes incluem tanto testes unitários quanto testes de integração.

## Autores

- [@DaniellaZuccolotto](https://github.com/DaniellaZuccolotto)
- [@monteiroMS](https://github.com/monteiroMS)
- [@RamonaS2](https://github.com/RamonaS2)

## Contribuição
Esse é um projeto desenvolvido para fins educacionais. Contribuições são bem-vindas, mas lembre-se de respeitar o código de conduta do projeto.

## Licença
Esse projeto está sob a licença MIT. Consulte o arquivo LICENSE para mais detalhes.
