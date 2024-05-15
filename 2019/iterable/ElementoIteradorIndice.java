/*
Autor: Andres Anguiano 1638975x
Fecha: 17 Mayo 2020
Modificar la interfaz ListaIndice para que extienda a la interfaz Iterable
y así la implementación de la clase ArregloListaIndice realiza el método iterator().
El método iterator() devuelve un objeto del tipo ElementoIteradorIndice,
el cual implementa los métodos next() y hasNext(). Agregar código que muestre el uso del iterador.
*/
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ElementoIteradorIndice<E> implements Iterator<E> {
  protected ListaIndice<E> lista;
  protected Integer cursor;
  public ElementoIteradorIndice(ListaIndice<E> L) {
    lista = L;
    cursor = (lista.isEmpty())? null : 0;
  }
//el cual implementa los métodos next() y hasNext().
  public boolean hasNext() { return (cursor != null);  }

  public E next() throws NoSuchElementException {
    if (cursor == null)
      throw new NoSuchElementException("No hay elemento siguiente");
    E aRegresar = lista.get(cursor);
    cursor = (cursor == lista.size()-1)? null : cursor+1;
    return aRegresar;
  }

  public void remove() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("remove");
  }
}
