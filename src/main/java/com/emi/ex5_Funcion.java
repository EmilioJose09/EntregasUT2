/* - utiliza al menos una función y un procedimiento. Adjunta el código de las funciones y procedimientos también. */

package com.emi;

import java.sql.*;

public class ex5_Funcion {
    public static void main(String[] args) {
        String funcion = "{? = call album_manin_function()}";
        String procedure = "call album_manin_procedure()";

        try (Connection conexion= ConnectionPool.getInstance().getConection()){
            CallableStatement callableStatement = conexion.prepareCall(procedure);
            callableStatement.execute();

            callableStatement = conexion.prepareCall(funcion);
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.execute();

            System.out.println(callableStatement.getString(1));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
