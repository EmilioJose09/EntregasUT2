package com.emi;

import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;
public class ConnectionPool {
    private static ConnectionPool pool;
    private static BasicDataSource bds;
    ConnectionPool(){
        bds = new BasicDataSource();
        bds.setUrl("jdbc:postgresql://localhost:5432/emilio");
        bds.setUsername("root");
        bds.setPassword("root");
        bds.setMinIdle(5);
        bds.setMaxIdle(20);
    }
    public static ConnectionPool getInstance(){
        if (pool == null){
            pool = new ConnectionPool();
        }
        return pool;
    }
    public Connection getConection(){
        Connection connect = null;
        try{
            connect = bds.getConnection();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return connect;
    }
    public void closeConection (Connection conection) throws SQLException {
        conection.close();
    }
}
