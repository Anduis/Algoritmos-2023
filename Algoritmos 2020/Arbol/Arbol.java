class arbol
{
  Nodo raiz;
  void addRecurs(int k)
  {
    if(raiz==null)
      raiz=new Nodo(k);
    else
      raiz.add(k);
  }
  void insert(int k)
  {
    Nodo temp = new Nodo(k);
    Nodo actual = raiz;
    while(actual != null)
    {
      if (k <= actual.getIzq())
        actual = actual.getIzq();
      else if (k > actual.getDer())
        actual = actual.getDer();
    }
      actual = temp;
  }
  boolean search(int k)
  {

  }
  void postrden()
  {

  }
  void inOrden()
  {

  }
  void preOrden()
  {

  }
}
class Nodo
{
 private int elemento;
 int getElemento(){ return elemento;}
 setElemento(int x){elemento = x;}

 private Nodo izq;
 Nodo getIzq(){ return izq;}
 setIzq(Nodo x){izq = x;}

 private Nodo der;
 Nodo getDer(){ return der;}
 setDer(Nodo x){der = x;}

 void add(int k)
 {
  if(k >= this.getDer())
    if (this.getDer() == null)
      setDer(new Nodo(k));
    else
      this.getDer().add(k);
  else
    if (this.getIzq() == null)
      setDer(new Nodo(k));
    else
      this.getIzq().add(k);
 }
}
