import java.util.LinkedList;
public class Fail
{
  /*
  ->Leer maximo y minimo del conjunto
  ->Determinar cantidad de elementos y de buckets
  ->distribuir los elementos en sus buckets correspondientes
  ->Sort each bucket
  ->Merge buckets
  public static int[] bucketSort(int[] A){

  }
  */
  public static void main(String[] args)
  {
    int[] A = {14,11,6,3,15,2,8,17,8,2,0,16,12,16,2,4,3,8};
    int k = maxIn(A);
    System.out.println("max: "+ maxIn(A));
    System.out.println("min: "+ minIn(A));
    System.out.println("sizeA: "+ A.length);
    System.out.println("bNumber: "+bNumber(A));
    System.out.println("rango: " + range(A));

  }
  public static int bNumber (int[] A)//cantidad de buckets
  {
    return (int)Math.sqrt(A.length);
  }

  //?????
  /*
  public static ArrayList<Integer> separa (int[] A)
  {
    for (int i; i<bNumber(A) ; ++i ) {
      if (A(i) < (i*range(A)))
      {

      }
    }
  }
  */
  public static int range (int[] A)
  {
    int a = maxIn(A);
    int b = minIn(A);
    return (a+b)/bNumber(A);
  }
  public static int maxIn (int[] A)
  {
    int n = A[0];
    for (int  i = 1; i < A.length ; ++i )
      if (A[i]>n) n=A[i];
    return n;
  }
  public static int minIn (int[] A)
  {
    int n = A[0];
    for (int  i = 1; i < A.length ; ++i )
      if (A[i]<n) n=A[i];
    return n;
  }
}
