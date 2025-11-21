# 🔄 Guia de Migração: Supabase → Neon

## ✅ Arquivos Atualizados

- ✅ `.env.example` - Template com instruções do Neon
- ✅ `README.md` - Documentação atualizada para Neon
- ✅ `application.properties` - Configuração ajustada

## 📋 Próximos Passos

### 1. Obter Connection String do Neon

1. Acesse: https://console.neon.tech/
2. Selecione seu projeto
3. No Dashboard, copie a **Connection String** (PostgreSQL)

Exemplo:
```
postgresql://username:password@ep-something-123456.us-east-2.aws.neon.tech/neondb?sslmode=require
```

### 2. Extrair Credenciais da String

Da string acima, extraia:

```
Host:     ep-something-123456.us-east-2.aws.neon.tech
Port:     5432
Database: neondb
User:     username
Password: password
```

### 3. Atualizar o arquivo .env

Edite o arquivo `.env` com suas credenciais reais:

```bash
nano .env
```

Cole as credenciais:

```env
DB_HOST=ep-something-123456.us-east-2.aws.neon.tech
DB_PORT=5432
DB_NAME=neondb
DB_USER=seu_username
DB_PASSWORD=sua_senha
```

Salve: `Ctrl+O` + `Enter` + `Ctrl+X`

### 4. Testar Conectividade

```bash
# Testar porta aberta
timeout 5 bash -c "source .env && cat < /dev/null > /dev/tcp/\$DB_HOST/\$DB_PORT" && echo "✅ Conectado!" || echo "❌ Falhou"
```

### 5. Executar a Aplicação

```bash
./mvnw spring-boot:run
```

## 🎯 Vantagens do Neon

- ✅ **Suporte IPv4** - Funciona em qualquer rede
- ✅ **Serverless** - Escala automaticamente
- ✅ **Branching** - Crie branches do banco para testes
- ✅ **Free tier** - 3GB storage gratuito
- ✅ **Backups automáticos**

## ⚠️ Importante

Após a migração, suas tabelas precisarão ser recriadas no Neon.
O Hibernate fará isso automaticamente com `ddl-auto=update`.

## 🔗 Links Úteis

- Neon Console: https://console.neon.tech/
- Documentação: https://neon.tech/docs/
- pgAdmin 4: https://www.pgadmin.org/
