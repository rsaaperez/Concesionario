/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Concesionario;

import Objetos.*;
import java.sql.SQLException;

/**
 *
 * @author rsaaperez
 */
public class Metodos {

    //Creamos un metodo para crear los objetos y llamar a insertar en la clase conexion.
    public static void insertar(String marca, String modelo, String año, String precio) throws SQLException {
        Conexion cox = new Conexion();
        Coche c = new Coche(marca, modelo, año, precio);
        cox.insertar(c);
    }

    //Creamos un metodo para crear los objetos y llamar a editar en la clase conexion.
    public static void editar(String modeloViejo, String modelo, String año, String precio, String marca) throws SQLException {
        Conexion cox = new Conexion();
        Coche c = new Coche(marca, modelo, año, precio);
        cox.editar(c, modeloViejo);
    }
    //Creamos un metodo para borrar.
    public static void borrar(String modelo) throws SQLException {
        Conexion cox = new Conexion();
        cox.borrar(modelo);
    }
    public static void ver(String modelo) throws SQLException{
        Conexion cox= new Conexion();
        cox.Select_Coches_Marca(modelo);
    }
    
}
