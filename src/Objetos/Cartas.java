/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;


/**
 *
 * @author rsaaperez
 */
public class Cartas{
    //Creamos los elementos privados.

    private String nombre;
    private String tipo;
    private String habilidad;
    private String rareza;
    //Creamos los constructores de nuestra clase.

    public Cartas() {
        //Vacio.
    }

    public Cartas(String nombre, String tipo, String rareza, String habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.rareza = rareza;
        this.habilidad = habilidad;
    }

    //Generamos los getters  y los setters necesarios para manejar nuestros elementos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRareza() {
        return rareza;
    }

    public void setRareza(String rareza) {
        this.rareza = rareza;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
}
