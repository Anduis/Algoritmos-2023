/*
Autor: Andres Anguiano
fecha: 22-9-2020
Objetivo: Encontrar el minimo numero en un arreglo. Entrada, el tamano del arreglo y todos los números, salida: el numero menor.
*/
import java.util.*;
public class Main
{
  static int minimo(int[]A, int x)
  {
    if (x == 1)
    {
      return A[0];
    }
    else
    {
      return Math.min(A[x-1], minimo(A, x-1));
    }
  }
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    scan.tokens();
    int[] A = new int[scan.nextInt()];
    int i=0;
    while (i<A.length)
    {
      A[i]=scan.nextInt();
      ++i;
    }
    scan.close();
    System.out.print(minimo(A, A.length));
  }
}
