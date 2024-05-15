 /** 
  * Interfaz para una deque: una colección de objetos que pueden ser
  * insertados y quitados en ambos extremos; un subconjunto de los
  * métodos de java.util.LinkedList.
  * 
  */

public interface Deque<E> {
 /**
  * Regresa el número de elementos en la deque.
  */
  public int size();
 /** 
  * Determina si la deque está vacía.
  */
  public boolean isEmpty();
 /** 
  * Regresa el primer elemento; una excepción es lanzada si la deque
  * está vacía.
  */
  public E getFirst() throws EmptyDequeException;
 /** 
  * Regresa el último elemento; una excepción es lanzada si la deque
  * está vacía.
  */
  public E getLast() throws EmptyDequeException;
 /**
  * Insertar un elemento para que sea el primero en la deque.
  */
  public void addFirst (E element); 
 /**
  * Insertar un elemento para que sea el último en la deque.
  */
  public void addLast (E element); 
 /** 
  * Quita el primer elemento; una excepción es lanzada si la deque
  * está vacía.
  */
  public E removeFirst() throws EmptyDequeException;
 /** 
  * Quita el último elemento; una excepción es lanzada si la deque
  * está vacía.
  */
  public E removeLast() throws EmptyDequeException;
}
