/*
Autor: Andres Anguiano
Fecha: 08/09/2023
Indicaciones: compara los algoritmos de ordenamiento O(n)
*/

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    int n = 60;
    long[] countingTimes = new long[n];
    long[] radixTimes = new long[n];
    long[] bucketTimes = new long[n];

    for (int i = 0; i < n; i++) {
      int[] A = fillRandom(200000 * (i + 1));

      long aC = System.currentTimeMillis();
      countingSort(A.clone(), max(A));
      countingTimes[i] = System.currentTimeMillis() - aC;

      long aR = System.currentTimeMillis();
      radixSort(A.clone(), max(A));
      radixTimes[i] = System.currentTimeMillis() - aR;

      long aB = System.currentTimeMillis();
      bucketSort(A.clone(), bNumber(A));
      bucketTimes[i] = System.currentTimeMillis() - aB;
    }

    System.out.println("CountingSort:");
    print(countingTimes);
    System.out.println("RadixSort:");
    print(radixTimes);
    System.out.println("BucketSort:");
    print(bucketTimes);
  }

  // CountingSort
  public static void countingSort(int[] A, int k) {
    int i;
    int[] B = new int[A.length];
    int[] C = new int[k + 1];
    for (i = 0; i < A.length; i++)
      C[A[i]] += 1;
    for (i = 1; i < C.length; i++)
      C[i] += C[i - 1];
    for (i = A.length - 1; i >= 0; i--)
      B[--C[A[i]]] = A[i];
    for (i = 0; i < A.length; i++)
      A[i] = B[i];
  }

  // RadixSort
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

  // BucketSort
  public static void bucketSort(int[] A, int bNumber) {
    LinkedList<Integer>[] buckets = new LinkedList[bNumber];
    for (int i = 0; i < bNumber; i++)
      buckets[i] = new LinkedList<Integer>();
    for (int j : A)
      buckets[hash(j, bNumber)].add(j);
    for (List<Integer> bucket : buckets)
      Collections.sort(bucket);
    int i = 0;
    for (List<Integer> bucket : buckets)
      for (int j : bucket)
        A[i++] = j;
  }

  public static int hash(int x, int bNumber) {
    return x / bNumber;
  }

  public static int bNumber(int[] A) {
    return (int) Math.sqrt(A.length) + 1;
  }

  // util
  public static void print(long[] A) {
    for (int i = 0; i < A.length; i++)
      System.out.println(A[i]);
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
      temp[i] = rnd.nextInt(Integer.MAX_VALUE);
    return temp;
  }
}
