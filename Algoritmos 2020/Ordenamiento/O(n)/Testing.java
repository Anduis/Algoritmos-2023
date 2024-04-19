import java.util.*;
public class Testing{
  public static void main(String[] args)
  {
    int[] numeroSet = new int[50];
    long[] tiemposCounting = new long[50];
    long[] tiemposRadix = new long[50];
    long[] tiemposBucket = new long[50];

    for (int i = 0 ; i != 10000000 ;){
      i= i+200000;
      numeroSet[(i/200000)-1]=i;
    }

    for (int i = 0 ; i < numeroSet.length ; i++){
      int[] Au = llenaAleatorio(numeroSet[i]);
      int[] Ad = new int[Au.length];
      int[] At = new int[Au.length];
      for (int o = 0 ; o<Au.length ; o++ ){
        Ad[o]=Au[o];
        At[o]=Au[o];
      }
      int k = maxIn(Au);
      long aC = System.currentTimeMillis();
      countingSort(Au,k);
      long bC = System.currentTimeMillis();
      long tC = bC-aC;
      tiemposCounting[i] = tC;

      long aR = System.currentTimeMillis();
      radixSort(Ad,k);
      long bR = System.currentTimeMillis();
      long tR = bR-aR;
      tiemposRadix[i] = tR;

      long aB = System.currentTimeMillis();
      bucketSort(At, bNumber(At));
      long bB = System.currentTimeMillis();
      long tB = bB-aB;
      tiemposBucket[i] = tB;
    }
    System.out.println("CountingSort");
    imprime(tiemposCounting);
    System.out.println("RadixSort");
    imprime(tiemposRadix);
    System.out.println("BucketSort");
    imprime(tiemposBucket);
  }
  /*--------------------------------CountingSort--------------------------------*/
  static void countingSort(int[] A, int k)// k -> maxIn(A)
  {
    int i;
    int[] B = new int[A.length];
    int[] C = new int[k + 1];
    for (i = 0; i < A.length; i++)
      C[A[i]] += 1;
    for (i = 1; i < C.length; i++)
      C[i] += C[i - 1];
    for (i = A.length-1; i >= 0; i--)
    	B[--C[A[i]]] = A[i];
    for (i = 0; i < A.length; i++)
      A[i] = B[i];
  }
  /*--------------------------------RadixSort--------------------------------*/
  static void countingR(int[] A, int d)// d -> i^digito corriente
  {
    int[] B = new int[A.length];
    int[] C = new int[10];
    int i;
    for (i = 0; i < A.length; i++)
      C[(A[i] / d) % 10] += 1;
    for (i = 1; i < C.length; i++)
      C[i] += C[i - 1];
    for (i = A.length - 1; i >= 0; i--)
      B[--C[(A[i] / d) % 10]] = A[i];
    for (i = 0; i < A.length; i++)
      A[i] = B[i];
  }
  public static void radixSort(int[] A, int k)// k -> maxIn(A), ordena
  {
    for (int i = 1; k/i > 0 ; i= i*10)
      countingR(A,i);
  }
  /*--------------------------------BucketSort--------------------------------*/
  private static void bucketSort(int[] A, int bNumber)
  {
    List<Integer>[] buckets = new List[bNumber];// Create bucket array
    for(int i = 0; i < bNumber; i++)// Associate a list with each index
      buckets[i] = new LinkedList<>();  // in the bucket array

    for(int j : A)// Assign numbers from array to the proper bucke
      buckets[hash(j, bNumber)].add(j);// by using hashing function

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
  /*--------------------------------UTILIDADES--------------------------------*/
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
  public static int[] llenaAleatorio(int a){
    Random aleatorio = new Random();
    int[] memoria = new int[a];
    for(int i = 0 ; i < a ; i++)
      memoria[i] =  aleatorio.nextInt(a);
    return memoria;
    //2147483647
  }
}
