package com.emi;
/**
 * Crea un proyecto JDBC que genere una base de datos con tu nombre y, al menos, una tabla para el elemento con el que estés trabajando (discos, libros, videojuegos, etc).*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Creacion_BBDD {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";

        try (Connection conexion = DriverManager.getConnection(jdbcUrl, "root", "root");
            Statement stmt = conexion.createStatement()){
            Class.forName("org.postgresql.Driver");

            String sql = "CREATE DATABASE emilio";
            stmt.executeUpdate(sql);
            System.out.println("Base de datos creada");

        } catch (Exception e) {
            e.printStackTrace();
        }
        createTable();
    }
    public static void createTable(){
        String url = "jdbc:postgresql://localhost:5432/emilio";
        String sql = "Create table Album (id integer primary key, nom varchar, tiempo numeric)";
        try (Connection conn = DriverManager.getConnection(url, "root", "root");
             Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sql);
            System.out.println("Se ha creado correctamente");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

