public class Main
{
  public static void main(String[] args)
  {
    int[] A = {163,768,720,421,109,110,154,733,766,653,913,537,0,49,999,1000};//
    imprime(A);
    radixSort(A,maxIn(A));
  }
  public static void radixSort(int[] A, int k){
    for (int i = 1; k/i > 0 ; i= i*10)
      countingR(A,i);
  }
  public static int maxIn (int[] A)
  {
    int n = A[0];
    for (int  i = 1; i < A.length ; ++i )
      if (A[i]>n) n=A[i];
    return n;
  }
  static void countingR(int[] A, int d)
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
  static void imprime(int[] A)// imprime en forma un arreglo de int's
  {
    for (int x = 0 ; x<A.length ; x++) {
      if (x == 0) System.out.print("[");
      if (x < A.length-1) System.out.print(A[x] + ",");
      if (x == A.length-1) System.out.print(A[x] +"]");
    }
    System.out.println();
  }
}
