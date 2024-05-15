/*
Autor:Andres Anguiano 1638975x
Dar un algoritmo tiempo O(n) para calcular la profundidad de todos los nodos de un árbol T,
donde n es la cantidad de nodos de T. Escribir su método Java correspondiente en la clase UtileriasArbol.
*/
public class utileriasarbol{
  protected static class DepthNode<E>{
    protected Posicion<E> node;
    protected int depth;
    DepthNode (Posicion<E> e, int i){
      node = e;
      depth = i;
    }
    public Posicion<E> getNode(){return node;}
    public int getDepth(){return depth;}
    public E getElement(){return node.elemento();}
    public String toString() { return "["+node.elemento()+", "+depth+"]"; }
  }
  public static <E> void filldepthlist(Tree<E> T, Posicion<E> v, int i, ListaNodoPosicion<DepthNode<E>> L){
    L.addLast(new DepthNode(v,i));
    i++;
    for (Posicion<E> w : T.children(v))
      filldepthlist(T,w,i,L);
  }
  public static <E> ListaNodoPosicion<DepthNode<E>> depthlist(Tree<E> T){
    ListaNodoPosicion<DepthNode<E>> L = new ListaNodoPosicion<>();
    filldepthlist(T,T.root(),0,L);
    return L;
  }

}
