package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {

    //private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/aerolinea?useSLL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CLAVE = "admin";
    
     /*static {
    try {
        Class.forName(CONTROLADOR);
    } catch (ClassNotFoundException e) {
        System.out.println("Error al cargar el controlador");
        e.printStackTrace();
    }
    }*/
    public Connection conectar() {
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            //System.out.println("Conexión OK");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR no se pudo conectar a la base de datos");
            e.printStackTrace();
        }
        
        return conexion;
    }
}
