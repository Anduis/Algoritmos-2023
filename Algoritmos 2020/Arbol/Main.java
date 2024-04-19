import java.util.Scanner;
class Main
{
  public static void main(String[] args)
  {
    ArbolRN A = new ArbolRN();

    Scanner scan = new Scanner(System.in);
    int entradas = scan.nextInt();
    while (entradas != 0)
    {
      A.insertRN(scan.nextInt());
      entradas--;
    }
    A.imprimeEnOrden(A.raiz);
    System.out.print("\n");
  }
}
class ArbolRN
{
  int tamImpresion=0;//variable para no imprimir un espacio al final
  Nodo raiz;
  Nodo nil;
  ArbolRN()
  {
		nil = new Nodo();
		nil.color = true;
		nil.l = nil;
		nil.r = nil;
		raiz = nil;
	}
  void insertRN(int e)
  {
    tamImpresion++;
    Nodo z = new Nodo();
    z.e = e;
    z.l = nil;
    z.r = nil;
    z.color = false;

    Nodo y = nil;
    Nodo x = raiz;
    while(x != nil)
    {
      y = x;
      if (e < x.e)
        x = x.l;
      else
        x = x.r;
    }
    z.p = y;
    if (y == nil)
    {
      z.color = true;
      raiz = z;
    }
    else if(e < y.e)
      y.l = z;
    else
      y.r = z;
    fixinRN(z);
  }

  void fixinRN(Nodo z)
  {
    Nodo y;
    while (z.p.color == false)
    {
      if (z.p == z.p.p.l)
      {
        y = z.p.p.r;
        if (y.color == false)
        {
          z.p.color = true;
          y.color = true;
          z.p.p.color = false;
          z = z.p.p;
        }
        else
        {
          if (z == z.p.r)
          {
            z = z.p;
            giraIzq(z);
          }
          z.p.color = true;
          z.p.p.color = false;
          giraDer(z.p.p);
        }
      }
      else
      {
        y = z.p.p.l;
        if (y.color == false)
        {
          z.p.color = true;
          y.color = true;
          z.p.p.color = false;
          z = z.p.p;
        }
        else
        {
          if (z == z.p.l)
          {
            z = z.p;
            giraDer(z);
          }
          z.p.color = true;
          z.p.p.color = false;
          giraIzq(z.p.p);
        }
      }
    }
    raiz.color = true;
  }

  void giraIzq(Nodo x)
  {
    Nodo y = x.r;
    x.r = y.l;
    if (y.l != nil)
      y.l.p = x;
    y.p = x.p;
    if (x.p == nil)
      raiz = y;
    else if (x == x.p.l)
      x.p.l = y;
    else
      x.p.r = y;
    y.l = x;
    x.p = y;
  }

  void giraDer(Nodo y)
  {
    Nodo x = y.l;
    y.l = x.r;
    if (x.r != nil)
      x.r.p = y;
    x.p = y.p;
    if(y.p == nil)
      raiz = x;
    else if (y.p.l == y)
      y.p.l = x;
    else
      y.p.r = x;
    x.r = y;
    y.p = x;
  }
  void imprimeEnOrden(Nodo x)
  {
    if (x != nil)
    {
      imprimeEnOrden(x.l);
      System.out.print(x.e);
      if (x.color == true)
        System.out.print("N");
      else
        System.out.print("R");
      if(tamImpresion != 1)
      {
        System.out.print(" ");
        tamImpresion--;
      }
      imprimeEnOrden(x.r);
    }
  }
}

class Nodo
{
  boolean color; //true -> Negro ; false -> Rojo
  int e;// elemento
  Nodo l, r, p; //hijo izquierdo; hijo derecho; padre
}
