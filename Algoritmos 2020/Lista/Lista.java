/* Lista enlazada simple insercion ordenada */
class Lista
{
  NodoL top;
    void insert(NodoL x)
    {
      if (top == null)
        top = x;
      else
      {
        NodoL actual = top;
        while(actual != null)
        {
          if (x.elemento < actual.elemento)
          {
            System.out.println("esto");
            x.siguiente = actual;
            if (actual == top)
              top = x;
            else
              predecessor(actual).siguiente = x;
            return;
          }
          actual = actual.siguiente;
        }
        predecessor(actual).siguiente= x;
      }
  }
  NodoL predecessor(NodoL x)
  {
    NodoL actual = top;
    while (actual.siguiente != x)
      actual = actual.siguiente;
    return actual;
  }

  void imprime ()
  {
    NodoL x = top;
    while (x != null)
    {
      System.out.println(x.elemento);
      x = x.siguiente;
    }
  }
  public static void main(String[] args)
  {
    Lista mia = new Lista();
    mia.insert(new NodoL(1));
    mia.insert(new NodoL(0));
    mia.insert(new NodoL(2));
    mia.insert(new NodoL(1));
    mia.insert(new NodoL(25));
    mia.insert(new NodoL(-87));
    mia.insert(new NodoL(15));
    mia.insert(new NodoL(0));
    mia.insert(new NodoL(8));
    mia.insert(new NodoL(16));
    mia.imprime();
  }
}
class NodoL
{
  int elemento;
  NodoL siguiente;
  NodoL (int e)
  {
    elemento = e;
  }
}
