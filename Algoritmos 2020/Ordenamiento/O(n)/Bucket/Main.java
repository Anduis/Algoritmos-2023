import java.util.*;
public class BucketSort {
  public static void main(String[] args) {
    int[] A = {4498,7327,5354,3374,1099,5849,5492,3459,5570,8607,5933,5722,4789,6846,1781,3505,7284,7969};
    //int[] A = {21,11,33,70,5,25,65,55};
    int k = maxIn(A);
    System.out.println("max: "+ maxIn(A));
    System.out.println("min: "+ minIn(A));
    System.out.println("sizeA: "+ A.length);
    System.out.println("bNumber: "+bNumber(A));
    System.out.println("rango: " + range(A));
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    System.out.println("Original array- " + Arrays.toString(A));
    bucketSort(A, bNumber(A),range(A));
    System.out.println("Sorted array after bucket sort- " + Arrays.toString(A));
  }

  private static void bucketSort(int[] A, int bNumber, int rango)
  {
    List<Integer>[] buckets = new List[bNumber];// Create bucket array
    for(int i = 0; i < bNumber; i++)// Associate a list with each index
      buckets[i] = new LinkedList<>();  // in the bucket array

    for(int j : A){// Assign numbers from array to the proper bucke
      System.out.println("hash- " + hash(j, bNumber, rango));
      buckets[hash(j, bNumber, rango)].add(j);// by using hashing function
    }

    for(List<Integer> bucket : buckets)// sort buckets
      Collections.sort(bucket);
    int i = 0;

    for(List<Integer> bucket : buckets)// Merge buckets to get sorted array
      for(int j : bucket)
        A[i++] = j;
  }

  private static int hash(int x, int bNumber, int rango)// A very simple hash function
  {
    int y=-1;
    for (int i = 1 ; i <= rango ; i++) {
      if ((x >= (i-1)*rango) && (x < (i+1)*rango) ) y = i-1;
    }
    return y;
  }
  //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
  public static int bNumber (int[] A)//cantidad de buckets
  {
    return (int)Math.sqrt(A.length)+1;
  }
  public static int range (int[] A)
  {
    int a = maxIn(A);
    int b = minIn(A);
    return (a+b)/(bNumber(A)-1);
  }
  public static int maxIn (int[] A)
  {
    int n = A[0];
    for (int  i = 1; i < A.length ; ++i )
      if (A[i]>n) n=A[i];
    return n;
  }
  public static int minIn (int[] A)
  {
    int n = A[0];
    for (int  i = 1; i < A.length ; ++i )
      if (A[i]<n) n=A[i];
    return n;
  }
}
