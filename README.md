Restaurant Order App
Visie Groep
=====

Dit is een applicatie voor horeca bedrijven waar klanten via een tablet o.i.d. eten en drinken kunnen bestellen. 

## Getting Started

### Prerequisites

Voor dit project heb je nodig:
- Java
- Docker

### Installatie

Download het project.


Gebruik Compose om de benodigde services te draaien

```shell
user:host:project_folder$ docker-compose up
```

Wacht tot alle services beschikbaar zijn, en start de applicatie

```shell
user:host:project_folder/visie.excersise.spring.restaurant$ ./mvn spring-boot:run
```


## Uitvoeren van tests

```shell
user:host:project_folder/visie.excersise.spring.restaurant$ ./mvn test
```

## Levering

Dit wordt straks nog allemaal gedockerized, maar voor nu, draai mysql via docker, en draai app via maven task.

```shell
user:host:project_folder$ docker-compose up
user:host:project_folder/visie.excersise.spring.restaurant$ ./mvn spring-boot:run
```



# Author

  - **Simon Meulenbeek** - [simonmeulenbeek](https://github.com/simonmeulenbeek)

See also the list of [contributors](https://github.com/PurpleBooth/a-good-readme-template/contributors)
who participated in this project.


## Acknowledgments

  - Hat tip to anyone whose code is used
  - Inspiration
  - etc
