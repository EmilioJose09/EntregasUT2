package com.emi;

import java.sql.*;

/*- realiza un ejemplo de código susceptible de sufrir ataque por inyección de SQL.*/
public class ex2_Inyeccion {
    public static void main(String[] args) {

        String sqlInyeccion = "Select * from Album where id = 1 or 1=1";
        int cont = 0;
        try (Connection conexion= ConnectionPool.getInstance().getConection();
        Statement stmt = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)){

            ResultSet resultSet = stmt.executeQuery(sqlInyeccion);

            resultSet.absolute(3);//aqui hacemos inyeccion con el dato numero 3
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));

            resultSet.first();//aqui hacemos inyeccion con el primer dato de la tabla
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));

            resultSet.last();//aqui hacemos inyeccion con el ultimo dato de la tabla
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
