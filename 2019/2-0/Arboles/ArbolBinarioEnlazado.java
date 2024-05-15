import java.util.Iterator;
/**s
  * Una implementación de la interfaz ArbolBinario usando una estructura
  * enlazada.
  * @see ArbolBinario */
public class ArbolBinarioEnlazado<E> implements ArbolBinario<E> {
  protected PosicionAB<E> raiz;	// referencia a la raíz
  protected int tam;		// número de nodos
  /**  Crea un árbol binario vacío */
  public ArbolBinarioEnlazado() {
    raiz = null;  // empezar con un árbol binario
    tam = 0;
  }
  /** Regresa el número de nodos en el árbol. */
  public int size() {
    return tam;
  }
  /** Indica si el árbol está vacío. */
  public boolean isEmpty() {
    return (tam == 0);
  }
  /** Indica si un nodo es interno. */
  public boolean isInternal(Posicion<E> v) throws InvalidPositionException {
    revisaPosicion(v);		// método auxiliar
    return (hasLeft(v) || hasRight(v));
  }
  /** Indica si un nodo es externo */
  public boolean isExternal(Posicion<E> v) throws InvalidPositionException {
    return !isInternal(v);
  }
  /** Indica si un nodo es la raíz */
  public boolean isRoot(Posicion<E> v) throws InvalidPositionException {
    revisaPosicion(v);
    return (v == root());
  }
  /** Indica si un nodo tiene hijo izquierdo */
  public boolean hasLeft(Posicion<E> v) throws InvalidPositionException {
    PosicionAB<E> vv = revisaPosicion(v);
    return (vv.getIzq() != null);
  }
  /** Indica si un nodo tiene hijo derecho */
  public boolean hasRight(Posicion<E> v) throws InvalidPositionException {
    PosicionAB<E> vv = revisaPosicion(v);
    return (vv.getDer() != null);
  }
  /** Regresa la raíz del árbol */
  public Posicion<E> root() throws EmptyTreeException {
    if (raiz == null)
      throw new EmptyTreeException("El árbol está vacío");
    return raiz;
  }
  /** Regresa el hijo izquierdo de un nodo. */
  public Posicion<E> left(Posicion<E> v)
    throws InvalidPositionException, BoundaryViolationException {
    PosicionAB<E> vv = revisaPosicion(v);
    Posicion<E> posIzq = vv.getIzq();
    if (posIzq == null)
      throw new BoundaryViolationException("Sin hijo izquierdo");
    return posIzq;
  }
  /** Regresa el hijo izquierdo de un nodo. */
  public Posicion<E> right(Posicion<E> v)
    throws InvalidPositionException, BoundaryViolationException {
    PosicionAB<E> vv = revisaPosicion(v);
    Posicion<E> posDer = vv.getDer();
    if (posDer == null)
      throw new BoundaryViolationException("Sin hijo derecho");
    return posDer;
   }
  /** Regresa el padre de un nodo. */
  public Posicion<E> parent(Posicion<E> v)
    throws InvalidPositionException, BoundaryViolationException {
    PosicionAB<E> vv = revisaPosicion(v);
    Posicion<E> posPadre = vv.getPadre();
    if (posPadre == null)
      throw new BoundaryViolationException("Sin padre");
    return posPadre;
  }
  /** Regresa una colección iterable de los hijos de un nodo. */
  public Iterable<Posicion<E>> children(Posicion<E> v)
    throws InvalidPositionException {
   ListaPosicion<Posicion<E>> children = new ListaNodoPosicion<Posicion<E>>();
    if (hasLeft(v))
      children.addLast(left(v));
    if (hasRight(v))
      children.addLast(right(v));
    return children;
  }
  /** Regresa una colección iterable de los nodos de un árbol. */
  public Iterable<Posicion<E>> positions() {
   ListaPosicion<Posicion<E>> posiciones = new ListaNodoPosicion<Posicion<E>>();
    if(tam != 0)
      preordenPosiciones(root(), posiciones);  // asignar posiciones en preorden
    return posiciones;
  }
 /** Regresar un iterado de los elementos guardados en los nodos. */
  public Iterator<E> iterator() {
    Iterable<Posicion<E>> posiciones = positions();
   ListaPosicion<E> elementos = new ListaNodoPosicion<E>();
   for (Posicion<E> pos: posiciones)
     elementos.addLast(pos.elemento());
    return elementos.iterator();  // Un iterador de elementos
  }
  /** Reemplaza el elemento en un nodo. */
  public E replace(Posicion<E> v, E o)
    throws InvalidPositionException {
    PosicionAB<E> vv = revisaPosicion(v);
    E temp = v.elemento();
    vv.setElemento(o);
    return temp;
  }
  // Métodos adicionales accesores
  /** Regresa el hermano de un nodo. */
  public Posicion<E> sibling(Posicion<E> v)
    throws InvalidPositionException, BoundaryViolationException {
      PosicionAB<E> vv = revisaPosicion(v);
      PosicionAB<E> posPadre = vv.getPadre();
      if (posPadre != null) {
        PosicionAB<E> posHermano;
        PosicionAB<E> posIzq = posPadre.getIzq();
        if (posIzq == vv)
          posHermano = posPadre.getDer();
        else
          posHermano = posPadre.getIzq();
        if (posHermano != null)
	       return posHermano;
      }
      throw new BoundaryViolationException("Sin hermano");
  }
  // Métodos adicionales de actualización
  /** Agrega un nodo raíz a un árbol vacío */
  public Posicion<E> addRoot(E e) throws NonEmptyTreeException {
    if(!isEmpty())
      throw new NonEmptyTreeException("El árbol ya tiene raíz");
    tam = 1;
    raiz = creaNodo(e,null,null,null);
    return raiz;
  }
  /** Insertar un hijo izquierdo en un nodo dado. */
  public Posicion<E>  insertLeft(Posicion<E> v, E e)
    throws InvalidPositionException {
    PosicionAB<E> vv = revisaPosicion(v);
    Posicion<E> posIzq = vv.getIzq();
    if (posIzq != null)
      throw new InvalidPositionException("El nodo ya tiene hijo izquierdo");
    PosicionAB<E> ww = creaNodo(e, vv, null, null);
    vv.setIzq(ww);
    tam++;
    return ww;
  }
  /** Insertar un hijo derecho en un nodo dado. */
  public Posicion<E>  insertRight(Posicion<E> v, E e)
    throws InvalidPositionException {
    PosicionAB<E> vv = revisaPosicion(v);
    Posicion<E> posDer = vv.getDer();
    if (posDer != null)
      throw new InvalidPositionException("El nodo ya tiene hijo derecho");
    PosicionAB<E> w = creaNodo(e, vv, null, null);
    vv.setDer(w);
    tam++;
    return w;
  }
  /** Quitar un nodo con un hijo o sin hijos. */
  public E remove(Posicion<E> v)
    throws InvalidPositionException {
    PosicionAB<E> vv = revisaPosicion(v);
    PosicionAB<E> posIzq = vv.getIzq();
    PosicionAB<E> posDer = vv.getDer();
    if (posIzq != null && posDer != null)
      throw new InvalidPositionException("No se puede remover nodo con dos hijos");
    PosicionAB<E> ww = null; 	// el único hijo de v, si tiene
    if (posIzq != null)
      ww = posIzq;
    else if (posDer != null)
      ww = posDer;
    if (vv == raiz) { 	// v es la raíz entonces
      if (ww != null)   // hacer al hijo la nueva raíz
        ww.setPadre(null);
      raiz = ww;
    }
    else { 		// v no es la raíz
      PosicionAB<E> uu = vv.getPadre();
      if (vv == uu.getIzq())
        uu.setIzq(ww);
      else
        uu.setDer(ww);
      if(ww != null)
        ww.setPadre(uu);
    }
    tam--;
    return v.elemento();
  }

  /** Conecta dos árboles para ser los subárboles de un nodo externo. */
  public void attach(Posicion<E> v, ArbolBinario<E> T1, ArbolBinario<E> T2)
    throws InvalidPositionException {
    PosicionAB<E> vv = revisaPosicion(v);
    if (isInternal(v))
      throw new InvalidPositionException("No se pueda conectar del nodo interno");
    if (!T1.isEmpty()) {
      PosicionAB<E> r1 = revisaPosicion(T1.root());
      vv.setIzq(r1);
      r1.setPadre(vv);		// T1 deberá ser inválidado
    }
    if (!T2.isEmpty()) {
      PosicionAB<E> r2 = revisaPosicion(T2.root());
      vv.setDer(r2);
      r2.setPadre(vv);		// T2 deberá ser inválidado
    }
  }
  /** Intercambiar los elementos en dos nodos */
  public void swapElements(Posicion<E> v, Posicion<E> w)
    throws InvalidPositionException {
    PosicionAB<E> vv = revisaPosicion(v);
    PosicionAB<E> ww = revisaPosicion(w);
    E temp = w.elemento();
    ww.setElemento(v.elemento());
    vv.setElemento(temp);
  }
  /** Expandir un nodo externo en un nodo interno con dos nodos
    * externos hijos */
  public void expandExternal(Posicion<E> v, E l, E r)
    throws InvalidPositionException {
    if (!isExternal(v))
      throw new InvalidPositionException("El nodo no es externo");
    insertLeft(v, l);
    insertRight(v, r);
  }
  /** Quitar un nodo externo v y reemplazar su padre con el hermano de v*/
  public void removeAboveExternal(Posicion<E> v)
    throws InvalidPositionException {
    if (!isExternal(v))
      throw new InvalidPositionException("El nodo no es externo");
    if (isRoot(v))
      remove(v);
    else {
      Posicion<E> u = parent(v);
      remove(v);
      remove(u);
    }
  }
  // Métodos auxiliares
  /** Si v es un nodo de un árbol binario, convertir a PosicionAB,
    * si no lanzar una excepción */
  protected PosicionAB<E> revisaPosicion(Posicion<E> v)
    throws InvalidPositionException {
    if (v == null || !(v instanceof PosicionAB))
      throw new InvalidPositionException("La posición no es válida");
    return (PosicionAB<E>) v;
  }
  /** Crear un nuevo nodo de un árbol binario */
  protected PosicionAB<E> creaNodo(E elemento, PosicionAB<E> parent,
				  PosicionAB<E> left, PosicionAB<E> right) {
    return new NodoAB<E>(elemento,parent,left,right); }
  /** Crear una lista que guarda los nodos en el subárbol de un nodo,
    * ordenada de acuerdo al recorrido en preordel del subárbol. */
  protected void preordenPosiciones(Posicion<E> v, ListaPosicion<Posicion<E>> pos)
    throws InvalidPositionException {
    pos.addLast(v);
    if (hasLeft(v))
      preordenPosiciones(left(v), pos);	// recursividad en el hijo izquierdo
    if (hasRight(v))
      preordenPosiciones(right(v), pos);	// recursividad en el hijo derecho
  }
  /** Crear una lista que guarda los nodos del subárbol de un nodo,
     ordenados de acuerdo al recorrido en orden del subárbol. */
  protected void posicionesEnorden(Posicion<E> v, ListaPosicion<Posicion<E>> pos)
    throws InvalidPositionException {
    if (hasLeft(v))
      posicionesEnorden(left(v), pos); 	// recursividad en el hijo izquierdo
    pos.addLast(v);
    if (hasRight(v))
      posicionesEnorden(right(v), pos); // recursividad en el hijo derecho
  }
}
