import java.util.Scanner;
class Main
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();//tamano matriz= num de vertices
    int m = scan.nextInt();//num de aristas
    int v = scan.nextInt();// primero para dfs
    Grafo A = new Grafo(n);
    while (m!=0)
    {
      A.conecta(scan.nextInt()-1,scan.nextInt()-1,scan.nextInt());
      m--;
    }
    A.kruskal(v-1);
    System.out.println();
    //A.imprimeMatriz();
  }
}
class Grafo
{
  void conecta(int x, int y, int z)
  {
    Arista uno = new Arista(x);
    Arista dos = new Arista(y);
    Vertice unodos = new ver
  }
}
class Vertice
{
  int peso;
  Vertice uno;
  Vertice dos;
}
class Arista
{
  int elemento;
  Lista vertices;
  Arista (int elemento)
  {
    elemento = x;
  }
  void add()
  {
  }
}
class Lista//para que los arboles se inserten con grados en orden ascendente
{
  NodoL head;
  void insert(NodoL x)
  {
    if (head == null)
      head = x;
    else
    {
      NodoL actual = head;
      while(actual != null)
      {
        if (x.elemento.grado() < actual.elemento.grado())
        {
          x.siguiente = actual;
          if (actual == head)
            head = x;
          else
            pre(actual).siguiente = x;
          return;
        }
        actual = actual.siguiente;
      }
      pre(actual).siguiente= x;
    }
  }
  NodoL pre(NodoL x)
  {
    NodoL actual = head;
    while (actual.siguiente != x)
      actual = actual.siguiente;
    return actual;
  }
  void delete(NodoL x)
  {
    if (x == head)
      head = x.siguiente;
    else
      pre(x).siguiente = x.siguiente;
  }
  public static void main(String[] args) {
  int
  }
}
class NodoL
{
  Vertice elemento;
  NodoL siguiente;
  NodoL (Vertice e){ elemento = e;}
}
