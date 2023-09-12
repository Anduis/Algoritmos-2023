/*
Autor: Andres Anguiano
Fecha: 08/09/2023
Indicaciones: Implementacion de algoritmo O(n) Bucket
*/

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    int[] A = fillRandom(20);
    System.out.println(Arrays.toString(A));
    bucketSort(A, bNumber(A));
    System.out.println(Arrays.toString(A));
  }

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

  public static int[] fillRandom(int a) {
    Random rnd = new Random();
    int[] temp = new int[a];
    for (int i = 0; i < a; i++)
      temp[i] = rnd.nextInt(a);
    return temp;
  }
}
