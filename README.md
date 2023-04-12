# Drone-Feeder 🛰
Este projeto foi desenvolvido como desafio final do curso de Java da Trybe em parceria com o Hub Floripa. O objetivo é construir um sistema de entrega de pacotes utilizando drones.

## Funcionamento
O sistema consiste em uma API REST implementada atraves de um CRUD que permite o cadastro de drones, entregas e upload de vídeos. A API utiliza o framework Spring Boot e banco de dados MySQL.

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

Você pode usar o seguinte comando para criar o banco de dados e rodar o projeto:

```bash
docker-compose up -d
```

O projeto estará rodando em http://localhost:8080.

## Testes

Para rodar os testes do projeto, execute o seguinte comando:

```bash
mvn test
```

## Schemas

#### Entregas

| Método | Funcionalidade | URL |
|---|---|---|
| `GET` | Retorna todos as entregas cadastradas | http://localhost:8080/entregas |
| `GET` | Retorna uma entrega cadastrada conforme id | http://localhost:8080/entregas/{id} |
| `POST` | Criação de uma nova entrega | http://localhost:8080/entregas |
| `PUT` | Atualiza a entrega | http://localhost:8080/entregas/{id} |
| `DELETE` | Deleta uma entrega | http://localhost:8080/entregas/{id} |

Nessa requisição POST e PUT é necessário informar o seguinte JSON:

```
{
  "dataHora": LocalDateTime.now(),
  "video": "nomeDoVideo.mp4",
  "status": "Entregue",
  "drone": new Drone,
}

```

#### Drone

| Método | Funcionalidade | URL |
|---|---|---|
| `GET` | Retorna todos os drones cadastradas | http://localhost:8080/drones |
| `GET` | Retorna um drone cadastrada conforme id | http://localhost:8080/drones/{id} |
| `POST` | Criação de um novo drone | http://localhost:8080/drones |
| `PUT` | Atualiza o drone | http://localhost:8080/drones/{id} |
| `DELETE` | Deleta um drone | http://localhost:8080/drones/{id} |

Nessa requisição POST e PUT é necessário informar o seguinte JSON:

```
{
  "nome": "nomeDoDrone"
  "latitude": "10.45"
  "longitude": "20.45"
}
```

#### Video

| Método | Funcionalidade | URL |
|---|---|---|
| `GET` | Retorna todos os videos cadastradas | http://localhost:8080/videos |
| `GET` | Faz o download do video cadastrado conforme o nome | http://localhost:8080/{nome} |
| `POST` | Faz o upload do video | http://localhost:8080/videos |

Nessa requisição POST é necessário fazer os seguintes passo a passo

```
- Enviar arquivo por meio de form-data
- Nome da chave: "file"
- Arquivo de vídeo não pode conter mais de 1MB de tamanho.
```

## Autores

- [@DaniellaZuccolotto](https://github.com/DaniellaZuccolotto)
- [@monteiroMS](https://github.com/monteiroMS)
- [@RamonaS2](https://github.com/RamonaS2)

## Contribuição
Esse é um projeto desenvolvido para fins educacionais. Contribuições são bem-vindas, mas lembre-se de respeitar o código de conduta do projeto.
