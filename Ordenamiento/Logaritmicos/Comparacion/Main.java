/*
Autor: Andres Anguiano
Fecha: 08/09/2023
Indicaciones: compara los algoritmos de ordenamiento O(nlogn)
*/

import java.util.Random;

public class Main {
  public static void main(String[] args) {
    int n = 60;
    long[] quickTimes = new long[n];
    long[] mergeTimes = new long[n];
    long[] heapTimes = new long[n];

    for (int i = 0; i < n; i++) {
      int[] temp = fillRandom(200000 * (i + 1));

      long tQ = System.currentTimeMillis();
      quickSort(temp.clone(), 0, temp.length - 1);
      quickTimes[i] = System.currentTimeMillis() - tQ;

      long tM = System.currentTimeMillis();
      mergeSort(temp.clone(), 0, temp.length - 1);
      mergeTimes[i] = System.currentTimeMillis() - tM;

      long tH = System.currentTimeMillis();
      heapSort(temp.clone());
      heapTimes[i] = System.currentTimeMillis() - tH;
    }

    System.out.println("QuickSort:");
    print(quickTimes);
    System.out.println("MergeSort:");
    print(mergeTimes);
    System.out.println("HeapSort:");
    print(heapTimes);
  }

  // QUICKSORT
  static void quickSort(int[] A, int s, int e) {
    if (s < e) {
      int p = partition(A, s, e);
      quickSort(A, s, p - 1);
      quickSort(A, p + 1, e);
    }
  }

  static int partition(int[] A, int s, int e) {
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

  // MERGESORT
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

  // HEAPSORT
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

  // util
  static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

  public static int[] fillRandom(int a)// llena un int[] de tamaño a con valores aleatorios
  {
    Random rnd = new Random();
    int[] temp = new int[a];
    for (int i = 0; i < a; i++)
      temp[i] = rnd.nextInt(Integer.MAX_VALUE);
    return temp;
  }

  static void print(long[] A) {
    for (int i = 0; i < A.length; i++)
      System.out.println(A[i]);
  }
}
