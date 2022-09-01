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
public class Validador {
    //<editor-fold defaultstate="collapsed" desc="validaciones comedor">
    //Los beneficiarios del comedor deben ser entre 50 y 200
    public boolean validaBeneficiarios(int beneficiarios){
        return(beneficiarios>=50 && beneficiarios<=200);
    }
    //nombre y codigo no vacio
    public boolean validaNoVacio(String valor){
        return(!valor.isEmpty());
    }
    //La fecha del comedor no debe ser menor a tres días de la fecha actual.
    public boolean validaFecha(Date fecha){
        //Date fechaActual=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); 
        calendar.add(Calendar.DATE, 3); 
        return fecha.after(calendar.getTime());
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="validaciones delegado">
    //El delegado puede ser nuevo (N) o antiguo (A).
    public boolean validaTipoDelegado(char tipoDelegado){
        return(tipoDelegado=='N' || tipoDelegado=='A' ||
                tipoDelegado=='n' || tipoDelegado=='a');
    }   
//</editor-fold>
}
