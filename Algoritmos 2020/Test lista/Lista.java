/* Lista enlazada simple */
class Lista
{
  private Nodo top;
  private int tam;
  Nodo getTop () { return top; }
  int getTam () { return tam; }
  void setTop (Nodo x){ top = x; }

  Lista()
  {
    top = null ;
  }

  Nodo search(int k)//devuelve Nodo de elemento k
  {
    Nodo x = this.top;
    while(x != null && x.getElemento() != k)
    {
      x = x.getSig();
    }
    return x;
  }

  void insert (Nodo x)//agrega al inicio
  {
    x.setSig(top);
    this.setTop(x);
    tam++;
  }

  void delete (Nodo x)
  {
    if (x == top)
    {
      this.setTop(x.getSig());
    }
    else
    {
      this.predecessor(x).setSig(x.getSig());
    }
    tam--;
  }


  Nodo minimum(Nodo top)
  {
    Nodo x = this.getTop();
    while(top.getSig() != null)
    {
      if (top.getSig().getElemento() < x.getElemento())
      {
        x = top.getSig();
      }
      top = top.getSig();
    }
    return x;
  }

  Nodo maximum(Nodo top)
  {
    Nodo x = this.getTop();
    while(top.getSig() != null)
    {
      if (top.getSig().getElemento() > x.getElemento())
      {
        x = top.getSig();
      }
      top = top.getSig();
    }
    return x;
  }

  Nodo successor(Nodo x)
  {
    return x.getSig();
  }

  Nodo predecessor(Nodo x)
  {
    Nodo a = this.top;
    while( a != null && a.getSig() != x )
    {
      a = a.getSig();
    }
    return a;
  }

  int size(Nodo head)// dado un nodo devuelve la cantidad de nodos que le siguen
  {
    int i = 0;
    Nodo temp = head;
    while(temp != null)
    {
      ++i;
      temp = temp.getSig();
    }
    return i;
  }
  /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-MERGESORT-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
  Nodo[] divide(Nodo x,int p)
	{
		Nodo uno, dos;
		int t = p;
		if (t < 2)
		{
			uno = x;
			dos = null;
			return new Nodo[] {uno, dos};
		}
		Nodo temp = x;
		int i = (t-1)/2;
		for (int j = 0; j < i; j++)
    {
			temp = temp.getSig();
		}
		uno = x;
		dos = temp.getSig();
		temp.setSig(null);

		return new Nodo[] {uno, dos};
	}

  Nodo merge(Nodo a, Nodo b)
  {
    if (a == null)
      return b;
    if (b == null)
      return a;
    Nodo temp;
    if (a.getElemento() <= b.getElemento())
    {
      temp = a;
      temp.setSig(merge(a.getSig(), b));
    }
    else
    {
      temp = b;
      temp.setSig(merge(a, b.getSig()));
    }

    return temp;
  }

	Nodo mergeSort(Nodo top, int p)
	{
		if (top == null || top.getSig() == null)
			return top;

		Nodo[] A = divide(top, p);
		Nodo uno = A[0];
		Nodo dos = A[1];
    if (p%2 != 0)
    {
      uno = mergeSort(uno, (p/2)+1);
      dos = mergeSort(dos, p/2);
    }
    else
    {
      p = p/2;
      uno = mergeSort(uno, p);
      dos = mergeSort(dos, p);
    }

		return merge(uno, dos);
	}

  void imprime ()
  {
    Nodo x = this.getTop();
    while (x != null)
    {
      System.out.println(x.getElemento());
      x = x.getSig();
    }
  }

}
class Nodo
{
  private int elemento ;
  private Nodo sig ;
  Nodo (int e)
  {
    elemento = e;
    sig = null;
  }
  Nodo (int e, Nodo x)
  {
    elemento = e;
    sig = x;
  }
  int getElemento () { return elemento; }
  Nodo getSig () { return sig; }
  void setElemento ( int x ) { elemento = x; }
  void setSig ( Nodo x ) { sig = x; }
}
