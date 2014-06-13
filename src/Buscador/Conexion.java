/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscador;

import Objetos.Cartas;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;
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

    Connection conexion = null;

    public Statement GetConnection() {
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost/buscadormagic";
            String usuarioDB = "root";
            String passwordDB = "root";
            conexion = (Connection) DriverManager.getConnection(servidor, usuarioDB, passwordDB);
            st = (Statement) conexion.createStatement();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la Conexión con la BD " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } finally {
            return st;
        }
    }

    public void cerrarCon(Connection conexion) {
        try {
            conexion.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de cierre" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertar(Cartas c) {
        String tipo = c.getTipo();
        try {
            switch (tipo) {
                case "criatura":
                    try {
                        GetConnection().executeUpdate("Insert Into cartas Values ('"+c.getNombre()+"', '"+c.getTipo()+ "', '" + c.getRareza() + "', '" + c.getHabilidad() + "')");
                        GetConnection().executeUpdate("INSERT INTO criatura values ('" + c.getNombre() + "', " + c.getCoste(c) + ", '" + c.getCol(c) + "', " + c.getFue(c) + ", " + c.getDef(c) + ")");      
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case "artefacto":
                    try {
                        GetConnection().executeUpdate("INSERT INTO cartas (nombre, tipo, rareza. habilidad) VALUES ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "')");
                        GetConnection().executeUpdate("INSERT INTO artefacto (nombre, cmc, color) values ('" + c.getNombre() + "', '" + c.getCoste(c) + "', '" + c.getCol(c) + "')");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case "conjuro":
                    try {
                        GetConnection().executeUpdate("INSERT INTO cartas (nombre, tipo, rareza. habilidad) VALUES ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "')");
                        GetConnection().executeUpdate("INSERT INTO conjuro (nombre, cmc, color) values ('" + c.getNombre() + "', '" + c.getCoste(c) + "', '" + c.getCol(c) + "')");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case "encantamiento":
                    try {
                        GetConnection().executeUpdate("INSERT INTO cartas (nombre, tipo, rareza. habilidad) VALUES ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "')");
                        GetConnection().executeUpdate("INSERT INTO encantamento (nombre, cmc, color) values ('" + c.getNombre() + "', '" + c.getCoste(c) + "', '" + c.getCol(c) + "')");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case "instantaneo":
                    try {
                        GetConnection().executeUpdate("INSERT INTO cartas (nombre, tipo, rareza. habilidad) VALUES ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "')");
                        GetConnection().executeUpdate("INSERT INTO Instantaneo (nombre, cmc, color) values ('" + c.getNombre() + "', '" + c.getCoste(c) + "', '" + c.getCol(c) + "')");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case "tierra":
                    GetConnection().executeUpdate("INSERT INTO cartas (nombre, tipo, rareza. habilidad) VALUES ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "')");
                    GetConnection().executeUpdate("INSERT INTO Tierra (nombre) VALUES ('" + c.getNombre() + "')");
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object[][] seleccionarLista() {
        ResultSet rs = null;
        //Array
        try {
            Statement st = (Statement) conexion.createStatement();
            rs = (ResultSet) st.executeQuery("SELECT * FROM cartas");
            //boolean r = rs.next();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //return rs;
            return ResultSetToArray(rs);
        }
    }

    private Object[][] ResultSetToArray(ResultSet rs) {
        Object obj[][] = null;
        int j = 0;
        try {
            rs.last();
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            int numCols = rsmd.getColumnCount();
            int numFils = rs.getRow();
            obj = new Object[numFils][numCols];
            rs.beforeFirst();
            while (rs.next()) {
                for (int i = 0; i < numCols; i++) {
                    obj[j][i] = rs.getObject(i + 1);
                }
                j++;
            }
        } catch (Exception e) {
        }
        return obj;
    }

    public void editar(Cartas c, String nom) {
        String tipo = c.getTipo();
        try {
            switch (tipo) {
                case "criatura":
                    try {
                        GetConnection().executeUpdate("UPDATE INTO carta (nombre, tipo, rareza, habilidad) values ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "') WHERE nombre='" + nom + "')");
                        GetConnection().executeUpdate("UPDATE INTO criatura (nombre, cmc, color, fuerza, defensa) values ('" + c.getNombre() + "', '" + c.getCoste(c) + "', '" + c.getCol(c) + "', '" + c.getFue(c) + "', '" + c.getDef(c) + "') WHERE nombre='" + nom + "'");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case "artefacto":
                    try {
                        GetConnection().executeUpdate("UPDATE INTO carta (nombre, tipo, rareza, habilidad) values ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "') WHERE nombre='" + nom + "')");
                        GetConnection().executeUpdate("UPDATE INTO artefacto (nombre, cmc, color) values ('" + c.getNombre() + "', '" + c.getCoste(c) + "', '" + c.getCol(c) + "') WHERE nombre='" + nom + "'");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case "conjuro":
                    try {
                        GetConnection().executeUpdate("UPDATE INTO carta (nombre, tipo, rareza, habilidad) values ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "') WHERE nombre='" + nom + "')");
                        GetConnection().executeUpdate("UPDATE INTO conjuro (nombre, cmc, color) values ('" + c.getNombre() + "', '" + c.getCoste(c) + "', '" + c.getCol(c) + "') WHERE nombre='" + nom + "'");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case "encantamiento":
                    try {
                        GetConnection().executeUpdate("UPDATE INTO carta (nombre, tipo, rareza, habilidad) values ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "') WHERE nombre='" + nom + "')");
                        GetConnection().executeUpdate("UPDATE INTO encantamento (nombre, cmc, color) values ('" + c.getNombre() + "', '" + c.getCoste(c) + "', '" + c.getCol(c) + "') WHERE nombre='" + nom + "'");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case "instantaneo":
                    try {
                        GetConnection().executeUpdate("UPDATE INTO carta (nombre, tipo, rareza, habilidad) values ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "') WHERE nombre='" + nom + "')");
                        GetConnection().executeUpdate("UPDATE INTO Instantaneo (nombre, cmc, color) values ('" + c.getNombre() + "','" + c.getCoste(c) + "', '" + c.getCol(c) + "' WHERE nombre='" + nom + "')");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }   break;
                case "tierra":
                    GetConnection().executeUpdate("UPDATE INTO carta (nombre, tipo, rareza, habilidad) values ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "') WHERE nombre='" + nom + "')");
                    GetConnection().executeUpdate("UPDATE INTO Tierra (nombre) VALUES ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "' ) WHERE nombre='" + nom + "'");
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
