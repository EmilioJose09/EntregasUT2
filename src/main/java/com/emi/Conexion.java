package com.emi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Crea un proyecto JDBC que genere una base de datos con tu nombre y, al menos, una tabla para el elemento con el que estés trabajando (discos, libros, videojuegos, etc).
 * - sobre un ResultSet de todo el contenido de la tabla realiza al menos una inserción,una modificación y un borrado utilizando, al menos, 5 métodos de desplazamiento a lo largo del ResultSet.
 * - realiza un ejemplo de código susceptible de sufrir ataque por inyección de SQL.
 * - haz la variante que corrija el inconveniente anterior (haciendo uso de PreparedStatement)
 * - realiza una transacción que no se complete al provocar un rollback.
 * - utiliza al menos una función y un procedimiento. Adjunta el código de las funciones y procedimientos también.
 * - haz uso a lo largo del proyecto de un agrupamiento (pool) de conexiones.
 */
public class Conexion
{
    public static void main( String[] args ) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/emilio" ;
        try (Connection conexion = DriverManager.getConnection(jdbcUrl, "root", "root")) {
            //Abrir la conexión con la Base de Datos
            System.out.println("Conectando con la Base de datos...");

            System.out.println("Conexión establecida con la Base de datos..." + conexion.getSchema());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
