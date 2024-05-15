/*
Autor: Andres Anguiano 1638975x
Fecha: 17 Mayo 2020
Modificar la interfaz ListaIndice para que extienda a la interfaz Iterable
y así la implementación de la clase ArregloListaIndice realiza el método iterator().
El método iterator() devuelve un objeto del tipo ElementoIteradorIndice,
el cual implementa los métodos next() y hasNext(). Agregar código que muestre el uso del iterador.
*/
 import java.util.Iterator;
public interface ListaIndice<E>  extends Iterable<E>{ //Modificar la interfaz ListaIndice para que extienda a la interfaz Iterable

  public Iterator<E> iterator();

  public int size();

  public boolean isEmpty();

  public void add(int i, E e)
    throws IndexOutOfBoundsException;

  public E get(int i)
    throws IndexOutOfBoundsException;

  public E remove(int i)
    throws IndexOutOfBoundsException;

  public E set(int i, E e)
    throws IndexOutOfBoundsException;
}
