
```markdown
# 🌍 Country API - Spring Boot

API RESTful para gestão de informações de países, desenvolvida em **Spring Boot** com persistência em banco relacional e containerizada com **Docker** e **Docker Compose**.

---

## 📌 Funcionalidades

- Criar um novo país (com nome, capital, região, sub-região e área).
- Listar todos os países cadastrados.
- Atualizar informações de um país existente.
- Eliminar um país.
- Ordenar a lista de países por qualquer propriedade (`nome`, `capital`, `regiao`, `subRegiao`, `area`).

---

## 🛠️ Tecnologias utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Lombok**
- **PostgreSQL** (pode ser substituído por MySQL se necessário)
- **Docker**
- **Docker Compose**

---

## 📂 Estrutura do Projeto

```

src/main/java/com/example/demo
│
├── controller
├── dto
├── mapper
├── model
├── repository
├── service
└── service/impl

````

---

## ⚡ Endpoints

### Criar país
```http
POST /api/countries
Content-Type: application/json

{
  "nome": "Moçambique",
  "capital": "Maputo",
  "regiao": "África",
  "subRegiao": "África Austral",
  "area": 801590.0
}
````

### Listar todos os países

```http
GET /api/countries
```

### Listar países ordenados por uma propriedade

```http
GET /api/countries?sortBy=nome
```

### Buscar país por ID

```http
GET /api/countries/{id}
```

### Atualizar país

```http
PUT /api/countries/{id}
Content-Type: application/json

{
  "nome": "Brasil",
  "capital": "Brasília",
  "regiao": "América",
  "subRegiao": "América do Sul",
  "area": 8515767.0
}
```

### Deletar país

```http
DELETE /api/countries/{id}
```

---

## ⚙️ Docker & Docker Compose

* Para rodar o projeto com Docker:

```bash
docker-compose up --build
```

* Serviço da aplicação acessível em: `http://localhost:8080`
* Banco de dados PostgreSQL em: `localhost:5432`

---

## 📄 Observações

* Validações de dados são aplicadas ao criar e atualizar países.
* Mensagens de erro são retornadas quando um país já existe ou quando campos obrigatórios estão ausentes.


