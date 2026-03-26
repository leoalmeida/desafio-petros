# Pedra, Papel e Tesoura API

![Java](https://img.shields.io/badge/Java-17-007396)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-6DB33F)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-C71A36)

Aplicacao Java com Spring Boot que expoe uma API REST para jogar Pedra, Papel e Tesoura entre dois jogadores.

## Objetivo

Receber as jogadas de dois jogadores, comparar as regras do jogo e retornar o resultado da partida.

## Regras do jogo

- Pedra vence Tesoura
- Tesoura vence Papel
- Papel vence Pedra
- Jogadas iguais resultam em empate

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Maven
- JUnit 5
- Docker e Docker Compose

## Endpoint da API

Base path:

```text
/api/v1/PPT
```

Endpoint disponivel:

```http
POST /api/v1/PPT
```

### Exemplo de requisicao

```json
{
    "id": 1,
	"jogador1": "PAPEL",
	"jogador2": "pedra"
}
```

As jogadas aceitas sao:

- `PEDRA`
- `PAPEL`
- `TESOURA`

A entrada e case-insensitive, entao valores como `pedra`, `Pedra` e `PEDRA` sao aceitos.

### Exemplo de resposta

```json
{
	"id": 1,
	"dataHora": "2026-03-26T17:20:45.123456",
	"jogador1": "PAPEL",
	"jogador2": "PEDRA",
	"resultado": "Jogador 1 vence"
}
```

### Exemplo com curl

```bash
curl --request POST http://localhost:8080/api/v1/PPT \
	--header "Content-Type: application/json" \
	--data '{
        "id": 1,
		"jogador1": "TESOURA",
		"jogador2": "PAPEL"
	}'
```

## Exemplos de erro da API

### 1. Jogada invalida

Quando uma jogada nao pertence ao conjunto `PEDRA`, `PAPEL` ou `TESOURA`, a API responde com erro 400.

Exemplo de requisicao:

```json
{
    "id": 1,
	"jogador1": "LAGARTO",
	"jogador2": "PEDRA"
}
```

Resposta esperada:

```http
HTTP/1.1 400 Bad Request
Content-Type: application/json
```

Exemplo de corpo de resposta:

```json
{
	"timestamp": "2026-03-26T21:11:33.185",
	"status": 400,
	"error": "Bad Request",
	"message": "Corpo da requisicao invalido",
	"path": "/api/v1/PPT"
}
```

### 2. JSON malformado

Quando o corpo da requisicao nao e um JSON valido, a API responde com erro 400.

Exemplo de requisicao invalida:

```json
{
    "id": 1,
	"jogador1": "PEDRA",
	"jogador2": "TESOURA",
}
```

Resposta esperada:

```http
HTTP/1.1 400 Bad Request
Content-Type: application/json
```

Exemplo de corpo de resposta:

```json
{
	"timestamp": "2026-03-26T21:13:02.410",
	"status": 400,
	"error": "Bad Request",
	"message": "Erro de validacao",
	"path": "/api/v1/PPT",
	"fieldErrors": {
		"jogador2": "jogador2 e obrigatorio"
	}
}
```

## Como executar o projeto

### Pre-requisitos

- Java 17 instalado
- Maven 3.8+ ou uso do Maven Wrapper do projeto

### Executar localmente com Maven Wrapper

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

Por padrao, a aplicacao sobe em:

```text
http://localhost:8080
```

## Como executar os testes

No Windows:

```powershell
.\mvnw.cmd test
```

No Linux ou macOS:

```bash
./mvnw test
```

## Executar com Docker

O projeto possui `Dockerfile` e `docker-compose.yaml`.

Antes de subir com Docker Compose, crie um arquivo `.env` na raiz do projeto com as portas usadas pelo container:

```env
SPRING_PPT_GAME_LOCAL_PORT=8080
SPRING_PPT_GAME_DOCKER_PORT=8081
```

Depois execute:

```bash
docker compose up --build
```

Nesse modo, a porta exposta localmente sera definida por `SPRING_PPT_GAME_LOCAL_PORT`.

## Documentacao da API

Como o projeto usa Springdoc OpenAPI, a interface Swagger UI pode ser acessada apos subir a aplicacao em:

```text
http://localhost:8080/swagger-ui/index.html
```

## Estrutura basica do projeto

```text
src/main/java/com/example/demo
|-- controller
|-- dto
|-- service
```

## Possiveis respostas da partida

- `Empate`
- `Jogador 1 vence`
- `Jogador 2 vence`
