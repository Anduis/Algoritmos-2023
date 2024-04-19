import java.util.Scanner;
class Test
{
  public static void main(String[] args)
  {
    Prioridad Q = new Prioridad();
    Scanner scan = new Scanner(System.in);
    while(scan.hasNext())
    {
      int x = scan.next().charAt(0);
      if (x=='a')
      {
        Q.enqueue(scan.nextInt(),scan.nextInt());
      }
      if (x=='b')
        Q.dequeue();
      if (x=='c')
        break;
      Q.imprime();
    }
  }
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
class Prioridad
{
  NodoL head;
  NodoL busca(int x)
  {
    NodoL temp = head;
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
      delete(busca(q));
    NodoL x = new NodoL(new Nod(q, w));
    if (head == null)
      head = x;
    else
    {
      NodoL actual = head;
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
  NodoL pre(NodoL x)
  {
    NodoL actual = head;
    while (actual.siguiente != x)
      actual = actual.siguiente;
    return actual;
  }
  void dequeue(){head = head.siguiente;}
  boolean isEmpty(){return head==null;}
  void delete(NodoL x)
  {
    if (x == head)
      head = x.siguiente;
    else
      pre(x).siguiente = x.siguiente;
  }
  void imprime()
  {
    System.out.println("ESTA VACIO " + isEmpty());
    NodoL temp = head;
    while (temp != null)
    {
      System.out.println("Elemento: "+temp.elemento.elemento +" Cuesta: "+ temp.elemento.costo);
      temp = temp.siguiente;
    }
  }
}
class NodoL
{
  Nod elemento;
  NodoL siguiente;
  NodoL (Nod e){ elemento = e;}
}
