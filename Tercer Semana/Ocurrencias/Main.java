/*
Autor: Andres Anguiano
Fecha: 01/09/2023
Indicaciones: Dado un arreglo de n números enteros, el programa debe encontrar el número de veces que "y" aparece entre ellos.
*/

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int y = sc.nextInt();
    int n = sc.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++)
      A[i] = sc.nextInt();
    System.out.println(countOcurrences(A, y, n));
    sc.close();
  }

  static int countOcurrences(int[] A, int y, int i) {
    if (i == 1)
      if (A[0] == y)
        return 1;
      else
        return 0;

    if (A[i - 1] == y)
      return 1 + countOcurrences(A, y, i - 1);
    return countOcurrences(A, y, i - 1);
  }

}