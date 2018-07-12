Projeto: desafio-bolao
Author: Solon Junior
Tecnologias: CDI, JSF, JPA, PrimeFacese e Postgres

Requerimentos

Este projeto foi projetado para ser executado com Java 8.0, Apache Tomcat 8.0, Banco de dados Postgres 9.5 ou versões superiores.

Antes executar o projeto:

Entre na pasta SQL e execute o script SQL_Inicial.sql em seu Postgres.

Acesse o arquivo persistence.xml na pasta \src\main\resources\META-INF\persistence.xml:
Altere o usuario e senha para acesso ao seu banco de dados.
 
Acesso para a aplicação
URL para acesso: http://localhost:8080/desafio-bolao/

Perfis de acesso Iniciais de acordo com o script sql:
Perfil admin: name: admin password: admin
Perfis Comuns: name: user1 password: user
			   name: user2 password: user
			   name: user3 password: user