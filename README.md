# Projeto mongoDB e Spring
<hr>
   <img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=RED&style=for-the-badge"/>
   
## Descrição do projeto
Criar uma aplicação Java que representa postagens. Essas postagens possuem um autor e 0..x comentários possíveis.

Para construir essa aplicação, foi utilizado um banco de dados não relacional, pois este possui maior velocidade executando consultas simples e mapeamento mais simplório.
O post está aninhado com os comentários e referenciado pelo autor.

## Modelo conceitual
No modelo a seguir, temos a representação UML dos documentos e relacionamentos dentro dessa aplicação.

![image](https://user-images.githubusercontent.com/84423626/213741009-fbcc8047-4ea7-464b-b34b-4719f36713a0.png)

## Instâncias
Abaixo, temos o diagrama que representa a relação de instanciação entre as classes. 


## Funcionalidades
- Funcionalidade 1: GET dos usuários, posts por ID, titulo e por palavras.

- Funcionalidade 2: POST de autores.

- Funcionalidade 3: DELETE de autores.

- Funcionalidade 3: UPDATE (PUT) de autores.

## End points

<strong> (GET) e (POST) de usuários </strong> <br>

    http://localhost:8080/users
    
<strong> (GET) usuários por id </strong> <br>

    http://localhost:8080/users/{id}
    
<strong> (PUT) e (DELETE) de um usuário </strong> <br>

    http://localhost:8080/users/{id}
    
<strong> (GET) pesquisa um post utilizando um texto dentro de um período minimo e máximo

    http://localhost:8080/posts/searchbytitle?text={texto}

Consulte os demais end points nas [classes de recursos de cada entidade.](https://github.com/RonaldAG/projeto-mongodb-spring/blob/main/src/main/java/com/ronaldgarcia/workshopmongo/resources/PostResource.java)
    

## Tecnologias utilizadas

<strong> Linguagem: </strong> <br>

<a href="https://www.java.com" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a>

<strong> Frameworks: </strong> <br>

<a href="https://spring.io.com" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg" alt="spring" width="40" height="40"/>  </a>
<a href="https://www.postman.com/" target="_blank"> <img src="https://www.logolynx.com/images/logolynx/84/84b61060699fcac2ac5e915d71ea8567.jpeg" alt="postman" width="40" height="40"/>  </a>


## Acesso ao projeto

Você pode [acessar o código fonte do projeto](https://github.com/RonaldAG/projeto-mongodb-spring).
