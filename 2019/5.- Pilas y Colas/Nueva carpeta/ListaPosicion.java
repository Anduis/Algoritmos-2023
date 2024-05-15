import java.util.Iterator;
/**
 * Una interfaz para listas posicionales.
 *
 */
public interface ListaPosicion<E> extends Iterable<E> {
  /** Regresa un iterador de todos los elementos en la lista. */
  public Iterator<E> iterator();
  /** Regresa una colección iterable de todos los nodos en la lista. */
  public Iterable<Posicion<E>> positions();
  /** Regresa la cantidad de elementos en esta lista. */
  public int size();
  /** Indica si la lista está vacía. */
  public boolean isEmpty();
  /** Regresa el primer nodo en la lista. */
  public Posicion<E> first();
  /** Regresa el último nodo en la lista. */
  public Posicion<E> last();
  /** Regresa el nodo siguiente a un nodo dado en la lista. */
  public Posicion<E> next(Posicion<E> p) 
    throws InvalidPositionException, BoundaryViolationException;
  /** Regresa el nodo anterior a un nodo dado en la lista. */
  public Posicion<E> prev(Posicion<E> p) 
    throws InvalidPositionException, BoundaryViolationException;
  /** Inserta un elemento en el frente de la lista. */
  public void addFirst(E e);
  /** Inserta un elemento al final de la lista. */
  public void addLast(E e);
  /** Inserta un elemento después del nodo dado en la lista. */
  public void addAfter(Posicion<E> p, E e) 
    throws InvalidPositionException;
  /** Inserta un elemento antes del nodo dado en la lista. */
  public void addBefore(Posicion<E> p, E e) 
    throws InvalidPositionException;
  /** Quita un nodo de la lista, regresando el elemento guardado. */      
  public E remove(Posicion<E> p) throws InvalidPositionException;
  /** Reemplaza el elemento guardado en el nodo dado, regresando el viejo. */
  public E set(Posicion<E> p, E e) throws InvalidPositionException;
}
