/*
Autor: Andres Anguiano
Fecha: 08/09/2023
Indicaciones: Implementacion de algoritmo O(n) Bucket
*/

import java.util.Random;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] A = fillRandom(20);
    System.out.println(Arrays.toString(A));
    radixSort(A, max(A));
    System.out.println(Arrays.toString(A));
  }

  public static void countingR(int[] A, int d) {
    int i;
    int[] B = new int[A.length];
    int[] C = new int[10];
    for (i = 0; i < A.length; i++)
      C[(A[i] / d) % 10] += 1;
    for (i = 1; i < C.length; i++)
      C[i] += C[i - 1];
    for (i = A.length - 1; i >= 0; i--)
      B[--C[(A[i] / d) % 10]] = A[i];
    for (i = 0; i < A.length; i++)
      A[i] = B[i];
  }

  public static void radixSort(int[] A, int k) {
    for (int i = 1; k / i > 0; i = i * 10)
      countingR(A, i);
  }

  public static int max(int[] A) {
    int n = A[0];
    for (int i = 1; i < A.length; ++i)
      if (A[i] > n)
        n = A[i];
    return n;
  }

  public static int[] fillRandom(int a) {
    Random rnd = new Random();
    int[] temp = new int[a];
    for (int i = 0; i < a; i++)
      temp[i] = rnd.nextInt(a);
    return temp;
  }
}
