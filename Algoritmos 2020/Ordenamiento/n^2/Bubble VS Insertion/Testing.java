import java.util.Random;
// ordenamiento tiempo cuadratico
public class Testing
{
  public static void main(String[] args)
  {
    int[] numeroSet = new int[60];
    long[] tiemposBubble = new long[60];
    long[] tiemposInsertion = new long[60];
    long[] tiemposSelection = new long[60];

    for (int i = 0 ; i != 30000 ;)//llena numeroSet de 500 en 500 hasta 1,000
    {
      i= i+500;
      numeroSet[(i/500)-1]=i;
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
      tiemposBubble[i] = bubbleSort(extra);
      tiemposInsertion[i] = insertionSort(extr);
      tiemposSelection[i] = selectionSort(temp);
    }

    System.out.println("bubbleSort");
    imprime(tiemposBubble);
    System.out.println("insertionSort");
    imprime(tiemposInsertion);
    System.out.println("selectionSort");
    imprime(tiemposSelection);
  }

  static void imprime(long[] x){
    for (int i = 0; i < x.length ; i++ ) {
      System.out.println( x[i]);
    }
  }

  static long bubbleSort(int[] arr)//devuelve un long con el tiempo que tardó en acomodar
  {
    long a = System.currentTimeMillis();
    int n = arr.length;
    int temp = 0;
    for(int i=0; i < n; i++)
    {
      for(int j=1; j < (n-i); j++)
      {
        if(arr[j-1] > arr[j])
        {
          temp = arr[j-1];
          arr[j-1] = arr[j];
          arr[j] = temp;
        }

      }
    }
    long b = System.currentTimeMillis();
    long t = b-a;
    return t;
  }

  static long insertionSort(int arr[])//devuelve un long con el tiempo que tardó en acomodar
  {
    long a = System.currentTimeMillis();
    int n = arr.length;
    for (int i = 1; i < n; ++i)
    {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key)
      {
        arr[j + 1] = arr[j];//para recorrer los mas grandes a la derecha
        j = j - 1;
      }
      arr[j + 1] = key;
    }
    long b = System.currentTimeMillis();
    long t = b-a;
    return t;
  }
  static long selectionSort(int[] A)//devuelve un long con el tiempo que tardó en acomodar
  {
    long a = System.currentTimeMillis();
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
    long b = System.currentTimeMillis();
    long t = b-a;
    return t;
  }

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
