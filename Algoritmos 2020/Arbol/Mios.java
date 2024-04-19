import java.util.*;
public class Mios{
  //UTILIDADES
  static void imprime(int[] A)// imprime en forma un arreglo de int's
  {
    for (int x = 0 ; x<A.length ; x++) {
      if (x == 0) System.out.print("[");
      if (x < A.length-1) System.out.print(A[x] + ",");
      if (x == A.length-1) System.out.print(A[x] +"]");
    }
  }
  public static long usrEsbribe(){// devuelve un long con los datos que ingrese el usuario
    Scanner scan = new Scanner(System.in);
    long teclado = scan.nextLong();
    return teclado;
  }
  static int dif(int x, int y)//diferencia el mas chico de dos int
  {
  if (x<y)
  return x;
  else
  return y;
  }
  public static boolean isSorted (int[]A){
    for (int i = 1; i<A.length ; i++ )
      if (A[i] < A[i-1]) return false;
    return true;
  }
  public static int[] llenaAleatorio(int a)// llena un int[] de tamaño a
  {
    Random aleatorio = new Random();
    int[] memoria = new int[a];
    for(int i = 0 ; i < a ; i++)
    {
      memoria[i] =  aleatorio.nextInt(2147483647);
    }
    return memoria;
  }
  public static int maxIn (int[] A)
  {
    int n = A[0];
    for (int  i = 1; i < A.length ; ++i )
      if (A[i]>n) n=A[i];
    return n;
  }
  static void cambia(int[] A, int i, int j)//cintercambia dos elementos dados sus indices
  {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
  public static int maxDigit(int x, int y)
  {
    if (x<1)
      return y;
    else
      return maxDigit(x/10,y+1);
  }
}
