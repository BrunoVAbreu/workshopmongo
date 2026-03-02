[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[MONGO_BADGE]:https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white

<h1 align="center" style="font-weight: bold;">Workshop MongoDB 📝</h1>

![java][JAVA_BADGE]
![spring][SPRING_BADGE]
![mongo][MONGO_BADGE]

<details open="open">
<summary>Índice</summary>

- [🚀 Como executar](#started)
  - [Pré-requisitos](#prerequisites)
  - [Clonando](#cloning)
  - [Variáveis de Ambiente](#env)
  - [Iniciando](#starting)
- [📍 Endpoints da API](#routes)
  - [Usuários](#users)
  - [Posts](#posts)

</details>

<p align="center">
  <b>Uma API RESTful desenvolvida com Spring Boot e MongoDB. Permite gerenciar usuários e seus posts, com suporte a comentários embutidos nos documentos, explorando o modelo orientado a documentos do MongoDB.</b>
</p>

<h2 id="started">🚀 Como executar</h2>

<h3 id="prerequisites">Pré-requisitos</h3>

- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/)
- [MongoDB](https://www.mongodb.com/try/download/community) rodando localmente na porta `27017`
- [Git](https://git-scm.com/)

<h3 id="cloning">Clonando</h3>

```bash
git clone https://github.com/BrunoVAbreu/workshopmongo.git
```

<h3 id="env">Variáveis de Ambiente</h3>

Verifique o arquivo `src/main/resources/application.properties` e confirme que o MongoDB está acessível:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo
```

<h3 id="starting">Iniciando</h3>

```bash
cd workshopmongo
./mvnw spring-boot:run
```

A aplicação será iniciada em `http://localhost:8080`.

> Certifique-se de que o serviço do MongoDB está em execução antes de iniciar a aplicação.

<h2 id="routes">📍 Endpoints da API</h2>

### Usuários

| Rota | Descrição |
|------|-----------|
| `GET /users` | Lista todos os usuários |
| `GET /users/{id}` | Busca usuário por ID |
| `GET /users/{id}/posts` | Lista todos os posts de um usuário |
| `POST /users` | Cria um novo usuário |
| `PUT /users/{id}` | Atualiza um usuário |
| `DELETE /users/{id}` | Remove um usuário |

**POST /users — Requisição**
```json
{
  "name": "João Silva",
  "email": "joao@email.com"
}
```

**GET /users/{id} — Resposta**
```json
{
  "id": "64b1f2c3e4b0a1d2e3f4a5b6",
  "name": "João Silva",
  "email": "joao@email.com"
}
```

**GET /users/{id}/posts — Resposta**
```json
[
  {
    "id": "64b1f2c3e4b0a1d2e3f4a5b7",
    "date": "2024-01-01T10:00:00.000+00:00",
    "title": "Meu primeiro post",
    "body": "Conteúdo do post",
    "author": {
      "id": "64b1f2c3e4b0a1d2e3f4a5b6",
      "name": "João Silva"
    },
    "comments": []
  }
]
```

---

### Posts

| Rota | Descrição |
|------|-----------|
| `GET /posts/{id}` | Busca post por ID |

**GET /posts/{id} — Resposta**
```json
{
  "id": "64b1f2c3e4b0a1d2e3f4a5b7",
  "date": "2024-01-01T10:00:00.000+00:00",
  "title": "Meu primeiro post",
  "body": "Conteúdo do post",
  "author": {
    "id": "64b1f2c3e4b0a1d2e3f4a5b6",
    "name": "João Silva"
  },
  "comments": [
    {
      "text": "Ótimo post!",
      "date": "2024-01-01T11:00:00.000+00:00",
      "author": {
        "id": "64b1f2c3e4b0a1d2e3f4a5b8",
        "name": "Maria Souza"
      }
    }
  ]
}
```
