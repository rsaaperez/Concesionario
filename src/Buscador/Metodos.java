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

    //Creamos un metodo para crear los objetos y llamar a insertar en la clase conexion.
    public static void insertar(String nombre, String tipo, String rareza, String habilidad, int cmc, String color, int fuerza, int defensa, int lealtad) {
        Cartas c = null;
        Conexion cox = new Conexion();
        switch (tipo) {
            case "Criatura":
                c = new Criatura(cmc, color, habilidad, fuerza, defensa, nombre, tipo, rareza);
                cox.insertar(c);
                break;
            case "Planeswalker":
                c = new Planeswalker(cmc, color, habilidad, lealtad, nombre, tipo, rareza);
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

    //Creamos un metodo para crear los objetos y llamar a editar en la clase conexion.
    public static void editar(String nombreViejo, String nombre, String tipo, String rareza, String habilidad, int cmc, String color, int fuerza, int defensa, int lealtad) {
        Cartas c = null;
        Conexion cox = new Conexion();
        switch (tipo) {
            case "Criatura":
                c = new Criatura(cmc, color, habilidad, fuerza, defensa, nombre, tipo, rareza);
                cox.editar(c, nombreViejo);
                break;
            case "Planeswalker":
                c = new Planeswalker(cmc, color, habilidad, lealtad, nombre, tipo, rareza);
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
