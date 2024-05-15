/**
 * Interfaz para un nodo de un árbol binario. Esta mantiene un elemento,
 * un nodo padre, un nodo izquierdo, y nodo derecho.
 *
 */
public interface PosicionAB<E> extends Posicion<E> { 	// hereda elemento()
  public void setElemento(E o);
  public PosicionAB<E> getIzq(); 
  public void setIzq(PosicionAB<E> v); 
  public PosicionAB<E> getDer(); 
  public void setDer(PosicionAB<E> v); 
  public PosicionAB<E> getPadre(); 
  public void setPadre(PosicionAB<E> v);
}
