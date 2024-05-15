//import java.util.Iterator;
/**
 * Una interfaz para listas arreglo.
 */
public interface ListaIndice<E> {
  /** Regresa el número de elementos en esta lista. */
  public int size();
  /** Prueba si la lista vacía. */
  public boolean isEmpty();
  /** Insertar un elemento e para estar en el índice i, 
    * desplazando todos los elementos después de este. */
  public void add(int i, E e) 
    throws IndexOutOfBoundsException;
  /** Regresar el elemento en el índice i, sin quitarlo. */
  public E get(int i) 
    throws IndexOutOfBoundsException;
  /** Quita y regresa el elemento en el índice i, 
    * desplazando los elementos después de este. */
  public E remove(int i)
    throws IndexOutOfBoundsException;
  /** Reemplaza el elemento en el índice i con e, 
    * regresando el elemento previo en i. */
  public E set(int i, E e)
    throws IndexOutOfBoundsException;
}
