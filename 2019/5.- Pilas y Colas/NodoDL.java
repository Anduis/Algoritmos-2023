/** Nodo de una lista doblemente enlazada de una lista de cadenas */
public class NodoDL<E> {

  protected E elemento;	// elemento que será referido desde el nodo
  protected NodoDL<E> sig, prev;	// Apuntadores a los nodos siguiente y previo

  /** Constructor sin argumentos */
  public NodoDL() { ; }

  /** Constructor que crea un nodo con los campos dados */
  public NodoDL(E e, NodoDL<E> p, NodoDL<E> s) {
    elemento = e;
    prev = p;
    sig = s;
  }

  /** Regresa el elemento de este nodo */
  public E getElemento() { return elemento; }
  /** Regresa el nodo previo de este nodo */
  public NodoDL<E> getPrev() { return prev; }
  /** Regresa el nodo siguiente de este nodo */
  public NodoDL<E> getSig() { return sig; }
  /** Pone el elemento de este nodo */
  public void setElemento(E nvoElem) { elemento = nvoElem; }
  /** Pone el nodo previo de este nodo */
  public void setPrev(NodoDL<E> nvoPrev) { prev = nvoPrev; }
  /** Pone el nodo siguiente de este nodo */
  public void setSig(NodoDL<E> nvoSig) { sig = nvoSig; }
}
