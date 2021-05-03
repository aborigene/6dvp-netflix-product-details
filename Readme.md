# O que é essa API?
Esta é uma API com o objetivo de prover detalhes de filmes. A API possui quatro endpoints:

1. /api/movies_by_genre
2. /api/movie_search
3. /api/getAll
4. /swagger-ui

O objetivo é permitir aos usuários pesquisas nas bases de filmes do serviço. Os endpoints retornam uma lista de filmes com base nos parâmetros informados via query string.

Toda a API está documentada via Swagger, estando a sua documentação de uso disponível em: http://<host do serviço>:<porta do serviço>/swagger-ui.html

# Como usar essa API?
## Variáveis de ambiente.
<p>Configurações do MySQL</p>
<p>DB_SERVER = <i>Servidor do MySQL</i></p>
<p>DB_PORT = <i>Porta do servidor</i></p>
<p>DB_USERNAME =<i>Usuário</i></p>
<p>DB_PASSWORD =<i>Senha</i></p>

<p>Configurações do RabbitMQ</p>
<p>MQ_SERVER = <i>Servidor do RabbitMQ</i></p>
<p>MQ_PORT = <i>Porta do servidor</i></p>
<p>MQ_USERNAME =<i>Usuário</i></p>
<p>MQ_PASSWORD =<i>Senha</i></p>

## Dump Mysql
<p>Restaurar o arquivo de backup <i>support-db.sql</i> localizado na pasta <i>/data</i></p>

## Execução Docker
<p>docker build -t 6dvp-netflix/product-details:v1.0.0 .</p>
<p>docker run --name product-details -d -p 8092:8092 -e DB_SERVER=xxx.xxx.xxx.xxx -e DB_PORT=3306 -e DB_USERNAME=xxx -e DB_PASSWORD=xxx -e MQ_SERVER=xxx.xxx.xxx.xxx -e MQ_PORT=5672 -e MQ_USERNAME=xxx -e MQ_PASSWORD=xxx dvp-netflix/support:v1.0.0</p>
