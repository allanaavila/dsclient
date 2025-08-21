# CRUD de Clientes

Este é um projeto de desafio da Formação Desenvolvedor Moderno da DevSuperior. O projeto consiste em uma API REST completa de web services para acessar um recurso de clientes , contendo as cinco operações básicas de CRUD (Create, Read, Update, Delete).
O projeto deverá estar com um ambiente de testes configurado acessando o banco de dados H2, deverá usar Maven como gerenciador de dependência, e Java como linguagem.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Banco de Dados H2** (em memória)
- **Maven** (para gerenciamento de dependências)
- **Jackson**
- **Jakart Validation**

## Entidade Client
A entidade **Client** foi implementada conforme especificação do desafio.  

| Atributo    | Tipo      | Descrição             |
|-------------|-----------|-----------------------|
| **id**      | Long      | Chave primária        |
| **name**    | String    | Nome do cliente       |
| **cpf**     | String    | CPF do cliente        |
| **income**  | Double    | Renda                 |
| **birthDate** | LocalDate | Data de nascimento   |
| **children** | Integer   | Quantidade de filhos  |

---
  
## Como Executar o Projeto
Para executar o projeto, siga os seguintes passos:
1.  **Clone o repositório:**
   ```bash
    git clone [https://github.com/allanaavila/dsclient.git](https://github.com/allanaavila/dsclient.git)
   ```
2.  **Navegue até o diretório do projeto:**
    ```bash
    cd clientes
    ```
3.  **Execute a aplicação Spring Boot:**
    Você pode executar a aplicação a partir de sua IDE (como IntelliJ, VS Code) ou pelo terminal.

    ```bash
    # Pelo terminal usando Maven
    ./mvnw spring-boot:run
    ```
## Acessando o Banco de Dados

Com a aplicação em execução, você pode acessar o console web do H2 para visualizar as tabelas e os dados.

1.  Abra seu navegador e acesse: `http://localhost:8080/h2-console`
2.  Use as seguintes credenciais para se conectar:
    - **JDBC URL:** `jdbc:h2:mem:clientdb`
    - **User Name:** `sa`
    - **Password:** (deixe em branco)
3.  Clique em "Connect".

   Você verá as tabelas `TB_CLIENT`

## Checklist de Validação

- [x] **GET /clients/{id}** retorna cliente existente  
- [x] **GET /clients/{id}** retorna **404** para cliente inexistente  
- [x] **GET /clients** retorna listagem paginada corretamente  
- [x] **POST /clients** insere cliente válido  
- [x] **POST /clients** retorna **422** e mensagens personalizadas para dados inválidos  
- [x] **PUT /clients/{id}** atualiza cliente válido  
- [x] **PUT /clients/{id}** retorna **404** para cliente inexistente  
- [x] **PUT /clients/{id}** retorna **422** para dados inválidos  
- [x] **DELETE /clients/{id}** deleta cliente existente  
- [x] **DELETE /clients/{id}** retorna **404** para cliente inexistente  

## Tratamento de Exceções

- **ID não encontrado** → retorna **404 Not Found** (em GET / PUT / DELETE).  
- **Erro de validação** → retorna **422 Unprocessable Entity** com mensagens personalizadas:  
- Nome não pode ser vazio.  
- Data de nascimento não pode ser futura (`@PastOrPresent`).  

---

## Seed de Dados

O projeto já vem com um **seed** inicial de **10 clientes** cadastrados automaticamente no banco H2.  
Assim, é possível testar as funcionalidades de busca, atualização e deleção logo após subir a aplicação.

---

## Observação

O projeto está configurado com `.gitignore` para evitar salvar arquivos e pastas desnecessários no repositório, como:  
- `.idea/` (IntelliJ)  
- `.metadata/` (Eclipse)  
- `target/` (build Maven)  

---


👩‍💻 **Desenvolvido por Allana Ávila**
   
