# Proyecto 1 Topicos especiales de telematica

[TOCM]

[TOC]

## Desarrolador

- Joshua Sánchez Álvarez - jsanch90@eafit.edu.co - Universidad EAFIT

# ¿Cual es la problemática que quiere resolver?

Se desea realizar una aplicación para el registro de datos de sensores (humedad, temperatura, ubicación) teniendo una arquitectura desacoplada entre el backend y el frontend para garantizar principios de desarrollo de software como responsabilidades únicas, inversión de dependencias entre otras, además aplicar patrones de desarrollo de software como MVC (Model View Controller), todo esto con el fin de de entregar software de calidad  que cumple con atributos como mantenibilidad y extensibilidad.

# Requisitos funcionales
- El sistema debe registrar datos de los sensores cada 10 segundos.
- El sistema debe tener servicios rest para realizar el registro y recuperación de datos.
- El sistema debe tener una arquitectura de frontend y backend desacoplada.
- El sistema solo permitirá a los usuarios autorizados registrar datos de los sensores.
- El sistema permitirá visualizar los datos registrados por los sensores.

# Requisitos no funcionales
- Seguridad
- Extensibilidad
- Mantenibilidad

#Tecnologías de desarrollo

## Backend
Para el desarrollo de backend se utilizó Spring Boot, allí se desarrolló la API REST con los distintos endpoints para posteriormente ser utilizados en el frontend, todo el desarrollo del backend se hizo con Java. Para la persistencia de los datos se utilizó una base de datos relacional, como motor de base de datos se eligió MySQL.
![](https://technology.amis.nl/wp-content/uploads/2018/01/spring-boot.png)

## Frontend
Para el frontend se empleó Angular 8, desde allí se implementaron unos servicios propios de Angular para consumir la API que se desarrolló en Spring Boot y los datos que esta nos retornaba se muestran en el front en forma de tabla. Se pueden consultar todos los registros o registros relacionados a un usuario específico.
![](https://i.ytimg.com/vi/5_IC_ZJrVMg/maxresdefault.jpg)

# Especificación de los servicion REST API
| Endpoint  | Método | Especificación | Ejemplo |
| ------------- | ------------- | ------------- | ------------- |
| /register/user_registers | GET | Permite recuperar todos los registros de sensores y GPS de un usuario en específico, el nombre de usuario se pasa por los parámetros de la url. | http://localhost:8080/register/user_registers?userId=josh |
| /register/all | GET | Recupera todos los registros de los sensores y GPS almacenados en la base de datos. | http://localhost:8080/register/all |
| /register/add | POST** | Añade un registro de los distintos sensores y el GPS a la base de datos, este registro va relacionado con un usuario, el nombre del usuario se pasa por los parámetros de la url. | http://localhost:8080/register/add?userId=josh |
| /user/add | POST | Añade un usuario nuevo. | http://localhost:8080/user/add |
| /user/all | GET | Retorna todos los usuarios registrados. | http://localhost:8080/user/add |
| /user/login | POST | Realiza el proceso para autenticar un usuario. | http://localhost:8080/user/login |

Los servicios que están marcados con (**) en el método http requieren de un objeto JSON cuando se hace la petición al servicio. A continuación se añaden unos ejemplos de cómo debe ser la estructura de estos objetos.

## Estructura de objeto Register
```javascript
{
	"latitude": "5.0",
	"longitude": "2.099",
	"date": "2021-10-01",
	"temperature":"26",
	"humidity":"8"
}
```
## Estructura del objeto User
```javascript
{
	"username":"josh",
	"password":"testPass"
}

```

# Autenticación de los servicion
Para autenticar los servicios de la api rest se utilizó JWT. Cuando un usuario registrado inicia sesión satisfactoriamente en la aplicación el sistema le asigna un token con el cual puede consumir los servicios de la API.

# Ejecucion

## Backend
- La manera mas sencilla de ejecutar el servidor del backend es descargar el repositorio e imortar el proyecto que esta en el direcctorio ```tet_data_register_app/back/data_register_rest_api/``` como un proyecto de maven en algun IDE como Eclipse o IntelliJ.

- Tambien se puede ejecutar desde la terminal llegando hasta el mismo directorio y ejecutando el comando ```mvn spring-boot:run ```.

## Frontend
- Para ejecutar el servidor del frontend hay que ubicarse en el directorio ```tet_data_register_app/front/data-register-front/``` y ejecutar el comando ```ng serve```

- Tambien se puede importar en un IDE como WebStorm y desde allí lanzar el servidor.
