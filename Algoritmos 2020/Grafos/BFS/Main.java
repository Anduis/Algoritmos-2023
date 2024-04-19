import java.util.Scanner;
class Main
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();//tamano matriz= num de vertices
    int m = scan.nextInt();//num de aristas "nodos"
    int v = scan.nextInt();// primero para bfs
    Grafo A = new Grafo(n);
    while (m!=0)
    {
      A.conecta(scan.nextInt()-1,scan.nextInt()-1);
      m--;
    }
    A.BFS(v);
    //A.imprimeMatriz();
  }
}
class Grafo
{
  int[][] matriz;
  int visitados[];
  Grafo(int x)
  {
    matriz = new int[x][x];
    visitados = new int[x];
  }
  void conecta(int x, int y)
  {
    matriz[x][y] = 1;
    matriz[y][x] = 1;
  }
  void imprimeMatriz()
  {
    for (int i = 0; i < matriz.length ; ++i){
      for (int k = 0; k < matriz.length ; ++k)
        System.out.print(matriz[i][k]+" ");
      System.out.println();
    }
  }
  void BFS(int ini) //Breadth First Search
  {
    Queue Q = new Queue();
    Q.enqueue(ini-1);
    while(!Q.isEmpty())
    {
      int v = Q.dequeue();
      if(visitados[v]!=1)
        System.out.print(v+1 +" ");
      visitados[v]=1;
      for (int i = 0 ; i < matriz.length ; i++)
        if(matriz[v][i] != 0 && visitados[i] != 1)
          Q.enqueue(i);
    }
    System.out.println();
  }
}
class Queue
{
  Nodo primero;
  Nodo ultimo;
  boolean isEmpty(){ return primero == null;}
  void enqueue(int x)
  {
    Nodo temp = new Nodo(x);
    if (primero==null)
      primero = temp;
    else
      ultimo.siguiente = temp;
    ultimo=temp;
  }
  int dequeue()
  {
    int x = primero.elelemento;
    if (primero != null)
      if(primero==ultimo)
        primero = null;
      else
        primero = primero.siguiente;
    return x;
  }
}
class Nodo
{
  int elelemento;
  Nodo siguiente;
  Nodo(int x){elelemento=x;}
}
