import java.util.*;
public class Tt
{
  public static void main(String[] args) {
    int[] A = llenaAleatorio(10000000);
//int[] A = {4498,7327,5354,3374,1099,5849,5492,3459,5570,8607,5933,5722,4789,6846,1781,3505,7284,7969};
    long aB = System.currentTimeMillis();
    bucketSort(A, bNumber(A));
    long bB = System.currentTimeMillis();
    long tB = bB-aB;
    System.out.println("max: "+ maxIn(A));
    System.out.println("min: "+ minIn(A));
    System.out.println("sizeA: "+ A.length);
    System.out.println("bNumber: "+bNumber(A));

    System.out.println(tB);
  }
  private static void bucketSort(int[] A, int bNumber)
  {
    List<Integer>[] buckets = new List[bNumber];// Create bucket array
    for(int i = 0; i < bNumber; i++)// Associate a list with each index
      buckets[i] = new LinkedList<>();  // in the bucket array

    for(int j : A)// Assign numbers from array to the proper bucke
    {
      //System.out.println("elemento: "+ j +" hash: " + hash(j, bNumber) +"  esta en " + (hash(j, bNumber))*3161 +"<"+j+"<"+(hash(j, bNumber)+1)*3161);
      buckets[hash(j, bNumber)].add(j);// by using hashing function
    }

    for(List<Integer> bucket : buckets)// sort buckets
      Collections.sort(bucket);
    int i = 0;

    for(List<Integer> bucket : buckets)// Merge buckets to get sorted array
      for(int j : bucket)
        A[i++] = j;
  }
  private static int hash(int x, int bNumber)// A very simple hash function
  {
    return x/bNumber;
  }
  public static int bNumber (int[] A)//cantidad de buckets
  {
    return (int)Math.sqrt(A.length)+1;
  }
  static void imprime(long[] x){
    for (int i = 0; i < x.length ; i++ )
      System.out.println(x[i]);
  }
  public static int maxIn (int[] A)
  {
    int n = A[0];
    for (int  i = 1; i < A.length ; ++i )
      if (A[i]>n) n=A[i];
    return n;
  }
  public static int range (int[] A)
  {
    int a = maxIn(A);
    int b = minIn(A);
    return (a+b)/(bNumber(A)-1);
  }
  public static int minIn (int[] A)
  {
    int n = A[0];
    for (int  i = 1; i < A.length ; ++i )
      if (A[i]<n) n=A[i];
    return n;
  }
  public static int[] llenaAleatorio(int a){
    Random aleatorio = new Random();
    int[] memoria = new int[a];
    for(int i = 0 ; i < a ; i++)
      memoria[i] =  aleatorio.nextInt(a);
    return memoria;
  }
}
