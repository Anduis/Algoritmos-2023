import java.util.Iterator;
/**
 * Una interfaz para un árbol donde los nodos pueden tener
 * una cantidad arbitraria de hijos.
 */
public interface Tree<E> extends Iterable<E> {
  /** Regresa el número de nodos en el árbol. */
  public int size();
  /** Valida si el árbol está vacío. */
  public boolean isEmpty();
  /** Regresa un iterador de los elementos guardados en el árbol. */
  public Iterator<E> iterator();
  /** Regresa una colección iterable de los nodos. */
  public Iterable<Posicion<E>> positions();
  /** Reemplaza el elemento guardado en un nodo dado. */
  public E replace(Posicion<E> v, E e)
    throws InvalidPositionException;
  /** Regresa la raíz del árbol. */
  public Posicion<E> root() throws EmptyTreeException;
  /** Regresa el padre de un nodo dado. */
  public Posicion<E> parent(Posicion<E> v)
    throws InvalidPositionException, BoundaryViolationException;
  /** Regresa una colección iterable de los hijos de un nodo dado. */
  public Iterable<Posicion<E>> children(Posicion<E> v) 
    throws InvalidPositionException;
  /** Valida si un nodo dado es interno. */
  public boolean isInternal(Posicion<E> v) 
    throws InvalidPositionException;
  /** Valida si un nodo dado es externo. */
  public boolean isExternal(Posicion<E> v) 
    throws InvalidPositionException;
  /** Valida si un nodo dado es la raíz del árbol. */
  public boolean isRoot(Posicion<E> v)
    throws InvalidPositionException;
}
