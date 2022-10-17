
package Conexion;
//PAQUETES NECESARIOS PARA LA CONEXION
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

//CONFIGURACION PARA LA CONEXION
public class cls_Conexion {
    
    private static final String DRIVER   = "com.mysql.cj.jdbc.Driver";
    private static final String USER     = "root";
    private static final String PASSWORD = "@Oooc14800";
    private static final String URL      = "jdbc:mysql://localhost:3306/Colegio";
    private Connection CN;
    private Connection getConnetion;
    public cls_Conexion(){
        CN = null;
    }
    
    
    //ESTABLECEMOS CONEXION CON LA BASE DE DATOS
    public Connection getConnetion(){
        try{
            Class.forName(DRIVER);
            CN = DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa", "Conexion",JOptionPane.INFORMATION_MESSAGE );
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR AL CONECTAR A LA BASE DE DATOS",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return CN;
    }
    //CERRAMOS LA CONEXION
    public void close(){
        try{
            CN.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR AL CERRAR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
  
    
}
