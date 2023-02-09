# Projeto mongoDB e Spring
<hr>
   <img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=RED&style=for-the-badge"/>
   
## Descrição do projeto
Criar uma aplicação Java que representa postagens. Essas postagens possuem um autor e 0..x comentários possíveis.

Para construir essa aplicação, foi utilizado um banco de dados não relacional, pois este possui maior velocidade executando consultas simples e mapeamento mais simplório.
O post está aninhado com os comentários e referenciado pelo autor.

## Conceituação
Para desenvolver essa solução, foi necessário ter alguns novos conceitos estruturados. Eles são: **DTO, documentos referenciados e aninhados, query methods, tratamento de exceções.**

### DTO
Consiste em abstrair da entidade apenas as informações para a query. 
Dessa forma, cria-se uma nova classe apenas com os atributos que devem aparecer na requisição. Para que isso funcione, precisamos sobrescrever o construtor da nova classe de forma que receba a entidade como parâmetro. Observe abaixo uma das [DTO's implementadas.](https://github.com/RonaldAG/projeto-mongodb-spring/tree/main/src/main/java/com/ronaldgarcia/workshopmongo/dto)
```
public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
}
```
### Documentos aninhados x referenciados
O mongoDB se trata de um banco de dados orientado a documentos. Dentro da organização desse banco, podemos relacionar os documentos por referência ou aninhando-os.

#### Referencia
Quando um documento aponta para outro, não carregando as suas informações, apenas referenciando para o ID do relacionamento. Isso é possível através da anotação @DBRef, que está presente no [seguinte documento.](https://github.com/RonaldAG/projeto-mongodb-spring/blob/main/src/main/java/com/ronaldgarcia/workshopmongo/domain/User.java)
```	
    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();
```
#### Aninhados
Documento aninhado ocorre quando o primeiro possui uma cópia dos dados de seu relacionado. Isso não necessita de sintaxe, sendo executado por padrão toda vez que há um relacionamento entre documentos. Basta apenas incluir tal classe dentro de outra. 

### Query Methods
São os métodos presentes dentro da interface que implementa o [MongoRepository](https://github.com/RonaldAG/projeto-mongodb-spring/blob/main/src/main/java/com/ronaldgarcia/workshopmongo/repositories/PostRepository.java). Podemos consultar algumas implementações já estipuladas na documentação do MongoDB, como a utilizada no seguinte código:
```
    List<Post> findByTitleContainingIgnoreCase(String text); 
```
Como também é possível **criar** query methods, utilizando a anotação `@query`, como podemos oberservar abaixo.
```
    @Query("{ title: { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);
```
#### Documentação
- Sintaxe pre-definida
- Criar uma query personalizada  

### Tratamento de Exceções
#### Classe standard error
Criar uma [classe](https://github.com/RonaldAG/projeto-mongodb-spring/blob/main/src/main/java/com/ronaldgarcia/workshopmongo/resources/exceptions/StandardError.java) que tenha todas as informações necessárias para imprimir .json

#### Classe que controla as exceções
Criar uma [classe de controle](https://github.com/RonaldAG/projeto-mongodb-spring/blob/main/src/main/java/com/ronaldgarcia/workshopmongo/resources/exceptions/ResourceExceptionHandler.java) que capta essas exceções lançadas e imprime o corpo pré-definido.


## Modelo conceitual
No modelo a seguir, temos a representação UML dos documentos e relacionamentos dentro dessa aplicação.

![image](https://user-images.githubusercontent.com/84423626/217807418-e0825ef0-a500-4025-8665-aa387d2b0115.png)


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

Consulte os demais end points nas [classes de recursos de cada entidade.](https://github.com/RonaldAG/projeto-mongodb-spring/blob/main/src/main/java/com/ronaldgarcia/workshopmongo/resources)
    

## Tecnologias utilizadas

<strong> Linguagem: </strong> <br>

<a href="https://www.java.com" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a>

<strong> Frameworks: </strong> <br>

<a href="https://spring.io.com" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg" alt="spring" width="40" height="40"/>  </a>
<a href="https://www.postman.com/" target="_blank"> <img src="https://www.logolynx.com/images/logolynx/84/84b61060699fcac2ac5e915d71ea8567.jpeg" alt="postman" width="40" height="40"/>  </a>


## Acesso ao projeto

Você pode [acessar o código fonte do projeto](https://github.com/RonaldAG/projeto-mongodb-spring).
