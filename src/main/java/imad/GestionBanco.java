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

        //declaracion de objetos
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce la edad del cliente");
        edadCliente = teclado.nextInt();
        System.out.println("Introduce el sueldo bruto del cliente");
        sueldoBrutoMensual = teclado.nextDouble();
        //condicion si es mayor de 17 y menor de 66 
        if (edadCliente > 17 && edadCliente < 66) {
            System.out.println("Introduce el sueldo bruto del cliente");
            sueldoBrutoMensual = teclado.nextDouble();
            System.out.println("Introduce la cantidad de dinero que necesita");
            dineroPedidoBanco = teclado.nextDouble();
            //multiplicamos el sueldo menusal por 12 para conseguir el anual
            if (dineroPedidoBanco < ((sueldoBrutoMensual * 12) * FACTOR_MULTIPLICATIVO)) {
                System.out.println("Introduce el tiempo en el que piensa pagar la hipoteca");
                edadAnyosHipoteca = teclado.nextInt();
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
        }else{
            System.out.println("La edad no es valida");
        }

    }
}
