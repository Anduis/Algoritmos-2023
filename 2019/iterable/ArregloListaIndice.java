/*
Autor: Andres Anguiano 1638975x
Fecha: 17 Mayo 2020
Modificar la interfaz ListaIndice para que extienda a la interfaz Iterable
y así la implementación de la clase ArregloListaIndice realiza el método iterator().
El método iterator() devuelve un objeto del tipo ElementoIteradorIndice,
el cual implementa los métodos next() y hasNext(). Agregar código que muestre el uso del iterador.
*/
import java.util.Iterator;

public class ArregloListaIndice<E> implements ListaIndice<E> {
  private E[] A;
  private int N = 16;
  private int tam = 0;
  public ArregloListaIndice() {
    A = (E[]) new Object[N];
  }
  public Iterator<E> iterator() { return new ElementoIteradorIndice<E>(this); }//y así la implementación de la clase ArregloListaIndice realiza el método iterator().
  //El método iterator() devuelve un objeto del tipo ElementoIteradorIndice,
  public static <E> String toString(ListaIndice<E> l) {// Agregar código que muestre el uso del iterador.
    Iterator<E> it = l.iterator();
    String s = "[";
    while (it.hasNext()) {
      s += it.next();
      if (it.hasNext()) s += ", ";
      }
    s += "]";
    return s;
  }

  public String toString() {
    return toString(this);
  }

  public void add(int r, E e)
    throws IndexOutOfBoundsException {
    revisarIndice(r, size() + 1);
    for (int i=tam-1; i>=r; i--)
      A[i+1] = A[i];
    A[r] = e;
    tam++;
  }

  public E remove(int r)
    throws IndexOutOfBoundsException {
    revisarIndice(r, size());
    E temp = A[r];
    for (int i=r; i<tam-1; i++)
    A[i] = A[i+1];
    tam--;
    ajustarN();
    return temp;
  }

  protected void revisarIndice(int r, int n)
    throws IndexOutOfBoundsException {
    if (r < 0 || r >= n)
      throw new IndexOutOfBoundsException("indice ilegal : " + r);
    ajustarN();
  }
  protected void ajustarN(){
    if (tam == N) {
      N *= 2;
      E[] B =(E[]) new Object[N];
      for (int i=0; i<tam; i++)
        B[i] = A[i];
      A = B;
    }
    if (tam <= N/4) {
      N /= 2;
      E[] B =(E[]) new Object[N];
      for (int i=0; i<tam; i++)
      B[i] = A[i];
      A = B;
    }
  }

  public int size() {
    return tam;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public E get(int r)
    throws IndexOutOfBoundsException {
    revisarIndice(r, size());
    return A[r];
  }

  public E set(int r, E e)
    throws IndexOutOfBoundsException {
    revisarIndice(r, size());
    E temp = A[r];
    A[r] = e;
    return temp;
  }

  public void estado(String op, Object elemento) {
    System.out.print("Accion :" + op);
    System.out.println(", devuelve: " + elemento);
    System.out.print("En Arreglo Ahora : " + size()+" Capacidad :"+N);
    System.out.println(", Arreglo: " + toString());
  }

  public static void main(String[] args) {
    Object o;
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    ArregloListaIndice<Integer> A = new ArregloListaIndice<Integer>();
    A.estado("Nuevo ArregloLista de Integers", null);
    A.add(A.size(),7);
    A.estado("*al final 7*", null);
    A.add(A.size(),2);
    A.estado("*al final 2*", null);
    o = A.remove(A.size()-1);
    A.estado("Sale ultimo", o);
    A.add(A.size(),9);
    A.estado("*al final 9*", null);
    A.add(A.size(),11);
    A.estado("*al final 11*", null);
    A.add(0,3);
    A.estado("*al inicio 3*", null);
    A.add(3,4);
    A.estado("*al cuarto lugar 4*", null);
    A.add(0,71);
    A.estado("*al inicio 71*", null);
    o= A.get(4);
    A.set(4,82);
    A.estado("*cambiar el quinto ahora: 82, antes: ", o);
    A.add(2,0);
    A.estado("*al tercer lugar 0*", null);
    for (int i=0; i<15 ; i++ ) {
      A.add(4+i,(i*3)/2);
    }
    A.estado("*en el quinto lugar en adelante agrega 15 numeros*", null);
    for (int i =11; i!=-1 ;i-- ) {
      A.remove(A.size()-1);
    }
    A.estado("*borrar los ultimos 12 elementos*", null);
    o = A.remove(0);
    A.estado("Sale primero", o);
    o = A.remove(3);
    A.estado("Sale el cuarto", o);
    o = A.get(2);
    A.estado("en el tercer lugar?", o);
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    Integer total=0;
    for (Iterator<Integer> it = A.iterator(); it.hasNext() ; ) {// Agregar código que muestre el uso del iterador.
      Integer x =it.next();
      total += x;
    }
    System.out.println("la suma de todos los valores en el Arreglo es :"+ total);
  }
}
