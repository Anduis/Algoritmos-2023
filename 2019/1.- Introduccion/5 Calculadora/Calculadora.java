/*
*Autor: Andres Anguiano
*fecha: 11 Marzo 2020 12 Marzo 2020
*
*Escribir la aplicación Java Calculadora la cual simula una calculadora simple,
*usando la terminal como el dispositivo de entrada y salida.
*De esta forma, cada entrada a la calculadora, será un número, como 12.34 o 1034, o un operador, como + o =,
*que estarán en líneas separespués de cada entrada se deberá mostrar el cálculo que se va realizando.
*
*/
import java.util.Scanner;
public class Calculadora{
  public static void main(String[] args) {
    System.out.println("*-Para operar deberas presionar 'enter' despues de cada numero o operador\n*-Los operadores son: + (suma), - (resta), * (producto), / (division)\n*-Para detener el programa y recibir el Total emplee el operador =");
    Scanner entrada = new Scanner(System.in);
    double memoria = 0 ;
    analiza(entrada, memoria);
  }
  public static void espacio(){

  }
  public static void analiza(Scanner entrada, double memoria){
    while (entrada.hasNextLine()){
      if (entrada.hasNextDouble()) {
        double i = entrada.nextDouble();
        memoria = i;
      }
      else {
        String operador = entrada.nextLine();
        if (operador.equals("+")) {
          if (entrada.hasNextDouble()){
            double j = entrada.nextDouble();
            memoria = memoria+j;
            System.out.println("= \n"+memoria);
          }
        }

        if (operador.equals("-")) {
          if (entrada.hasNextDouble()){
            double j = entrada.nextDouble();
            memoria = memoria-j;
            System.out.println("= \n"+memoria);
          }
        }

        if (operador.equals("*")) {
          if (entrada.hasNextDouble()){
            double j = entrada.nextDouble();
            memoria = memoria*j;
            System.out.println("= \n"+memoria);
          }
        }

        if (operador.equals("/")) {
          if (entrada.hasNextDouble()){
            double j = entrada.nextDouble();
            memoria = memoria/j;
            System.out.println("= \n"+memoria);
          }
        }
        if (operador.equals("=")){
          System.out.println("Total = "+memoria);
          break;
        }
      }
    }
  }
}
