/**
 * La clase implementa un nodo de un árbol binario guardando las referencias
 * a un elemento, un nodo padre, un nodo izquierdo, y un nodo derecho.
 *
 */
public class NodoAB<E> implements PosicionAB<E> {
  private E elemento;  // elemento guardado en este nodo
  private PosicionAB<E> izq, der, padre;  // nodos adyacentes
  /** Constructor por defecto */
  public NodoAB() { }
  /** Constructor principal */
  public NodoAB(E elemento, PosicionAB<E> padre, 
		PosicionAB<E> izq, PosicionAB<E> der) { 
    setElemento(elemento);
    setPadre(padre);
    setIzq(izq);
    setDer(der);
  }
  /** Regresa el elemento guardado en esta posición */
  public E elemento() { return elemento; }
  /** Pone el elemento guardado en esta posición */
  public void setElemento(E o) { elemento=o; }
  /** Regresa el hijo izquierdo de esta posición */
  public PosicionAB<E> getIzq() { return izq; }
  /** Pone el hijo izquierdo de esta posición */
  public void setIzq(PosicionAB<E> v) { izq=v; }
  /** Regresa el hijo derecho de esta posición */
  public PosicionAB<E> getDer() { return der; }
  /** Pone el hijo derecho de esta posición */
  public void setDer(PosicionAB<E> v) { der=v; }
  /** Regresa el padre de esta posición */
  public PosicionAB<E> getPadre() { return padre; }
  /** Pone el padre de esta posición */
  public void setPadre(PosicionAB<E> v) { padre=v; }
}
