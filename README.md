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

### Design: 
[Here we can find a little design](https://lucid.app/lucidchart/1ac6bf9f-e551-474b-9e4a-50b65de74649/edit?viewport_loc=-21%2C85%2C1541%2C1075%2CM7oo7ZBUANsC&invitationId=inv_80e2e048-808e-47e5-b38d-d4f638a37bef#)
this you made with [Lucid](https://lucid.app/).

## Requirements:   
1. Gradle 7.x
2. Java 11

## How to run
Go to the starter located in infra/com.pokemon.list.infra.adapter.Starter.kt and run the main method.
