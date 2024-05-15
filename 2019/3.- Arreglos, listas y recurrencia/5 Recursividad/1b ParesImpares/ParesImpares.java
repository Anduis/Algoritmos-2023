/*
*Autor: Andres Anguiano 1638975x
Fecha: 8 Abril 2020
**INDICACIONES DADAS:
**Aplicación ParesImpares para poner los valores de un arreglo de tipo int
**de tal modo que todos los valores pares aparezcan antes que los valores impares.
*/
import java.util.Random;
public class ParesImpares{
  public static void main(String[] args) {
    int[] arreglo = llenaAleatorio(20);

    //imprimir arreglo aleatorio
    for (int x = 0 ; x<arreglo.length ; x++) {
      if (x == 0) System.out.print("El arreglo es : [");
      if (x < arreglo.length-1) System.out.print(arreglo[x]+ ", ");
      if (x == arreglo.length-1) System.out.print(arreglo[x]+"]");
    }
    System.out.println();
    //imprimir numero de pares/impares, esto es opcional, no afecta a nada
    int nPares = cuenta(arreglo,arreglo.length)[0];
    System.out.println("Numero de pares : " + nPares);
    int nImpares = cuenta(arreglo,arreglo.length)[1];
    System.out.println("Numero de impares : " + nImpares);
    //ordenar arreglo aleatorio son los impares al final
    separa(arreglo, arreglo.length-1, 0);
    //imprimir arreglo ordenado
    for (int j = 0 ; j<arreglo.length ; j++) {
      if (j == 0) System.out.print("El arreglo ordenado es : [");
      if (j < arreglo.length-1) System.out.print(arreglo[j]+ ", ");
      if (j == arreglo.length-1) System.out.print(arreglo[j]+"]");
    }
  }

  public static int[] llenaAleatorio(int x){
    Random aleatorio = new Random();
    aleatorio.setSeed(System.currentTimeMillis());
    int[] memoria = new int[x];
    for(int i = 0 ; i < x ; i++){
      memoria[i] =  aleatorio.nextInt(100);
    }
    return memoria;
  }

  static boolean esImpar(int i){
    if (i%2 == 0) return false;
    else return true;
  }

  public static void separa(int[] x, int l, int i){
      if(i < l){
        if(esImpar(x[i])){
          int g = x[l];
          x[l] = x[i];
          x[i] = g;
          separa(x, l-1, i);
        }
        else separa(x, l, i+1);
      }
  }

  public static int[] cuenta(int [] x, int l){
    int[] respuesta = new int[2];
    int y = l-1;
    if (y > 0) respuesta = cuenta(x,y);
    if (esImpar(x[y])) respuesta[1]++;
    if (!esImpar(x[y])) respuesta[0]++;
    return respuesta;
  }
}
