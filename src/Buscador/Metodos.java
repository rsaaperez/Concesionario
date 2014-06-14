/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscador;

import Objetos.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        if (existe(nombre) == true) {
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

    public static void buscar(String nombre, String tipo, String rareza, String habilidad) {
        Cartas c = null;
        Conexion cox = new Conexion();
        Cartas aux[][] = null;
        if (existe(nombre) == true) {
            aux = (Cartas[][]) cox.seleccionarLista();
            switch (tipo) {
                case "criatura":
                    for (int i = 0; i < aux.length; i++) {
                        for (int j = 0; j < aux[i].length; j++) {
                            if (aux[i][j].getTipo().compareToIgnoreCase(tipo) == 0) {
                                if (rareza == aux[i][j].getRareza()) {
                                    if (habilidad == aux[i][j].getHabilidad()) {
                                        c = new Criatura(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getFue(c), aux[i][j].getDef(c), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    } else {
                                        c = new Criatura(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getFue(c), aux[i][j].getDef(c), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    }
                                } else {
                                    if (habilidad == aux[i][j].getHabilidad()) {
                                        c = new Criatura(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getFue(c), aux[i][j].getDef(c), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    } else {
                                        c = new Criatura(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getFue(c), aux[i][j].getDef(c), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
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
                                if (rareza == aux[i][j].getRareza()) {
                                    if (habilidad == aux[i][j].getHabilidad()) {
                                        c = new Encantamiento(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    } else {
                                        c = new Encantamiento(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    }
                                } else {
                                    if (habilidad == aux[i][j].getHabilidad()) {
                                        c = new Encantamiento(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    } else {
                                        c = new Encantamiento(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
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
                                    if (habilidad == aux[i][j].getHabilidad()) {
                                        c = new Artefacto(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    } else {
                                        c = new Artefacto(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    }
                                } else {
                                    if (habilidad == aux[i][j].getHabilidad()) {
                                        c = new Artefacto(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    } else {
                                        c = new Artefacto(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
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
                                if (rareza == aux[i][j].getRareza()) {
                                    if (habilidad == aux[i][j].getHabilidad()) {
                                        c = new Instantaneo(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    } else {
                                        c = new Instantaneo(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    }
                                } else {
                                    if (habilidad == aux[i][j].getHabilidad()) {
                                        c = new Instantaneo(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    } else {
                                        c = new Instantaneo(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
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
                                if (rareza == aux[i][j].getRareza()) {
                                    if (habilidad == aux[i][j].getHabilidad()) {
                                        c = new Conjuro(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    } else {
                                        c = new Conjuro(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    }
                                } else {
                                    if (habilidad == aux[i][j].getHabilidad()) {
                                        c = new Conjuro(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    } else {
                                        c = new Conjuro(aux[i][j].getCoste(c), aux[i][j].getCol(c), aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
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
                                if (rareza == aux[i][j].getRareza()) {
                                    if (habilidad == aux[i][j].getHabilidad()) {
                                        c = new Tierra(aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    } else {
                                        c = new Tierra(aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    }
                                } else {
                                    if (habilidad == aux[i][j].getHabilidad()) {
                                        c = new Tierra(aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    } else {
                                        c = new Tierra(aux[i][j].getHabilidad(), aux[i][j].getNombre(), aux[i][j].getTipo(), aux[i][j].getRareza());
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
        }
    }

}
