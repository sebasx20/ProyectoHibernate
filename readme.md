# Estructura proyecto

> La información técnica se encuentra en el archivo PDF adjunto

Estructura de directorios del proyecto: 

```
├── src
│   ├── generarDatos
|   |   ├── Contabilidad
|   |   ├── Empleado
|   |   ├── LlenarListaEmpleado
|   ├── hibernateMysql
|   |   ├── Consulta
|   |   ├── HiberanateUtil
|   ├── main
|   |   ├── Main
|   ├── paths
|   |   ├── DatConnection
|   |   ├── DbConnection
|   ├── reverse
|   |   ├── Listaempleados
|   |   ├── ListaempleadosId
├── hibernate.cfg.xml
├── hibernate.reveng.xml
```


# Paths

| Fichero | Funcionalidad
| --- | --- |
| DatConnection | Contiene una variable predefinida con la ubicación del archivo y métodos para modificarlos |
| DbConnection | Contiene la ruta de la base de datos mariaDB asi como su usuario y contraseña |

## Editar la conexión de hibernate con MySQL

La ip relacionada en la conexión actual del hibernate es la siguiente:
```xml
<property name="hibernate.connection.url">jdbc:mysql://192.168.1.135/db1eva</property>
```

Si se cambia se recomienda reiniciar el WorkSpace para que los cambios queden grabados.

# Generar datos

En este `package` se encuentran los archivos que consolidaran la información solicitada. 

* `Contabilidad` Contiene el método `generarContabilidad` que primero obtiene los datos del fichero `.dat ` y los almacena en un array de objetos de Contabilidad invocando al constructor definido en esta misma clase.

* `Empleado` Contiene el método `generarRhhventas` realiza un Query a la base de datos `MariaDB`. 
    * `SELECT matricula,apenom, departamento,  ROUND(SUM(ventas),5) AS ventas, semana FROM rrhhventas GROUP BY matricula` (Los datos se suman en la misma `select`).
    * El resultado de la query se almacena en un array de objetos de Empleados invocando al constructor definido en esta misma clase.

* `LlenarListaEmpleados` Invoca a los dos métodos anteriores y consolida la información.