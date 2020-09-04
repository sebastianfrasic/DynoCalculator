# Taller #2 - AREP
# INTRODUCTION TO COMPUTER SYSTEM DESIGN

Write a web application to calculate the mean and standard deviation of a set of n real numbers. Your program reads the n real numbers from a web page.
 
Use a linked list to store the n numbers for the calculations.

Write a short article describing the architecture of the solution. Identify clearly abstractions of memory, communications channels and interpreters.

## Comenzando 🚀

Para ver el artículo en Latex haga [click acá](/Taller2Arep.pdf)

[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://app.circleci.com/pipelines/github/sebastianfrasic/Taller-Heroku-AREP)


Enlace de la aplicación en Heroku:
[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://fierce-ravine-15671.herokuapp.com/inputdata)

### Pre-requisitos 📋

* Java 8
* Maven (Apache Maven)
* Git



### Instalación 🔧

1. Clonar el repositorio

```
git clone https://github.com/sebastianfrasic/Taller-Heroku-AREP.git
```

2. En una terminal:

```
mvn package
```


3. Para ejecutar la aplicación

```
java -cp target/classes;target/dependency/* edu.eci.arep.SparkWebApp
```
Para poder utilizar la aplicación dirígase a su navegador web de preferencia, y coloque:

```
localhost:4567/inputdata
```

4. Si desea ver la documentación _javadoc_ de la aplicación

```
mvn javadoc:javadoc
```
Esta documentación quedará en el directorio /target/site


## Ejecutando las pruebas ⚙️

En una terminal:
```
mvn test
```




## Construido con 🛠️

* Java 8
* JUnit
* [Maven](https://maven.apache.org/) - Manejador de dependencias




## Autor ✒️

* Juan Sebastián Frásica Galeano

## Licencia 📄

Este proyecto está bajo la Licencia GNU General Public License - [LICENSE](LICENSE) 


