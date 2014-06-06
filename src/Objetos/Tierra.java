/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;

/**
 *
 * @author mperezsilva
 */
public class Tierra extends Cartas implements Serializable{
 
    public Tierra() {
    }

    public Tierra(String habilidad, String nombre, String tipo, String rareza) {
        super(nombre, tipo, rareza, habilidad);
    }
 
}
