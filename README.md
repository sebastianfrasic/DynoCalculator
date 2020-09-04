# Parcial 1 AREP

1. Construir un servicio WEB (puede usar Spark o Sockets) que reciba un número y una cadena de tres caracteres. La cadena puede ser una de tres opciones: "cos", "sin", "tan". El servicio asume que el número que recibe está en radianes y retorna una estructura JSON con el valor de las función trigonométrica correspondiente. Para probar, y para ver como el browser arma el query, puede usar  un formulario de html.
2. Construya otro servicio Web (puede usar Spark o Sockets) que sea una fachada del servicios construido en el primer punto. Es decir, este servicio recibe los mismos parámetros y regresa el mismo resultado, pero para hacer el cálculo debe invocar via http al servicio web que se constuyó en el primer punto.
3. Su diseño debe soportar la composición de nuevas operaciones para modificar servicios existentes o componer nuevos servicios. Por ejemplo, piense que en el futuro podemos solicitar que se creen nuevos servicios sobre  el API web, es decir,  debe ser fácilmente extensible.
4. El diseño de los servicios WEB debe tener en cuenta buenas prácticas de diseño OO.
5. Despliegue los servicios en Heroku en dynos separados.
6. Construya un cliente JAVA para probar los dos servicios.
7. El cliente y los servicios debe entregarlos en dos proyectos estructurado con Maven. El primero con el servicio fachada y el cliente. Y el segundo con el servicio web concreto.
8. El cliente debe traer "quemada" en el código fuente la url de su aplicación desplegada en Heroku.
9. Entregue todo en GITHUB y el enlace a Heroku de cada uno de los servicios.

## Comenzando 🚀

Enlace de la aplicación en Heroku:
[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://dyno-calculator.herokuapp.com/calculator)

### Pre-requisitos 📋

* Java 8
* Maven (Apache Maven)
* Git



### Instalación 🔧

1. Clonar el repositorio

```
git clone https://github.com/sebastianfrasic/DynoCalculator.git
```

2. En una terminal:

```
mvn package
```


3. Para ejecutar la aplicación

```
java -cp target/classes;target/dependency/* edu.eci.arep.controller.CalculatorController
```
Para poder utilizar la aplicación dirígase a su navegador web de preferencia, y coloque:

```
localhost:4567/calculator
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


