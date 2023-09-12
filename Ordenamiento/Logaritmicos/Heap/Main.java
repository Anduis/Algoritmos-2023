/*
Autor: Andres Anguiano
Fecha: 08/09/2023
Indicaciones: Implementacion de algoritmo O(nlogn) Heap
*/

import java.util.Random;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] A = fillRandom(20);
    System.out.println(Arrays.toString(A));
    heapSort(A);
    System.out.println(Arrays.toString(A));
  }

  public static void heapSort(int A[]) {
    for (int i = A.length / 2 - 1; i >= 0; i--)
      heapify(A, A.length, i);
    for (int i = A.length - 1; i > 0; i--) {
      swap(A, 0, i);
      heapify(A, i, 0);
    }
  }

  public static void heapify(int A[], int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < n && A[l] > A[largest])
      largest = l;
    if (r < n && A[r] > A[largest])
      largest = r;
    if (largest != i) {
      swap(A, i, largest);
      heapify(A, n, largest);
    }
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
