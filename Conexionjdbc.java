package com.mycompany.conexionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexionjdbc {

    public static void main(String[] args) {
        String inventario="root";
        String password="";
        String url="jdbc:mysql://localhost:3308/sistema_inventario_virtual";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, inventario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM inventario");
            while(rs.next()){
                System.out.println(rs.getString("Nombre"));
            }
            
            
            
            //insertar datos
            statement.execute("INSERT INTO `inventario` (`idInventario`, `idProducto`, `Nombre`, `Categoria`, `Descripcion`, `Ubicacion`) VALUES (NULL, 1, 'Producto1', 'Categoria1', 'Descripcion1', 'Ubicacion1');");
             System.out.println(rs.getString("")); 
            rs = statement.executeQuery("SELECT * FROM inventario");
            while(rs.next()){
                System.out.println(rs.getString("Nombre"));
            }
            
            
            
           //Acualizacion de datos.
           
           statement.execute(" UPDATE 'inventario' SET 'Nombre' = 'Clavos de pared' WHERE 'inventario'. 'idInventario' = 3 AND 'inventario'. 'idProducto' = 1;");
             System.out.println(rs.getString("")); 
            rs = statement.executeQuery("SELECT * FROM inventario");
            while(rs.next()){
                System.out.println(rs.getString("Nombre"));
            }
            
            
            //Eliminar datos
            
            statement.execute("DELETE FROM inventario WHERE 'inventario'. 'idinventario' =1 AND 'inventario'.'idProducto'=1");
             System.out.println(rs.getString("")); 
            rs = statement.executeQuery("SELECT * FROM inventario");
            while(rs.next()){
                System.out.println(rs.getString("Nombre"));
            }
             
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexionjdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
