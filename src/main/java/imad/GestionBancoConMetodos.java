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
public class GestionBancoConMetodos {

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
                System.out.println("¿Que desea realizar\n "
                        + "1. Pulse 1 para calcular hipoteca\n "
                        + "2. Pulse 2 para salir");
                eleccion = teclado.nextInt();
            } while (eleccion < 1 || eleccion > 2);

            switch (eleccion) {
                case 1:
                    do {
                        System.out.println("Introduce la edad del cliente: (edad minima 18 edad maxima 65)");
                        edadCliente = teclado.nextInt();
                    } while (comprobadorEdadValida(edadCliente));
                    do {
                        System.out.println("Introduce el sueldo bruto del cliente (minimo 500€/mes)");
                        sueldoBrutoMensual = teclado.nextDouble();
                    } while (sueldoBrutoMensual < 500);
                    do {
                        System.out.println("Introduce la cantidad de dinero que necesita");
                        dineroPedidoBanco = teclado.nextDouble();
                    } while (dineroPedidoBanco > 1000000);

                    //multiplicamos el sueldo menusal por 12 para conseguir el anual
                    if (comprobadorDineroSolicitadoValido(sueldoBrutoMensual, dineroPedidoBanco, FACTOR_MULTIPLICATIVO)) {
                        do {
                            System.out.println("Introduce el tiempo en el que piensa pagar la hipoteca");
                            edadAnyosHipoteca = teclado.nextInt();
                        } while (edadAnyosHipoteca < 1 || edadAnyosHipoteca > 50);
                        if (edadAnyosHipoteca < 30 && edadAnyosHipoteca > 5) {
                           
                            if (comprobadorAnyosHipotecaValido(edadAnyosHipoteca,edadCliente)) {
                                System.out.println("Lo sentimos pero la edad del cliente más los anyos para devolver la hipoteca no son validos");
                            } else {
                                System.out.println("Prestamo operativo");
                            }
                        } else {
                            System.out.println("Los años de hipoteca no corrsponde (max 30 y min 5)");
                        }
                    } else {

                        System.out.println("El cliente no es apto");
                    }

                    break;
                case 2:
                    repeticion = false;
                    break;
            }

        } while (repeticion);
    }
// metodo que comprueba si la edad recibida es mayor de 17 y menor que 66 y devuelve true en caso de edad no valida
    public static boolean comprobadorEdadValida(int edad) {
        boolean edadValida = true;
        if (edad > 65 || edad < 18) {
            edadValida = true;
        } else {
            edadValida = false;
        }
        return edadValida;
    }
//metodo que devuelve true si dineroSolicitado es valido para el banco 
    public static boolean comprobadorDineroSolicitadoValido(double dineroPedido, double sueldo, double factorMulti) {
        boolean cantidadValida = true;
        if (dineroPedido < ((sueldo * 12) * factorMulti)) {
            cantidadValida = true;
        } else {
            cantidadValida = false;
        }
        return cantidadValida;
    }
//metodo que devuelve true si la los anyos de hipoteca mas la edad del cliente no supera 75
    public static boolean comprobadorAnyosHipotecaValido(int anyosHipoteca, int edad) {
        boolean edadValida = true;
        if ((edad + anyosHipoteca) > 75) {
            edadValida = true;
        } else {
            edadValida = false;

        }
        return edadValida;
    }

}
