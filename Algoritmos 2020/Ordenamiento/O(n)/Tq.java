import java.util.*;
public class Tq
{
  public static void main(String[] args) {
    int[] A = llenaAleatorio(100000);
    //int[] A = {4498,7327,5354,3374,1099,5849,5492,3459,5570,8607,5933,5722,4789,6846,1781,3505};
    //System.out.println("Original array- " + Arrays.toString(A));
    int  r= bNumber(A);
    int  t= range(A);
    System.out.println("esta en orden: " + isSorted(A));
    long aB = System.currentTimeMillis();
    bucketSort(A, r, t);
    long bB = System.currentTimeMillis();
    long tB = bB-aB;
    //System.out.println("Sorted array after bucket sort- " + Arrays.toString(A));
    System.out.println("max: "+ maxIn(A));
    System.out.println("min: "+ minIn(A));
    System.out.println("sizeA: "+ A.length);
    System.out.println("rango: "+ range(A));
    System.out.println("bNumber: "+bNumber(A));

    System.out.println("tiempo: " + tB);
    System.out.println("esta en orden: " + isSorted(A));
  }
  private static void bucketSort(int[] A, int bNumber, int rango)
  {
    List<Integer>[] buckets = new List[bNumber];// Create bucket array
    for(int i = 0; i < bNumber; i++)// Associate a list with each index
      buckets[i] = new LinkedList<>();  // in the bucket array

    for(int j : A)// Assign numbers from array to the proper bucke
    {
      System.out.println("elemento: "+ j +" hash: " + hash(j, bNumber,rango) +"  esta en " + (hash(j, bNumber,rango))*rango +"<"+j+"<"+(hash(j, bNumber,rango)+1)*rango);
      buckets[hash(j, bNumber, rango)].add(j);// by using hashing function
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
    /*
    for(List<Integer> bucket : buckets)// sort buckets
      Collections.sort(bucket);
    int i = 0;

    for(List<Integer> bucket : buckets)// Merge buckets to get sorted array
      for(int j : bucket)
        A[i++] = j;
    */
  }

  private static int hash(int x, int bNumber, int rango)// A very simple hash function
  {
    return x/bNumber; //si es cuadrada
    /*
    int y=0;
    for (int i = 1 ; i <= rango ; i++) {
      if ((x >= (i-1)*rango) && (x < (i+1)*rango) ) y = i-1;
    }
    return y;
    */
  }
  public static int bNumber (int[] A)//cantidad de buckets
  {
    return (int)Math.sqrt(A.length)+1;
  }
  static void imprime(long[] x){
    for (int i = 0; i < x.length ; i++ )
      System.out.println(x[i]);
  }
  public static boolean isSorted (int[]A){
    for (int i = 1; i<A.length ; i++ )
      if (A[i] < A[i-1]) return false;
    return true;
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
