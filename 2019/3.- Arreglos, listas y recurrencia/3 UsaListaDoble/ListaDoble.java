/** Lista doblemente enlazada de nodos tipo NodoD para cadenas . */
public class ListaDoble {
  protected int tam ; // cantidad de elementos
  protected NodoD cabeza , cola ; // centinelas
  /** Constructor que crea una lista vac a */
  public ListaDoble () {
    tam = 0;
    cabeza = new NodoD (null , null , null ); // crer cabeza
    cola = new NodoD (null , cabeza , null ); // crear terminaci on
    cabeza . setSig ( cola ); // cabeza apunta a terminaci on
  }
  /** Regresa la cantidad de elementos en la lista */
  public int tam () { return tam ; }
  /** Indica si la lista esta vac a */
  public boolean estaVacia () { return ( tam == 0); }
  /** Regresa el primer nodo de la lista */
  public NodoD getPrimero () throws IllegalStateException {
    if ( estaVacia ()) throw new IllegalStateException ("La lista esta vac a");
    return cabeza . getSig ();
  }
  /** Regresa el u ltimo nodo de la lista */
  public NodoD getUltimo () throws IllegalStateException {
    if ( estaVacia ()) throw new IllegalStateException ("La lista esta vac a");
    return cola . getPrev ();
  }
  /** Regresa el nodo anterior al nodo v dado . Un error ocurre si v
  * es la cabeza */
  public NodoD getPrev ( NodoD v) throws IllegalArgumentException {
    if (v == cabeza ) throw new IllegalArgumentException
      ("No se puede mover hacia atr as de la cabeza de la lista ");
    return v. getPrev ();
  }
  /** Regresa el nodo siguiente al nodo v dado . Un error ocurre si v
  * es la cola */
  public NodoD getSig ( NodoD v) throws IllegalArgumentException {
    if (v == cola ) throw new IllegalArgumentException
      ("No se puede mover hacia adelante de la terminaci on de la lista ");
    return v. getSig ();
  }
  /** Inserta el nodo z dado antes del nodo v dado . Un error
  * ocurre si v es la cabeza */
  public void agregarAntes ( NodoD v, NodoD z) throws IllegalArgumentException {
    NodoD u = getPrev (v); // podr a lanzar un IllegalArgumentException
    z. setPrev (u);
    z. setSig (v);
    v. setPrev (z);
    u. setSig (z);
    tam ++;
  }
  /** Inserta el nodo z dado despues del nodo v dado . Un error
  * ocurre si v es la cabeza */
  public void agregarDespues ( NodoD v, NodoD z) {
    NodoD w = getSig (v); // podr a lanzar un IllegalArgumentException
    z. setPrev (v);
    z. setSig (w);
    w. setPrev (z);
    v. setSig (z);
    tam ++;
  }
  /** Inserta el nodo v dado en la cabeza de la lista */
  public void agregarInicio ( NodoD v) {
    agregarDespues ( cabeza , v);
  }
  /** Inserta el nodo v dado en la cola de la lista */
  public void agregarFinal ( NodoD v) {
    agregarAntes (cola , v);
  }
  /** Quitar el nodo v dado de la lista . Un error ocurre si v es
  * la cabeza o la cola */
  public void remover ( NodoD v) {
    NodoD u = getPrev (v); // podr a lanzar IllegalArgumentException
    NodoD w = getSig (v); // podr a lanzar IllegalArgumentException
    // desenlazar el nodo v de la lista
    w. setPrev (u);
    u. setSig (w);
    v. setPrev ( null );
    v. setSig ( null );
    tam --;
  }
  /** Regresa si un nodo v dado tiene un nodo previo */
  public boolean tienePrev ( NodoD v) { return v != cabeza ; }
  /** Regresa si un nodo v dado tiene un nodo siguiente */
  public boolean tieneSig ( NodoD v) { return v != cola ; }
  /** Regresa una cadena representando la lista */
  public String toString () {
    String s = "[";
    NodoD v = cabeza . getSig ();
    while (v != cola ) {
    s += v. getElemento ();
    v = v. getSig ();
    if (v != cola )
    s += ",";
    }
    s += "]";
    return s;
  }
}
