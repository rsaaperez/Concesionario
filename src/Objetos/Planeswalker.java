/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

/**
 *
 * @author Raúl
 */
public class Planeswalker extends Cartas{
    
    private int cmc;
    private String color;
    private int lealtad;

    public Planeswalker() {
    }

    public Planeswalker(int cmc, String color, String habilidad, int lealtad, String nombre, String tipo, String rareza) {
        super(nombre, tipo, rareza, habilidad);
        this.cmc = cmc;
        this.color = color;
        this.lealtad = lealtad;
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

    public int getLealtad() {
        return lealtad;
    }

    public void setLealtad(int lealtad) {
        this.lealtad = lealtad;
    }

    public int getCoste(Cartas c){
        return cmc;
    }
    public String getCol(Cartas c){
        return color;
    }
    public int getLeal(Cartas c){
        return lealtad;
    }


}
