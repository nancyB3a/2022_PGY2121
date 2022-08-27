/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microempresa;

import java.util.Date;

/**
 *
 * @author NBBS
 */
public class Valida {
    //valor debe ser mayor a 0
    public boolean validarNumeroPositivo(int valor){
        /*if (valor>0) {
            return true;
        }else{
            return false;
        }*/
        return(valor>0);
    }
    //El código del producto debe tener largo 4 --> es un int
    public boolean validarLargo4(int valor) {
       /* if (valor>=1000 && valor<=9999) {
            return true;
        }else{
            return false;
        }*/
       return (valor>=1000 && valor<=9999);
    }
    //La subcategoría debe ser Fruta o Verdura
    public boolean validarSubcategoria(String subcategoria){
        /*if (subcategoria.equalsIgnoreCase("FRUTA") || subcategoria.equalsIgnoreCase("VERDURA") ) {
            return true;
        }else{
            return false;
        }*/
        return (subcategoria.equalsIgnoreCase("FRUTA") || subcategoria.equalsIgnoreCase("VERDURA") ) ;
    }
    //El teléfono debe tener largo 8-->int (10000000 - 99999999)
    public boolean validarLargo8(int valor){
        String cualquierString= valor+"";
       /* if(aux.length()==8){
            return true;
        }else{
            return false;
        }*/
       return (cualquierString.length()==8);
    }
    //El mail debe tener largo mínimo de 6
    public boolean validarCorreo(String correo){
        return (correo.length()>=6);
    }
    //La fecha de la solicitud debe ser menor o igual a la actual
    public boolean validarFecha(Date fechaSolicitud){
        Date fechaActual= new Date();
        /*if (fechaSolicitud.compareTo(fechaActual)<=0) {
            return true;
        }else{
            return false;
        }*/        
        return (fechaSolicitud.compareTo(fechaActual)<=0);
    }
    //TAREA: RUT
}
