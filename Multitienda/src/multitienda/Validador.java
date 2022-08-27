/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitienda;

/**
 *
 * @author Nancy
 */
public class Validador {
    /*Validaciones
♦ El nombre del trabajador no debe estar vacío
♦ El dígito del trabajador puede ser un número del 0 al 9 o la letra K
♦ El monto debe ser mayor igual a 0*/
   
    public boolean validaNombre(String nombre){
       return(!nombre.equals(""));
    }
    public boolean validaDv(char dv){
        boolean flag;
        switch(dv){
            case '0': case '1': case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':case 'k':case 'K':
               flag=true; 
               break; 
            default:
                flag=false;
        }
        return flag;
    }
    public boolean validaMonto(int monto){
        return (monto>=0);
    }
}
