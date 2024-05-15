/*
*Autor: Andres Anguiano 1638975x
Fecha: 8 Abril 2020
**INDICACIONES DADAS:
**Aplicación MinimoMaximoRecursivo para encontrar el valor mínimo
**y máximo de un arreglo de valores int aleatorios sin usar ciclos para hallar los valores
*/
import java.util.Random;
public class MinimoMaximoRecursivo{
  public static void main(String[] args) {
    int[] arreglo = llenaAleatorio(20);
    int minimo = encuentraMin(arreglo,arreglo.length);
    int maximo = encuentraMax(arreglo,arreglo.length);

    for (int x = 0 ; x<arreglo.length ; x++) {
      if (x == 0) System.out.print("El arreglo es : [");
      if (x < arreglo.length-1) System.out.print(arreglo[x] + ", ");
      if (x == arreglo.length-1) System.out.print(arreglo[x] +"]");
    }
    System.out.println();
    System.out.println("El valor minimo del arreglo es: " + minimo);
    System.out.println("El valor maximo del arreglo es: " + maximo);
  }

  public static int[] llenaAleatorio(int a){
    Random aleatorio = new Random();
    aleatorio.setSeed(System.currentTimeMillis());
    int[] memoria = new int[a];
    for(int i = 0 ; i < a ; i++){
      memoria[i] =  aleatorio.nextInt(100);
    }
    return memoria;
  }

  public static int valorEn(int[] x, int y){
    int respuesta;
    respuesta = x[y];
    return respuesta;
  }

  public static int encuentraMin(int[] x, int l){
    int y = l-1; // "y" es la cantidad de lugares en el arreglo que faltan por revisar
    int memoria = valorEn(x,y);
    if (y > 0) memoria = encuentraMin(x,y);
    if (valorEn(x,y) < memoria) memoria = valorEn(x,y);
    return memoria;
  }

  public static int encuentraMax(int[] x, int l){
    int y = l-1;
    int memoria = valorEn(x,y);
    if (y > 0) memoria = encuentraMax(x,y);
    if (valorEn(x,y) > memoria) memoria = valorEn(x,y);
    return memoria;
  }
}
