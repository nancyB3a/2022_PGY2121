/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitienda;

/**
 *
 * @author nanbe
 */
public class Trabajador {
    //El trabajador tiene un run, dv y nombre
    private int rut;
    private char dv;
    private String nombre;
    
    //Constructores
    public Trabajador() {
    }

    public Trabajador(int rut, char dv, String nombre) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
    }

    //Accesadores y Mutadores
    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "rut=" + rut + "-" + dv + ", nombre=" + nombre + '}';
    }
    
}
