/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitienda;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Nancy
 */
public class Multitienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Validador val=new Validador();
        Trabajador trab1=new Trabajador();
        Tarjeta tj1=new Tarjeta();
        int opc;
        do {
            Scanner teclado=new Scanner(System.in);
            System.out.println("1.- Ingresar Trabajador");
            System.out.println("2.- Ingresar Tarjeta");
            System.out.println("3.- Obtener Correlativo");
            System.out.println("4.- Validar Clave");
            System.out.println("5.- Validar Monto y Descontar");
            System.out.println("6.- Ver Vigencia");
            System.out.println("7.- Salir");
            opc=teclado.nextInt();
            switch(opc){
                case 1:
                    String nombre="Juanito";
                    if (val.validaNombre(nombre)) {
                        trab1.setNombre(nombre);
                    }
                    char dv='9';
                    if (val.validaDv(dv)) {
                      trab1.setDv(dv);
                    }
                    trab1.setRut(19879223);
                    break;
                case 2:
                    tj1.setCodigo(tj1.correlativo());
                    tj1.setClave(1987);
                    tj1.setMonto(100000);
                    SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha=new Date();
                    try{
                        fecha=formato.parse("20/09/2020");
                    }catch(Exception ex){}
                    tj1.setVigencia(fecha);
                    tj1.setTrabajador(trab1);
                    System.out.println(tj1.toString());      
                    break;
                case 3:
                    System.out.println("Correlativo: "+ tj1.correlativo());
                    break;
                case 4:
                    if (tj1.validaClave()) {
                        System.out.println("Clave Válida");
                    }else{
                        System.out.println("Clave Inválida");
                    }
                    break;
                case 5:
                    int total=125000;
                    System.out.println("Total: $" + total);
                    if (tj1.validaCompra(total)) {
                        tj1.rebajaMonto(total);
                        System.out.println("Nuevo Monto: $"+ tj1.getMonto());
                    }else{
                        System.out.println("Saldo Insuficiente!! $"+ tj1.getMonto());
                    }
                    break;
                case 6:
                    if (tj1.validaVigencia()) {
                        System.out.println("Vigente");
                    }else{
                        System.out.println("Vencida");
                    }
                    break;
                case 7:
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Error, opción Inválida!!!"); 
            }
            
        } while (opc!=7);
        
        
    }
    
}
