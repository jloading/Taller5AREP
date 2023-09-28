# TALLER 5: MODULARIZACIÓN CON VIRTUALIZACIÓN E INTRODUCCIÓN A DOCKER

En este taller se profundizarán los conceptos de modulación por medio de virtualización usando Docker y AWS.

### Prerrequisitos

- Java: Es un lenguaje de programación de propósito general orientado a objetos, portátil y muy versátil.
- Maven: Es una herramienta que maneja el ciclo de vida del programa.
- Git: Es un sistema de control de versiones distribuido (VCS).

### Instalación

1. Clonar el repositorio

```
https://github.com/jloading/Taller4AREP
```

2. Se construye el proyecto con Maven

```
mvn package
```

### Corriendo la aplicación

### * En su máquina:

Se corren los comandos
```
mvn clean package install
mvn clean install
```

Se corre el servidor con el comando
#### Para Mac:
```
java -cp "target/classes:target/dependency/*" org.example.SparkWebServer
```

#### Para Windows:
```
java -cp "target\classes:target\dependency\*" org.example.SparkWebServer

```

Para finalizar, se accede a la siguiente dirección desde el navegador

```
http://localhost:4567/operaciones
```

## Corriendo las pruebas


## Qué se hizo
Se creó una clase con los métodos necesarios para responder las solicitudes. Cada método tiene su respectiva etiqueta (@RequestMapping o @GetMapping)

<img width="693" alt="Captura de pantalla 2023-09-22 a la(s) 12 27 46 a m" src="https://github.com/jloading/Taller4AREP/assets/65261708/fcb9f95f-d142-48b8-a358-caa5d4a6b56b">

A su vez en la clase servidor se crearon las condiciones encargadas de llamar los métodos mencionados anteriormente dependiendo de la solicitud que se haga a través de la URI

<img width="689" alt="Captura de pantalla 2023-09-22 a la(s) 12 29 52 a m" src="https://github.com/jloading/Taller4AREP/assets/65261708/ba05dc8b-e52c-425f-a8c7-0173a2b33bbe">

## Hecho con

* Java: Lenguaje de programación de propósito general con enfoque a el paradigma de orientado a objetos, y con un fuerte tipado de variables.
* Git: Es un sistema de control de versiones distribuido (VCS).
* Maven: Es una herramienta que estandariza la configuración del ciclo de vida del proyecto.
* HTML: Es un lenguaje de marcado que estructura una página web y su contenido.
* JavaScript: Lenguaje de programación que los desarrolladores utilizan para hacer paginas web dinamicas.

## Autor

* **Juan Carlos Acosta**

