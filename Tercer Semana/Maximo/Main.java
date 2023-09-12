/*
Autor: Andres Anguiano
Fecha: 01/09/2023
Indicaciones: Dado un arreglo de n números enteros, el programa debe encontrar el valor máximo entre ellos.
*/

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < n; i++)
      A[i] = sc.nextInt();
    System.out.println(findMax(A, n));
    sc.close();
  }

  static int findMax(int[] A, int i) {
    if (i == 1)
      return A[0];
    if (A[i - 1] > findMax(A, i - 1))
      return A[i - 1];
    return findMax(A, i - 1);
  }
}
