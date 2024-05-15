/*
*Autor: Andres Anguiano Matricula:1638975x
*Fecha: 30 Marzo 2020 31 Marzo
**INDICACIONES DADAS:
**Modificar el código Java de los métodos add(e) y remove(i) para las puntuaciones del juego,
**guardadas en el arreglo entradas, de la clase Puntuaciones, para que ahora las entradas no se mantengan en orden.
**Todavía se quiere guardar las n entradas entre los índices 0 y n-1. Los métodos se deben implementar sin usar ciclos,
**por lo que la cantidad de pasos que hagan no dependen de n.
**Agregar código para mostrar el comportamiento que tienen los métodos ahora que las puntuaciones no están ordenadas.
*/

public class Puntuaciones {
  public static final int MAX_ENTRADAS = 11;//Todavía se quiere guardar las n entradas entre los índices 0 y n-1.
  protected int numEntradas ;
  protected EntradaJuego [] entradas ;

  public Puntuaciones () {
    entradas = new EntradaJuego [ MAX_ENTRADAS ];
    numEntradas = 0;
  }
  public String toString () {//modifiqué este metodo para que no imprima los vacios
    String s = "[";
    for (int i = 0; i < MAX_ENTRADAS ; i ++) {
      if (entradas[i]!=null) {
        if (i > 0 ) s += ", ";
        s += entradas [i];
      }
    }
    return s + "]";
  }

  int vacios=0; //CANTIDAD DE LUGARES VACIOS POR REMOCION
  int[] espaciosDesocupados = new int[MAX_ENTRADAS+1];  //ARREGLO QUE GUARDA LA POSICION DE LOS ELIMINADOS
  public void add ( EntradaJuego e) { //se agregan al espacio en el arreglo correspondiente a el numero de entradas corriente,
    if (vacios != 0) {//a menos que haya eliminados, en ese caso se ocupara primero el puesto del ultimo en ser eliminado,
      entradas[espaciosDesocupados[vacios]] = e;
      vacios--;
    }else
      entradas[numEntradas]=e;
    numEntradas++;
  }
  //Modificar el código Java de los métodos add(e) y remove(i)
  public EntradaJuego remove (int i) throws IndexOutOfBoundsException {
    if ((i < 0) || (i >= numEntradas ) ||entradas[i]==null)
      throw new IndexOutOfBoundsException ("Indice no valido : " + i);
    EntradaJuego temp = entradas [i];
    entradas[i]=null;
    vacios++;
    espaciosDesocupados[vacios]=i;
    numEntradas --;
    return temp;
  }

  //Modificar el código Java de los métodos add(e) y remove(i)
  public static void main(String[] args) {
    Puntuaciones misx = new Puntuaciones();
    EntradaJuego entrada1 = new EntradaJuego("Andres", 1);
    EntradaJuego entrada2 = new EntradaJuego("Falso2", 2);
    EntradaJuego entrada3 = new EntradaJuego("Falso3", 3);
    EntradaJuego entrada4 = new EntradaJuego("Falso4", 4);
    EntradaJuego entrada5 = new EntradaJuego("Falso5", 5);
    EntradaJuego entrada6 = new EntradaJuego("Falso6", 6);
    EntradaJuego entrada7 = new EntradaJuego("Falso7", 7);
    EntradaJuego entrada8 = new EntradaJuego("Falso8", 8);
    EntradaJuego entrada9 = new EntradaJuego("Falso9", 9);
    EntradaJuego entrada10 = new EntradaJuego("Falso10", 0);
    EntradaJuego entrada11 = new EntradaJuego("Falso11", 10);
    EntradaJuego entrada01 = new EntradaJuego("esteNoIbaAqui1", 7);
    EntradaJuego entrada02 = new EntradaJuego("esteNoIbaAqui2", 8);
    EntradaJuego entrada03 = new EntradaJuego("esteNoIbaAqui3", 9);
    misx.add(entrada1);
    misx.add(entrada2);
    misx.add(entrada3);
    misx.add(entrada4);
    misx.add(entrada5);
    misx.add(entrada6);
    misx.add(entrada7);
    misx.add(entrada8);
    misx.add(entrada9);
    misx.add(entrada10);
    misx.add(entrada11);
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    System.out.println("Maximo de entradas: " + misx.MAX_ENTRADAS+ ". Numero de entradas: "+ misx.numEntradas +". espacio vacios: "+ misx.vacios );
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    System.out.println(misx.toString());
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    System.out.println("");

    System.out.println("*-*-*-*-*-*-*-C*A*M*B*I*O*S-*-*-*-*-*-*-*");
    System.out.println("Se elimino "+ misx.remove(5-1)+", "+misx.remove(6-1)+", "+misx.remove(7-1));
    System.out.println("");
    System.out.println("Maximo de entradas: " + misx.MAX_ENTRADAS+ ". Numero de entradas: "+ misx.numEntradas +". espacio vacios: "+ misx.vacios );
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    System.out.println(misx.toString());

    System.out.println();
    System.out.println("*-*-*-*-*-*-*-C*A*M*B*I*O*S-*-*-*-*-*-*-*");
    misx.add(entrada02);
    misx.add(entrada01);
    misx.add(entrada03);
    System.out.println("Se elimino "+misx.remove(10)+ " y se agregaron 3 entradas");
    System.out.println("");
    System.out.println("Maximo de entradas: " + misx.MAX_ENTRADAS+ ". Numero de entradas: "+ misx.numEntradas +". espacio vacios: "+ misx.vacios );
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    System.out.println(misx.toString());
  }
}
