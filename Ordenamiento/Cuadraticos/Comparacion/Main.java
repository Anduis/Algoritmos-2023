/*
Autor: Andres Anguiano
Fecha: 06/09/2023
Indicaciones: compara los algoritmos de ordenamiento O(n^2)
*/

import java.util.Random;

public class Main {
  public static void main(String[] args) {
    int n = 60;
    long[] bubbleTimes = new long[n];
    long[] insertionTimes = new long[n];
    long[] selectionTimes = new long[n];

    for (int i = 0; i < n; i++) {
      int[] temp = fillRandom(500 * (i + 1));
      bubbleTimes[i] = bubbleSort(temp.clone());
      insertionTimes[i] = insertionSort(temp.clone());
      selectionTimes[i] = selectionSort(temp.clone());
    }

    System.out.println("bubbleSort");
    print(bubbleTimes);
    System.out.println("insertionSort");
    print(insertionTimes);
    System.out.println("selectionSort");
    print(selectionTimes);
  }

  public static int[] fillRandom(int a)// llena un int[] de tamaño a con valores aleatorios
  {
    Random rnd = new Random();
    int[] temp = new int[a];
    for (int i = 0; i < a; i++)
      temp[i] = rnd.nextInt(2147483647);
    return temp;
  }

  static void print(long[] A) {
    for (int i = 0; i < A.length; i++)
      System.out.println(A[i]);
  }

  static long bubbleSort(int[] A) {
    long a = System.currentTimeMillis();
    int temp = 0;
    for (int i = 0; i < A.length; i++)
      for (int j = 1; j < (A.length - i); j++)
        if (A[j - 1] > A[j]) {
          temp = A[j - 1];
          A[j - 1] = A[j];
          A[j] = temp;
        }
    long b = System.currentTimeMillis();
    return b - a;
  }

  static long insertionSort(int A[]) {
    long a = System.currentTimeMillis();
    for (int i = 1; i < A.length; ++i) {
      int key = A[i];
      int j = i - 1;
      while (j >= 0 && A[j] > key)
        A[j + 1] = A[j--];
      A[j + 1] = key;
    }
    long b = System.currentTimeMillis();
    return b - a;
  }

  static long selectionSort(int[] A) {
    long a = System.currentTimeMillis();
    for (int i = 0; i < A.length; ++i) {
      int lugar = i;
      for (int j = i; j < A.length; ++j)
        if (A[j] < A[lugar])
          lugar = j;
      int guardado = A[i];
      A[i] = A[lugar];
      A[lugar] = guardado;
    }
    long b = System.currentTimeMillis();
    return b - a;
  }
}
