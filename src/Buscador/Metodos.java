/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscador;

import Objetos.*;
//<<<<<<< HEAD
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//=======
//>>>>>>> origin/master

/**
 *
 * @author rsaaperez
 */
public class Metodos {

    //Creamos un metodo para comprobar si existen las cartas.
    public static boolean existe(String nomeBuscar) {
        Conexion cox = new Conexion();
        Cartas aux[][] = null;
        boolean existe = false;
        try {
            aux = (Cartas[][]) cox.seleccionarLista();
            for (int i = 0; i < aux.length; i++) {
                for (int j = 0; j < aux[i].length; j++) {
                    if (aux[i][j].getNombre().compareToIgnoreCase(nomeBuscar) == 0) {
                        existe = true;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("erro existe " + ex.getMessage());
        } finally {
            return existe;
        }
    }

    //Creamos un metodo para crear los objetos y llamar a insertar en la clase conexion.
    public static void insertar(String nombre, String tipo, String rareza, String habilidad, int cmc, String color, int fuerza, int defensa) {
        Cartas c = null;
        Conexion cox = new Conexion();
        if (existe(nombre) == false) {
            switch (tipo) {
                case "criatura":
                    c = new Criatura(cmc, color, habilidad, fuerza, defensa, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "encantamiento":
                    c = new Encantamiento(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "artefacto":
                    c = new Artefacto(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "instantaneo":
                    c = new Instantaneo(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "conjuro":
                    c = new Conjuro(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "tierra":
                    c = new Tierra(habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
            }
        }
    }

    //Creamos un metodo para crear los objetos y llamar a editar en la clase conexion.
    public static void editar(String nombreViejo, String nombre, String tipo, String rareza, String habilidad, int cmc, String color, int fuerza, int defensa) {
        Cartas c = null;
        Conexion cox = new Conexion();
        if (existe(nombreViejo) == false) {
            switch (tipo) {
                case "criatura":
                    c = new Criatura(cmc, color, habilidad, fuerza, defensa, nombre, tipo, rareza);
                    cox.editar(c, nombreViejo);
                    break;
                case "encantamiento":
                    c = new Encantamiento(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombreViejo);
                    break;
                case "artefacto":
                    c = new Artefacto(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombreViejo);
                    break;
                case "instantaneo":
                    c = new Instantaneo(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombreViejo);
                    break;
                case "conjuro":
                    c = new Conjuro(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombreViejo);
                    break;
                case "tierra":
                    c = new Tierra(habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombreViejo);
                    break;
            }
        }
    }

    public static Cartas buscar(String nombre, String tipo, String rareza, String habilidad) {
        Cartas c = null;
        Conexion cox = new Conexion();
        Cartas aux[][] = null;
        ResultSet s = null;
        if (existe(nombre) == true) {
            aux = (Cartas[][]) cox.seleccionarLista();
            switch (tipo) {
                case "criatura":
                    for (int i = 0; i < aux.length; i++) {
                        for (int j = 0; j < aux[i].length; j++) {
                            if (aux[i][j].getTipo().compareToIgnoreCase(tipo) == 0) {
                                if (rareza.equalsIgnoreCase(aux[i][j].getRareza())) {
                                    if (habilidad.equalsIgnoreCase(aux[i][j].getHabilidad())) {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarCria(nombre);
                                            try {
                                                c = new Criatura(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), s.getInt("fuerza"), s.getInt("defensa"), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    } else {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarCria(nombre);
                                            try {
                                                c = new Criatura(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), s.getInt("fuerza"), s.getInt("defensa"), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                } else {
                                    if (habilidad.equalsIgnoreCase(aux[i][j].getHabilidad())) {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarCria(nombre);
                                            try {
                                                c = new Criatura(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), s.getInt("fuerza"), s.getInt("defensa"), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    } else {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarCria(nombre);
                                            try {
                                                c = new Criatura(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), s.getInt("fuerza"), s.getInt("defensa"), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "encantamiento":
                    for (int i = 0; i < aux.length; i++) {
                        for (int j = 0; j < aux[i].length; j++) {
                            if (aux[i][j].getTipo().compareToIgnoreCase(tipo) == 0) {
                                if (rareza.equalsIgnoreCase(aux[i][j].getRareza())) {
                                    if (habilidad.equalsIgnoreCase(aux[i][j].getHabilidad())) {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarEncan(nombre);
                                            try {
                                                c = new Encantamiento(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    } else {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarEncan(nombre);
                                            try {
                                                c = new Encantamiento(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                } else {
                                    if (habilidad.equalsIgnoreCase(aux[i][j].getHabilidad())) {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarEncan(nombre);
                                            try {
                                                c = new Encantamiento(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    } else {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarEncan(nombre);
                                            try {
                                                c = new Encantamiento(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "artefacto":
                    for (int i = 0; i < aux.length; i++) {
                        for (int j = 0; j < aux[i].length; j++) {
                            if (aux[i][j].getTipo().compareToIgnoreCase(tipo) == 0) {
                                if (rareza == aux[i][j].getRareza()) {
                                    if (habilidad.equalsIgnoreCase(aux[i][j].getHabilidad())) {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarArte(nombre);
                                            try {
                                                c = new Artefacto(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    } else {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarArte(nombre);
                                            try {
                                                c = new Artefacto(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                } else {
                                    if (habilidad.equalsIgnoreCase(aux[i][j].getHabilidad())) {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarArte(nombre);
                                            try {
                                                c = new Artefacto(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    } else {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarArte(nombre);
                                            try {
                                                c = new Artefacto(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "instantaneo":
                    for (int i = 0; i < aux.length; i++) {
                        for (int j = 0; j < aux[i].length; j++) {
                            if (aux[i][j].getTipo().compareToIgnoreCase(tipo) == 0) {
                                if (rareza.equalsIgnoreCase(aux[i][j].getRareza())) {
                                    if (habilidad.equalsIgnoreCase(aux[i][j].getHabilidad())) {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarInst(nombre);
                                            try {
                                                c = new Instantaneo(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    } else {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarInst(nombre);
                                            try {
                                                c = new Instantaneo(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                } else {
                                    if (habilidad.equalsIgnoreCase(aux[i][j].getHabilidad())) {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarInst(nombre);
                                            try {
                                                c = new Instantaneo(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    } else {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarInst(nombre);
                                            try {
                                                c = new Instantaneo(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "conjuro":
                    for (int i = 0; i < aux.length; i++) {
                        for (int j = 0; j < aux[i].length; j++) {
                            if (aux[i][j].getTipo().compareToIgnoreCase(tipo) == 0) {
                                if (rareza.equalsIgnoreCase(aux[i][j].getRareza())) {
                                    if (habilidad.equalsIgnoreCase(aux[i][j].getHabilidad())) {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarConj(nombre);
                                            try {
                                                c = new Conjuro(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    } else {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarConj(nombre);
                                            try {
                                                c = new Conjuro(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                } else {
                                    if (habilidad.equalsIgnoreCase(aux[i][j].getHabilidad())) {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarConj(nombre);
                                            try {
                                                c = new Conjuro(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    } else {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            s = cox.seleccionarConj(nombre);
                                            try {
                                                c = new Conjuro(s.getInt("cmc"), s.getString("color"), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                            } catch (SQLException ex) {
                                                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "tierra":
                    for (int i = 0; i < aux.length; i++) {
                        for (int j = 0; j < aux[i].length; j++) {
                            if (aux[i][j].getTipo().compareToIgnoreCase(tipo) == 0) {
                                if (rareza.equalsIgnoreCase(aux[i][j].getRareza())) {
                                    if (habilidad.equalsIgnoreCase(aux[i][j].getHabilidad())) {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            c = new Tierra(aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                        }
                                    } else {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            c = new Tierra(aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                        }
                                    }
                                } else {
                                    if (habilidad.equalsIgnoreCase(aux[i][j].getHabilidad())) {
                                        if (nombre.equalsIgnoreCase(aux[i][j].getNombre())) {
                                            c = new Tierra(aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                        }
                                    } else {
                                        if (nombre.equals(aux[i][j].getNombre())) {
                                            c = new Tierra(aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
        }
        return c;
    }

}
