public class Main
{
  static void selesctionSort(int[] A)
  {
    for (int i = 0; i < A.length ; ++i )
    {
      int lugar = i;
      for (int j = i; j<A.length ; ++j )
        if (A[j] < A[lugar])
          lugar = j;
      int guardado = A[i];
      A[i] = A[lugar];
      A[lugar] = guardado;
    }
  }
  static void imprime(int[] A)// imprime en forma un arreglo de int's
  {
    for (int x = 0 ; x<A.length ; x++) {
      if (x == 0) System.out.print("[");
      if (x < A.length-1) System.out.print(A[x] + ",");
      if (x == A.length-1) System.out.print(A[x] +"]");
    }
  }
  public static void main(String[] args)
  {
    int [] A ={8,48,64,2,6,8,4,9,2,0};
    imprime(A);
    selesctionSort(A);
    imprime(A);
  }

}
