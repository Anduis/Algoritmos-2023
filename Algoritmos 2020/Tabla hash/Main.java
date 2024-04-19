import java.util.Scaneer;
class Main
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    int entradas = scan.nextInt();

    Tabla T = new Tabla();

    while (entradas != 0)
    {
      T.agrega(scan.nextInt());
      entradas--;
    }
    T.imprime();
  }
{
class Tabla
  {
  Nodo[] T;
  int m;
  Tabla(int  x)
  {
    T = new Nodo [x];
    m = x;
  }
  void agrega(int x)
  {
    T[hash(x)].add(New Nodo(x));
  }
  int hash(int x)
  {
    return x%m;
  }
  void imprime()
  {
    for(int i = 0 ; i!=m ; i++)
    {
      T.[i].imprime();
    }
  }
}
class Nodo//para cada casilla
{
  int elemento;
  Nodo siguiente;
  Nodo(int x)
  {
    elemento=x;
  }
}
class ListaD
{
  Nodo top;
  void add(Nodo x)
  {
    x.siguiente(top);
    top = x;
  }
  void imprime()
  {
    Nodo actual= top;
    while (actual!=null)
    {
      System.out.println(actual.elemento);
      actual = actual.siguiente;
    }
  }
}
