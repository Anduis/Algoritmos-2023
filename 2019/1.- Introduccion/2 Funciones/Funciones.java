/*
*Autor: Andres Anguiano
*Fecha: 04 marzo 2020
*Escribir la aplicación Funciones la cual contiene dos funciones que realizan lo siguiente:
*Función esMultiplo, la cual toma dos valores long, n y m, y regresa true si y solo si n es un múltiplo de m, esto es, n=m i para algún entero i.
*Función esImpar, el cual toma un int i y regresa true si y solo si i es impar. La función no puede usar los operadores multiplicación, módulo, o división.
*Agregar código en la aplicación para mostrar el uso de las funciones.
*/
public class Funciones{
  static boolean esMultiplo(long N, long M){ //true si y solo si n es un múltiplo de m, esto es, n=m i para algún entero i.
    if (N % M == 0)
      return true;
    else
      return false;
  }
  static boolean esImpar(int i){ //true si y solo si i es impar. La función no puede usar los operadores multiplicación, módulo, o división.
    if (i < 0)
      while (i < -1) i = i+2;
    else
      while (i > 1) i = i-2;

    if (i == 0)
      return false;
    else
      return true;
  }

  public static void main(String[] args) {
    long Multiplo = 97920l;
    long Numero = 136l;
    int x = -16;

    //Agregar código en la aplicación para mostrar el uso de las funciones
    boolean Resultado1 = esMultiplo(Multiplo,Numero);
      if (Resultado1 == true)
        System.out.println(Multiplo + " es Multiplo de " + Numero);
      else
        System.out.println(Multiplo + " no es Multiplo de " + Numero);

    boolean Resultado1_2 = esMultiplo(45,8);
      if (Resultado1_2 == true)
        System.out.println(45 + " es Multiplo de " + 8);
      else
        System.out.println(45 + " no es Multiplo de " + 8);

    boolean Resultado2 = esImpar(x);
      if (Resultado2 == true)
        System.out.println(x +" es impar");
      else
        System.out.println(x +" no es impar");

    boolean Resultado2_2 = esImpar(79);
      if (Resultado2_2 == true)
        System.out.println(79 +" es impar");
      else
        System.out.println(79 +" no es impar");
  }
}
