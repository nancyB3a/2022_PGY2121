/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microempresa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author nanbe
 */
public class MicroEmpresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variables
        int opcion; //para el menú
        boolean flag; //para validaciones
        //cliente
        int rut, telefono;
        char dv;
        String nombre, direccion, mail;
        //producto
        int codigo, precio, cantidad;
        String subcategoria, descripcion;
        char medida;
        //solicitud
        int numero,total;
        String fecha;
        int porcentaje;
        int descuento;        
        
        //Creo las instancias a mis clases
        Valida valida=new Valida();
        Cliente cliente=new Cliente();
        Solicitud sol=new Solicitud();
        do {
            Scanner teclado=new Scanner(System.in);
            System.out.println("..............MENU..............");
            System.out.println("1.- Ingresar Cliente");
            System.out.println("2.- Ingresar Solicitud y sus Productos");
            System.out.println("3.- Aplicar Descuento");
            System.out.println("4.- Salir (Ver la Solicitud)");
            System.out.print("Ingrese su opción: ");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1: //1.- Ingresar Cliente
                    System.out.print("Ingrese RUT: ");
                    rut=teclado.nextInt();
                    System.out.print("Ingrese DV: ");
                    dv=teclado.next().charAt(0);
                    System.out.print("Ingrese Nombre: ");
                    nombre=teclado.next();
                    do {
                        System.out.print("Ingrese teléfono: ");
                        telefono=teclado.nextInt();
                        flag=valida.validarLargo8(telefono);
                        if (!flag) { //false==false=>true <=> !false => true
                            System.out.println("Teléfono inválido (largo 8)");
                        }
                    } while (flag==false);
                    do {
                        System.out.print("Ingrese su mail: ");
                        mail=teclado.next();
                        flag=valida.validarCorreo(mail);
                        if (flag==false) {
                            System.out.println("Mail inválido (largo mínimo es 6)");
                        }
                    } while (flag==false);
                    System.out.print("Ingrese dirección: ");
                    direccion=teclado.next();
                    //Guardo los datos correctos en el Cliente
                    cliente.setRut(rut);
                    cliente.setDv(dv);
                    cliente.setNombre(nombre);
                    cliente.setTelefono(telefono);
                    cliente.setMail(mail);
                    cliente.setDireccion(direccion);
                    System.out.println("Cliente agreagado con Exito!!");
                    System.out.println("---------------------------------------------");
                    
                    break;
                case 2://2.- Ingresar Solicitud y sus Productos
                    //Solicitud
                    numero=sol.obtenerNroSolicitud();
                    sol.setNumero(numero);
                    sol.setCliente(cliente);
                    Date fechaDate=null;
                    do {
                        System.out.print("Ingrese Fecha (dd/mm/yyyy): ");
                        fecha=teclado.next();
                        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
                        try{
                            fechaDate=formato.parse(fecha);
                            flag=valida.validarFecha(fechaDate);
                        }catch(ParseException ex){
                            flag=false;
                            System.out.println("Fecha inválida (dd/mm/yyyy)");
                        }
                        if (flag==false) {
                            System.out.println("Fecha de la solicitud debe ser menor o igual a la actual");
                        }
                    } while (flag==false);
                    sol.setFecha(fechaDate);
                    //Productos
                    System.out.print("¿Cuantos productos ingresará?: ");
                    int totalProductos=teclado.nextInt();
                    for (int i = 1; i <= totalProductos; i++) {
                        Producto prod=new Producto();
                        codigo=0;
                        precio=0;
                        cantidad=0;
                        subcategoria="";
                        descripcion="";
                        medida=' ';
                        do {
                            System.out.print("Ingrese Código: ");
                            codigo=teclado.nextInt();
                            flag=valida.validarLargo4(codigo);
                            if (flag==false) {
                                System.out.println("Código inválido (largo 4)");
                            }
                        } while (flag==false);
                        do {
                            System.out.print("Ingrese precio: ");
                            precio=teclado.nextInt();
                            flag=valida.validarNumeroPositivo(precio);
                            if (flag==false) {
                                System.out.println("Precio inválido");
                            }
                        } while (flag==false);
                        do {
                            System.out.print("Ingrese subcategoría (Fruta o Verdura)");
                            subcategoria = teclado.next();
                            flag = valida.validarSubcategoria(subcategoria);
                            if (flag == false) {
                                System.out.println("Subcategoria inválida");
                            }
                        } while (flag == false);
                        
                        System.out.println("Ingrese descripción: ");
                        descripcion = teclado.next();

                        System.out.print("Ingrese medida (U:unidad o G:gramos): ");
                        medida = teclado.next().toUpperCase().charAt(0);
                        if (medida == 'U') {
                            System.out.print("Ingrese unidades: ");
                        } else {
                            System.out.print("Ingrese gramos: ");
                        }
                        cantidad=teclado.nextInt();
                        //guardar los datos válidos en producto
                        prod.setCodigo(codigo);
                        prod.setPrecio(precio);
                        prod.setSubcategoria(subcategoria);
                        prod.setDescripcion(descripcion);
                        prod.setMedida(medida);
                        prod.setCantidad(cantidad);
                        
                        sol.agregarProducto(prod);
                        System.out.println("Solicitud agreagada con Exito!!");
                        System.out.println("---------------------------------------------");
                    }
                    break;
                case 3://3.- Aplicar Descuento
                    System.out.print("Ingrese porcentaje de descuento (1-100): %");
                    porcentaje = teclado.nextInt();
                    descuento=sol.descontar(porcentaje);//invoco customer que calcula el descuento
                    System.out.println("Total: $" + sol.getTotal());
                    System.out.println("Descuento: $" + descuento);
                    System.out.println("-------------------------------");
                    System.out.println("A pagar: $"+(sol.getTotal()-descuento));
                    System.out.println("-------------------------------");
                    break;                 
                case 4: //4.- Salir (Ver la Solicitud)
                    System.out.println("\n");
                    System.out.println("Solicitud Finalizada");
                    System.out.println("\n\nResúmen de Solicitud\n");
                    sol.verSolicitud();
                    break;
                default:
                    System.out.println("Opción Inválida!!!");
            }
        } while (opcion!=4);
        
        
    }
    
}
