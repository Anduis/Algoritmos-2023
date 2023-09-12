/*
Autor: Andres Anguiano
Fecha: 06/09/2023
Indicaciones: Implementacion de algoritmo O(n^2) Selection
*/

import java.util.Arrays;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    int[] A = fillRandom(20);
    System.out.println(Arrays.toString(A));
    selectionSort(A);
    System.out.println(Arrays.toString(A));
  }

  public static void selectionSort(int[] A) {
    for (int i = 0; i < A.length; ++i) {
      int index = i;
      for (int j = i; j < A.length; ++j)
        if (A[j] < A[index])
          index = j;
      int temp = A[i];
      A[i] = A[index];
      A[index] = temp;
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
