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
- **PostgreSQL (Neon)** - Banco de dados relacional serverless na nuvem
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
- Conta no Neon (gratuita) com banco de dados criado
- Git (para clonar o repositório)
- pgAdmin 4 (opcional, para gerenciamento visual do banco)

### Passo a Passo

1. **Clone o repositório**
```bash
git clone <url-do-repositorio>
cd spring-test
```

2. **Configure o banco de dados Supabase**

Este projeto utiliza o **Supabase** como banco de dados PostgreSQL na nuvem, permitindo acesso de qualquer PC.

#### 📍 Como obter as credenciais do Supabase:

1. Acesse o [Supabase Dashboard](https://app.supabase.com/)
2. Selecione seu projeto
3. No menu lateral, vá em **Settings** → **Database**
4. Na seção **Connection String**, escolha a aba **Connection String** ou **Connection Info**
5. Copie as informações:
   - **Host**: algo como `db.xxxxxxxxxxxx.supabase.co`
   - **Port**: `5432`
   - **Database name**: geralmente `postgres`
   - **User**: geralmente `postgres`
   - **Password**: a senha definida na criação do projeto

#### 🔐 Configurar variáveis de ambiente localmente:

1. Copie o arquivo de exemplo:
```bash
cp .env.example .env
```

2. Edite o arquivo `.env` com suas credenciais reais do Neon:
```env
DB_HOST=ep-something-123456.us-east-2.aws.neon.tech
DB_PORT=5432
DB_NAME=neondb
DB_USER=seu_username
DB_PASSWORD=sua_senha_real_aqui
```

⚠️ **IMPORTANTE**: O arquivo `.env` está no `.gitignore` e **não deve ser versionado** no Git (contém dados sensíveis).

#### 🔒 Sobre SSL/TLS no Neon:

O Neon **requer conexão SSL** obrigatoriamente. A string de conexão já está configurada com `?sslmode=require`:

```
jdbc:postgresql://[HOST]:[PORT]/[DATABASE]?sslmode=require
```

3. **Execute a aplicação**

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

4. **Acesse a aplicação**

A aplicação estará disponível em: `http://localhost:8080`

---

## 🗄️ Gerenciamento do Banco com pgAdmin 4

Você pode gerenciar o banco Neon visualmente usando o pgAdmin 4:

### Conectar no pgAdmin 4:

1. Abra o pgAdmin 4
2. Clique com o botão direito em **Servers** → **Register** → **Server**
3. Na aba **General**:
   - **Name**: `Neon - meubanco` (ou nome de sua preferência)
4. Na aba **Connection**:
   - **Host name/address**: `ep-something-123456.region.aws.neon.tech` (seu endpoint do Neon)
   - **Port**: `5432`
   - **Maintenance database**: `neondb` (ou nome do seu database)
   - **Username**: seu username do Neon
   - **Password**: sua senha do Neon
   - ✅ Marque **Save password**
5. Na aba **SSL**:
   - **SSL mode**: `Require`
6. Clique em **Save**

Agora você pode visualizar e gerenciar todas as tabelas, executar queries SQL e muito mais pelo pgAdmin!

### 📊 String de Conexão JDBC (para referência):

```
jdbc:postgresql://[HOST]:[PORT]/[DATABASE]?sslmode=require
```

Exemplo real:
```
jdbc:postgresql://ep-something-123456.us-east-2.aws.neon.tech:5432/neondb?sslmode=require
```

---

## 🔄 Trabalhando em Múltiplos PCs

Como o banco está no Neon (nuvem), você pode trabalhar de qualquer PC:

1. Clone o repositório no novo PC
2. Crie o arquivo `.env` com as mesmas credenciais do Neon
3. Execute normalmente

✅ **Vantagens**:
- Banco de dados único e centralizado
- Sem necessidade de sincronizar dados entre PCs
- Acesso de qualquer lugar com internet
- Backups automáticos e branching (feature do Neon)
- Suporte completo a IPv4 (sem problemas de conectividade)

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
