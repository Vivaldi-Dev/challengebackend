# 🌍 Country API - Spring Boot

API RESTful para gestão de informações de países, desenvolvida em **Spring Boot** com persistência em banco relacional e containerizada com **Docker** e **Docker Compose**.

---

## 📌 Funcionalidades

- ✅ Criar um novo país (com nome, capital, região, sub-região e área)
- ✅ Listar todos os países cadastrados
- ✅ Atualizar informações de um país existente
- ✅ Eliminar um país
- ✅ Ordenar a lista de países por qualquer propriedade (`nome`, `capital`, `regiao`, `subRegiao`, `area`)
- ✅ Validação para evitar países duplicados
- ✅ Tratamento de erros com respostas apropriadas

---

## 🛠️ Tecnologias utilizadas

- **Java 17**
- **Spring Boot 3.5.5**
- **Spring Data JPA**
- **Spring Web**
- **Lombok**
- **PostgreSQL**
- **Docker & Docker Compose**
- **Maven**

---

## 🚀 Como executar

### 🐳 **Executar com Docker **

```bash
# 1. Executar com Docker Compose
docker-compose up --build

# 2. Ou executar em background
docker-compose up -d --build
```

**Serviços com Docker:**
- 🌐 **Aplicação**: http://localhost:8080
- 🗄️ **PostgreSQL**: localhost:5432
- 📊 **Banco de dados**: `challenge_db`
- 👤 **Usuário**: `postgres`
- 🔑 **Senha**: `password`

---

### 💻 **Executar localmente (sem Docker)**

```bash

CREATE DATABASE challenge_db;
CREATE USER postgres WITH PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE challenge_db TO postgres;


./mvnw spring-boot:run
```

**Configuração do PostgreSQL local:**
```properties

spring.datasource.url=jdbc:postgresql://localhost:5432/challenge_db
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

**Variáveis de ambiente suportadas:**
- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- `SPRING_JPA_HIBERNATE_DDL_AUTO`

---

## ⚡ Endpoints

### 📝 Criar país
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
```

### 📋 Listar todos os países
```http
GET /api/countries
```

### 🔍 Listar países ordenados
```http
GET /api/countries?sortBy=nome
GET /api/countries?sortBy=capital
GET /api/countries?sortBy=area
```

### 🔎 Buscar país por ID
```http
GET /api/countries/{id}
```

### ✏️ Atualizar país
```http
PUT /api/countries/{id}
Content-Type: application/json

{
  "nome": "Brasil",
  "capital": "Brasília",
  "regiao": "América do Sul",
  "subRegiao": "América Latina",
  "area": 8515767.0
}
```

### 🗑️ Deletar país
```http
DELETE /api/countries/{id}
```

---

## 📊 Exemplo de Respostas

### ✅ Sucesso (201 Created):
```json
{
  "id": 1,
  "nome": "Brasil",
  "capital": "Brasília",
  "regiao": "América do Sul",
  "subRegiao": "América Latina",
  "area": 8515767.0
}
```

### ❌ Conflito (409 Conflict):
```json
{
  "timestamp": "2024-01-15T10:00:00.000",
  "status": 409,
  "error": "Conflict",
  "message": "Country with the same name already exists",
  "path": "/api/countries"
}
```

### ❌ Não encontrado (404 Not Found):
```json
{
  "timestamp": "2024-01-15T10:00:00.000",
  "status": 404,
  "error": "Not Found",
  "message": "País não encontrado",
  "path": "/api/countries/999"
}
```

## 👨‍💻 Desenvolvido por

Vivaldi Afonso Nobela Jr - nobelavivaldi@gmail.com

---