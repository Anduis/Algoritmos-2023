import java.util.Scanner;
class Main
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    Dijkstra k= new Dijkstra(sc);
  }
}
class Dijkstra
{
  int n, m, s, t;
  ListaAristas Aristas;
  Prioridad Cola;
  Nod[] Pro;
  Dijkstra(Scanner scan)
  {
    n = scan.nextInt();//num de vertices
    m = scan.nextInt();//num de aristas
    s = scan.nextInt();//inicio
    t = scan.nextInt();//final
    llenaAristas(scan);// la entrada guardada como lista de adyacencia
    Cola = new Prioridad(); //guarda solamente el elemento y su costo
    Pro = new Nod[n]; //elemento(indice+1), costo, predecesor, guarda las rutas minimas
    inicia();
    //imprimeNodos();
    System.out.println(Pro[t-1].costo);
  }
  void inicia()
  {
    for (int i = 0; i<n ; ++i)
      Pro[i] = new Nod();
    Pro[s-1].costo=0;
    Cola.enqueue(s,0);
    vaciaCostos();
  }
  void llenaAristas(Scanner scan)
  {
    Aristas = new ListaAristas();
    for (int i = m ; i>0; i--)
      Aristas.insert(new NodA(new Arista(scan.nextInt(),scan.nextInt(),scan.nextInt())));
  }
  void vaciaCostos()
  {
    while(!Cola.isEmpty())
    {
    int x = Cola.dequeue();
      NodA temp = Aristas.head;
      while (temp.elemento != null)
      {
        while (temp.elemento.U < x)
          temp = temp.siguiente;
        try
        {
          while (temp.elemento.U == x && temp.elemento.U != t)
          {
            add(x, temp.elemento.V, temp.elemento.W);
            temp = temp.siguiente;
          }
        }
        catch (NullPointerException e)
        {
          break;
        }
        break;
      }
    }
  }
  void add(int u, int v, int w)
  {
    Nod temp = Pro[v-1];
    int sum = w;
    if (Pro[u-1].costo != 99999)
      sum = Pro[u-1].costo + w;
    if (temp.costo > sum)
    {
      temp.costo = sum;
      temp.predecesor = u;
      if (v==t)
        return;
      Cola.enqueue(v,sum);
    }
  }
  void imprimeNodos()
  {
    for (int i = 0 ; i < n ; i++ )
      System.out.println(" elemento "+ (i+1) + " costo "+ Pro[i].costo+ " predecesor "+ Pro[i].predecesor);
  }
}
class ListaAristas
{
  NodA head;
  void insert(NodA x)
  {
    if (head == null)
      head = x;
    else
    {
      NodA actual = head;
      while(actual != null)
      {//ordenadas por el primer vertice
        if (x.elemento.U < actual.elemento.U)
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
  NodA pre(NodA x)
  {
    NodA actual = head;
    while (actual.siguiente != x)
      actual = actual.siguiente;
    return actual;
  }
}
class NodA
{
  Arista elemento;
  NodA siguiente;
  NodA (Arista e){ elemento = e;}
}
class Arista
{
  int U;
  int V;
  int W;
  Arista(int x, int y, int z)
  {
    U = x;
    V = y;
    W = z;
  }
}
class Prioridad
{
  Nod head;
  Nod busca(int x)
  {
    Nod temp = head;
      while (temp != null)
      {
        if (temp.elemento == x)
          return temp;
        temp = temp.siguiente;
      }
      return null;
  }
  void enqueue(int q, int w)
  {
    if (busca(q)!= null)
    {
      if (busca(q).costo > w)
        delete(busca(q));
      else
        return;
    }
    Nod x = new Nod(q, w);
    if (head == null)
      head = x;
    else
    {
      Nod actual = head;
      while(actual != null)
      {
        if (x.costo < actual.costo)
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
  Nod pre(Nod x)
  {
    Nod actual = head;
    while (actual.siguiente != x)
      actual = actual.siguiente;
    return actual;
  }
  int dequeue()
  {
    int x = head.elemento;
    head = head.siguiente;
    return x;
  }
  boolean isEmpty(){return head==null;}
  void delete(Nod x)
  {
    if (x == head)
      head = x.siguiente;
    else
      pre(x).siguiente = x.siguiente;
  }
  void imprime()
  {
    System.out.println("ESTA VACIO " + isEmpty());
    Nod temp = head;
    while (temp != null)
    {
      System.out.println("Elemento: "+temp.elemento +" Cuesta: "+ temp.costo);
      temp = temp.siguiente;
    }
  }
}
class Nod
{
  int elemento;
  int costo;
  Nod siguiente;
  int predecesor;
  Nod (int e, int f)
  {
    elemento = e;
    costo = f;
  }
  Nod()
  {
    costo = 99999;
    predecesor = 0;
  }
}
