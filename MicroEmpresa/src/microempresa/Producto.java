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
public class Producto {
   /*almacenar del producto el código, subcategoría, descripción, precio, 
    medida (unidad o gramos) y su cantidad*/ 
    
    //atributos
    private int codigo, precio, cantidad;
    private String subcategoria, descripcion;
    private char medida;//U:unidad y G:gramos
    
    //constructores

    public Producto() {
    }

    public Producto(int codigo, int precio, int cantidad, String subcategoria, String descripcion, char medida) {
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
        this.medida = medida;
    }
    //Get y Set

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getMedida() {
        return medida;
    }

    public void setMedida(char medida) {
        this.medida = medida;
    }
    
}
