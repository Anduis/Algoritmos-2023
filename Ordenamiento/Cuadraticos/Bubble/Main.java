/*
Autor: Andres Anguiano
Fecha: 06/09/2023
Indicaciones: Implementacion de algoritmo O(n^2) Bubble
*/

import java.util.Arrays;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    int[] A = fillRandom(20);
    System.out.println(Arrays.toString(A));
    bubbleSort(A);
    System.out.println(Arrays.toString(A));
  }

  public static void bubbleSort(int[] A) {
    int temp = 0;
    for (int i = 0; i < A.length; i++)
      for (int j = 1; j < (A.length - i); j++)
        if (A[j - 1] > A[j]) {
          temp = A[j - 1];
          A[j - 1] = A[j];
          A[j] = temp;
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