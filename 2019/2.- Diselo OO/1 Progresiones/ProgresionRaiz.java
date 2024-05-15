/*
*Autor: Andres Anguiano
*Fecha: 19 Marzo 2020
*
**INDICACIONES DADAS*
**también scribir la clase ProgresionRaiz la cual extiende la clase Progresion tal que cada valor en la progresión es la raíz cuadrada del valor previo.
**Observar que ya no se puede representar más cada valor con un entero.
**Se deberá incluir un constructor por defecto que tenga 65536 como el primer valor y un constructor parametrizado que inicie con un número dado como el primer valor.
*/
import java.lang.Math;
public class ProgresionRaiz extends Progresion {//Escribir la clase ProgresionRaiz la cual extiende la clase Progresion
  protected double primero ;
  protected double actual ;

  ProgresionRaiz () {//Se deberá incluir un constructor por defecto que tenga 65536 como el primer valor
    primero = 65536;
  }

  ProgresionRaiz ( double uno ) {//constructor parametrizado que inicie con un número dado como el primer valor
    primero = uno;
  }

  protected double inicio () {
    actual = primero ;
    return actual ;
  }

  protected double consecuente () {// tal que cada valor en la progresión es la raíz cuadrada del valor previo.
    actual = Math.sqrt(actual);

    return actual ;
  }
  public void mostrarProgresion ( int n) {
    System.out.print ( inicio ());
    for (int i = 1; i < n; i ++)
      System.out.print (" " + consecuente ());
      System.out.println (); 
  }
}
