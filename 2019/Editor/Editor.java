/*
Autor:Andres Anguiano 1638975x
Fecha: 14 Mayo 2020
Escribir un editor de texto simple, el cual guarda y muestra una cadena de caracteres usando el ADT lista nodo.
El editor deberá soportar las siguientes operaciones:
left: mover el cursor a la izquierda un carácter (no se hace nada si se está al inicio del texto).
right: mover el cursor a la derecha un carácter (no se hace nada si se está al final del texto).
cut: borrar el carácter a la derecha del cursor (no se hace nada al final del texto).
paste c: insertar el carácter c enseguida del cursor.
*/
public class Editor<E> implements ListaNodo<E>{
  protected int tam;
  protected NodoD<E> cabeza, cola;
  public Posicion<E> cursor;

  public Editor() {
    tam = 0;
    cabeza = new NodoD<E>(null, null, null);
    cola = new NodoD<E>(cabeza, null, null);
    cabeza.setNext(cola);
  }

  public Posicion<E> first() throws EmptyListException {
    if (tam==0)
    throw new EmptyListException("La lista está vacía");
    return cabeza.getNext();
  }

  public Posicion<E> last() throws EmptyListException {
    if (tam==0)
    throw new EmptyListException("La lista está vacía");
    return cola.getPrev();
  }

  public Posicion<E> next(Posicion<E> p) throws InvalidPositionException, BoundaryViolationException {
    NodoD<E> v = revisaPosicion(p);
    NodoD<E> next = v.getNext();
    if (next == cola)
    throw new BoundaryViolationException
    ("No se puede avanzar más allá del final de la lista");
    return next;
  }

  public Posicion<E> prev(Posicion<E> p) throws InvalidPositionException, BoundaryViolationException {
    NodoD<E> v = revisaPosicion(p);
    NodoD<E> prev = v.getPrev();
    if (prev == cabeza)
    throw new BoundaryViolationException
    ("No se puede avanzar más allá del inicio de la lista");
    return prev;
  }

  public void addFirst(E elemento) {
    tam++;
    NodoD<E> nodoNuevo = new NodoD<E>(cabeza, cabeza.getNext(), elemento);
    cabeza.getNext().setPrev(nodoNuevo);
    cabeza.setNext(nodoNuevo);
  }

  public void addLast(E elemento) {
    tam++;
    NodoD<E> ultAnterior = cola.getPrev();
    NodoD<E> nodoNuevo = new NodoD<E>(ultAnterior, cola, elemento);
    ultAnterior.setNext(nodoNuevo);
    cola.setPrev(nodoNuevo);
  }

  public E set(Posicion<E> p, E elemento)
  throws InvalidPositionException {
    NodoD<E> v = revisaPosicion(p);
    E elemVjo = v.elemento();
    v.setElemento(elemento);
    return elemVjo;
  }
  public void addAfter(Posicion<E> p, E elemento) throws InvalidPositionException {
    NodoD<E> v = revisaPosicion(p);
    tam++;
    NodoD<E> nodoNuevo = new NodoD<E>(v, v.getNext(), elemento);
    v.getNext().setPrev(nodoNuevo);
    v.setNext(nodoNuevo);
  }

  public void addBefore(Posicion<E> p, E elemento) throws InvalidPositionException {
    NodoD<E> v = revisaPosicion(p);
    tam++;
    NodoD<E> nodoNuevo = new NodoD<E>(v.getPrev(), v, elemento);
    v.getPrev().setNext(nodoNuevo);
    v.setPrev(nodoNuevo);
  }

  public E remove(Posicion<E> p)
  throws InvalidPositionException {
    NodoD<E> v = revisaPosicion(p);
    tam--;
    NodoD<E> vPrev = v.getPrev();
    NodoD<E> vNext = v.getNext();
    vPrev.setNext(vNext);
    vNext.setPrev(vPrev);
    E vElem = v.elemento();

    v.setNext(null);
    v.setPrev(null);
    return vElem;
  }
  //los anteriores son los metodos que menciona en las notas que tendria el adt ListaNodo
  protected NodoD<E> revisaPosicion(Posicion<E> p) throws InvalidPositionException {
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

  public boolean isFirst(Posicion<E> p)
    throws InvalidPositionException {
    NodoD<E> v = revisaPosicion(p);
    return v.getPrev() == cabeza;
  }
  public boolean isLast(Posicion<E> p)
      throws InvalidPositionException {
    NodoD<E> v = revisaPosicion(p);
    return v.getNext() == cola;
  }

  public String toString() {
    String s = "[";
    Posicion<E> v = first();
    s += v.elemento();
    while (!isLast(v)) {
      s += next(v).elemento();
      v=next(v);
      }
    s += "]";
    return s;
  }

  //left: mover el cursor a la izquierda un carácter (no se hace nada si se está al inicio del texto).
  public void left(){ if (!isFirst(cursor)) cursor = prev(cursor); }
  //right: mover el cursor a la derecha un carácter (no se hace nada si se está al final del texto).
  public void right(){ if (!isLast(cursor)) cursor = next(cursor); }
  //cut: borrar el carácter a la derecha del cursor (no se hace nada al final del texto).
  public E cut(){
    if (!isLast(cursor)) {
      Posicion<E> nvo = prev(cursor);
      right();
      E respuesta = remove(cursor);
      cursor = nvo;
      right();
      return respuesta;
    }
    else return null;
  }
  //paste c: insertar el carácter c enseguida del cursor.
  public void paste(E c){
    if (tam==0){
      addFirst(c);
      cursor=last();
    }
    else{
      addAfter(cursor, c);
      right();
    }
  }
  //devuelve el elemento bajo el cursor
  public E curs()
  throws InvalidPositionException {
    NodoD<E> v = revisaPosicion(cursor);
    E vElem = v.elemento();
    return vElem;
  }
  public void inf(String op) {
    System.out.print(op+" Escrito :"+this.toString()+" ,");
    System.out.println(" cursor: [" + curs()+"]");
  }
  public static void main(String[] args) {
    Editor<Character> A = new Editor<Character>();
    A.paste('H');
    A.inf("escribe 'H'");
    A.paste('o');
    A.inf("escribe 'o'");
    A.paste('l');
    A.inf("escribe 'l'");
    A.paste('a');
    A.inf("escribe 'a'");
    A.paste(' ');
    A.inf("escribe ' '");
    A.paste('m');
    A.inf("escribe 'm'");
    A.paste('u');
    A.inf("escribe 'u'");
    A.paste('m');
    A.inf("escribe 'm'");
    A.paste('d');
    A.inf("escribe 'd'");
    A.paste('o');
    A.inf("escribe 'o'");
    A.left();
    A.inf("cursor a la izq.");
    A.left();
    A.inf("cursor a la izq.");
    A.left();
    A.inf("cursor a la izq.");
    Object o = A.cut();
    A.inf("cortar :"+o);
    A.paste('n');
    A.inf("pegar: "+'n');
    A.right();
    A.inf("cursor a la dcha.");
    A.right();
    A.inf("cursor a la dcha.");
    A.right();
    A.inf("cursor a la dcha.");
    A.paste('.');
    A.inf("escribe '.'");
    A.left();
    A.inf("cursor a la izq.");
    A.paste('!');
    A.inf("escribe '!'");
  }
}
