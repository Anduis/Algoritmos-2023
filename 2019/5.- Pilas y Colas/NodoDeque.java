 /**
  * Implementación de la interfaz Deque mediante una lista doblemente
  * enlazada. Esta clase usa la clase NodoDL, la cual implementa un nodo de
  * la lista.
  */
public class NodoDeque<E> implements Deque<E> {
  protected NodoDL<E> cabeza, cola;  // nodos centinelas
  protected int tam;    // cantidad de elementos
  /** Constructor sin parámetros para crear una deque vacía. */
  public NodoDeque() {  // inicializar una deque vacía
    cabeza = new NodoDL<E>();
    cola = new NodoDL<E>();
    cabeza.setSig(cola);  // hacer que cabeza apunte a cola
    cola.setPrev(cabeza);  // hacer que cola apunte a cabeza
    tam = 0;
  }
  /**
	 * Regresar el tamaño de la deque, esto es el número de elementos que tiene.
	 * @return  Número de elementos en la deque
  */
  public int size() {
    return tam;
  }
  /**
   * Esta función regresa true si y sólo si la deque está vacía.
   * @return  true si la deque está vacía, false de otro modo.
   */
  public boolean isEmpty() {
    return tam == 0;
  }
  /**
   * Devolver el primer elemento sin modificar la deque.
   * @return El primer elemento en la secuencia.
   */
  public E getFirst() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Deque está vacía.");
    return cabeza.getSig().getElemento();
  }
  /**
   * Devolver el último elemento sin modificar la deque.
   * @return El último elemento en la secuencia.
   */
  public E getLast() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Deque está vacía.");
    return cola.getPrev().getElemento();
  }
  public void addFirst(E o) {
    NodoDL<E> segundo = cabeza.getSig();
    NodoDL<E> primero = new NodoDL<E>(o, cabeza, segundo);
    segundo.setPrev(primero);
    cabeza.setSig(primero);
    tam++;
  }
  public void addLast(E o) {
    NodoDL<E> penultimo = cola.getPrev();
    NodoDL<E> ultimo = new NodoDL<E>(o, penultimo, cola);
    penultimo.setSig(ultimo);
    cola.setPrev(ultimo);
    tam++;
  }
  public E removeFirst() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Deque está vacía.");
    NodoDL<E> primero = cabeza.getSig();
    E e = primero.getElemento();
    NodoDL<E> segundo = primero.getSig();
    cabeza.setSig(segundo);
    segundo.setPrev(cabeza);
    tam--;
    return e;
   }
  public E removeLast() throws EmptyDequeException {
    if (isEmpty())
      throw new EmptyDequeException("Deque está vacía.");
    NodoDL<E> ultimo = cola.getPrev();
    E e = ultimo.getElemento();
    NodoDL<E> penultimo = ultimo.getPrev();
    cola.setPrev(penultimo);
    penultimo.setSig(cola);
    tam--;
    return e;
  }
}
