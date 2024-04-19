public class Main
{
  static int[] countingSort(int[] A, int k)
  {
    int i;
    int[] C = new int[k + 1];
    int[] B = new int[A.length];
    for (i = 0; i < A.length; i++)
      C[A[i]] += 1;
    for (i = 1; i < C.length; i++)
      C[i] += C[i - 1];
    for (i = A.length-1; i >= 0; i--)
    	B[--C[A[i]]] = A[i];
    return B;
  }
  public static void main(String[] args) {
    int[] A = {163,768,720,421,109,110,154,733,766,653,913,537,0,18,35,999,1000};
    int k = maxIn(A);
    int[] B = countingSort(A,k);
    imprime (A);
    System.out.println();
    imprime (B);
  }
  public static int maxIn (int[] A)
  {
    int n = A[0];
    for (int  i = 1; i < A.length ; ++i )
      if (A[i]>n) n=A[i];
    return n;
  }
  static void imprime(int[] A)// imprime en forma un arreglo de int's
  {
    for (int x = 0 ; x<A.length ; x++) {
      if (x == 0) System.out.print("[");
      if (x < A.length-1) System.out.print(A[x] + ",");
      if (x == A.length-1) System.out.print(A[x] +"]");
    }
  }
}
