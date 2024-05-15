public class ArbolBinarioArreglo<E> implements ArbolBinario<E>{
  protected PosicionElementoIndice<E> raiz;
  protected ListaIndice<PosicionElementoIndice> A = new ArregloListaIndice<PosicionElementoIndice>();
  protected int tam = A.size();

  public ArbolBinarioArreglo() {
  }
  //metodos interfaz ArbolBinario
  public Posicion<E> left(Posicion<E> v) throws InvalidPositionException, BoundaryViolationException{
    PosicionAB<E> vv = revisaPosicion(v);
    if ( enArray(vv.getIzq()) == null)
      throw new BoundaryViolationException("Sin hijo izquierdo");
    return enArray(vv.getIzq());
  }
  public Posicion<E> right(Posicion<E> v) throws InvalidPositionException, BoundaryViolationException{
    PosicionAB<E> vv = revisaPosicion(v);
    if ( enArray(vv.getDer()) == null)
      throw new BoundaryViolationException("Sin hijo derecho");
    return enArray(vv.getDer())
  }
  public boolean hasLeft(Posicion<E> v) throws InvalidPositionException{
    PosicionAB<E> vv = revisaPosicion(v);
    return (enArray(vv.getIzq()) != null);
  }
  public boolean hasRight(Posicion<E> v) throws InvalidPositionException{
    PosicionAB<E> vv = revisaPosicion(v);
    return (enArray(vv.getDer()) != null);
  }
  //metodos interfaz Tree
  public int size(){ return tam; }
  public boolean isEmpty(){ return (tam==0); }
  public Iterator<E> iterator(){
  }
  public Iterable<Posicion<E>> positions(){

  }
  public E replace(Posicion<E> v, E o) throws InvalidPositionException{
    PosicionAB<E> vv = revisaPosicion(v);
    E temp = enArray(vv).elemento();
    vv.setElemento(o);
    enArray(vv).setElemento(o);
    return temp;
  }
  public Posicion<E> root() throws EmptyTreeException{
    return enArray(1);
  }
  public Posicion<E> parent(Posicion<E> v) throws InvalidPositionException, BoundaryViolationException{
    PosicionAB<E> vv = revisaPosicion(v);
    Posicion<E> posPadre = vv.getPadre();
    if (enArray(posPadre) == null)
      throw new BoundaryViolationException("Sin padre");
    return enArray(posPadre);
  }
  public Iterable<Posicion<E>> children(Posicion<E> v) throws InvalidPositionException{
  }
  public boolean isInternal(Posicion<E> v) throws InvalidPositionException{
    revisaPosicion(v);
    return (hasLeft(v) || hasRight(v));
  }
  public boolean isExternal(Posicion<E> v) throws InvalidPositionException{ return !isInternal(v); }
  public boolean isRoot(Posicion<E> v) throws InvalidPositionException{
    revisaPosicion(v);
    return (v.getIndice()==1)
  }

  // Métodos adicionales accesores
  public Posicion<E> sibling(Posicion<E> v)
  throws InvalidPositionException, BoundaryViolationException {}
  // Métodos adicionales de actualización
  public Posicion<E> addRoot(E e) throws NonEmptyTreeException {
    if(!isEmpty())
      throw new NonEmptyTreeException("El árbol ya tiene raíz");
    raiz = new PosicionElementoIndice(e,1);
    hallarFamilia(raiz);
    return raiz;
  }
  public Posicion<E> insertLeft(Posicion<E> v, E e) throws InvalidPositionException {
    PosicionAB<E> vv = revisaPosicion(v);
    Posicion<E> posIzq = vv.getIzq();
    if (enArray(posIzq) != null)
      throw new InvalidPositionException("El nodo ya tiene hijo izquierdo");
    posIzq = new PosicionElementoIndice(e, posIzq.getIndice());
    hallarFamilia(posIzq);
    hallarFamilia(v);
    return posIzq;
  }
  public Posicion<E>  insertRight(Posicion<E> v, E e) throws InvalidPositionException {
    PosicionAB<E> vv = revisaPosicion(v);
    Posicion<E> posDer = vv.getDer();
    if (enArray(posDer) != null)
      throw new InvalidPositionException("El nodo ya tiene hijo derecho");
    posDer = new PosicionElementoIndice(e, posDer.getIndice());
    hallarFamilia(posDer);
    hallarFamilia(v);
    return posDer;
  }
  public void hallarFamilia(Posicion<E> v){//para mantener acutalizadas las relaciones tiene que realizarce despues de cada cambio
    if(enArray(v.getPadre())!=null)
      v.setPadre(enArray(v.getPadre()));
    if(enArray(v.getIzq())!=null)
      v.setIzq(enArray(v.getIzq()));
    if(enArray(v.getDer())!=null)
      v.setDer(enArray(v.getDer()));
    //para actualización del arreglo
    if(enArray(v)!=null)
      A.set(v.getIndice(),v)
    if(enArray(v)==null)
      A.add(v.getIndice(),v)
  }
  public E remove(Posicion<E> v) throws InvalidPositionException {
    revisaPosicion(v);
    int i=v.getIndice();
    while(hasLeft(v)||hasRight(v)){
      A.remove
    }
  }
  public void attach(Posicion<E> v, ArbolBinario<E> T1, ArbolBinario<E> T2) throws InvalidPositionException {}
  public void swapElements(Posicion<E> v, Posicion<E> w) throws InvalidPositionException {}
  public void expandExternal(Posicion<E> v, E l, E r) throws InvalidPositionException {}
  public void removeAboveExternal(Posicion<E> v) throws InvalidPositionException {}
  // Métodos auxiliares
  /** Si v es un nodo de un árbol binario, convertir a PosicionAB,
    * si no lanzar una excepción */
  protected PosicionElementoIndice<E> revisaPosicion(Posicion<E> v) throws InvalidPositionException {
    if (enArray(v) == null)
      throw new InvalidPositionException("La posición no es válida");
    return (PosicionElementoIndice<E>) v;
  }
  public Posicion<E> enArray(Posicion<E> v){ return A.get(v.getIndice()); }//devuelve posicion guardada en arreglo, solo se guarda ahi si tiene elemento
}
