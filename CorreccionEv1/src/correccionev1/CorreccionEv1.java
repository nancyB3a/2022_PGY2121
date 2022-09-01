/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package correccionev1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author nanbe
 */
public class CorreccionEv1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Date fecha = new Date();
        Validador val = new Validador();
        Delegado d1 = new Delegado();
        Comedor c1 = new Comedor();
        int opc;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("      Menú");
            System.out.println("*****************");
            System.out.println("1.- • Crear un comedor a un delegado");
            System.out.println("2.- • Enviar Correo.");
            System.out.println("3.- • Realizar un aporte adicional a un delegado");
            System.out.println("4.- SALIR");
            System.out.println("Ingrese su opción:.......");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    String codigo="COM01";
                    if(val.validaNoVacio(codigo)){
                        c1.setCodigo(codigo);
                    }else{
                        System.out.println("Identificador no debe ser vacío");
                    }
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        fecha = (formato.parse("06/09/2022"));
                    } catch (Exception e) {}
                    if (val.validaFecha(fecha)) {
                        c1.setFecha(fecha);
                    }else{
                        System.out.println("Fecha no válida");
                    }
                    c1.setBeneficiarios(50);
                    c1.setValorAporte(50000);
                    String nombre="Benito";
                    if (val.validaNoVacio(nombre)) {
                        d1.setNombre(nombre);
                    }else{
                        System.out.println("Nombre no puede estar vacío");
                    }
                    d1.setRut(19000111);
                    char tipo='a';
                    if (val.validaTipoDelegado(tipo)) {
                        d1.setTipoDelegado(tipo);
                    }else{
                        System.out.println("Tipo de delegado No válido");
                    }
                    d1.setCorreo("delegado@delegado.cl");
                    d1.setComedor(c1);
                    System.out.println(d1.toString());                 
                    break;
                case 2:
                    d1.enviarCorreo();
                    break;
                case 3:
                    if (val.validaFecha(d1.getComedor().getFecha())) {
                        d1.aporteAdicional(10);
                        System.out.println("Nuevo Monto: $" + d1.getComedor().getValorAporte());
                    }                    
                    break;
                case 4:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Opción NO Válida!!");
            }
        } while (opc != 4);

        //para probar
        
        Comedor c2 = new Comedor("COM02", fecha,100,100000);
        Delegado d2 = new Delegado("Nina", 9876540, 'A', "nina@gmail.com", c2);
        c2.imprimir();
        d2.aporteAdicional(50);
        System.out.println("Nuevo Monto: $" + c2.getValorAporte());
    }

}
