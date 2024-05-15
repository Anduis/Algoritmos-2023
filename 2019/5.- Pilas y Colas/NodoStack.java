/**
 * Implementación del ADT pila por medio de una lista simple enlazada.
 *   
 * @see Nodo
 */
 
public class NodoStack<E> implements Stack<E> {
  protected Nodo<E> cima; // referencia el nodo cabeza
  protected int tam;     // número de elementos en la pila
  /** Crear una pila vacía. */
  public NodoStack() {
    cima = null;
    tam = 0;
  }
  public int size() { return tam; }
  public boolean isEmpty() {
    return cima == null;
  }
  public void push(E elem) {
    Nodo<E> v = new Nodo<E>(elem, cima); // crear un nuevo nodo y enlazarlo
    cima = v;
    tam++;
  }
  public E top() throws EmptyStackException {
    if (isEmpty()) throw new EmptyStackException("La pila está vacía.");
    return cima.getElemento();
  }
  public E pop() throws EmptyStackException {
    if (isEmpty()) throw new EmptyStackException("La pila está vacía.");
    E temp = cima.getElemento();
    cima = cima.getSig(); // desenlazar el antiguo nodo cima
    tam--;
    return temp;
  }


 /**
  * Regresar una representación de cadena de la pila como una lista
  * de elementos con el elemento cima al final: [ ... , prev, cima ].
  * Este método se ejecuta en tiempo O(n), donde n es el número de
  * elementos en la pila.
  * @return representación textual de la pila.
  */
  public String toString() {
    Nodo<E> cur = cima;
    String s = "[";
    while (cur != null) {
      if (cur == cima) // primer elemento
        s += cur.getElemento();
      else
        s += ", " + cur.getElemento();
      cur = cur.getSig();
    }
    return s + "]";
  }

 /**
  * Imprime información acerca de una operación y la pila.
  * @param S pila de la cual se reporta su estado
  * @param op operación realizada
  * @param elemento elemento regresado por la operacion
  */ 
  public static void estado(Stack S, String op, Object elemento) {
    System.out.println("---------------------------------");
    System.out.println(op);
    System.out.println("Regresado: " + elemento);
    String estadoVacio;
    if (S.isEmpty())
      estadoVacio = "vacío";
    else
      estadoVacio = "no vacío";
    System.out.println("tam = " + S.size() + ", " + estadoVacio);
    System.out.println("Pila: " + S);
  }

 /**
  * Programa de prueba que realiza una serie de operaciones en una pila
  * e imprime la operación realizada, el elemento regresado
  * y el contenido de la pila después de cada operación.
  */
  public static void main(String[] args) {
    Object o;
    Stack<Integer> A = new NodoStack<Integer>();
    estado (A, "Nueva Pila Vacía", null);
    A.push(5);
    estado (A, "push(5)", null);
    A.push(3);
    estado (A, "push(3)", null);
    A.push(7);
    estado (A, "push(7)", null);
    o = A.pop();
    estado (A, "pop()", o);
    A.push(9);
    estado (A, "push(9)", null);
    o = A.pop();
    estado (A, "pop()", o);
    o = A.top();
    estado (A, "top()", o);
  }
}
