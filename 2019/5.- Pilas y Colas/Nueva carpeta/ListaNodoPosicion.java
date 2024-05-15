import java.util.Iterator;
/**
 * Realización de una ListaPosición usando una lista doblemente enlazada
 * de nodos.
 *
 */
public class ListaNodoPosicion<E> implements ListaPosicion<E> {
  protected int tam;           // número de elementos en la lista
  protected NodoD<E> cabeza, cola; // centinelas especiales
  public Posicion<E> cursor;
  /** Constructor que crea una lista vacía; tiempo O(1) */
  public ListaNodoPosicion() {
    tam = 0;
    cabeza = new NodoD<E>(null, null, null);  // crea cabeza
    cola = new NodoD<E>(cabeza, null, null); // crea cola
    cabeza.setNext(cola);  // hacer que cabeza apunte a cola
  }
  /** Revisa si la Posicion es válida para esta lista y la convierte a
    * NodoD si esta es válida: tiempo O(1) */
  protected NodoD<E> revisaPosicion(Posicion<E> p)
    throws InvalidPositionException {
    if (p == null)
      throw new InvalidPositionException
        ("Posición Null pasada a ListaNodo");
    if (p == cabeza)
      throw new InvalidPositionException
        ("El nodo cabeza no es una Posicion válida");
    if (p == cola)
      throw new InvalidPositionException
        ("El nodo cola no es una Posicion válida");
    try {
      NodoD<E> temp = (NodoD<E>) p;
      if ((temp.getPrev() == null) || (temp.getNext() == null))
        throw new InvalidPositionException
          ("Posición no pertenece a una ListaNodo válida");
      return temp;
    } catch (ClassCastException e) {
      throw new InvalidPositionException
      ("Posición es de un tipo incorrecto para esta lista");
    }
  }
  /** Regresa el número de elementos en la lista; tiempo O(1) */
  public int size() { return tam; }
  /** Valida si la lista está vacía;  tiempo O(1) */
  public boolean isEmpty() { return (tam == 0); }
  /** Regresa la primera Posicion en la lista; tiempo O(1) */
  public Posicion<E> first()
      throws EmptyListException {
    if (isEmpty())
      throw new EmptyListException("La lista está vacía");
    return cabeza.getNext();
  }
  /** Regresa la última Posicion en la lista; tiempo O(1) */
  public Posicion<E> last()
      throws EmptyListException {
    if (isEmpty())
      throw new EmptyListException("La lista está vacía");
    return cola.getPrev();
  }
  public void left(){
    cursor = prev(cursor);
  }
  public void right(){
    cursor = next(cursor);
  }
  public E cut(){
    right();
    return remove(cursor);
  }
  public void paste(E c){
    addAfter(cursor, c);
  }
  public void actualizaCursor(){
    cursor=last();
  }
  /** Regresa la Posicion anterior de la dada; tiempo O(1) */
  public Posicion<E> prev(Posicion<E> p)
      throws InvalidPositionException, BoundaryViolationException {
    NodoD<E> v = revisaPosicion(p);
    NodoD<E> prev = v.getPrev();
    if (prev == cabeza)
      throw new BoundaryViolationException
        ("No se puede avanzar más allá del inicio de la lista");
    return prev;
  }
  /** Regresa la Posicion después de la dada; tiempo O(1) */
  public Posicion<E> next(Posicion<E> p)
      throws InvalidPositionException, BoundaryViolationException {
    NodoD<E> v = revisaPosicion(p);
    NodoD<E> next = v.getNext();
    if (next == cola)
      throw new BoundaryViolationException
        ("No se puede avanzar más allá del final de la lista");
    return next;
  }
  /** Insertar el elemento dado antes de la Posicion dada: tiempo O(1) */
  public void addBefore(Posicion<E> p, E elemento)
      throws InvalidPositionException {
    NodoD<E> v = revisaPosicion(p);
    tam++;
    NodoD<E> nodoNuevo = new NodoD<E>(v.getPrev(), v, elemento);
    v.getPrev().setNext(nodoNuevo);
    v.setPrev(nodoNuevo);
  }
 /** Insertar el elemento dado después de la Posicion dada: tiempo O(1) */
  public void addAfter(Posicion<E> p, E elemento)
      throws InvalidPositionException {
    NodoD<E> v = revisaPosicion(p);
    tam++;
    NodoD<E> nodoNuevo = new NodoD<E>(v, v.getNext(), elemento);
    v.getNext().setPrev(nodoNuevo);
    v.setNext(nodoNuevo);
  }
 /** Insertar el elemento dado al final de la lista, regresando
   * la nueva Posicion; tiempo O(1) */
  public void addLast(E elemento) {
    tam++;
    NodoD<E> ultAnterior = cola.getPrev();
    NodoD<E> nodoNuevo = new NodoD<E>(ultAnterior, cola, elemento);
    ultAnterior.setNext(nodoNuevo);
    cola.setPrev(nodoNuevo);
    if(tam==1) actualizaCursor();
  }
  /** Insertar el elemento dado al inicio de la lista, regresando
    * la nueva Posicion; tiempo O(1) */
  public void addFirst(E elemento) {
    tam++;
    NodoD<E> nodoNuevo = new NodoD<E>(cabeza, cabeza.getNext(), elemento);
    cabeza.getNext().setPrev(nodoNuevo);
    cabeza.setNext(nodoNuevo);
    if(tam==1) actualizaCursor();
  }
  /** Quitar la Posicion dada de la lista; tiempo O(1) */
  public E remove(Posicion<E> p)
      throws InvalidPositionException {
    NodoD<E> v = revisaPosicion(p);
    tam--;
    NodoD<E> vPrev = v.getPrev();
    NodoD<E> vNext = v.getNext();
    vPrev.setNext(vNext);
    vNext.setPrev(vPrev);
    E vElem = v.elemento();
    // desenlazar la Posicion de la lista y hacerlo inválido
    v.setNext(null);
    v.setPrev(null);
    return vElem;
  }
  /** Reemplaza el elemento en la Posicion dada con el nuevo elemento
    * y regresar el viejo elemento; tiempo O(1) */
  public E set(Posicion<E> p, E elemento)
      throws InvalidPositionException {
    NodoD<E> v = revisaPosicion(p);
    E elemVjo = v.elemento();
    v.setElemento(elemento);
    return elemVjo;
  }
  /** Regresa un iterador con todos los elementos en la lista. */
  public Iterator<E> iterator() { return new ElementoIterador<E>(this); }
  /** Regresa una colección iterable de todos los nodos en la lista. */
  public Iterable<Posicion<E>> positions() {  // crea una lista de posiciones
    ListaPosicion<Posicion<E>> P = new ListaNodoPosicion<Posicion<E>>();
    if (!isEmpty()) {
      Posicion<E> p = first();
      while (true) {
        P.addLast(p); // agregar Posicion p como el últ. elemento de la lista P
        if (p == last())
          break;
        p = next(p);
      }
    }
    return P; // regresar P como el objeto iterable
  }
  // Métodos de conveniencia
  /** Valida si una Posicion es la primera; tiempo O(1). */
  public boolean isFirst(Posicion<E> p)
    throws InvalidPositionException {
    NodoD<E> v = revisaPosicion(p);
    return v.getPrev() == cabeza;
  }
  /** Valida si una Posicion es la última; tiempo O(1). */
  public boolean isLast(Posicion<E> p)
      throws InvalidPositionException {
    NodoD<E> v = revisaPosicion(p);
    return v.getNext() == cola;
  }
  /** Intercambia los elementos de dos posiciones dadas; tiempo O(1) */
  public void swapElements(Posicion<E> a, Posicion<E> b)
      throws InvalidPositionException {
    NodoD<E> pA = revisaPosicion(a);
    NodoD<E> pB = revisaPosicion(b);
    E temp = pA.elemento();
    pA.setElemento(pB.elemento());
    pB.setElemento(temp);
  }
  /** Regresa una representación textual de una lista nodo usando for-each */
  public static <E> String forEachToString(ListaPosicion<E> L) {
    String s = "[";
    int i = L.size();
    for (E elem: L) {
      s += elem; // moldeo implícito del elemento a String
      i--;
      if (i > 0)
        s += ", "; // separar elementos con una coma
    }
    s += "]";
    return s;
  }
  /** Regresar una representación textual de una lista nodo dada */
  public static <E> String toString(ListaPosicion<E> l) {
    Iterator<E> it = l.iterator();
    String s = "[";
    while (it.hasNext()) {
      s += it.next();  // moldeo implícito del elemento a String
      }
    s += "]";
    return s;
  }
  /** Regresa una representación textual de la lista */
  public String toString() {
    return toString(this);
  }
  public static void main(String[] args) {
    ListaNodoPosicion<Character> A = new ListaNodoPosicion<Character>();
    A.addFirst('d');
    A.addFirst(' ');
    A.addFirst('s');
    Posicion<Character> p1 = A.first();
    System.out.println(A.toString(A)+"" +p1);
  }
}
