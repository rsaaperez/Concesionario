/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buscador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DAM1_15
 */
public class Conexion {

    static Connection conexion = null;

    public static Statement GetConnection() {
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost/baseCartas";
            String usuarioDB = "root";
            String passwordDB = "asdf";
            conexion = (Connection) DriverManager.getConnection(servidor, usuarioDB, passwordDB);
            st = (Statement) conexion.createStatement();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } finally {
            return st;
        }
    }

    public static void cerrarCon(Connection conexion) {
        try {
            conexion.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de cierre" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        }
    }

    public void insertar(String nombre, String tipo, String rareza) {
     try {
     GetConnection().executeUpdate("INSERT INTO cartas values (nombre, tipo, rareza, habilidad)");
     } catch (SQLException ex) {
     Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
/*
     public void seleccionar() {
     ResultSet rs =null;
     try {
     Statement st = (Statement) conexion.createStatement(); 
     rs= (ResultSet) st.executeQuery("SELECT nombre from cartas");
     st.close();
     } catch (SQLException ex) {
     Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
     } finally {
     System.out.println(rs);
     }
     }*/
}
