# Installation : 

1- clone this repo within your workspace:

``` 

git clone https://github.com/RaoufEdabbar/PI3GLJEE.git

```

2- create a new otdav database in phpmadmin and upload otdav.sql as a new database schema

3- update maven to download all the dependencies for the project, you are free to the IDE or terminal

``` 
    maven update
```

4- create datasource for otdav database with wildflay administration dashboard with  java:/otdav as name

```
 http://localhost:9990/console/index.html#configuration > Subsystem  > Datasources & Drivers > Datasources > Add Datasources.
``` 


5- install the project

``` with your ide right click on PI.OTDAV > RUN AS > Maven install ```

6- launch the server

7- deploy the project within the server: in the server tab

``` 
 right click on the server, add the ear project.
``` 

8- open the browser:

``` 
localhost:8080/Registered web context/api/categories

```


# Developement:

1- check this workflow please, we will use it as we are working on this project : https://guides.github.com/introduction/flow/

2- after the installation of the project, create new branch for each feature:
   
    as an example: manage category,

  ``` 
     git checkout -b f-manage-categories 
  ```

  then push your modification, create pull-request, github will trigger a hook to check if there is conflicts between your branch and master branch, if every think ok you can merge, otherwise, within ur branch fetch master and manage the conflicts files and push again.


  # every new branch should be created from master.


  3- within pi.domain.ejb package:

          create the Remote Interface, ex: WorkFacadeRemote, check CategoryFacadeRemote
          create the WorkBean ejb with the implementation of WorkFacadeRemote, check CategoryBean

  4- within pi.esprit.api

         create the resource, ex: WorkResources, check CategoryResources







------------------------------------------------------------------------------------------

5- update  

Architecture de Projet JEE

Editeur JBOSS STUDIO

SREVEUR WildFly 9.x

Pour créer le chemin otdav de la datasource de projet :

Login        : admin
Mot de passe :wildflyadmin

modifier le fichier persistance de la phase create par update lors de la generation de base de donnée 


instalation github pour jboss studio

lien d'integration gitHub

https://access.redhat.com/articles/1584523


creation branche Arwa

