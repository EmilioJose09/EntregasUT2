package com.emi;

import org.postgresql.util.PSQLException;

import java.sql.*;

    /* - haz la variante que corrija el inconveniente anterior (haciendo uso de PreparedStatement)*/
public class ex3_Variante {
     public static void main(String[] args) {

            String sqlInyeccion = "Select * from Album where id = 1 or 1=1";
            int cont = 0;
            try (Connection conexion= ConnectionPool.getInstance().getConection();
                 PreparedStatement stmt = conexion.prepareStatement(sqlInyeccion, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)){

                ResultSet resultSet2 = stmt.executeQuery(sqlInyeccion);

                resultSet2.absolute(3);//aqui hacemos inyeccion con el dato numero 3
                System.out.println(resultSet2.getString(1));
                System.out.println(resultSet2.getString(2));
                System.out.println(resultSet2.getString(3));

                resultSet2.first();//aqui hacemos inyeccion con el primer dato de la tabla
                System.out.println(resultSet2.getString(1));
                System.out.println(resultSet2.getString(2));
                System.out.println(resultSet2.getString(3));

                resultSet2.last();//aqui hacemos inyeccion con el ultimo dato de la tabla
                System.out.println(resultSet2.getString(1));
                System.out.println(resultSet2.getString(2));
                System.out.println(resultSet2.getString(3));


            }catch (PSQLException e){
                System.out.println("A mi no me Inyectassss MANINNN");
            }
             catch (SQLException e){
                e.printStackTrace();
            }
     }
}
