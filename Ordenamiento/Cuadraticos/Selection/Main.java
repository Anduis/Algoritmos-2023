/*
Autor: Andres Anguiano
Fecha: 06/09/2023
Indicaciones: Implementacion de algoritmo O(n^2) Selection
*/

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] A = { 8, 48, 64, 2, 6, 8, 4, 9, 2, 0 };
    System.out.println(Arrays.toString(A));
    selectionSort(A);
    System.out.println(Arrays.toString(A));
  }

  static void selectionSort(int[] A) {
    for (int i = 0; i < A.length; ++i) {
      int lugar = i;
      for (int j = i; j < A.length; ++j)
        if (A[j] < A[lugar])
          lugar = j;
      int guardado = A[i];
      A[i] = A[lugar];
      A[lugar] = guardado;
    }
  }

}
