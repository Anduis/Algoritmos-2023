/**
 * Una clase nodo simple para una lista doblemente enlazada. Cada NodoD
 * tiene una referencia a un elemento guardado, un nodo previo y un nodo
 * siguiente.
 * 
 * @author 
 */
public class NodoD<E> implements Posicion<E> {
  private NodoD<E> prev, next;	// Referencia a los nodos anterior y posterior
  private E elemento;	// Elemento guardado en esta posición
  /** Constructor */
  public NodoD(NodoD<E> nuevoPrev, NodoD<E> nuevoNext, E elem) {
    prev = nuevoPrev;
    next = nuevoNext;
    elemento = elem;
  }
  // Método de la interfaz Posicion
  public E elemento() throws InvalidPositionException {
    if ((prev == null) && (next == null))
      throw new InvalidPositionException("¡La posición no está en una lista!");
    return elemento;
  }
  // Métodos accesores
  public NodoD<E> getNext() { return next; }
  public NodoD<E> getPrev() { return prev; }
  // Métodos actualizadores
  public void setNext(NodoD<E> nuevoNext) { next = nuevoNext; }
  public void setPrev(NodoD<E> nuevoPrev) { prev = nuevoPrev; }
  public void setElemento(E nuevoElemento) { elemento = nuevoElemento; }
}
