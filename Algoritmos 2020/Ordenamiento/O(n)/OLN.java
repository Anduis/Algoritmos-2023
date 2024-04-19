import java.util.*;
public class OLN{
  public static void main(String[] args)
  {
    int[] numeroSet = new int[50];
    long[] tiemposCounting = new long[50];
    long[] tiemposRadix = new long[50];
    long[] tiemposBucket = new long[50];
    long[] tiemposHeap = new long[50];

    for (int i = 0 ; i != 10000000 ;){
      i= i+200000;
      numeroSet[(i/200000)-1]=i;
    }

    for (int i = 0 ; i < numeroSet.length ; i++){
      int[] Au = llenaAleatorio(numeroSet[i]);
      int[] Ad = new int[Au.length];
      int[] At = new int[Au.length];
      int[] Ac = new int[Au.length];
      for (int o = 0 ; o<Au.length ; o++ ){
        Ad[o]=Au[o];
        At[o]=Au[o];
        Ac[o]=Au[o];
      }
      int k = maxIn(Au);
      /*
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
      */

      int w = bNumber(At);
      long aB = System.currentTimeMillis();
      bucketSort(At, w);
      long bB = System.currentTimeMillis();
      long tB = bB-aB;
      tiemposBucket[i] = tB;
/*
      long aH = System.currentTimeMillis();
      heapSort(Ac);
      long bH = System.currentTimeMillis();
      long tH = bH-aH;
      tiemposHeap[i] = tH;
      */
    }
    /*
    System.out.println("CountingSort");
    imprime(tiemposCounting);
    System.out.println("RadixSort");
    imprime(tiemposRadix);
    */
    System.out.println("BucketSort");
    imprime(tiemposBucket);
    /*
    System.out.println("HeapSort");
    imprime(tiemposHeap);
    */
  }
  //------------------------------------------------------------------------------------------- HEAPSORT
  public static void heapSort(int A[]){
    int n = A.length;
    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--)
      heapify(A, n, i);
    // One by one extract an element from heap
    for (int i=n-1; i>0; i--){
      // Move current root to end
      int temp = A[0];
      A[0] = A[i];
      A[i] = temp;
      // call max heapify on the reduced heap
      heapify(A, i, 0);
    }
  }

  // To heapify a subtree rooted with node i which is
  // an index in A[]. n is size of heap
  public static void heapify(int A[], int n, int i){
    int largest = i; // Initialize largest as root
    int l = 2*i + 1; // left = 2*i + 1
    int r = 2*i + 2; // right = 2*i + 2

    // If left child is larger than root
    if (l < n && A[l] > A[largest])
    largest = l;

    // If right child is larger than largest so far
    if (r < n && A[r] > A[largest])
    largest = r;

    // If largest is not root
    if (largest != i){
      int swap = A[i];
      A[i] = A[largest];
      A[largest] = swap;

      // Recursively heapify the affected sub-tree
      heapify(A, n, largest);
    }
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
    {
      buckets[j/bNumber].add(j);// by using hashing function
    }

    int c=0;
    for(List<Integer> bucket : buckets)// sort buckets
    {
      int i = 0;
      int[] temp = new int[bucket.size()];
      for(int j : bucket)
        temp[i++] = j;
      quickSort(temp,0,temp.length-1);
      for(int k : temp)
        A[c++] = k;
    }
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
  //------------------------------------------------------------------------------------------- QUICKSORT
  static int particion(int[] A, int p, int r){
    int x = A[r];
    int i = (p-1);
    for ( int j = p ; j < r ; j++ ){
      if (A[j] < x){
        i++;
        cambia(A,i,j);
      }
    }
    cambia(A,(i+1),r);
    return i+1;
  }
  static void cambia(int[] A, int i, int j){
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
  static void quickSort(int[] A, int p, int r){
    if (p < r){
      int z = particion(A, p, r);
      quickSort(A, p, z-1);
      quickSort(A, z+1, r);
    }
  }
}
