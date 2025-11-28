<h1 align="center">Application de CRUD com JPA e Spring Boot</h1>
<p align="center"><i>Projeto CRUD completo utilizando Spring Data JPA, MySQL Database, Spring Web</i></p>

##  About this project
Este é um repositório usando para persistência de dados, busca, deleção e manipulação com Spring Web. 

Sendo uma aplicação web completa para expor dados de um dado por meio da API Rest ou por meio de páginas dinâmicas. Nessa arquitetura, o Spring Web cuida da camada de apresentação e da lógica de negócios, enquanto o Spring Data JPA gerencia a persistência de dados no banco de dados.

### Technologies
<p display="inline-block">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40" alt="java logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40" alt="spring logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original.svg" height="40" alt="docker logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/insomnia/insomnia-original.svg" height="40" alt="insomnia logo"  />
</p>

- Java (21)
- Spring Boot (3.5.6)
- Spring Data JPA
- Spring Web
- H2 Database
- Maven
- Insomnia ou Postman (Aplicativos que interagem com serviçoes da API, para criar e enviar requisições HTTP)

Banco de Dados
- H2

Gerenciamente de Contêineres
- Docker

### Development Tools
<p display= "inline-block">
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" height="40" alt="intellij logo"  />
</p>

## Funcionalidades
O que o usuário pode fazer?
- Create: Criar/Cadastrar novos itens
- Read: Listar todos os itens e Buscar item por ID
- Update: Atualizar informações de um item existente
- Delete: Excluir um item

## Pré-Requisitos
- Java Development Kit (JDK) - versão 21 ou inferior
- Uma IDE (Intellij IDEA, Eclipse, VS code)
- H2 rodando em memória
- Insomnia ou Postman: Criar e enviar requisições HTTP

## Running
### 1 Clonar o repositório do Github
```
git clone https://github.com/astonishiing/JPA-CRUD-Spring_Boot.git
```

### 2 Configurando o banco de dados

1. Abra o Docker
2. Abra a pasta a qual você clonou o repositorio diretamente no Git
Execute o comando:
```
docker-compose up
```

Caso ocorra error, verifique se está na pasta do repositório que foi clonado; 

Repita o procedimento novamente desde o inicio (Feche o Docker e o git e repita o procedimento) e utilize o comando:

```
docker-compose up -d
```

3. Compile o projeto

No terminal irá aparecer:

```
Hibernate: create table tb_users...
```
Se aparecer isso o seu banco de dados foi criado e também as suas colunas

### 3 Endpoints da API

- Abra o Insomnia ou Postman para fazer as requisições

| Método | Endpoint | Descrição | Corpo da Requisição (JSON) |
| :---: | :--- | :--- | :--- |
| **GET** | `/v1/users` | Lista todos os itens cadastrados. | *(Nenhum)* |
| **GET** | `/v1/users/{id}` | Busca um item específico pelo ID. | *(Nenhum)* |
| **POST** | `/v1/users` | **Cria (Cadastra)** um novo item. | `{"nome": "...", "descricao": "..."}` |
| **PUT** | `/v1/users/{id}` | **Atualiza** o item com o ID especificado. | `{"nome": "...", "descricao": "..."}` |
| **DELETE** | `/v1/users/{id}` | **Exclui** o item com o ID especificado. | *(Nenhum)* |

## References
[Documentação - MySQL Data (Spring)](https://spring.io/guides/gs/accessing-data-mysql)

[Documentação - Docker Compose](https://docs.docker.com/compose)

[Documentação - Spring Boot](https://spring.io/projects/spring-boot)

[Documentação - Thyleaf](https://www.thymeleaf.org/doc/tutorials/3.1/thymeleafspring.html)

Youtube
