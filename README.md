# Pokemon-list-kotlin
## Introduction:
Hi, This is a service created in kotlin using reactor with only 2 objectives, first one, I want feedback,
is so important to me receive that because I am learning kotlin and second one is help you with a simple 
example how you can create a simple service using kotlin and reactor.

## Structure:
### Architecture: 
Here we are using [Ports and Adapters Architecture](https://medium.com/idealo-tech-blog/hexagonal-ports-adapters-architecture-e3617bcf00a0).  
This is a clean architecture who help us to write cleanest, maintainable and readable, in ports and adapters we have 3 layers:  

Domain: In this layer we have all our business logic.  
App: In this layer we have our handlers.  
Infra: In this layer we have our adapters and all third party libraries.

### Project Structure:
Domain:   
- aggregate: All aggregates, in this case we have only one, Pagination.
- entity: Our business entities, in this case, we have our entity Pokemon, we will put all business logic and information in this class.
- exception: Contains all our business exceptions.
- ports: Contains all interfaces for our external services or repositories.
- vo: Have each VO (Value Objects) and its respective business logic.  
App:
- handler: We can find the handlers, for our two endpoints. 
- query: Following [CQRS](https://microservices.io/patterns/data/cqrs.html) concepts, we do our request with queries.]
Infra:
- adapter.in.api: Here is our adapter type in, in this case is our endpoint configuration.
- adapter.out: Contains all implementation about our services or repositories defined in our Domain Layer. 
- config: In this example we use Spring Webflux, then in this package we find our beans configurations.

### Design: 
#### /pokemon/list
![Complete List](https://github.com/juansefo/pokemon-list-kotlin/blob/main/docs/getPokemons.png)

#### /pokemon
![Specific Pokemon](https://github.com/juansefo/pokemon-list-kotlin/blob/main/docs/getPokemon.png)

## Requirements:   
1. Gradle 7.x
2. Java 11

## How to run:
Go to the starter located in infra/com.pokemon.list.infra.adapter.Starter.kt and run the main method.

## Resources:
1. [Ports and Adapters Architecture](https://medium.com/idealo-tech-blog/hexagonal-ports-adapters-architecture-e3617bcf00a0)
2. [Hexagoal architecture JavaKotlin](https://dev.to/jorgetovar621/hexagonal-architecture-javakotlin-example-15i7)
3. [CQRS](https://microservices.io/patterns/data/cqrs.html)