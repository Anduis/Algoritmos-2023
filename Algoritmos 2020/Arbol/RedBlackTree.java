public class RedBlackTree
{
	Nodo raiz;
	Nodo nil;
  public RedBlackTree()
  {
    nil = new Nodo();
    nil.color = true;
    nil.l = null;
    nil.r = null;
    raiz = nil;
  }
  public void insert(int e)
  {
		Nodo z = new Nodo();
		z.p = null;
		z.e = e;
		z.l = nil;
		z.r = nil;
		z.color = false;
		Nodo y = null;
		Nodo x = this.raiz;
		while (x != nil)
    {
			y = x;
			if (z.e < x.e)
				x = x.l;
		  else
				x = x.r;
		}
    z.p = y;
    if (y == null)
      raiz = z;
    else if (z.e < y.e)
      y.l = z;
    else
      y.r = z;
		if (z.p == null){
			z.color = true;
			return;
		}
		if (z.p.p == null)
			return;
		fixInsert(z);
	}

  void fixInsert(Nodo z)
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
      if (z == raiz)
        break;
    }
    raiz.color = true;
  }
	public void giraIzq(Nodo x)
  {
		Nodo y = x.r;
		x.r = y.l;
		if (y.l != nil)
			y.l.p = x;
		y.p = x.p;
		if (x.p == null)
			this.raiz = y;
		else if (x == x.p.l)
			x.p.l = y;
		else
			x.p.r = y;
		y.l = x;
		x.p = y;
	}

	public void giraDer(Nodo y)
  {
		Nodo x = y.l;
		y.l = x.r;
		if (x.r != nil)
			x.r.p = y;
		x.p = y.p;
		if (y.p == null)
			this.raiz = x;
		else if (y == y.p.r)
			y.p.r = x;
		else
			y.p.l = x;
		x.r = y;
		y.p = x;
	}
  void imprimeInOrder(Nodo x)
  {
    if (x!=nil)
    {
      imprimeInOrder(x.l);
      System.out.print(x.e);
      if (x.color == true)
        System.out.print("B");
      else
        System.out.print("R");
      System.out.print(" ");
      imprimeInOrder(x.r);
    }
  }
	public static void main(String [] args){
    	RedBlackTree A = new RedBlackTree();
        A.insert(8);
    	A.insert(18);
    	A.insert(5);
    	A.insert(15);
    	A.insert(17);
    	A.insert(25);
    	A.insert(40);
    	A.insert(80);
    	A.imprimeInOrder(A.raiz);
	}
}
class Nodo
{
	int e;
	Nodo p;
	Nodo l;
	Nodo r;
	boolean color;
}
