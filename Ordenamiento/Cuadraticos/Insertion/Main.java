/*
Autor: Andres Anguiano
Fecha: 06/09/2023
Indicaciones: Implementacion de algoritmo O(n^2) Insertion
*/

import java.util.Arrays;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    int[] A = fillRandom(20);
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

  public static int[] fillRandom(int a)// llena un int[] de tamaño a con valores aleatorios
  {
    Random rnd = new Random();
    int[] temp = new int[a];
    for (int i = 0; i < a; i++)
      temp[i] = rnd.nextInt(a);
    return temp;
  }
}