/* Lista enlazada simple */
import java.util.Random;
class Main
{
  public static void main(String[] args)
  {
    int[] numeroSet = new int[50];
    long[] tiemposLista = new long[50];
    long[] tiemposArreglo = new long[50];
    for (int i = 0 ; i != 20000 ;){
      i= i+400;
      numeroSet[(i/400)-1]=i;
    }

    for (int i = 0 ; i < numeroSet.length ; i++)
    {
      Arreglo A = new Arreglo();
      A.array = A.llenaAleatorioArreglo(numeroSet[i]);
      long aa = System.nanoTime();
      A.mergeSort(A.array,0,A.array.length-1);
      long ab = System.nanoTime();
      long at = ab-aa;
      tiemposArreglo[i] = at;

      Lista L = new Lista();
      L = L.llenaAleatorioLista(numeroSet[i]);
      Nodo top = L.getTop();
      int tam = L.getTam();
      long la = System.nanoTime();
      L.mergeSort(top, tam);
      long lb = System.nanoTime();
      long lt = lb-la;
      tiemposLista[i] = lt;
//2147483647
    }
    System.out.println("MergeSort Arreglo");
    imprimels(tiemposArreglo);
    System.out.println("MergeSort Lista");
    imprimels(tiemposLista);

  }
  static void imprimels(long[] x){
    for (int i = 0; i < x.length ; i++ ){
      System.out.println( x[i]);
    }
  }
}

class Arreglo
{
  int[] array;
  Arreglo()
  {

  }
  public static int[] llenaAleatorioArreglo(int a)
  {
    Random aleatorio = new Random();
    int[] memoria = new int[a];
    for(int i = 0 ; i < a ; i++)
    {
      memoria[i] =  aleatorio.nextInt(a);
    }
    return memoria;
  }

  //---------------------------------------- MERGESORT Arreglo
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
    while (i < n1 && j < n2){
      if (L[i] <= R[j]){
        A[k] = L[i];
        i++;
      }
      else{
        A[k] = R[j];
        j++;
      }
      k++;
    }
    while (i < n1){
      A[k] = L[i];
      i++;
      k++;
    }
    while (j < n2){
      A[k] = R[j];
      j++;
      k++;
    }
  }
  public static void mergeSort(int[] A, int p, int r){
    if (r > p){
      int m = (r+p)/2;
      mergeSort(A,p,m);
      mergeSort(A,m+1,r);
      merge(A,p,m,r);
    }
  }
}
class Lista
{
  private Nodo top;
  private int tam;
  Nodo getTop () { return top; }
  int getTam () { return tam; }
  void setTop (Nodo x){ top = x; }

  Lista()
  {
    top = null ;
  }

  Nodo search(int k)//devuelve Nodo de elemento k
  {
    Nodo x = this.top;
    while(x != null && x.getElemento() != k)
    {
      x = x.getSig();
    }
    return x;
  }

  void insert (Nodo x)//agrega al inicio
  {
    x.setSig(top);
    this.setTop(x);
    tam++;
  }

  void delete (Nodo x)
  {
    if (x == top)
      this.setTop(x.getSig());
    else
      this.predecessor(x).setSig(x.getSig());
    tam--;
  }

  Nodo successor(Nodo x){ return x.getSig(); }

  Nodo minimum(Nodo top)
  {
    Nodo x = this.getTop();
    while(top.getSig() != null)
    {
      if (top.getSig().getElemento() < x.getElemento())
        x = top.getSig();
      top = top.getSig();
    }
    return x;
  }

  Nodo maximum(Nodo top)
  {
    Nodo x = this.getTop();
    while(top.getSig() != null)
    {
      if (top.getSig().getElemento() > x.getElemento())
        x = top.getSig();
      top = top.getSig();
    }
    return x;
  }

  Nodo predecessor(Nodo x)
  {
    Nodo a = this.top;
    while( a != null && a.getSig() != x )
    {
      a = a.getSig();
    }
    return a;
  }

  int size(Nodo head)// dado un nodo devuelve la cantidad de nodos que le siguen
  {
    int i = 0;
    Nodo temp = head;
    while(temp != null)
    {
      ++i;
      temp = temp.getSig();
    }
    return i;
  }
/*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
/*
  Nodo[] divide(Nodo x)
	{
		Nodo uno, dos;
		int len = size(x);
		if (len < 2)
		{
			uno = x;
			dos = null;
			return new Nodo[] { uno, dos };
		}
		Nodo temp = x;
		int i = (len - 1) / 2;
		for (int j = 0; j < i; j++)
    {
			temp = temp.sig;
		}
		uno = x;
		dos = temp.sig;
		temp.sig= null;

		return new Nodo[] { uno, dos };
	}
  */
  Nodo[] divide(Nodo x,int p)
	{
		Nodo uno, dos;
		int len = p;
		if (len < 2)
		{
			uno = x;
			dos = null;
			return new Nodo[] { uno, dos };
		}
		Nodo temp = x;
		int i = (len - 1) / 2;
		for (int j = 0; j < i; j++)
    {
			temp = temp.sig;
		}
		uno = x;
		dos = temp.sig;
		temp.sig= null;

		return new Nodo[] { uno, dos };
	}
  Nodo merge(Nodo a, Nodo b)
  {
    if (a == null)
      return b;
    if (b == null)
      return a;
    Nodo temp;
    if (a.elemento <= b.elemento)
    {
      temp = a;
      temp.sig = merge(a.sig, b);
    }
    else
    {
      temp = b;
      temp.sig = merge(a, b.sig);
    }

    return temp;
  }
	Nodo mergeSort(Nodo top, int p)
	{
		if (top == null || top.sig == null)
			return top;

		Nodo[] A = divide(top, p);
		Nodo uno = A[0];
		Nodo dos = A[1];
    if (p%2 != 0)
    {
      uno = mergeSort(uno, (p/2)+1);
      dos = mergeSort(dos, p/2);
    }
    else
    {
      p = p/2;
      uno = mergeSort(uno, p);
      dos = mergeSort(dos, p);
    }

		return merge(uno, dos);
	}

/*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
  Lista llenaAleatorioLista(int a)
  {
    Lista L = new Lista();
    Random aleatorio = new Random();
    for(int i = 0 ; i < a ; i++)
    {
      L.insert(new Nodo(aleatorio.nextInt(a)));
    }
    return L;
  }

  void imprime ()
  {
    Nodo x = this.getTop();
    while (x != null)
    {
      System.out.println(x.getElemento());
      x = x.getSig();
    }
  }

}
class Nodo
{
  int elemento ;
  Nodo sig ;
  Nodo (int e)
  {
    elemento = e;
    sig = null;
  }
  Nodo (int e, Nodo x)
  {
    elemento = e;
    sig = x;
  }
  int getElemento () { return elemento; }
  Nodo getSig () { return sig; }
  void setElemento ( int x ) { elemento = x; }
  void setSig ( Nodo x ) { sig = x; }
}
