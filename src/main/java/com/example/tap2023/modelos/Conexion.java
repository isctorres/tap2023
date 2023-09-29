package com.example.tap2023.modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static String server = "127.0.0.1";
    private static String user = "topicos";
    private static String pass = "1234567890";
    private static String db = "restaurante";

    public static Connection conexion;
    public static void createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://"+server+":3306/"+db+"?allowPublicKeyRetrieval=true&useSSL=false",user,pass);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
