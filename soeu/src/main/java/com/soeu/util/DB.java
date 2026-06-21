package com.soeu.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
    private static Connection conn;

    public DB(){
        this.conn = null;
    }

    public static Connection getMySQLConnection(){
        if(conn == null){
            try{
                Properties props = getingSystemProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection(){
        if(conn != null){
            try {                
                conn.close(); 
                conn = null;
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

     public static void closeStatement(PreparedStatement ps){
        if(ps != null){
            try {                
                ps.close(); 
                ps = null;
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

     public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try {                
                rs.close(); 
                rs = null;
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static Properties getingSystemProperties(){ 
        try {
            Properties properties = new Properties();

            properties.load(
                DB.class
                    .getClassLoader()
                    .getResourceAsStream("db.properties")
            );

            return properties;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
}
