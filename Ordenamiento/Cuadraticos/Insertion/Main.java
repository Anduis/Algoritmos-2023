/*
Autor: Andres Anguiano
Fecha: 06/09/2023
Indicaciones: Implementacion de algoritmo O(n^2) Insertion
*/

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] A = { 8, 48, 64, 2, 6, 8, 4, 9, 2, 0 };
    System.out.println(Arrays.toString(A));
    insertionSort(A);
    System.out.println(Arrays.toString(A));
  }

  static void insertionSort(int A[]) {
    for (int i = 1; i < A.length; ++i) {
      int key = A[i];
      int j = i - 1;
      while (j >= 0 && A[j] > key)
        A[j + 1] = A[j--];
      A[j + 1] = key;
    }
  }
}