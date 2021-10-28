/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imad;

import java.util.Scanner;

/**
 *
 * @author imad
 */
public class GestionBanco {

    public static void main(String[] args) {
        //declaracion de variables
        int edadCliente;
        int edadAnyosHipoteca;
        double sueldoBrutoMensual;
        double dineroPedidoBanco;
        final double FACTOR_MULTIPLICATIVO = 5.85;
        boolean repeticion = true;
        int eleccion;
        //declaracion de objetos
        Scanner teclado = new Scanner(System.in);
        do {
            do {
                System.out.println("¿Que desea realizar\n 1. Pulse 1 para calcular hipoteca\n 2. Pulse 2 para salir");
                eleccion = teclado.nextInt();
            } while (eleccion < 1 || eleccion > 2);

            switch (eleccion) {
                case 1:
                   do{ System.out.println("Introduce la edad del cliente: (edad minima 18 edad maxima 66)");
                    edadCliente = teclado.nextInt();
                   }while(edadCliente<18||edadCliente>66);
                    //condicion si es mayor de 17 y menor de 66 
                    if (edadCliente > 17 && edadCliente < 66) {
                       do{ System.out.println("Introduce el sueldo bruto del cliente (minimo 500€/mes)");
                        sueldoBrutoMensual = teclado.nextDouble();
                       }while(sueldoBrutoMensual<500);
                       do{ System.out.println("Introduce la cantidad de dinero que necesita");
                        dineroPedidoBanco = teclado.nextDouble();
                       }while(dineroPedidoBanco>1000000);
                        //multiplicamos el sueldo menusal por 12 para conseguir el anual
                        if (dineroPedidoBanco < ((sueldoBrutoMensual * 12) * FACTOR_MULTIPLICATIVO)) {
                         do{   System.out.println("Introduce el tiempo en el que piensa pagar la hipoteca");
                            edadAnyosHipoteca = teclado.nextInt();
                         }while(edadAnyosHipoteca<1||edadAnyosHipoteca>50);
                            if (edadAnyosHipoteca < 30 && edadAnyosHipoteca > 5) {
                                if ((edadCliente + edadAnyosHipoteca) > 75) {
                                    System.out.println("Lo sentimos pero la suma no coincide");
                                } else {
                                    System.out.println("Prestamo operativo");
                                }
                            } else {
                                System.out.println("Los años de hipoteca no corrsponde");
                            }
                        } else {

                            System.out.println("El cliente no es apto");
                        }
                    } else {
                        System.out.println("La edad no es valida");
                    }
                    break;
                case 2:
                    repeticion = false;
                    break;
            }

        } while (repeticion);
    }
}
