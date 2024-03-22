package config;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection objConnection = null;

    public static boolean openConnection(){
        boolean isConnected = false;
        try{
            //Permite obtener o implementar driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creamos variables con nuestras credenciales de la base de datos
            String url = "jdbc:mysql://bao9zcktir47kuv8kbqt-mysql.services.clever-cloud.com:3306/bao9zcktir47kuv8kbqt";
            String user = "uoourniomrn7lgdg";
            String password = "Otoa3mGEI2Or2OGYXcnn";

            //Establecemos la conexión
            objConnection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Conexión realizada correctamente!! :)");
            isConnected = true;
        }catch(ClassNotFoundException  e){
            System.out.println("Error >> Driver no instalado");
        }
        catch (SQLException e){
            System.out.println("Error >> No se pudo establecer una conexión con la db");
            JOptionPane.showMessageDialog(null,"Error >> No se pudo establecer una conexión con la db");
        }
        return isConnected;
    }

    public static void closeConnection(){
        try{
            if(objConnection!=null) objConnection.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
