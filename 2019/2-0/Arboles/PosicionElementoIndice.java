/*Implementar el ADT árbol binario en la clase ArbolBinarioArreglo usando una lista arreglo.*/
public class PosicionElementoIndice<E> implements PosicionAB<E> {
  private E elemento;  // elemento guardado en este nodo
  private int indice;
  private PosicionElementoIndice<E> izq, der, padre,;
  /** Constructor por defecto */
  public PosicionElementoIndice() { }
  /** Constructor principal */
  public PosicionElementoIndice(E elemento, int i) {//los indices de los elementosindice son solo referencias a donde se ha de guardar los
    setElemento(elemento);
    setIndice(i);
    padre.setIndice(i/2);
    izq.setIndice(i*2)
    der.setIndice((i*2)+1)
  }
  public void setIndice(int i) { indice=i; }
  public void getIndice() { return i; }
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
