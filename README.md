# MercadoLibre Test ANti-Fraude

Este proyecto pretende solucionar el problema presentado por MercadoLibre 

###El ejercicio consiste en construir una API Rest que dada una dirección IP, encuentre el país al
que pertenece

El ejercicio consiste en construir una API Rest que dada una dirección IP, encuentre el país al
que pertenece

### Diseño de la solución

Se planteó desarrollar un API bajo el lenguaje de **JAVA** esta solución por lo cual se consumiran las tres APIS
publicas expuestas para desarrollar el ejercicio 

Geolocalización de IPs: https://ip2country.info/
Información de paises: http://restcountries.eu/
Información sobre monedas: https://exchangeratesapi.io/

Para el tema de las pruebas unitarias se escogio **JACOCO** como herramienta de generación de reportes de test unitarios
y coverturas del mismo.

## Tecnologías y herramientas empleadas

 - JAVA (JDK 8)
 - INTELLIJ IDE
 
 #### Gestor de dependencias
 
 - GRADLE
 
#### Frameworks

 - Feign
 - Hytrix
 - JPA
 - Springboot
 - Springboot-cloud
 - Lombok
 
## Requerimientos instalación

Para poder instalar y ejecutar correctamente este proyecto se debe contar con:

 - Instalación JAVA JDK8 o superior
 - Gradle o el mismo que esta embebido en el IDE
 - Conexión a internet con el fin de comunicarse con las APIS publicas
 - MYSQL Gestor de Base de datos
 
 ## Ejecutar el proyecto
 
 para poder eejcutar el proyecto siga estos pasos:
 
 - Creación de la variable de entorno **SPRIN_PROFILES** con el valor default
 - ejecución de los Scripts que se encuentran en la ruta /src/resource/model/statistics_country_statistics.sql 
 y statistics_routines en el gestor de BD para este ejercicio se utilizo MYSQL
 - para actualizar el proyecto gradle ejecutar gradle clean and build desde la terminal o en su defecto actualziar
 dependencias desde el IDE.
 - Documentación http://localhost:9086/swagger-ui.html#/
 
 -Rutas para probar API´S
 
 http://localhost:9086/api/v1/addressIp?ip=83.44.196.93
 http://localhost:9086/api/v1/statisticsAverageValue
 http://localhost:9086/api/v1/statisticsMaxValue
 http://localhost:9086/api/v1/statisticsMinValue
 
 
 
