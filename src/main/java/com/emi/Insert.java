package com.emi;

import java.sql.*;

public class Insert {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/emilio";
        String sql = "insert into Album (id, nom, tiempo) values (?,?,?)";

        try( Connection conexion = DriverManager.getConnection(url, "root", "root");
        PreparedStatement stmt = conexion.prepareStatement(sql);){

            stmt.setInt(1, 2);
            stmt.setString(2, "Feliz Cumpleaños Ferxxo");
            stmt.setDouble(3, 35.2);
            stmt.executeUpdate();

            stmt.setInt(1, 3);
            stmt.setString(2, "RHLM");
            stmt.setDouble(3, 21.8);
            stmt.executeUpdate();

            stmt.setInt(1, 4);
            stmt.setString(2, "Afrodisiaco");
            stmt.setDouble(3, 27.3);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
