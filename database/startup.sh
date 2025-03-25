#!/bin/sh

echo "Aguardando MySQL ficar disponível..."

until nc -z -v -w30 db-mysql 3306
do
  echo "Aguardando conexão com db-mysql:3306..."
  sleep 3
done

echo "MySQL está disponível! Subindo aplicação..."

exec java -jar -XX:+UseContainerSupport /aplicacao.jar