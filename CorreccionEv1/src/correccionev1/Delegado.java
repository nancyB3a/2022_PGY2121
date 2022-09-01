/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correccionev1;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author nanbe
 */
public class Delegado {
//<editor-fold defaultstate="collapsed" desc="atributos">
    private String nombre;
    private int rut;
    private char tipoDelegado; //N ó A
    private String correo;
    private Comedor comedor;   //colaboración 
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="constructores">
      public Delegado(String nombre, int rut, char tipoDelegado, String correo, Comedor comedor) {
        this.nombre = nombre;
        this.rut = rut;
        this.tipoDelegado = tipoDelegado;
        this.correo = correo;
        this.comedor = comedor;
    }

    public Delegado() {
    }  
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="accesadores y mutadores">

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public char getTipoDelegado() {
        return tipoDelegado;
    }

    public void setTipoDelegado(char tipoDelegado) {
        this.tipoDelegado = tipoDelegado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Comedor getComedor() {
        return comedor;
    }

    public void setComedor(Comedor comedor) {
        this.comedor = comedor;
    }
    
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="customer">
    @Override
    public String toString() {
        return "Delegado{" + "nombre=" + nombre + ", rut=" + rut + ", tipoDelegado=" + tipoDelegado + ", correo=" + correo + ", " + comedor + '}';
    } 
    /*Debe existir un método que permita realizar un aporte adicional al comedor, 
    dependiendo del delegado y del comedor. Si el delegado tiene antigüedad en 
    su cargo o el comedor solidario tiene más de 150 beneficiarios, se aplicará 
    un aporte adicional de x%.*/
    public void aporteAdicional(double porcentajeAdicional){
        double adicional=0;
        if (this.tipoDelegado=='A' || this.comedor.getBeneficiarios()>150) {
            adicional=this.comedor.getValorAporte()*(porcentajeAdicional/100);
            adicional+=this.comedor.getValorAporte();
            this.comedor.setValorAporte((int)adicional);
        }
    }
    /*Debe existir un método que permita enviar un correo recordatorio al 
    delegado cuando falten cinco días o menos del comedor para retirar el dinero asignado.*/
    public void enviarCorreo(){
        //Date fechaActual=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); 
        calendar.add(Calendar.DATE, 5); 
        if (this.comedor.getFecha().before(calendar.getTime()) ) {
            System.out.println("Para: "+ this.correo);
            System.out.println("Asunto: Recordatorio Comedor Solidario " + this.comedor.getCodigo());
            System.out.println("Estimado: " + this.nombre + ", recuerde que el próximo " + this.comedor.getFecha());
            System.out.println("Se realizará el comedor: "+ this.comedor.getCodigo());
            System.out.println("Saludos!");
        }
    }
//</editor-fold>


}
