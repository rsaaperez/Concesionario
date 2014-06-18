/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscador;

import Objetos.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author DAM1_15
 */
public class Conexion {

    Connection conexion = null;
    String servidor = "jdbc:mysql://localhost/buscadormagic";
    String usuarioDB = "root";
    String passwordDB = "root";
    String url = "jdbc:mysql://localhost/" + servidor;

    public Conexion() {
        try {
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //obtenemos la conexión
            conexion = (Connection) DriverManager.getConnection(url, usuarioDB, passwordDB);
            if (conexion != null) {
                System.out.println("OK base de datos " + servidor + " listo");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public java.sql.Connection getConnection() {
        return this.conexion;
    }

    public Statement GetConnection() {
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
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

    public Object[][] Select_Cartas() {
        int registros = 0;
        String consulta = "Select nombre,tipo,rareza,habilidad FROM cartas ";
        String consulta2 = "Select count(*) as total from cartas ";
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = conexion.prepareStatement(consulta2);
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
            PreparedStatement pstm = conexion.prepareStatement(consulta);
            java.sql.ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                data[i][0] = res.getString("nombre");
                data[i][1] = res.getString("tipo");
                data[i][2] = res.getString("rareza");
                data[i][3] = res.getString("habilidad");
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
            PreparedStatement pstm = conexion.prepareStatement(" SELECT * FROM cartas ");
            java.sql.ResultSet res = pstm.executeQuery();
            try {
                while (res.next()) {
                    listmodel.addElement(res.getString("nombre"));
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

    public void insertar(Cartas c) {
        String tipo = c.getTipo();
        try {
            switch (tipo) {
                case "Criatura":
                    try {
                        GetConnection().executeUpdate("Insert Into cartas Values ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "')");
                        GetConnection().executeUpdate("INSERT INTO criatura values ('" + c.getNombre() + "', " + c.getCoste(c) + ", '" + c.getCol(c) + "', " + c.getFue(c) + ", " + c.getDef(c) + ")");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Artefacto":
                    try {
                        GetConnection().executeUpdate("INSERT INTO cartas VALUES ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "')");
                        GetConnection().executeUpdate("INSERT INTO artefacto values ('" + c.getNombre() + "', " + c.getCoste(c) + ", '" + c.getCol(c) + "')");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Conjuro":
                    try {
                        GetConnection().executeUpdate("INSERT INTO cartas VALUES ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "')");
                        GetConnection().executeUpdate("INSERT INTO conjuro  values ('" + c.getNombre() + "', " + c.getCoste(c) + ", '" + c.getCol(c) + "')");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Encantamiento":
                    try {
                        GetConnection().executeUpdate("INSERT INTO cartas VALUES ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "')");
                        GetConnection().executeUpdate("INSERT INTO encantamiento values ('" + c.getNombre() + "', " + c.getCoste(c) + ", '" + c.getCol(c) + "')");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Instantaneo":
                    try {
                        GetConnection().executeUpdate("INSERT INTO cartas VALUES ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "')");
                        GetConnection().executeUpdate("INSERT INTO Instantaneo values ('" + c.getNombre() + "', " + c.getCoste(c) + ", '" + c.getCol(c) + "')");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Tierra":
                    GetConnection().executeUpdate("INSERT INTO cartas VALUES ('" + c.getNombre() + "', '" + c.getTipo() + "', '" + c.getRareza() + "', '" + c.getHabilidad() + "')");
                    GetConnection().executeUpdate("INSERT INTO Tierra VALUES ('" + c.getNombre() + "')");
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar(Cartas c, String nom, String tip) {
        String tipo = c.getTipo();
        try {
            switch (tipo) {
                case "Criatura":
                    try {
                        GetConnection().executeUpdate("UPDATE cartas set nombre='" + c.getNombre() + "', tipo='" + c.getTipo() + "', rareza='" + c.getRareza() + "', habilidad='" + c.getHabilidad() + "' WHERE nombre='" + nom + "'");
                        GetConnection().executeUpdate("INSERT INTO criatura values ('" + c.getNombre() + "', " + c.getCoste(c) + ", '" + c.getCol(c) + "', " + c.getFue(c) + ", " + c.getDef(c) + ")");
                        //if ("Instantaneo".equalsIgnoreCase(tip)) {
                            GetConnection().executeUpdate("Delete from instantaneo where nombre ='" + c.getNombre() + "'");
                        //}

                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case "Artefacto":
                    try {
                        GetConnection().executeUpdate("UPDATE cartas set nombre='" + c.getNombre() + "', tipo='" + c.getTipo() + "', rareza='" + c.getRareza() + "', habilidad='" + c.getHabilidad() + "' WHERE nombre='" + nom + "'");
                        GetConnection().executeUpdate("UPDATE artefacto set nombre='" + c.getNombre() + "',cmc=" + c.getCoste(c) + ", color='" + c.getCol(c) + "' WHERE nombre='" + nom + "'");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Conjuro":
                    try {
                        GetConnection().executeUpdate("UPDATE cartas set nombre='" + c.getNombre() + "', tipo='" + c.getTipo() + "', rareza='" + c.getRareza() + "', habilidad='" + c.getHabilidad() + "' WHERE nombre='" + nom + "'");
                        GetConnection().executeUpdate("UPDATE conjuro set nombre='" + c.getNombre() + "',cmc=" + c.getCoste(c) + ", color='" + c.getCol(c) + "' WHERE nombre='" + nom + "'");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Encantamiento":
                    try {
                        GetConnection().executeUpdate("UPDATE cartas set nombre='" + c.getNombre() + "', tipo='" + c.getTipo() + "', rareza='" + c.getRareza() + "', habilidad='" + c.getHabilidad() + "' WHERE nombre='" + nom + "'");
                        GetConnection().executeUpdate("UPDATE encantamiento set nombre='" + c.getNombre() + "',cmc=" + c.getCoste(c) + ", color='" + c.getCol(c) + "' WHERE nombre='" + nom + "'");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Instantaneo":
                    try {
                        GetConnection().executeUpdate("UPDATE cartas set nombre='" + c.getNombre() + "', tipo='" + c.getTipo() + "', rareza='" + c.getRareza() + "', habilidad='" + c.getHabilidad() + "' WHERE nombre='" + nom + "'");
                        GetConnection().executeUpdate("UPDATE instantaneo set nombre='" + c.getNombre() + "',cmc=" + c.getCoste(c) + ", color='" + c.getCol(c) + "' WHERE nombre='" + nom + "'");
                    } catch (SecurityException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Tierra":
                    GetConnection().executeUpdate("UPDATE cartas set nombre='" + c.getNombre() + "', tipo='" + c.getTipo() + "', rareza='" + c.getRareza() + "', habilidad='" + c.getHabilidad() + "' WHERE nombre='" + nom + "'");
                    GetConnection().executeUpdate("UPDATE tierra set nombre='" + c.getNombre() + "' WHERE nombre='" + nom + "'");
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object[][] SelectIns(String nom) {
        String consulta = "Select cartas.nombre,cartas.tipo,cartas.rareza,cartas.habilidad,instantaneo.cmc,instantaneo.color FROM cartas,instantaneo where cartas.nombre='" + nom + "' and instantaneo.nombre='" + nom + "'";
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[1][6];
        //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try {
            PreparedStatement pstm = conexion.prepareStatement(consulta);
            java.sql.ResultSet res = pstm.executeQuery();
            while (res.next()) {
                data[0][0] = res.getString("nombre");
                data[0][1] = res.getString("tipo");
                data[0][2] = res.getString("rareza");
                data[0][3] = res.getString("habilidad");
                data[0][4] = res.getString("cmc");
                data[0][5] = res.getString("color");
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public Object[][] SelectCria(String nom) {
        String consulta = "Select cartas.nombre,cartas.tipo,cartas.rareza,cartas.habilidad,criatura.cmc,criatura.color, criatura.fuerza, criatura.defensa FROM cartas,criatura where cartas.nombre='" + nom + "' and criatura.nombre='" + nom + "'";
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[1][8];
        //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try {
            PreparedStatement pstm = conexion.prepareStatement(consulta);
            java.sql.ResultSet res = pstm.executeQuery();
            while (res.next()) {
                data[0][0] = res.getString("nombre");
                data[0][1] = res.getString("tipo");
                data[0][2] = res.getString("rareza");
                data[0][3] = res.getString("habilidad");
                data[0][4] = res.getString("cmc");
                data[0][5] = res.getString("color");
                data[0][6] = res.getString("fuerza");
                data[0][7] = res.getString("defensa");
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public Object[][] SelectEnc(String nom) {
        String consulta = "Select cartas.nombre,cartas.tipo,cartas.rareza,cartas.habilidad,encantamiento.cmc,encantamiento.color FROM cartas,encantamiento where cartas.nombre='" + nom + "' and encantamiento.nombre='" + nom + "'";
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[1][6];
        //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try {
            PreparedStatement pstm = conexion.prepareStatement(consulta);
            java.sql.ResultSet res = pstm.executeQuery();
            while (res.next()) {
                data[0][0] = res.getString("nombre");
                data[0][1] = res.getString("tipo");
                data[0][2] = res.getString("rareza");
                data[0][3] = res.getString("habilidad");
                data[0][4] = res.getString("cmc");
                data[0][5] = res.getString("color");
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public Object[][] SelectArt(String nom) {
        String consulta = "Select cartas.nombre,cartas.tipo,cartas.rareza,cartas.habilidad,artefacto.cmc,artefacto.color FROM cartas,artefacto where cartas.nombre='" + nom + "' and artefacto.nombre='" + nom + "'";
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[1][6];
        //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try {
            PreparedStatement pstm = conexion.prepareStatement(consulta);
            java.sql.ResultSet res = pstm.executeQuery();
            while (res.next()) {
                data[0][0] = res.getString("nombre");
                data[0][1] = res.getString("tipo");
                data[0][2] = res.getString("rareza");
                data[0][3] = res.getString("habilidad");
                data[0][4] = res.getString("cmc");
                data[0][5] = res.getString("color");
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public Object[][] SelectCon(String nom) {
        String consulta = "Select cartas.nombre,cartas.tipo,cartas.rareza,cartas.habilidad,conjuro.cmc,conjuro.color FROM cartas,conjuro where cartas.nombre='" + nom + "' and conjuro.nombre='" + nom + "'";
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[1][6];
        //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try {
            PreparedStatement pstm = conexion.prepareStatement(consulta);
            java.sql.ResultSet res = pstm.executeQuery();
            while (res.next()) {
                data[0][0] = res.getString("nombre");
                data[0][1] = res.getString("tipo");
                data[0][2] = res.getString("rareza");
                data[0][3] = res.getString("habilidad");
                data[0][4] = res.getString("cmc");
                data[0][5] = res.getString("color");
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public Object[][] SelectTie(String nom) {
        String consulta = "Select nombre,tipo,rareza,habilidad FROM cartas where nombre='" + nom + "'";
        //se crea una matriz con tantas filas y columnas que necesite
        Object[][] data = new String[1][4];
        //realizamos la consulta sql y llenamos los datos en la matriz "Object"
        try {
            PreparedStatement pstm = conexion.prepareStatement(consulta);
            java.sql.ResultSet res = pstm.executeQuery();
            while (res.next()) {
                data[0][0] = res.getString("nombre");
                data[0][1] = res.getString("tipo");
                data[0][2] = res.getString("rareza");
                data[0][3] = res.getString("habilidad");
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
}
