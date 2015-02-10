/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Concesionario;

import Objetos.Coche;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author rsaaperez
 */
public class Conexion {

    //Establecemos connection para conectarse a la base de datos
    private static java.sql.Connection connection = null;
    //Utilizamos localhost ya que el servidor correra en nuestra propia maquina
    private static final String URLDerby = "jdbc:derby://localhost:1527/Concesionario1";
    //Establecemos el usuario y la contrasena para conectarnos a la base de datos
    private static final String user = "raul";
    private static final String password = "raul";

    public static java.sql.Connection getConexion() throws SQLException {
        connection = DriverManager.getConnection(URLDerby, user, password);
        return connection;
    }

    public static Statement getStatement() throws SQLException {
        Statement st = (Statement) getConexion().createStatement();
        return st;
    }

    public static void insertar(Coche c) throws SQLException {
        getStatement().executeUpdate("Insert Into coche Values ('" + c.getModelo() + "', '" + c.getMarca() + "', '" + c.getAño() + "', '" + c.getPrecio() + "')");
    }

    public static void editar(Coche c, String modeloViejo) throws SQLException {
        getStatement().executeUpdate("UPDATE coche set modelo='" + c.getModelo() + "', marca='" + c.getMarca() + "', año='" + c.getAño() + "', precio='" + c.getPrecio() + "' WHERE modelo='" + modeloViejo + "'");
    }
    public static void borrar(String modelo) throws SQLException {
        getStatement().executeUpdate("DELETE from coche where modelo='"+modelo+"'");
    }

    public Object[][] Select_Coches() {
        int registros = 0;
        String consulta = "Select modelo, marca, año, precio FROM coche ";
        String consulta2 = "Select count(*) as total from coche ";
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = getConexion().prepareStatement(consulta2);
            java.sql.ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][4];
        //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try {
            PreparedStatement pstm = getConexion().prepareStatement(consulta);
            java.sql.ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString("modelo");
                data[i][1] = res.getString("marca");
                data[i][2] = res.getString("año");
                data[i][3] = res.getString("precio");
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
    public Object[][] Select_Coches_Marca(String marcas) {
        int registros = 0;
        String consulta = "Select modelo, marca, año, precio FROM coche where marca='"+marcas+"'";
        String consulta2 = "Select count(*) as total from coche where marca='"+marcas+"'";
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = getConexion().prepareStatement(consulta2);
            java.sql.ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[registros][4];
        //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try {
            PreparedStatement pstm = getConexion().prepareStatement(consulta);
            java.sql.ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString("modelo");
                data[i][1] = res.getString("marca");
                data[i][2] = res.getString("año");
                data[i][3] = res.getString("precio");
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public DefaultComboBoxModel LlenarComboBox() {
        DefaultComboBoxModel listmodel = null;
        try {
            listmodel = new DefaultComboBoxModel();
            PreparedStatement pstm = getConexion().prepareStatement(" SELECT modelo, marca, año, precio FROM coche ");
            java.sql.ResultSet res = pstm.executeQuery();
            try {
                while (res.next()) {
                    listmodel.addElement(res.getString("modelo"));
                }
                res.close();
            } catch (SQLException ex) {
                System.err.println("Error consulta :" + ex.getMessage());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listmodel;
    }
}
