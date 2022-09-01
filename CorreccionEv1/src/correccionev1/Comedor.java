/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correccionev1;

import java.util.Date;
/**
 *
 * @author nanbe
 */
public class Comedor {
//<editor-fold defaultstate="collapsed" desc="atributos">
    private String codigo;
    private Date fecha;
    private int beneficiarios;
    private int valorAporte;
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="constructores">
    public Comedor() {
    }

    public Comedor(String codigo, Date fecha, int beneficiarios, int valorAporte) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.beneficiarios = beneficiarios;
        this.valorAporte = valorAporte;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="accesadores y mutadores">
    public int getValorAporte() {
        return valorAporte;
    }
    public void setValorAporte(int valorAporte) {
        this.valorAporte = valorAporte;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   
    public int getBeneficiarios() {
        return beneficiarios;
    }

    public void setBeneficiarios(int beneficiarios) {
        this.beneficiarios = beneficiarios;
    }

        
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="customer">
    @Override
    public String toString() {
        return "Comedor{" + "codigo=" + codigo + ", fecha=" + fecha + ", beneficiarios=" + beneficiarios + ", valorAporte=" + valorAporte + '}';
    }
    //Debe existir un método que permita mostrar la información del comedor solidario.
    public void imprimir(){
        System.out.println("Comedor Solidario: "+ this.codigo);
        System.out.println("____________________________________________________");
        System.out.println("Fecha del Comedor: "+this.fecha);
        System.out.println("Platos Disponibles: "+this.beneficiarios);
        System.out.println("Valor Asignado: $"+this.valorAporte);
        System.out.println("____________________________________________________");
    }
    
//</editor-fold>


}
