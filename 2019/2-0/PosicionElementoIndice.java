/*Autor: Andres Anguiano
Implementar el ADT árbol binario en la clase ArbolBinarioArreglo usando una lista arreglo.*/
public class PosicionElementoIndice<E> implements posicion<E>{
  private E elemento;
  private int i;
  public PosicionElementoIndice(E elemento, int i) {
    setElemento(elemento);
    setIndice(i);
  }
  public void setElemento(E o) { elemento=o; }
  public E elemento() { return elemento; }
  public void setIndice(int x) { i=x; }
  public void getIndice() { return i; }

  public PosicionElementoIndice<E> getPadre(ListaIndice<PosicionElementoIndice<E>> A)	throws IndexOutOfBoundsException{
    return A.get(i/2);
  }
  public PosicionElementoIndice<E> getIzq(ListaIndice<PosicionElementoIndice<E>> A) throws IndexOutOfBoundsException{
		if(i*2< A.size())	return A.get(i*2);
		else return null;
	}
	public PosicionElementoIndice<E> getDer(ListaIndice<PosicionElementoIndice<E>> A) throws IndexOutOfBoundsException{
		if(i*2+1< A.size()) return A.get(i*2+1);
		else return null;
	}
	public void guarda(ListaIndice<PosicionElementoIndice<E>> A){
		if(i<A.size()){
			A.set(i, this);
		}else{
			while(i>A.size())
				A.add(A.size(), null);
			A.add(i, this);
		}
	}
}
