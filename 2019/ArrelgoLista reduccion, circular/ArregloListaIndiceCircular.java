/*
Autor: Andres Anguiano 1638975x
Fecha: 10 Mayo 2020
Indicaciones:
Implementar el ADT lista arreglo, en la clase ArregloListaIndiceCircular, usando un arreglo extendible empleado de forma circular,
para que de este modo las inserciones y los borrados al inicio y al final de la lista arreglo se hagan en tiempo constante.
Agregar código que muestre lo solicitado.
*/
public class ArregloListaIndiceCircular<E> implements ListaIndice<E> {
  private E[] A;
  private int N = 16;
  int f = 0; //lugar proximo a ocupar el inicio
  int r = 1; //lugar proximo a ocupar el fin

  public ArregloListaIndiceCircular() { A = (E[]) new Object[N]; }
  public int size(){
    if(f>=r) return (N-f)+r-1;
    else return r-f-1;
  }
  public boolean isEmpty() { return size() == 0; }
  public boolean isFull() { return r==f; }

  public void add(int x, E e) throws IndexOutOfBoundsException {
    revisarIndice(x);
    if (isFull()) {//si esta lleno dobla la capacidad y los acomoda
      N *= 2;
      E[] B =(E[]) new Object[N];
      for (int i = 0 ; i< A.length; i++ ) {
        B[i]=A[(f+1+i)%A.length];
        r=i;
      }
    A = B;
    f=N-1;
    }

    if (x==0) {
      A[f]=e;
      f = (N+f-1)%N;
    }
    else{
      for (int i=r; i!=((f+1+x)%N); i=(N+(i-1))%N)  // desplazar elementos hacia adelante
        A[i] = A[(N+(i-1))%N];
      A[((f+1+x)%N)]=e;
      r=(r+1)%N;
    }
  }
  public E remove(int x)
    throws IndexOutOfBoundsException {
    revisarIndice(x);
    if (x==0) {
      f = (f+1)%N;
      E temp = A[f];
      A[f]=null;
      return temp;
    }
    else {
      E temp = A[(f+1+x)%N];
      A[(f+1+x)%N] = null;
      for (int i=((f+x+1)%N); i!=r; i=(N+(i+1))%N)  // desplazar elementos hacia adelante
        A[i] = A[(i+1)%N];
      r=(r-1)%N;
      return temp;
    }
  }
  protected void revisarIndice(int x)//cuando se emplea un metodo de consulta, o de borrado los indices extremos(vacios), no son validos
    throws IndexOutOfBoundsException {
    if (x<0 || x >= N)  throw new IndexOutOfBoundsException("indice ilegal : " + x);
  }
  public E get(int x)
    throws IndexOutOfBoundsException {
    revisarIndice(x);
    return A[(f+x+1)%N];
  }
  public E set(int x, E e)
    throws IndexOutOfBoundsException {
    revisarIndice(x);
    E temp = A[(f+x+1)%N];
    A[(f+x+1)%N] = e;
    return temp;
  }
  public String toString() {//este metodo acomoda del primero al ultimo
    String s = "[";
    for (int i = r+1; i <= N-1; i++){
      if(A[i-1]!=null && A[i]!=null){ s += ", ";}
      if(A[i]!=null) s += A[i];
    }
    if(A[N-1]!=null && A[0]!=null){ s += ", ";}
    if (N > 0) if (A[0]!=null) s+= A[0];
    for (int i = 1; i <= r-1; i++){
      if(A[i-1]!=null && A[i]!=null){ s += ", ";}
      if(A[i]!=null) s += A[i];
    }
    return s + "]";
  }
  /*
  public String toString() {//este metodo te deja ver los espacios vacios del Arreglo
    String s = "[";
    if (N > 0) s+= A[0];
    for (int i = 1; i <= N-1; i++)
     s += ", " + A[i];
    return s + "]";
  }
  */
  public void estado(String op, Object elemento) {
    System.out.print("Accion :" + op);
    System.out.println(", devuelve: " + elemento);
    System.out.print("En Arreglo Ahora : " + size()+" Capacidad :"+N);
    System.out.println(", Arreglo: " + this);
  }
  public static void main(String[] args) {
    Object o;
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    ArregloListaIndiceCircular<Integer> A = new ArregloListaIndiceCircular<Integer>();
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
    for (int i=0; i<15 ; i++ ) { A.add(4+i,(i*3)/2);}
    A.estado("*en el quinto lugar en adelante agrega 15 numeros*", null);
    for (int i =11; i!=-1 ;i-- ) {  A.remove(A.size()-1);}
    A.estado("*borrar los ultimos 12 elementos*", null);
    o = A.remove(0);
    A.estado("Sale primero", o);
    o = A.remove(3);
    A.estado("Sale el cuarto", o);
    o = A.remove(A.size()-1);
    A.estado("Sale el ultimo", o);
    o = A.get(2);
    A.estado("en el tercer lugar?", o);
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
  }
}
