# 📚 Projeto de Estudo - Spring Boot

## 📋 Sobre o Projeto

Este é um projeto acadêmico desenvolvido para fins de **estudo e aprendizado do framework Spring Boot**. O objetivo é explorar e implementar os principais conceitos do ecossistema Spring, como Injeção de Dependências, REST APIs, Spring Data JPA e arquitetura MVC.

## 🎯 Objetivos de Aprendizado

- ✅ Compreender a estrutura básica de uma aplicação Spring Boot
- ✅ Implementar APIs RESTful seguindo boas práticas
- ✅ Utilizar Spring Data JPA para persistência de dados
- ✅ Aplicar os conceitos de inversão de controle (IoC) e injeção de dependências (DI)
- ✅ Seguir a arquitetura em camadas (Controller → Service → Repository)
- ✅ Integrar com banco de dados PostgreSQL

## 🛠️ Tecnologias Utilizadas

- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.7** - Framework principal
- **Spring Web** - Para criação de APIs REST
- **Spring Data JPA** - Para persistência e acesso a dados
- **PostgreSQL** - Banco de dados relacional
- **Maven** - Gerenciamento de dependências
- **Spring DevTools** - Para desenvolvimento com hot reload

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── estudo/
│   │           ├── EstudoApplication.java      # Classe principal
│   │           ├── controller/                  # Camada de controle (endpoints REST)
│   │           │   └── MensagemController.java
│   │           ├── service/                     # Camada de lógica de negócio
│   │           │   ├── MensagemService.java
│   │           │   └── ProdutoService.java
│   │           ├── repository/                  # Camada de acesso a dados
│   │           │   ├── MensagemRepository.java
│   │           │   └── ProdutoRepository.java
│   │           └── model/                       # Entidades do domínio
│   │               └── Produto.java
│   └── resources/
│       ├── application.properties               # Configurações da aplicação
│       ├── static/                              # Arquivos estáticos
│       └── templates/                           # Templates (se aplicável)
└── test/                                        # Testes unitários e de integração
```

## 🚀 Como Executar

### Pré-requisitos

- Java 21 ou superior instalado
- Maven instalado
- PostgreSQL instalado e em execução
- Git (para clonar o repositório)

### Passo a Passo

1. **Clone o repositório**
```bash
git clone <url-do-repositorio>
cd spring-test
```

2. **Configure o banco de dados**

Edite o arquivo `src/main/resources/application.properties` com suas credenciais do PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/estudo_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. **Crie o banco de dados**
```bash
psql -U postgres
CREATE DATABASE estudo_db;
\q
```

4. **Execute a aplicação**

Com Maven Wrapper (Linux/Mac):
```bash
./mvnw spring-boot:run
```

Com Maven Wrapper (Windows):
```bash
mvnw.cmd spring-boot:run
```

Ou com Maven instalado:
```bash
mvn spring-boot:run
```

5. **Acesse a aplicação**

A aplicação estará disponível em: `http://localhost:8080`

## 📚 Conceitos do Spring Estudados

### 1. **Injeção de Dependências**
O Spring gerencia automaticamente as dependências entre as classes usando `@Autowired` ou injeção via construtor.

### 2. **Arquitetura em Camadas**
- **Controller**: Recebe requisições HTTP e retorna respostas
- **Service**: Contém a lógica de negócio
- **Repository**: Faz a comunicação com o banco de dados
- **Model**: Representa as entidades do domínio

### 3. **Annotations Principais**
- `@SpringBootApplication`: Marca a classe principal da aplicação
- `@RestController`: Define um controlador REST
- `@Service`: Define uma classe de serviço
- `@Repository`: Define um repositório de dados
- `@Entity`: Marca uma classe como entidade JPA
- `@GetMapping`, `@PostMapping`, etc.: Mapeiam endpoints HTTP

### 4. **Spring Data JPA**
Interface que estende `JpaRepository` para operações CRUD automáticas no banco de dados.

## 🧪 Executando Testes

```bash
./mvnw test
```

## 📖 Exemplos de Endpoints

### Hello World
```bash
GET http://localhost:8080/
```

### Mensagens (exemplo)
```bash
GET http://localhost:8080/api/mensagens
POST http://localhost:8080/api/mensagens
```

### Produtos (exemplo)
```bash
GET http://localhost:8080/api/produtos
POST http://localhost:8080/api/produtos
```

## 🤝 Contribuindo

Este é um projeto de estudo, mas sugestões e melhorias são bem-vindas! Sinta-se à vontade para:

1. Fazer um fork do projeto
2. Criar uma branch para sua feature (`git checkout -b feature/NovaFuncionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/NovaFuncionalidade`)
5. Abrir um Pull Request

## 📝 Recursos para Estudo

- [Documentação Oficial do Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Guides](https://spring.io/guides)
- [Baeldung - Spring Tutorials](https://www.baeldung.com/spring-tutorial)
- [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)

## 📄 Licença

Este projeto é de código aberto e está disponível para fins educacionais.

## ✨ Autor

Projeto desenvolvido como parte dos estudos acadêmicos de Spring Boot e desenvolvimento de aplicações Java.

---

⭐ **Dica**: Este README também faz parte do aprendizado! Manter uma boa documentação é essencial em qualquer projeto de software.
