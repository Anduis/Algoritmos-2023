/*
Autor: Andres Anguiano
Fecha: 06/09/2023
Indicaciones: Implementacion de algoritmo O(n^2) Bubble
*/

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] A = { 8, 48, 64, 2, 6, 8, 4, 9, 2, 0 };
    System.out.println(Arrays.toString(A));
    bubbleSort(A);
    System.out.println(Arrays.toString(A));
  }

  static void bubbleSort(int[] A) {
    int temp = 0;
    for (int i = 0; i < A.length; i++)
      for (int j = 1; j < (A.length - i); j++)
        if (A[j - 1] > A[j]) {
          temp = A[j - 1];
          A[j - 1] = A[j];
          A[j] = temp;
        }
  }
}