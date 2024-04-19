import java.util.Random;
public class Main
{
  public static void merge(int[] A, int l, int m, int r){
    int n1= m-l+1;
    int n2 = r-m;
    int[] L = new int [n1];
    int[] R = new int [n2];
    for (int i = 0; i<n1 ; i++ ) {
      L[i] = A[l+i];
    }
    for (int j = 0; j<n2 ; j++ ) {
      R[j] = A[m+1+j];
    }
    int i = 0;
    int j = 0;
    /*
    if (i < n1 || j < n2) {
      for (int k = l ; k < r; k++) {
        if (L[i] <= R[j]) {
          A[k] = L[i];
          i++;
        }
        else{
          A[k] = R[j];
          j++;
        }
      }
    }
    */
    int k = l;
    while (i < n1 && j < n2)
    {
      if (L[i] <= R[j])
      {
        A[k] = L[i];
        i++;
      }
      else
      {
        A[k] = R[j];
        j++;
      }
      k++;
    }
    while (i < n1)
    {
      A[k] = L[i];
      i++;
      k++;
    }
    while (j < n2)
    {
      A[k] = R[j];
      j++;
      k++;
    }
  }
  public static void mergeSort(int[] A, int p, int r)
  {
    if (r > p) {
      int m = (r+p)/2;
      mergeSort(A,p,m);
      mergeSort(A,m+1,r);
      merge(A,p,m,r);
    }
  }
  public static int[] llenaAleatorio(int a)// llena un int[] de tamaño a con valores aleatorios b
  {
    Random aleatorio = new Random();
    int[] memoria = new int[a];
    for(int i = 0 ; i < a ; i++)
    {
      memoria[i] =  aleatorio.nextInt(a);
    }
    return memoria;
  }
  static void imprime(int[] A)// imprime en forma un arreglo de int's
  {
    for (int x = 0 ; x<A.length ; x++)
    {
      if (x == 0) System.out.print("[");
      if (x < A.length-1) System.out.print(A[x] + ",");
      if (x == A.length-1) System.out.print(A[x] +"]");
    }
  }
  public static void main(String[] args)
  {
    int[] A = llenaAleatorio(20);
    imprime(A);
    long a = System.currentTimeMillis();
    mergeSort(A,0,A.length-1);
    long b = System.currentTimeMillis();
    long t = b-a;
    imprime(A);
    System.out.println(t);
  }
}
