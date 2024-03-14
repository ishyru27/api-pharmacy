API Pharmacy
API para la gestión de farmacias.

Dependencias
Java 11
Maven
Spring Boot 2.2.x
H2 Database
Compilación
Para compilar el proyecto, ejecuta el siguiente comando en la raíz del proyecto:

mvn clean install
Esto descargará las dependencias del proyecto, compilará el código fuente y ejecutará los casos de prueba.

Ejecución
Una vez que se haya compilado el proyecto, puedes ejecutarlo utilizando el siguiente comando:
java -jar target/api-pharmacy-0.0.1-SNAPSHOT.jar
Esto iniciará la aplicación en el puerto predeterminado 8080.

Acceso a la consola de H2
Puedes acceder a la consola de la base de datos H2 navegando a la siguiente URL en tu navegador web:
Luego, ingresa la URL de la base de datos (jdbc:h2:mem:testdb), el usuario (verifarma) y la contraseña (admin) para conectarte a la base de datos H2.

http://localhost:8080/h2-console

Documentación del API
POST /api-pharmacies

Crea una nueva farmacia en el sistema.

Body:

{
"name": "Nombre de la farmacia",
"latitud": 12.345,
"longitud": -67.890
}

Respuesta exitosa:

{
"id": 1,
"name": "Nombre de la farmacia",
"latitud": 12.345,
"longitud": -67.890
}

Respuesta de error:

HTTP 400 Bad Request - Si los datos enviados no son válidos.


GET /api/farmacia/cercana?lat=-34.587722&lon=-58.425767
http://localhost:8080/api/farmacia/cercana?lat=-34.587722&lon=-58.425767

Obtiene la farmacia más cercana a las coordenadas especificadas.

Parámetros:

- latitud: Latitud de la ubicación actual.
- longitud: Longitud de la ubicación actual.

Respuesta exitosa:

{
"id": 1,
"name": "Nombre de la farmacia más cercana",
"latitud": 12.345,
"longitud": -67.890
}

Respuesta de error:

HTTP 404 Not Found - Si no se encuentra ninguna farmacia cercana.
