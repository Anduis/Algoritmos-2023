import java.util.Scanner;
class Queue
{
  public static void main(String[] args)
  {
    Queue Q = new Queue();
    Scanner scan = new Scanner(System.in);
    while(scan.hasNextInt())
    {
      int x = scan.nextInt();
      if (x==1)
      {
        int y = scan.nextInt();
        Q.enqueue(y);
      }
      if (x==2)
        Q.dequeue();
      Q.imprime();
    }
  }
  Nodo primero;
  Nodo ultimo;
  void enqueue(int x)
  {
    Nodo temp = new Nodo(x);
    if (primero==null)
      primero = temp;
    else
      ultimo.siguiente = temp;
    ultimo=temp;
  }
  void dequeue()
  {
    if (primero != null)
    {
    if(primero==ultimo)
      primero = null;
    else
      primero = primero.siguiente;
    }
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
