/*
Autor: Andres Anguiano
Fecha: 08/09/2023
Indicaciones: Implementacion de algoritmo O(nlogn) Merge
*/

import java.util.Random;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] A = fillRandom(20);
    System.out.println(Arrays.toString(A));
    mergeSort(A, 0, A.length - 1);
    System.out.println(Arrays.toString(A));
  }

  public static void merge(int[] A, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    int[] L = new int[n1];
    int[] R = new int[n2];
    for (int i = 0; i < n1; i++)
      L[i] = A[l + i];
    for (int j = 0; j < n2; j++)
      R[j] = A[m + 1 + j];
    int i = 0;
    int j = 0;
    int k = l;
    while (i < n1 && j < n2)
      if (L[i] <= R[j])
        A[k++] = L[i++];
      else
        A[k++] = R[j++];
    while (i < n1)
      A[k++] = L[i++];
    while (j < n2)
      A[k++] = R[j++];
  }

  public static void mergeSort(int[] A, int l, int r) {
    if (r > l) {
      int m = (r + l) / 2;
      mergeSort(A, l, m);
      mergeSort(A, m + 1, r);
      merge(A, l, m, r);
    }
  }

  public static int[] fillRandom(int a) {
    Random rnd = new Random();
    int[] temp = new int[a];
    for (int i = 0; i < a; i++)
      temp[i] = rnd.nextInt(a);
    return temp;
  }
}
