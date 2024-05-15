/**
  * Interfaz para una cola: una colección de elementos que son insertados
  * y removidos de acuerdo con el principio primero en entrar, primero en
  * salir.
  *
  * @see EmptyQueueException
  */

public interface Queue<E> {
 /**
  * Regresa el numero de elementos en la cola.
  * @return número de elementos en la cola.
  */
  public int size();
 /**
  * Indica si la cola está vacía
  * @return true si la cola está vacía, false de otro modo.
  */
  public boolean isEmpty();
 /**
  * Regresa el elemento en el frente de la cola.
  * @return elemento en el frente de la cola.
  * @exception EmptyQueueException si la cola está vacía.
  */
  public E front() throws EmptyQueueException;
 /**
  * Insertar un elemento en la zaga de la cola.
  * @param elemento nuevo elemento a ser insertado.
  */
  public void enqueue (E element);
 /**
  * Quitar el elemento del frente de la cola.
  * @return elemento quitado.
  * @exception EmptyQueueException si la cola está vacía.
  */
  public E dequeue() throws EmptyQueueException;
}
