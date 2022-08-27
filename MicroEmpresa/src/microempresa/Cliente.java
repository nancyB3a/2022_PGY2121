/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microempresa;

/**
 *
 * @author NBBS
 */
public class Cliente {
    /*Del cliente, su run, dv, nombre, mail, dirección y teléfono,*/
    //atributos
    private int rut, telefono;
    private char dv;
    private String nombre, direccion, mail;
    //constructores

    public Cliente() {
    }

    public Cliente(int rut, int telefono, char dv, String nombre, String direccion, String mail) {
        this.rut = rut;
        this.telefono = telefono;
        this.dv = dv;
        this.nombre = nombre;
        this.direccion = direccion;
        this.mail = mail;
    }
    //get and set

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
