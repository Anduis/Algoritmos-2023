import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  Una clase iterador simple para listas. Los elementos de una
 * lista son regresados por este iterador. No se hace copia de la
 * lista, por lo tanto cualquier cambio a la lista se refleja
 * en el iterador.
 *
 */
public class ElementoIterador<E> implements Iterator<E> {
  protected ListaPosicion<E> lista; // la lista subyacente
  protected Posicion<E> cursor; // la siguiente posición
  /** Crea un elemento iterador sobre la lista dada. */
  public ElementoIterador(ListaPosicion<E> L) {
    lista = L;
    cursor = (lista.isEmpty())? null : lista.first();
  }
  /** Valida si el iterador tiene un objeto siguiente. */
  public boolean hasNext() { return (cursor != null);  }
  /** Regresa el siguiente objeto en el iterador. */
  public E next() throws NoSuchElementException {
    if (cursor == null)
      throw new NoSuchElementException("No hay elemento siguiente");
    E aRegresar = cursor.elemento();
    cursor = (cursor == lista.last())? null : lista.next(cursor);
    return aRegresar;
  }
  /** Lanza una {@link UnsupportedOperationException} en todos los casos.
   * porque quitar no es una operación soportada en este iterador.
   */
  public void remove() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("remove");
  }
}
