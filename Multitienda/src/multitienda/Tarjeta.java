/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitienda;

import java.util.Date;

/**
 *
 * @author nanbe
 */
public class Tarjeta {
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    

 //La tarjeta tiene un código, clave, monto, vigencia y trabajador
    private long codigo;
    private int clave, monto;
    private Date vigencia;
    private Trabajador trabajador;
//Colaboración//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    

    public Tarjeta() {
    }

    public Tarjeta(long codigo, int clave, int monto, Date vigencia, Trabajador trabajador) {
        this.codigo = codigo;
        this.clave = clave;
        this.monto = monto;
        this.vigencia = vigencia;
        this.trabajador = trabajador;
    }
//</editor-fold>   
    //<editor-fold defaultstate="collapsed" desc="Accesadores y Mutadores">    
     public int getMonto() {
        return monto;
    }
    public void setMonto(int monto) {
        this.monto = monto;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
   //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="Customers">
    /*
♦ Un método que genere un código correlativo de la tarjeta de 16 dígitos.
♦ Un método que valide la clave del trabajador, siendo ésta los 4 primeros dígitos del run.
♦ Un método que permita validar si el monto cubre la compra que se desea realizar.
♦ Un método que permita descontar del monto de la tarjeta el valor de la compra realizada.
♦ Un método que valide si la tarjeta está vigente.
    */

    @Override
    public String toString() {
        return "Tarjeta{" + "codigo=" + codigo + ", clave=" + clave + ", monto=" + monto + ", vigencia=" + vigencia + ", " + trabajador + '}';
    }

    
    public long correlativo(){
        if (codigo==0) {//1000000000000000
            this.codigo=(long)Math.pow(100000, 3);
        }else{
            this.codigo= this.codigo + 1;
        }      
        return this.codigo;
    }
    public boolean validaClave(){
        String pass= this.trabajador.getRut()+"";
        //String code=this.clave+"";
        //return (pass.substring(0,4).equals(code));
        return(Integer.valueOf(pass.substring(0,4))==this.clave);         
    }
    public boolean validaCompra(int total){
        return (total<=this.monto);
    }
    public void rebajaMonto(int total){
        this.monto-=total;//this.monto=this.monto-total;
    }
    public boolean validaVigencia(){
        Date fecha= new Date();
        return this.vigencia.compareTo(fecha)>=0;
    }
    //</editor-fold>
}
