/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jframe;
import java.sql.Connection;
import java.sql.DriverManager;



public class DBConnection {
    static Connection con;
    public static Connection getcon() throws Exception{
        if(con == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arkani987794");
        }
        System.out.println("connected");
        return con;
    }
   public static void insertData(String sql) throws Exception{
       getcon().createStatement().executeUpdate(sql);
   }
}

