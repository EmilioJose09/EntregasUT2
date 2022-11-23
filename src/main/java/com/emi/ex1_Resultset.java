package com.emi;
/**- sobre un ResultSet de todo el contenido de la tabla realiza al menos una inserción,una modificación y un borrado utilizando, al menos, 5 métodos de desplazamiento a lo largo del ResultSet.*/
import java.sql.*;
public class ex1_Resultset {
        public static void main(String[] args) {
            String url = "jdbc:postgresql://localhost:5432/emilio";
            String sqlStatement = "select id,nom,tiempo from Album";
           try(Connection conexion = /*  */ConnectionPool.getInstance().getConection();   /*DriverManager.getConnection(url,"root", "root");*/
            PreparedStatement stmt = conexion.prepareStatement(sqlStatement,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);){
               ResultSet resultset = stmt.executeQuery();
               while (resultset.next()){
                   System.out.println("***DEVUELVE BOOLEANO***");
                   System.out.println("ID " + resultset.getString(1));//el numero o el nombre, puede ser GetInt
                   System.out.println("Nombre " + resultset.getString("nom"));//el numero o el nombre
                   System.out.println("Tiempo " + resultset.getString(3));//el numero o el nombre, puede ser GetDouble
               }
               resultset.absolute(3);
               System.out.println("***OBSERVAMOS NUESTRO DATO NUMERO 3***");
               System.out.println("ID " + resultset.getString(1));//el numero o el nombre, puede ser GetInt
               System.out.println("Nombre " + resultset.getString("nom"));//el numero o el nombre
               System.out.println("Tiempo " + resultset.getString(3));//el numero o el nombre, puede ser GetDouble

               resultset.first();
               System.out.println("***MOSTRAMOS NUESTRO PRIMER DATO***");
               System.out.println("ID " + resultset.getString(1));//el numero o el nombre, puede ser GetInt
               System.out.println("Nombre " + resultset.getString("nom"));//el numero o el nombre
               System.out.println("Tiempo " + resultset.getString(3));//el numero o el nombre, puede ser GetDouble

               resultset.moveToInsertRow();
               //System.out.println("***HACER UNA NUEVA FILA***");
               resultset.updateInt(1, 12);
               resultset.updateString(2, "Tengo sueño");
               resultset.updateDouble(3, 43.2);
               resultset.insertRow();

               resultset.last();
               System.out.println("***ACTUALIZAR LA ULTIMA FILA CREADA***");
               resultset.updateInt(1, 5);
               resultset.updateRow();

               resultset.last();
               //System.out.println("***ELIMINAR LA ULTIMA FILA CREADA***");
               resultset.deleteRow();

               //USANDO EL POOL
               ConnectionPool.getInstance().closeConection(conexion);
           }
           catch (SQLException e){
               e.printStackTrace();
           }
    }
}
