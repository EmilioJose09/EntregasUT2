package com.emi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ex4_Transaccion {

    public static void main(String[] args) throws SQLException {
        String sql = "insert into Album (id, nom, tiempo) values (?,?,?)";

        Connection conexion = null;
        PreparedStatement stmt = null;
        ResultSet resultset = null;

    try {
        conexion = ConnectionPool.getInstance().getConection();
        conexion.setAutoCommit(false);
        stmt = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS,
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        stmt.setInt(1, 2);
        stmt.setString(2, "Feliz Cumpleaños Ferxxo");
        stmt.setDouble(3, 35.2);
        stmt.executeUpdate();

        //Para que me corte una update y me haga la siguiente
        resultset = stmt.getGeneratedKeys();
        resultset.next();
        stmt.close();
        stmt = conexion.prepareStatement(sql);
        resultset.first();

        stmt.setInt(1, 3);
        stmt.setString(2, "RHLM");
        stmt.setDouble(3, 21.8);
        stmt.executeUpdate();

        //Para que me corte una update y me haga la siguiente
        resultset = stmt.getGeneratedKeys();
        resultset.next();
        stmt.close();
        stmt = conexion.prepareStatement(sql);
        resultset.first();

        stmt.setInt(1, 4);//No puede ir Double
        stmt.setString(2, "Afrodisiaco");
        stmt.setDouble(3, 27.3);
        stmt.executeUpdate();

        conexion.commit();

    }catch (SQLException e) {
        conexion.rollback();
        System.out.println("Rollback Manin");
        }
    finally{
        try{
            stmt.close();
            conexion.setAutoCommit(true);
            ConnectionPool.getInstance().closeConection(conexion);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    }
}

