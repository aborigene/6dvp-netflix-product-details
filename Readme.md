# O que é essa API?

Esta é uma API com o objetivo de prover detalhes de filmes. A API possui dois endpoints:

1. /api/movies_by_genre
2. /api/movie_search

O objetivo é permitir aos usuários pesquisas nas bases de filmes do serviço. Os endpoints retornam uma lista de filmes com base nos parâmetros informados via query string.

Toda a API está documentada via Swagger, estando a sua documentação de uso disponível em: http://<host do serviço>:<porta do serviço>/swagger-ui.html

## Como usar essa API?

Para construir a API basta executar o maven:

```
mvn clean package
```

Este comando irá compilar e testar a aplicação. Em seguida gerará o pacote jar para deploy. Para automatizar o deploy em containers deve-se usar o seguinte comando:

```
mvn clean install
```

Este comando irá fazer todo o processo de build da aplicação e em seguida construir a imagen Docker para deploy.

## TODO:

A API neste momento ainda não está autenticada, portanto não está pronta para produção. Quando a camada de autenticação for adicionada essa aplicação poderá se colocada em produção.