/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;


/**
 *
 * @author mperezsilva
 */
public class Criatura extends Cartas{

    private int cmc;
    private String color;
    private int fuerza;
    private int defensa;

    public Criatura() {
    }

    public Criatura(int cmc, String color, String habilidad, int fuerza, int defensa, String nombre, String tipo, String rareza) {
        super(nombre, tipo, rareza, habilidad);
        this.cmc = cmc;
        this.color = color;
        this.fuerza = fuerza;
        this.defensa = defensa;
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

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

}
