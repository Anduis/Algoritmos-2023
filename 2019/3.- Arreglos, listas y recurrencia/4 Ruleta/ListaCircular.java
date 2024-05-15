public class ListaCircular {
  protected Nodo cursor ; // cursor actual
  protected int tam ; // cantidad de nodos en la lista
  /** Constructor que crea una lista vacia */
  public ListaCircular () { cursor = null ; tam = 0; }
  /** Regresa cantidad de nodos */
  public int tam () { return tam ; }
  /** Regresa cursor */
  public Nodo getCursor () { return cursor ; }
  /** Mueve cursor hacia adelante */
  public void avanzar () { cursor = cursor . getSig (); }
  /** Agrega nodo despu es del cursor */
  public void agregar ( Nodo nodoNuevo ) {
  if ( cursor == null ) { //  lista vacia ?
    nodoNuevo.setSig(nodoNuevo);
   cursor = nodoNuevo ;
  }
  else {
    nodoNuevo.setSig(cursor.getSig());
    cursor.setSig(nodoNuevo);
  }
    tam ++;
  }
  /** Quita nodo despu es del cursor */
  public Nodo remover () {
    Nodo nodo = cursor.getSig(); // nodo que ser a removido
    if ( nodo == cursor )
    cursor = null ; // la lista quedar a vac a
    else {
    cursor.setSig(nodo.getSig()); // desenlazar el nodo
    nodo.setSig(null);
    }
    tam --;
    return nodo ;
  }
  /** Devuelve una representaci on String de la lista ,
  * iniciando desde el cursor */
  public String toString () {
    if ( cursor == null ) return "[]";
    String s = " [... " + cursor.getElemento ();
    Nodo cursorOrig = cursor ;
    for ( avanzar (); cursorOrig != cursor ; avanzar () )
    s += ", " + cursor.getElemento();
    return s + " ...] ";
  }
}
