package com.jetbrains;

import java.util.*;

public class Calculadora {

    Scanner intro = new Scanner(System.in);

    private void showMenu(){
        /* Método que muestra el menú de todas las operaciones, junto con las indicaciones para salir
         de la aplicación */
        System.out.println("Seleccione una opción: ");
        System.out.println("1) Sumar (A + B)");
        System.out.println("2) Restar (A - B)");
        System.out.println("3) Multiplicar (A * B)");
        System.out.println("4) Dividir (A / B)");
        System.out.println("5) Elevar a (A ^ B)");
        System.out.println("6) Calcular mayor número \n");
        System.out.println("¿Desea salir de la calculadora? (Y/N)\n");
        System.out.print("$:");
    }

    private double[] askForNumbers(boolean isDivision){
        /* Método que pide al usuario dos números en forma de string, comprueba que cada
         String sea un número con el método isNumeric(), y en el caso de que el parametro
         isDivision es verdadero, comprueba también que el número B (dividendo) sea distinto de 0. */
        double [] bothNumbers = new double [2];
        System.out.print("Inserte número A: ");
        String numberA = intro.nextLine();

        while(!isNumeric(numberA)) {
            System.out.println("Error. Inserte número A: ");
            numberA = intro.nextLine();
        }

        System.out.print("Inserte numero B: ");
        String numberB = intro.nextLine();

        while(!isNumeric(numberB) || (isDivision && Double.parseDouble(numberB) == 0)) {
            System.out.println("Error. Inserte numero B: ");
            numberB = intro.nextLine();
        }
        //Convierte los string en Double.
        bothNumbers[0] = Double.parseDouble(numberA);
        bothNumbers[1] = Double.parseDouble(numberB);

        return bothNumbers;
    }

    private void multiply() {
        // Pide dos numeros a la función askForNumbers, multiplica los números entregados.
        double [] numbers = askForNumbers(false);
        System.out.println("El total de la multiplicacion es: " + (numbers[0] * numbers [1]));
    }

    private void greaterNumber(){
        // Pide dos numeros a la funcion askForNumbers, indica cual es mayor de esos numeros.
        double [] numbers = askForNumbers(false);
        System.out.println(((numbers[0] > numbers[1]) || (numbers[0] == numbers[1]) ? ("El mayor de los " +
                           "dos números es " + numbers[0]) : ("El mayor de los dos números es " + numbers[1])));
    }
}