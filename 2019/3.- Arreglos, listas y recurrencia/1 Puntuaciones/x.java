/*
*Autor: Andres Anguiano Matricula:1638975x
*Fecha: 30 Marzo 2020
**INDICACIONES DADAS:
**Modificar el código Java de los métodos add(e) y remove(i) para las puntuaciones del juego,
**guardadas en el arreglo entradas, de la clase Puntuaciones, para que ahora las entradas no se mantengan en orden.
**Todavía se quiere guardar las n entradas entre los índices 0 y n-1. Los métodos se deben implementar sin usar ciclos,
**por lo que la cantidad de pasos que hagan no dependen de n.
**Agregar código para mostrar el comportamiento que tienen los métodos ahora que las puntuaciones no están ordenadas.
*/

/** clase para guardar las puntuaciones altas en un arreglo
en orden descendente . */
public class x {
  public static final int MAX_ENTRADAS = 11; // cantidad de puntuaciones
  protected int numEntradas ; // cantidad . actual de entradas
  protected EntradaJuego [] entradas ; // arreglo de entradas
  /** Constructor por defecto */
  public x () {
    entradas = new EntradaJuego [ MAX_ENTRADAS ];
    numEntradas = 0;
  }
  /** Regresa una cadena de las mayores puntuaciones */
  public String toString () {
    String s = "[";
    for (int i = 0; i < numEntradas ; i ++) {
      if (i > 0) s += ", "; // separar entradas con comas
      s += entradas [i];
    }
    return s + "]";
  }
  // ... metodos para actualizar el conjunto de puntuaciones ...

  /** Intenta agregar una nueva puntuacion a la coleccion si es lo
  suficientemente alta . */
  int vacios=0;
  int[] espaciosDesocupados = new int[MAX_ENTRADAS];
  public void add ( EntradaJuego e) {
    if (vacios != 0) {
      entradas[espaciosDesocupados[vacios]] = e;
      numEntradas++;
      vacios--;
    }else
    entradas[numEntradas]=e;
    numEntradas++;
  }

  /** Quitar el record del  Indice i y devolverlo . */
  public EntradaJuego remove ( int i) throws IndexOutOfBoundsException {
    if ((i < 0) || (i >= numEntradas ))
      throw new IndexOutOfBoundsException ("Indice no valido : " + i);
    // guardar temporalmente el objecto a ser quitado
    EntradaJuego temp = entradas [i];
    entradas[i]=null;
    espaciosDesocupados[vacios]=i;//guarda el numero del arreglo en donde quedo un espacio
    numEntradas --;
    vacios++;
    return temp ; // devolver objeto eliminado
  }

  public static void main(String[] args) {
    x misx = new x();
    EntradaJuego entrada1 = new EntradaJuego("Andres", 51);
    EntradaJuego entrada0 = new EntradaJuego("esteNoIbaAqui", 666);
    EntradaJuego entrada2 = new EntradaJuego("Inventado2", 52);
    EntradaJuego entrada3 = new EntradaJuego("Inventado3", 53);
    EntradaJuego entrada4 = new EntradaJuego("Inventado4", 54);
    EntradaJuego entrada5 = new EntradaJuego("Inventado5", 55);
    EntradaJuego entrada6 = new EntradaJuego("Inventado6", 56);
    EntradaJuego entrada7 = new EntradaJuego("Inventado7", 57);
    EntradaJuego entrada8 = new EntradaJuego("Inventado8", 58);
    EntradaJuego entrada9 = new EntradaJuego("Inventado9", 59);
    EntradaJuego entrada10 = new EntradaJuego("Inventado10", 50);
    EntradaJuego entrada11 = new EntradaJuego("Inventado11", 510);
    misx.add(entrada1);
    misx.add(entrada3);
    misx.add(entrada5);
    misx.add(entrada7);
    misx.add(entrada9);
    misx.add(entrada11);
    misx.add(entrada2);
    misx.add(entrada4);
    misx.add(entrada6);
    misx.add(entrada8);
    misx.add(entrada10);
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    System.out.println(misx.numEntradas+" entradas "+ misx.vacios +" espacios vacios");
    System.out.println(misx.toString());

    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    System.out.println("*-*-*-*-*-*-*-C*A*M*B*I*O*S-*-*-*-*-*-*-*");
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    misx.remove(5);
    misx.remove(6);
    System.out.println(misx.numEntradas+" entradas "+ misx.vacios +" espacios vacios");
    System.out.println(misx.toString());

    misx.add(entrada0);

  }
}
