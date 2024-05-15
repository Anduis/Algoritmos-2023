 /** 
  * Interfaz para una pila: una colección de objetos que son insertados
  * y removidos de acuerdo al principio último en entrar, primero en salir.
  * Esta interfaz incluye los métodos principales de java.util.Stack.
  * 
  * @see EmptyStackException
  */

public interface Stack<E> {

 /**
  * Regresa el número de elementos en la pila.
  * @return número de elementos en la pila.
  */
  public int size();

 /** 
  * Indica si la pila está vacia.
  * @return true si la pila está vacía, de otra manera false.
  */
  public boolean isEmpty();

 /** 
  * Explorar el elemento en la cima de la pila.
  * @return el elemento cima en la pila.
  * @exception EmptyStackException si la pila está vacía.
  */
  public E top() 
    throws EmptyStackException;  

 /**
  * Insertar un elemento en la cima de la pila.
  * @param elemento a ser insertado.
  */
  public void push (E elemento); 

 /** 
  * Quitar el elemento cima de la pila.
  * @return elemento removido.
  * @exception EmptyStackException si la pila está vacía.
  */
  public E pop()
    throws EmptyStackException; 
}
