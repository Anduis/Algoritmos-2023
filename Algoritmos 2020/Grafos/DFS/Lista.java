import java.util.Scanner;
class Lista
{
  public static void main(String[] args)
  {
    Lista L = new Lista();
    Scanner scan = new Scanner(System.in);
    while(scan.hasNextInt())
    {
      int x = scan.nextInt();
      if (x==1)
      {
        int y = scan.nextInt();
        L.push(y);
      }
      if (x==2)
        L.pop();
      L.imprime();
    }
  }
  Nodo primero;
  Nodo ultimo;
  void push(int x)
  {
    Nodo temp = new Nodo(x);
    if (primero==null)
      primero = temp;
    else
      ultimo.siguiente = temp;
    ultimo=temp;
  }
  void pop()
  {
    if (primero != null)
      if(primero==ultimo)
        primero = null;
      else
      {
        ultimo = pre(ultimo);
        ultimo.siguiente = null;
      }
  }
  Nodo pre(Nodo x)
  {
    Nodo actual = primero;
    while (actual.siguiente != x)
      actual = actual.siguiente;
    return actual;
  }
  void imprime()
  {
    Nodo temp = primero;
    while (temp != null)
    {
      System.out.print(temp.elelemento+" ");
      temp = temp.siguiente;
    }
    System.out.println();
  }
}
class Nodo
{
  int elelemento;
  Nodo siguiente;
  Nodo(int x){elelemento=x;}
}
