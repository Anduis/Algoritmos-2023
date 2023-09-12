/*
Autor: Andres Anguiano
Fecha: 08/09/2023
Indicaciones: Implementacion de algoritmo O(nlogn) Quick
*/

import java.util.Arrays;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    int[] A = fillRandom(20);
    System.out.println(Arrays.toString(A));
    quickSort(A, 0, A.length - 1);
    System.out.println(Arrays.toString(A));
  }

  public static void quickSort(int[] A, int s, int e) {
    if (s < e) {
      int p = partition(A, s, e);
      quickSort(A, s, p - 1);
      quickSort(A, p + 1, e);
    }
  }

  public static int partition(int[] A, int s, int e) {
    int p = e;
    int i = (s - 1);
    int j = s;
    while (j < p)
      if (A[j] > A[p])
        j++;
      else
        swap(A, ++i, j++);
    swap(A, (i + 1), p);
    return i + 1;
  }

  public static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

  public static int[] fillRandom(int a) {
    Random rnd = new Random();
    int[] temp = new int[a];
    for (int i = 0; i < a; i++)
      temp[i] = rnd.nextInt(a);
    return temp;
  }
}
