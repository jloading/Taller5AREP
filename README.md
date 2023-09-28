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

### * Desde Docker:



## Corriendo las pruebas


## Qué se hizo

### Docker
Se crea una imagen en Docker con el comando

```
docker build --tag taller5arep .
```

<img width="707" alt="Captura de pantalla 2023-09-27 a la(s) 9 40 39 p m" src="https://github.com/jloading/Taller5AREP/assets/65261708/7765f1bd-5c14-42ec-97cb-abe0d5af1913">

Posteriormente se crea un contenedor con el comando
```
docker run -d -p 34000:6000 --name taller5container taller5arep
```
<img width="542" alt="Captura de pantalla 2023-09-27 a la(s) 9 42 13 p m" src="https://github.com/jloading/Taller5AREP/assets/65261708/25c6bd35-a7ed-42ac-89c5-1162b229f80e">

Se crea una referencia a la imagen con el nombre del repositorio de Docker Hub al que será subida

```
docker tag taller5arep jloading9/taller5arep
```

<img width="423" alt="Captura de pantalla 2023-09-27 a la(s) 9 54 26 p m" src="https://github.com/jloading/Taller5AREP/assets/65261708/fd2db7dd-29df-4dae-94de-16de05f7cd5e">

Se autentica en Docker con el comando

```
docker login
```

<img width="385" alt="Captura de pantalla 2023-09-27 a la(s) 9 56 22 p m" src="https://github.com/jloading/Taller5AREP/assets/65261708/885f0903-1bd2-4a59-86e8-a6f116fce61b">

Se sube la imagen al repositorio con el comando
```
docker push jloading9/taller5arep:latest
```
<img width="638" alt="Captura de pantalla 2023-09-27 a la(s) 9 58 12 p m" src="https://github.com/jloading/Taller5AREP/assets/65261708/78ca5c37-59c7-4a86-b977-5249aadc26fa">




## Hecho con

* Java: Lenguaje de programación de propósito general con enfoque a el paradigma de orientado a objetos, y con un fuerte tipado de variables.
* Git: Es un sistema de control de versiones distribuido (VCS).
* Maven: Es una herramienta que estandariza la configuración del ciclo de vida del proyecto.
* HTML: Es un lenguaje de marcado que estructura una página web y su contenido.
* JavaScript: Lenguaje de programación que los desarrolladores utilizan para hacer paginas web dinamicas.

## Autor

* **Juan Carlos Acosta**

