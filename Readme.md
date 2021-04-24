# O que é essa API?

Esta é uma API com o objetivo de prover detalhes de filmes. A API possui quatro endpoints:

1. /api/movies_by_genre
2. /api/movie_search
3. /api/getAll
4. /swagger-ui

O objetivo é permitir aos usuários pesquisas nas bases de filmes do serviço. Os endpoints retornam uma lista de filmes com base nos parâmetros informados via query string.

Toda a API está documentada via Swagger, estando a sua documentação de uso disponível em: http://<host do serviço>:<porta do serviço>/swagger-ui.html

# Como usar essa API?

# Variáveis de ambiente.
## Configurações do MySQL
DB_SERVER = Servidor do MySQL

DB_PORT = Porta do servidor

DB_USERNAME =Usuário

DB_PASSWORD =Senha

## Configurações do RabbitMQ
MQ_SERVER = Servidor do RabbitMQ

MQ_PORT = Porta do servidor

MQ_USERNAME =Usuário

MQ_PASSWORD =Senha

## Dump Mysql
Restaurar o arquivo de backup product-details-db.sql localizado na pasta /data

## Execução Docker
docker build -t 6dvp-netflix/product-details:v1.0.0 .

docker run --name product-details -d -p 8092:8092 -e DB_SERVER=xxx.xxx.xxx.xxx -e DB_PORT=3308 -e DB_USERNAME=xxx -e DB_PASSWORD=xxx -e MQ_SERVER=xxx.xxx.xxx.xxx -e MQ_PORT=5672 -e MQ_USERNAME=xxx -e MQ_PASSWORD=xxx dvp-netflix/product-details:v1.0.0
