# API de Autenticação e Controle de Acesso com JWT e Spring Boot

Este projeto é uma API RESTful desenvolvida com Spring Boot que demonstra um sistema de autenticação e controle de acesso baseado em roles (ADMIN, USER) utilizando JSON Web Tokens (JWT).

## Funcionalidades Principais

  - **Autenticação Segura:** Endpoint de login que retorna um token JWT para autenticação nas requisições subsequentes.
  - **Controle de Acesso por Role:**
      - **ADMIN:** Acesso total ao sistema, incluindo listar, visualizar, editar e deletar qualquer usuário.
      - **USER:** Acesso limitado, podendo visualizar e editar apenas o seu próprio perfil.
  - **Endpoints Protegidos:** Rotas da API protegidas de acordo com a role do usuário autenticado.
  - **Registro de Novos Usuários:** Endpoint público para criação de novas contas de usuário.

## Tecnologias Utilizadas

  - **Java 17**
  - **Spring Boot 3**
  - **Spring Security:** Para a camada de segurança e autenticação.
  - **Spring Data JPA:** Para persistência de dados.
  - **H2 Database:** Banco de dados em memória para ambiente de desenvolvimento e testes.
  - **JSON Web Token (JJWT):** Para geração e validação dos tokens.
  - **Lombok:** Para reduzir código boilerplate em entidades e DTOs.
  - **Maven:** Para gerenciamento de dependências.

## Configuração do Ambiente

### Pré-requisitos

  - JDK 17 ou superior.
  - Maven 3.8 ou superior.
  - Sua IDE favorita (IntelliJ, VSCode, Eclipse).
  - [Postman](https://www.postman.com/downloads/) ou outra ferramenta para testar a API.

### Como Rodar o Projeto

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/albukerk1/JwtSecurity.git
    cd JwtSecurity
    ```

2.  **Compile o projeto com o Maven:**

    ```bash
    mvn clean install
    ```

3.  **Execute a aplicação:**

      - Pela sua IDE, localize a classe `JwtDemoApplication.java` e execute o método `main`.
      - Ou pelo terminal, execute o comando:
        ```bash
        mvn spring-boot:run
        ```

A aplicação estará disponível em `http://localhost:8080`.

## Como Usar a API

Ao iniciar, a aplicação cria dois usuários padrão:

  - **Admin:** `username: admin`, `password: admin123`
  - **User:** `username: user`, `password: user123`

### Testando os Endpoints com o Postman

#### 1\. Autenticação

Para acessar os endpoints protegidos, primeiro obtenha um token de autenticação.

**Endpoint:** `POST /api/auth/login`

**Body:**

```json
{
    "username": "admin",
    "password": "admin123"
}
```

**Resposta:**

```json
{
    "token": "exemployJhbGciOiJIUzI1NiJ9..."
}
```

**Copie o token** para usar nas requisições seguintes.

#### 2\. Autorização

Para as requisições autenticadas, adicione o token no cabeçalho, pela aba Authorization:

  - **Auth Type:** `Bearer Token`
  - **Token:** `exemployJhbGciOiJIUzI1NiJ9... (nesse campo você deve inserir o token que copiou anteriormente)`

### Lista de Endpoints

| Método | Endpoint                    | Descrição                                 | Acesso       |
| :----- | :-------------------------- | :---------------------------------------- | :----------- |
| `POST` | `/api/auth/login`           | Autentica um usuário e retorna um token.  | Público      |
| `POST` | `/api/auth/register`        | Registra um novo usuário.                 | Público      |
| `GET`  | `/api/users`                | Lista todos os usuários.                  | **ADMIN** |
| `GET`  | `/api/users/{id}`           | Busca um usuário por ID.                  | **ADMIN** |
| `GET`  | `/api/users/me`             | Retorna os dados do usuário logado.       | **USER**, **ADMIN** |
| `PUT`  | `/api/users/{id}`           | Atualiza um usuário.                      | **USER** (apenas o seu), **ADMIN** (qualquer um) |
| `DELETE`| `/api/users/{id}`           | Deleta um usuário.                        | **ADMIN** |

-----

Espero que este `README.md` seja útil para o seu projeto\!
