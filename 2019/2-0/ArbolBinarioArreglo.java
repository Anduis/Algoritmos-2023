/*Autor: Andres Anguiano
Implementar el ADT árbol binario en la clase ArbolBinarioArreglo usando una lista arreglo.
*/
public class ArbolBinarioArreglo<E> implements ArbolBinario<E>{
  protected PosicionElementoIndice<E> raiz;
  protected ListaIndice<PosicionElementoIndice> A;
  protected int tam;

  public ArbolBinarioArreglo() {
    A = new ArregloListaIndice<PosicionElementoIndice>()
    tam = 0;
    raiz = null;
  }
  //metodos interfaz ArbolBinario
  public Posicion<E> left(Posicion<E> v) throws InvalidPositionException, BoundaryViolationException {
		PosicionElementoIndice<E> vv = revisaPosicion(v);
		Posicion<E> posIzq = vv.getIzq(A);
		if (posIzq == null)
			throw new BoundaryViolationException("Sin hijo izquierdo");
		return posIzq;
	}
  public Posicion<E> right(Posicion<E> v) throws InvalidPositionException, BoundaryViolationException {
		PosicionElementoIndice<E> vv = revisaPosicion(v);
		Posicion<E> posDer = vv.getDer(A);
		if (posDer == null)
			throw new BoundaryViolationException("Sin hijo derecho");
		return posDer;
	}
  public boolean hasLeft(Posicion<E> v) throws InvalidPositionException{
    PosicionElementoIndice<E> vv = revisaPosicion(v);
    return (vv.getIzq(A) != null);
  }
  public boolean hasRight(Posicion<E> v) throws InvalidPositionException{
    PosicionElementoIndice<E> vv = revisaPosicion(v);
    return (vv.getDer(A) != null);
  }
  //metodos interfaz Tree
  public int size(){ return tam; }

  public boolean isEmpty(){ return (tam==0); }

  public Iterator<E> iterator() {
		Iterable<Posicion<E>> posiciones = positions();
		ListaPosicion<E> elementos = new ListaNodoPosicion<>();
		for (Posicion<E> pos: posiciones)
			elementos.addLast(pos.elemento());
		return elementos.iterator();
	}
  public Iterable<Posicion<E>> positions(){
    ListaPosicion<Posicion<E>> posiciones = new ListaNodoPosicion<>();
    if(tam != 0)
      preordenPosiciones(root(), posiciones);
    return posiciones;
  }
  public E replace(Posicion<E> v, E o) throws InvalidPositionException {
		PosicionElementoIndice<E> vv = revisaPosicion(v);
		E temp = v.elemento();
		vv.setElemento(o);
		return temp;
	}
  public Posicion<E> root() throws EmptyTreeException{
    if (tam == 0)
			throw new EmptyTreeException("El árbol está vacío");
		return raiz;
  }
  public Posicion<E> parent(Posicion<E> v) throws InvalidPositionException, BoundaryViolationException{
    PosicionElementoIndice<E> vv = revisaPosicion(v);
		Posicion<E> posPadre = vv.getPadre(A);
		if (posPadre == null)
			throw new BoundaryViolationException("Sin padre");
		return posPadre;
  }
  public Iterable<Posicion<E>> children(Posicion<E> v) throws InvalidPositionException{
    ListaPosicion<Posicion<E>> children = new ListaNodoPosicion<>();
		if (hasLeft(v))
			children.addLast(left(v));
		if (hasRight(v))
			children.addLast(right(v));
		return children;
  }
  public boolean isInternal(Posicion<E> v) throws InvalidPositionException{
    revisaPosicion(v);
    return (hasLeft(v) || hasRight(v));
  }
  public boolean isExternal(Posicion<E> v) throws InvalidPositionException{ return !isInternal(v); }

  public boolean isRoot(Posicion<E> v) throws InvalidPositionException{
    revisaPosicion(v);
    return (v == root())
  }

  // Métodos adicionales accesores
  public Posicion<E> sibling(Posicion<E> v) throws InvalidPositionException, BoundaryViolationException {
		PosicionElementoIndice<E> vv = revisaPosicion(v);
		PosicionElementoIndice<E> posPadre = vv.getPadre(A);
		if (posPadre != null) {
			PosicionElementoIndice<E> posHermano;
			PosicionElementoIndice<E> posIzq = posPadre.getIzq(A);
			if (posIzq == vv)
				posHermano = posPadre.getDer(A);
			else
				posHermano = posPadre.getIzq(A);
			if (posHermano != null)
				return posHermano;
		}
		throw new BoundaryViolationException("Sin hermano");
	}
  // Métodos adicionales de actualización
  public Posicion<E> addRoot(E e) throws NonEmptyTreeException {
    if(!isEmpty())
      throw new NonEmptyTreeException("El árbol ya tiene raíz");
    tam++;
    raiz = creaNodo(e,1);
		raiz.guarda(A);
    return raiz;
  }
  public Posicion<E> insertLeft(Posicion<E> v, E e) throws InvalidPositionException {
    PosicionElementoIndice<E> vv = revisaPosicion(v);
		Posicion<E> posIzq = vv.getIzq(A);
		if (posIzq != null)
			throw new InvalidPositionException("El nodo ya tiene hijo izquierdo");
		PosicionElementoIndice<E> w = creaNodo(e, vv.getIndice()*2);
		w.guarda(A);
		tam++;
		return w;
	}
  public Posicion<E>  insertRight(Posicion<E> v, E e) throws InvalidPositionException {
    PosicionElementoIndice<E> vv = revisaPosicion(v);
		Posicion<E> posDer = vv.getDer(A);
		if (posDer != null)
			throw new InvalidPositionException("El nodo ya tiene hijo derecho");
		PosicionElementoIndice<E> w = creaNodo(e,vv.getIndice()*2+1);
		w.guarda(A);
		tam++;
		return w;
  }
  protected void ajustaN(PosicionElementoIndice<E> v, int i){
    if ( isExternal(v) ){
      A.set(v.getIndice(), null);
    }else{
      if (hasLeft(v))  ajustaN(v.getIzq(A), i*2);
      if (hasRight(v))  ajustaN(v.getDer(A), i*2+1);
    }
    v.setIndice((v.getIndice()+i)/2);
    v.guarda(A);
  }
  public E remove(Posicion<E> v) throws InvalidPositionException {
		PosicionElementoIndice<E> vv = revisaPosicion(v);
		PosicionElementoIndice<E> posIzq = vv.getIzq(A);
		PosicionElementoIndice<E> posDer = vv.getDer(A);
		if (hasLeft(vv) && hasRight(vv))
			throw new InvalidPositionException("No se puede remover nodo con dos hijos");
		if(hasLeft(vv))
			ajustaN(posIzq, 0);
		else if(hasRight(vv))
			ajustaN(posDer, -1);
		else
			A.set(vv.getIndice(), null);
		if(vv == raiz)
			raiz=A.get(1);
		return v.elemento();
	}
  public void ajustaI(PosicionElementoIndice<E> v, int i){
		if ( isExternal(v) ){
			A.set(v.getIndice(), null);
		}else{
      if (hasLeft(v))  ajustaI(v.getIzq(A), i*2);
      if (hasRight(v))  ajustaI(v.getDer(A), i*2+1);
		}
		v.setIndice(i);
		v.guarda(A);
	}
  public void attach(Posicion<E> v, ArbolBinario<E> T1, ArbolBinario<E> T2) throws InvalidPositionException {
    PosicionElementoIndice<E> vv = revisaPosicion(v);
		if (isInternal(v))
			throw new InvalidPositionException("No se pueda conectar del nodo interno");
		if (!T1.isEmpty()) {
			PosicionElementoIndice<E> r1 = revisaPosicion(T1.root());
			tam += T1.size();
			ajustaI(r1,vv.getIndice()*2);
		}
		if (!T2.isEmpty()) {
			PosicionElementoIndice<E> r2 = revisaPosicion(T2.root());
			tam += T2.size();
			ajustaI(r2,vv.getIndice()*2+1);
		}
  }
  public void swapElements(Posicion<E> v, Posicion<E> w) throws InvalidPositionException {
    PosicionElementoIndice<E> vv = revisaPosicion(v);
    PosicionElementoIndice<E> ww = revisaPosicion(w);
    E temp = w.elemento();
    ww.setElemento(v.elemento());
    vv.setElemento(temp);
  }
  public void expandExternal(Posicion<E> v, E l, E r) throws InvalidPositionException {
    if (!isExternal(v))
      throw new InvalidPositionException("El nodo no es externo");
    insertLeft(v, l);
    insertRight(v, r);
  }
  public void removeAboveExternal(Posicion<E> v) throws InvalidPositionException {
    if (!isExternal(v))
			throw new InvalidPositionException("El nodo no es externo");
		PosicionElementoIndice<E> vv = revisaPosicion(v);
		A.set(vv.getIndice(), null);
		tam--;
		if (vv == raiz)
			raiz = null;
		else
			remove(A.get(vv.getPadre(A).getIndice()));
  }
  protected PosicionElementoIndice<E> revisaPosicion(Posicion<E> v) throws InvalidPositionException {
		if (v == null || !(v instanceof PosicionElementoIndice))
			throw new InvalidPositionException("La posición no es válida");
		return (PosicionElementoIndice<E>) v;
	}
  protected PosicionElementoIndice<E> creaNodo(E elemento, int i) {	return new PosicionElementoIndice<E>(elemento,i); }

  protected void preordenPosiciones(Posicion<E> v, ListaPosicion<Posicion<E>> pos) throws InvalidPositionException {
		pos.addLast(v);
		if (hasLeft(v))
			preordenPosiciones(left(v), pos);
		if (hasRight(v))
			preordenPosiciones(right(v), pos);
	}
  protected void posicionesEnorden(Posicion<E> v, ListaPosicion<Posicion<E>> pos) throws InvalidPositionException {
		if (hasLeft(v))
			posicionesEnorden(left(v), pos);
		pos.addLast(v);
		if (hasRight(v))
			posicionesEnorden(right(v), pos);
	}
}
