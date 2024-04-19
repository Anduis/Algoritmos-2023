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
      A.conecta(scan.nextInt()-1,scan.nextInt()-1);
      m--;
    }
    A.DFS(v-1);
    System.out.println();
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
  void DFS(int v) //Deep First Search
  {
    System.out.print(v+1 +" ");
    visitados[v]=1;
    for (int i = 0 ; i < matriz.length ; i++)
      if(matriz[v][i] != 0 && visitados[i] != 1)
        DFS(i);
  }
}
