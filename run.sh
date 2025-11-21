#!/bin/bash
# Script para executar o Spring Boot carregando variáveis do .env

echo "🚀 Iniciando Spring Boot com Neon Database..."
echo "📡 Carregando variáveis de ambiente do arquivo .env"
echo ""

# Carregar variáveis do .env
if [ -f .env ]; then
  export $(cat .env | grep -v '^#' | xargs)
  echo "✅ Credenciais carregadas do .env"
  echo "   Host: $DB_HOST"
  echo "   Database: $DB_NAME"
  echo ""
else
  echo "❌ Arquivo .env não encontrado!"
  echo "   Copie .env.example para .env e configure suas credenciais"
  exit 1
fi

./mvnw spring-boot:run
