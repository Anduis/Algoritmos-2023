import java.util.Scanner;
class Main
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    Kruskal k= new Kruskal(sc);
  }
}
class Kruskal
{
  int n, m, s, t;
  ListaAristas Aristas;
  Prioridad Cola;
  Nodo[] Pro;
  Kruskal(Scanner scan)
  {
    n = scan.nextInt();//num de vertices
    m = scan.nextInt();//num de aristas
    s = scan.nextInt();//inicio
    t = scan.nextInt();//final
    llenaAristas(scan);
    Cola = new Prioridad();
    Pro = new Nodo[n];
    for (int i = 0; i<n ; ++i)
      Pro[i] = new Nodo();
    inicia();
    //imprimeNodos();
  }
  void inicia()
  {
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
    Nodo temp = Pro[v-1];
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
  /*
  void imprimeNodo(int i)
  {
    System.out.println(" elemento "+ i+ " costo "+ Pro[i-1].costo+ " predecesor "+ Pro[i-1].predecesor);
  }
  void imprimeNodos()
  {
    for (int i = 0 ; i < n ; i++ )
      imprimeNodo(i+1);
  }
  void imprimeAristas()
  {
    NodA temp = Aristas.head;
    while (temp != null)
    {
      imprimeArista(temp);
      temp= temp.siguiente;
    }
  }
  void imprimeArista(NodA x)
  {
    System.out.println("U. "+x.elemento.U+"  V. "+x.elemento.V+"  W. "+x.elemento.W);
  }
  */
}
class Nodo
{
  int costo;
  int predecesor;
  Nodo()
  {
    costo = 99999;
    predecesor = 0;
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
      {
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
  NodP head;
  NodP busca(int x)
  {
    NodP temp = head;
      while (temp != null)
      {
        if (temp.elemento.elemento == x)
          return temp;
        temp = temp.siguiente;
      }
      return null;
  }
  void enqueue(int q, int w)
  {
    if (busca(q)!= null)
    {
      if (busca(q).elemento.costo > w)
        delete(busca(q));
      else
        return;
    }
    NodP x = new NodP(new Nod(q, w));
    if (head == null)
      head = x;
    else
    {
      NodP actual = head;
      while(actual != null)
      {
        if (x.elemento.costo < actual.elemento.costo)
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
  NodP pre(NodP x)
  {
    NodP actual = head;
    while (actual.siguiente != x)
      actual = actual.siguiente;
    return actual;
  }
  int dequeue()
  {
    int x = head.elemento.elemento;
    head = head.siguiente;
    return x;
  }
  boolean isEmpty(){return head==null;}
  void delete(NodP x)
  {
    if (x == head)
      head = x.siguiente;
    else
      pre(x).siguiente = x.siguiente;
  }
  void imprime()
  {
    System.out.println("ESTA VACIO " + isEmpty());
    NodP temp = head;
    while (temp != null)
    {
      System.out.println("Elemento: "+temp.elemento.elemento +" Cuesta: "+ temp.elemento.costo);
      temp = temp.siguiente;
    }
  }
}
class NodP
{
  Nod elemento;
  NodP siguiente;
  NodP (Nod e){ elemento = e;}
}
class Nod
{
  int elemento;
  int costo;
  Nod siguiente;
  Nod (int e, int f)
  {
    elemento = e;
    costo = f;
  }
}
