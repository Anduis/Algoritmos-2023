import java.util.Random;
//Comparativa de tiempos algoritmos nlogn QUICK MERGE HEAP
public class Main
{
  public static void main(String[] args)
  {
    int[] numeroSet = new int[50];
    long[] tiemposQuick = new long[50];
    long[] tiemposMerge = new long[50];
    /*
    long[] tiemposHeap = new long[50];
    */

    for (int i = 0 ; i != 10000000 ;)//llena numeroSet
    {
      i= i+200000;
      numeroSet[(i/200000)-1]=i;
    }

    for (int i = 0 ; i < numeroSet.length ; i++)
    {
      int[] temp = llenaAleatorio(numeroSet[i]);
      int[] extr = new int[temp.length];
      int[] extra = new int[temp.length];
      for (int o = 0 ; o<temp.length ; o++ ) {
        extr[o]=temp[o];
        extra[o]=temp[o];
      }
      long aQ = System.currentTimeMillis();
      quickSort(extra,0,extra.length-1);
      long bQ = System.currentTimeMillis();
      long tQ = bQ-aQ;
      tiemposQuick[i] = tQ;

      long aM = System.currentTimeMillis();
      mergeSort(temp,0,temp.length-1);
      long bM = System.currentTimeMillis();
      long tM = bM-aM;
      tiemposMerge[i] = tM;
      //tiemposHeap[i] = selectionSort(extr);

    }

    System.out.println("QuickSort");
    imprime(tiemposQuick);
    System.out.println("MergeSort");
    imprime(tiemposMerge);
    /*
    System.out.println("HeapSort");
    imprime(tiemposHeap);
    */
  }

  static void imprime(long[] x){ //cada dato una linea
    for (int i = 0; i < x.length ; i++ ) {
      System.out.println( x[i]);
    }
  }
  //------------------------------------------------------------------------------------------- QUICKSORT
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
  //------------------------------------------------------------------------------------------- MERGESORT
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
    if (r > p)
    {
      int m = (r+p)/2;
      mergeSort(A,p,m);
      mergeSort(A,m+1,r);
      merge(A,p,m,r);
    }
  }
  //------------------------------------------------------------------------------------------- HEAPSORT
  public void heapSort(int A[])
  {
    int n = A.length;
    // Build heap (rearrange array)
    for (int i = n / 2 - 1; i >= 0; i--)
      heapify(A, n, i);
    // One by one extract an element from heap
    for (int i=n-1; i>0; i--)
    {
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
  void heapify(int A[], int n, int i)
  {
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
    if (largest != i)
    {
      int swap = A[i];
      A[i] = A[largest];
      A[largest] = swap;

      // Recursively heapify the affected sub-tree
      heapify(A, n, largest);
    }
  }
  //-------------------------------------------------------------------------------------------
  public static int[] llenaAleatorio(int a)// llena un int[] de tamaño a con valores aleatorios b
  {
    Random aleatorio = new Random();
    int[] memoria = new int[a];
    for(int i = 0 ; i < a ; i++)
    {
      memoria[i] =  aleatorio.nextInt(2147483647);
    }
    return memoria;
  }
}
