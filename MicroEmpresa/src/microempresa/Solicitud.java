/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microempresa;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nanbe
 */
public class Solicitud {
    /*La solicitud del cliente, tiene un número de solicitud, una fecha, 
    un cliente, un total y varios productos*/
    //atributos
    private int numero,total;
    private Date fecha;
    private Cliente cliente;
    private String productos;
    //constructores

    public Solicitud() {
    }

    public Solicitud(int numero, int total, Date fecha, Cliente cliente, String productos) {
        this.numero = numero;
        this.total = total;
        this.fecha = fecha;
        this.cliente = cliente;
        this.productos = productos;
    }
    //Get and Set

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }
    
    //Customer
    //Un método que permite agregar productos a la solicitud
    public void agregarProducto(Producto producto){
        String uniMedida="";
        if (producto.getMedida()=='U') {
            uniMedida="unidades";
        }
        else{
            uniMedida="gramos";
        }
        this.total = this.total + producto.getPrecio();
        this.productos=this.productos + producto.getDescripcion() + " " + 
                producto.getCantidad()+ " " + uniMedida+ " $" +
                producto.getPrecio() + ";\n";
        //"Durazno+" "+300+" "+gramos+" $"+500
    }
    //Un método que permite ver el detalle del pedido del cliente
    public void verSolicitud(){
        SimpleDateFormat formated= new SimpleDateFormat("dd-MMM-yyyy");
        System.out.println("Solicitud: " + this.numero);
        System.out.println("******************************************");
        System.out.println("Cliente: " + this.cliente.getNombre());
        System.out.println("Fecha: " + formated.format(this.fecha));
        System.out.println(this.productos);
        System.out.println("******************************************");
        System.out.println("Total: $" + this.total);
    }
    //Un método que permite realizar un descuento en un % variable
    public int descontar(int porcentaje){
        int descuento= (int)(this.total*porcentaje/100);
        return descuento;
        //return (int)(this.total*porcentaje/100);
    }
    /*Un método que obtenga el número de la solicitud, el 
    cual será un correlativo*/
    public int obtenerNroSolicitud(){
        this.numero=this.numero+1;
        return this.numero;
    }
    
}
