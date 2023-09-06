import java.util.Random;
class Main{
  static int particion(int[] A, int p, int r)
  {
    int x = A[r];
    int i = (p-1);
    for ( int j = p ; j < r ; j++ )
    {
      if (A[j] < x)
      {
        i++;
        cambia(A,i,j);
      }
    }
    cambia(A,(i+1),r);
    return i+1;
  }
  static void cambia(int[] A, int i, int j)
  {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
  static void quickSort(int[] A, int p, int r)
  {
    if (p < r)
    {
      int z = particion(A, p, r);
      quickSort(A, p, z-1);
      quickSort(A, z+1, r);
    }
  }
  public static void main(String[] args)
  {
    int[] A = llenaAleatorio(10000*10000);
    System.out.println( );
    long a = System.currentTimeMillis();
    quickSort(A,0,A.length-1);
    long b = System.currentTimeMillis();
    long t = b-a;
    System.out.println(t);
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
  public static int[] llenaAleatorio(int a)// llena un int[] de tamaño a rango a
  {
    Random aleatorio = new Random();
    int[] memoria = new int[a];
    for(int i = 0 ; i < a ; i++)
    {
      memoria[i] =  aleatorio.nextInt(a);
    }
    return memoria;
  }
}
