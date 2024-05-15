 /**
  * Implementación de la ADT pila usando un arreglo de longitud fija.
  * Una excepción es lanzada si la operación push es intentada cuando
  * el tamaño de la pila es igual a la longitud del arreglo.  Esta
  * clase incluye los métodos principales de la clase agregada
  * java.util.Stack.
  *
  * @see FullStackException
  */
public class ArregloStack<E> implements Stack<E> {
 /**
  * Capacidad del arreglo usado para implementar la pila.
  */
  protected int capacidad;
 /**
  * Capacidad por defecto del arreglo.
  */
  public static final int CAPACIDAD = 5;
 /**
  * Arreglo genérico usado para implementar la pila.
  */
  protected E[] S;
 /**
  * indice del elemento cima de la pila en el arreglo
  */
  protected int cima = -1;
 /**
  * Inicializa la pila para usar un arreglo de longitud por defecto.
  */
  public ArregloStack() {
    this(CAPACIDAD);
  }
 /**
  * Inicializa la pila para usar un arreglo de longitud dada.
  * @param cap longitud del arreglo.
  */
  public ArregloStack(int cap) {
    capacidad = cap;
    S = (E[]) new Object[capacidad]; // el compilador podría dar advertencia
                                     // pero esta bien
  }
 /**
  * Regresa el número de elementos en la pila.
  * Este método se ejecuta en tiempo O(1)
  * @return número de elementos en la pila.
  */
  public int size() {
    return (cima + 1);
  }
 /**
  * Prueba si la pila esta vacia.
  * Este método se ejecuta en tiempo O(1)
  * @return true si la pila esta vacia, false de otra forma.
  */
  public boolean isEmpty() {
    return (cima < 0);
  }
 /**
  * Inserta un elemento en la cima de la pila.
  * Este método se ejecuta en tiempo O(1)
  * @return elemento insertado.
  * @param elemento elemento a ser insertado.
  * @exception FullStackException si el arreglo de los elementos esta lleno.
  */
  public void push(E elemento) throws FullStackException {
    if (size() == capacidad)
      throw new FullStackException("La pila esta llena.");
    S[++cima] = elemento;
  }
 /**
  * Inspecciona el elemento en la cima de la pila.
  * Este método se ejecuta en tiempo O(1)
  * @return elemento cima en la pila.
  * @exception EmptyStackException si la pila esta vacia.
  */
  public E top() throws EmptyStackException {
    if (isEmpty())
      throw new EmptyStackException("La pila esta vacia.");
    return S[cima];
    }
 /**
  * Quita el elemento cima de la pila.
  * Este método se ejecuta en tiempo O(1)
  * @return elemento removido.
  * @exception EmptyStackException si la pila esta vacia.
  */
  public E pop() throws EmptyStackException {
    if (isEmpty())
      throw new EmptyStackException("La pila esta vacia.");
    E elemento = S[cima];
    S[cima--] = null; // desreferenciar S[cima] para el colector de basura.
    return elemento;
  }
 /**
  * Regresa una representacion de la pila como una lista de elementos,
  * con el elemento cima al final: [ ... , prev, cima ].
  * Este metodo corre en tiempo O(n), donde n es el tamaño de la cima.
  * @return representación textual de la pila.
  */
  public String toString() {
    String s = "[";
    if (size() > 0) s+= S[0];
    for (int i = 1; i <= S.length-1; i++)
       s += ", " + S[i];
    return s + "]";
  }
 /**
  * Imprime información del estado de una operación reciente de la pila.
  * @param op operación hecha
  * @param elemento elemento regresado por la operación
  * @return información acerca de la operación hecha el elemento
  * regresado por la operación y el contenido de la pila después de
  * la operación.
  */
  public void estado(String op, Object elemento) {
    System.out.print("------> " + op);   // imprime esta operación
    System.out.println(", regresa " + elemento); // que fue regresado
    System.out.print("resultado: num. elems. = " + size());
    System.out.print(", esta vacio? " + isEmpty());
    System.out.println(", pila: " + this);       // contenido de la pila
  }
 /**
  * Probar el programa haciendo una serie de operaciones en pilas,
  * imprimiendo las operaciones realizadas, los elementos regresados y
  * el contenido de la pila involucrada, despues de cada operación.
  */
  public static void main(String[] args) {
    Object o;
    ArregloStack<Integer> A = new ArregloStack<Integer>(3);
    A.estado("new ArregloStack<Integer> A", null);
    A.push(7);
    A.estado("A.push(7)", null);
    o = A.pop();
    A.estado("A.pop()", o);
    A.push(9);
    A.estado("A.push(9)", null);
    o = A.pop();
    A.estado("A.pop()", o);
    ArregloStack<String> B = new ArregloStack<String>();
    B.estado("new ArregloStack<String> B", null);
    B.push("Paco");
    B.estado("B.push(\"Paco\")", null);
    B.push("Pepe");
    B.estado("B.push(\"Pepe\")", null);
    o = B.pop();
    B.estado("B.pop()", o);
    B.push("Juan");
    B.estado("B.push(\"Juan\")", null);
  }
}
