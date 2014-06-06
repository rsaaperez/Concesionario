/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author mperezsilva
 */
public class Conjuro extends Cartas{
    private int cmc;
    private String color;

    public Conjuro() {
    }

    public Conjuro(int cmc, String color, String habilidad, String nombre, String tipo, String rareza) {
        super(nombre, tipo, rareza, habilidad);
        this.cmc = cmc;
        this.color = color;
    }

    public int getCmc() {
        return cmc;
    }

    public void setCmc(int cmc) {
        this.cmc = cmc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
