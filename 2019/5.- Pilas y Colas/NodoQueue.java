/**
 * Realización de una cola mediante una lista ligada simple de nodos.
 * Todas las operaciones son hechas en tiempo constante.
 *
 */

public class NodoQueue<E> implements Queue<E> {

  protected Nodo<E> cabeza, cola;  // los nodos cabeza y cola
  protected int tam;

  /** Crear una cola vacía. */
  public NodoQueue() {
    cabeza = null;
    cola = null;
    tam = 0;
  }
  
  public int size() { //# Regresar el tamaño actual de la cola
    return tam;
  }
  
  public boolean isEmpty() { //# Regresa true si la cola está vacía
    return cabeza==null && cola==null;
  }

  public void enqueue(E elem) {
    Nodo<E> nodo = new Nodo<E>();
    nodo.setElemento(elem);
    nodo.setSig(null); // nodo será el nuevo nodo cola
    if (tam == 0)
      cabeza = nodo; // caso especial de una cola previamente vacía
    else
      cola.setSig(nodo); // agregar nodo en la cola de la lista
    cola = nodo; // actualizar la referencia al nodo cola
    tam++;
  }

  // Regresar el primer elemento de la cola
  public E front() throws EmptyQueueException {
    if (tam == 0)
      throw new EmptyQueueException("La cola está vacía.");
    return cabeza.getElemento();
  }
  
  public E dequeue() throws EmptyQueueException {
    if (tam == 0)
      throw new EmptyQueueException("La cola está vacía.");
    E e = cabeza.getElemento();
    cabeza = cabeza.getSig();
    tam--;
    if (tam == 0)
      cola = null; // la cola está ahora vacía
    return e;
  }

  public String toString() {
    String s = "";
    s += "(";
    if (!isEmpty()) {
      Nodo p = cabeza;
      do {
        s += p.getElemento() ;
        if (p != cola)
          s += ", ";
        p = p.getSig();
      } while (p != null); 
    }
    s += ")";
    return s;
  }

 /**
  * Imprime información acerca de una operación y la cola.
  * @param op operación realizada
  * @param elemento elemento regresado por la operación
  * @return información acerca de la operación realizada, el elemento
  * regresado por la operación y el contenido de la cola después
  * de la operación.
  */ 
  public static void estado(Queue Q, String op, Object elemento) {
    System.out.println("---------------------------------");
    System.out.println(op);
    System.out.println("Regresado : " + elemento);
    String estadoVacio;
    if (Q.isEmpty())
      estadoVacio = "vacía";
    else
      estadoVacio = "no vacía";
    System.out.println("tamaño = " + Q.size() + ", " + estadoVacio);
    System.out.println("Queue: " + Q);
  }

 /**
  * Programa prueba que realiza una serie de operaciones en una cola e
  * imprime la operación realizada, el elemento regresado y el contenido
  * de la cola después de cada operación.
  */
  public static void main(String[] args) {
    Object o;
    Queue<Integer> A = new NodoQueue<Integer>();
    estado (A, "Nueva cola vacía", null);
    A.enqueue(5);
    estado (A, "enqueue(5)", null);
    A.enqueue(3);
    estado (A, "enqueue(3)", null);
    A.enqueue(7);
    estado (A, "enqueue(7)", null);
    o = A.dequeue();
    estado (A, "dequeue()", o);
    A.enqueue(9);
    estado (A, "enqueue(9)", null);
    o = A.dequeue();
    estado (A, "dequeue()", o);
    o = o = A.front();
    estado (A, "front()", o);
  }
  
}
