import java.util.Scanner;
class Main
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    Lista principal = new Lista();
    int entradas = scan.nextInt();
    while (entradas != 0)
    {
      principal.insert(new Nodo(scan.nextInt()));
      entradas--;
    }
    SkipList A = new SkipList(principal);
    A.imprime();
  }
}
class SkipList
{
  Lista ruta;//la lista del nivel mas alto
  Indice cabezas = new Indice();//guarda las listas en orde de nivel ascendente
  SkipList(Lista x)
  {
    cabezas.insert(x);
    rutas(x);
  }
  void rutas(Lista prin)
  {
    Lista temp = new Lista();
    int i = 1;
    Nodo actual = prin.head;
    while(actual != null)
    {
      if (i%2 == 0)
        temp.insert(new Nodo(actual.elemento, actual));
      actual = actual.siguiente;
      i++;
    }
    cabezas.insert(temp);
    if (temp.head.siguiente == null)
      ruta = temp;
    else
      rutas(temp);
  }
  void imprime()
  {
    NodoIndice actual = cabezas.primerNivel;
    int k = 0;
    while (actual != null)
    {
      System.out.print("L" + ++k +". ");
      actual.elemento.head.imprime();
      actual = actual.siguiente;
    }
  }
}
class Indice
{
  NodoIndice primerNivel;
  NodoIndice actual;//nivel maximo
  void insert(Lista e)//tienen que agregarse del menor nivel al maximo
  {
    NodoIndice x = new NodoIndice(e);
    if (primerNivel == null)
      primerNivel = x;
    else
      actual.siguiente = x;
    actual = x;
  }
}
class NodoIndice
{
  Lista elemento;
  NodoIndice siguiente;
  NodoIndice(Lista x){elemento = x;}
}
class Lista//de insercion ordenada
{
  Nodo head;
  void insert(Nodo x)
  {
    if (head == null)
      head = x;
    else
    {
      Nodo actual = head;
      while(actual != null)
      {
        if (x.elemento < actual.elemento)
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
  Nodo pre(Nodo x)
  {
    Nodo actual = head;
    while (actual.siguiente != x)
      actual = actual.siguiente;
    return actual;
  }
  void delete(Nodo x)
  {
    if (x == head)
      head = x.siguiente;
    else
      pre(x).siguiente = x.siguiente;
  }
}
class Nodo
{
  int elemento;
  Nodo siguiente;
  Nodo abajo;
  Nodo (int e)
  {
    elemento = e;
    abajo = null;
  }
  Nodo (int e, Nodo x)
  {
    elemento = e;
    abajo = x;
  }
  void imprime()
  {
    Nodo temp = this;
    while (temp != null)
    {
      System.out.print(temp.elemento);
      if (temp.siguiente != null)
        System.out.print(" ");
      else
        System.out.print("\n");
      temp = temp.siguiente;
    }
  }
}
