/*
*Autor: Andres Anguiano
*Fecha: 17 Marzo 2020
*
**INDICACIONES DADAS*
**Escribir la clase ProgresionAbsoluta la cual extiende la clase Progresion tal que cada valor en la progresión es el valor absoluto de la diferencia entre los dos valores previos.
**Se deberá incluir un constructor por defecto que inicie con 2 y 200 como los primeros dos valores y un constructor parametrizado que inicie con un par dado de números como los primeros dos valores.
*/

public class ProgresionAbsoluta extends Progresion {//Escribir la clase ProgresionAbsoluta la cual extiende la clase Progresion
  protected long diferencia ;
  protected long segundo;

  ProgresionAbsoluta () {//Se deberá incluir un constructor por defecto que inicie con 2 y 200 como los primeros dos valores
    primero = 2;
    segundo = 200;
  }

  ProgresionAbsoluta ( long uno, long dos ) {//constructor parametrizado que inicie con un par dado de números como los primeros dos valores.
    primero = uno;
    segundo = dos;
  }

  protected long siguienteValor () {// tal que cada valor en la progresión es el valor absoluto de la diferencia entre los dos valores previos.
    diferencia = primero - segundo ;
    if (diferencia < 0) {diferencia *= -1;}
    primero = segundo ;
    segundo = diferencia ;
    diferencia = segundo ;

    actual = diferencia;
    return actual ;
  }

  public void mostrarProgresion ( int n) { //especializo este metodo para Imprimir de inicio los dos valores de entrada
    System.out.print ( primerValor ()+ " " + segundo);
    for (int i = 1; i < n; i ++)
      System.out.print (" " + siguienteValor ());
      System.out.println (" ");
  }
}
