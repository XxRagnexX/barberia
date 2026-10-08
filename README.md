# api_barberia

API REST para una barbería, hecha en Java 17 con Spring Boot 3. Guarda barberos y sus citas, y permite crearlos, modificarlos, buscarlos y borrarlos.

La base de datos es H2 en memoria, así que no hay que instalar nada: los datos viven mientras la API está encendida y se borran al apagarla.

## Cómo levantarla

Solo necesitas Java 17 o superior. Maven viene incluido en el proyecto:

```
mvnw clean package
java -jar target/api_barberia-0.0.1-SNAPSHOT.jar
```

En Mac o Linux es `./mvnw`, y en PowerShell `.\mvnw`. Cuando aparezca `Started ApiBarberiaApplication`, la API está corriendo en http://localhost:8080.

## Rutas

| Método | Ruta |
|---|---|
| GET, POST | `/api/barberos` |
| GET, PUT, DELETE | `/api/barberos/{id}` |
| GET, POST | `/api/citas` |
| GET, PUT, DELETE | `/api/citas/{id}` |

Al abrir http://localhost:8080 aparece la lista completa de rutas.

Para crear una cita, el barbero se manda solo con su id:

```json
{
  "nombreCliente": "Juan Pérez",
  "servicio": "Corte fade",
  "fechaHora": "2026-12-20T15:30:00",
  "precio": 12000,
  "barbero": { "id": 1 }
}
```

Al borrar un barbero se borran sus citas también. Hay 22 pruebas en la colección `postman/` que se pueden importar directo a Postman.

## Base de datos

La consola de H2 está en http://localhost:8080/h2-console. El JDBC URL es `jdbc:h2:mem:barberia_db`, el usuario `sa` y la contraseña queda vacía. Los datos de ejemplo los carga `data.sql` al arrancar.

## Estructura

El código está en `src/main/java/com/example/api_barberia/` y sigue 4 capas:

- `controller` — recibe la petición HTTP y responde con el código que corresponda.
- `service` — valida los datos y tiene la lógica.
- `repository` — habla con la base de datos.
- `model` — las entidades (barbero y cita, relación 1 a N).
