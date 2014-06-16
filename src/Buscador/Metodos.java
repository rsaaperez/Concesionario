/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscador;

import Objetos.*;

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
                case "Criatura":
                    c = new Criatura(cmc, color, habilidad, fuerza, defensa, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "Encantamiento":
                    c = new Encantamiento(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "Artefacto":
                    c = new Artefacto(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "Instantaneo":
                    c = new Instantaneo(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "Conjuro":
                    c = new Conjuro(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.insertar(c);
                    break;
                case "Tierra":
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
                case "Criatura":
                    c = new Criatura(cmc, color, habilidad, fuerza, defensa, nombre, tipo, rareza);
                    cox.editar(c, nombreViejo);
                    break;
                case "Encantamiento":
                    c = new Encantamiento(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombreViejo);
                    break;
                case "Artefacto":
                    c = new Artefacto(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombreViejo);
                    break;
                case "Instantaneo":
                    c = new Instantaneo(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombreViejo);
                    break;
                case "Conjuro":
                    c = new Conjuro(cmc, color, habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombreViejo);
                    break;
                case "Tierra":
                    c = new Tierra(habilidad, nombre, tipo, rareza);
                    cox.editar(c, nombreViejo);
                    break;
            }
        }
    }
}
