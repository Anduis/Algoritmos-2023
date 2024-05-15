/**
 * Una interfaz para un árbol binario donde cada nodo tiene
 * cero, uno o dos hijos.
 *
 */
public interface ArbolBinario<E> extends Tree<E> {
  /** Regresa el hijo izquierdo de un nodo. */
  public Posicion<E> left(Posicion<E> v)
    throws InvalidPositionException, BoundaryViolationException;
  /** Regresa el hijo derecho de un nodo. */
  public Posicion<E> right(Posicion<E> v)
    throws InvalidPositionException, BoundaryViolationException;
  /** Indica si un un nodo tiene hijo izquierdo. */
  public boolean hasLeft(Posicion<E> v) throws InvalidPositionException;
  /** Indica si un un nodo tiene hijo derecho. */
  public boolean hasRight(Posicion<E> v) throws InvalidPositionException;
}	
