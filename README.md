
## Person Project : A CRUD App
[![Build Status](https://travis-ci.org/mockito/mockito.svg?branch=release/3.x)](https://dashboard.heroku.com/apps/person-project-heroku/activity/builds/1ff8b658-9392-4624-9867-cadf186997ff)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

![Demo](https://i.imgur.com/zOBPBB9.gif)

## Compiling & Building in local

To build locally: 
> **```mvn clean install```** <br>

Package the project to run as a Jar executable 
>**```mvn clean package```**<br>

Run the Jar file : 
>**```java -jar target/person-project-0.0.1-SNAPSHOT.jar```**

![Launch](https://i.imgur.com/uSdWwx7.png)
## Access a deployed version on cloud 

Person Project is deployed on the following solutions.

[<b>Heroku PaaS</b>](https://person-project-heroku.herokuapp.com/person-project) <br>
[<b>AWS Elastic Beanstalk</b>](http://personproject-env.tjbyud53yc.us-east-2.elasticbeanstalk.com/person-project/)<br>
[<b>Microsoft Azure</b>](https://person-project.azurewebsites.net/person-project/v1/)


Information about all 3 environments are provided wth the Postman Json Collection <br>

[<b>Environment Information (/Environments)</b>](../master/src/main/resources/postman_scripts/)

![Cloud](https://i.imgur.com/LrtX9Zs.png)
## Frond-End

Person Project makes use of a frond-end app developed in Angular.
This Project is added as a Git sub-module to this repository <br>

[<b>person-project-ui</b>](https://github.com/joyalaugustine/person-project/tree/master/FrondEnd)

![Frond-end](https://i.imgur.com/TsivhcX.png)

## Authentication

Person Project uses a basic authentication.
Postman scripts include the authentication details. <br>

[<b>Postman Script</b>](../master/src/main/resources/postman_scripts/PersonProject.postman_collection.json)

![Authentication](https://i.imgur.com/lshUjVR.png)

## Development Details

This Project used the following features.

[<b>Spring boot</b>](https://spring.io/projects/spring-boot)<br>
[<b>Apache Maven</b>](https://maven.apache.org/)<br>
[<b>Project Lombok</b>](https://projectlombok.org/)<br>
[<b>Spring Data JPA</b>](https://spring.io/projects/spring-data-jpa)<br>
[<b>H2 Database Engine(In memory, Auto configured)</b>](https://www.h2database.com/html/main.html)
