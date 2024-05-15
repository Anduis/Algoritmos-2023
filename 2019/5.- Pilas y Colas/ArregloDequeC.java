/*
Autor: Andres Anguiano 1638975x
Fecha: 2 Mayo 2020

Escribir la clase ArregloDequeC, la cual implementa el ADT deque con capacidad limitada,
usando un arreglo en forma circular.
Agregar código para mostrar su uso
*/
public class ArregloDequeC<E> implements Deque<E> {
  int f = 0; //lugar proximo a ocupar el inicio del deque
  int r = 1; //lugar proximo a ocupar el fin del deque
  public static int N = 100;
  protected E[] A;

  public ArregloDequeC() {
    this(N);
  }
  public ArregloDequeC(int x) {
    N = x;
    A = (E[]) new Object[N];
  }
  public int size(){
    if(f>=r) return (N-f)+r-1;
    else return r-f-1;
  }
  public boolean isEmpty() {
    return (size()==0);
  }
  public boolean isFull(){
    return r==f;
  }
  public E getFirst() throws EmptyDequeException {
    if (isEmpty()) throw new EmptyDequeException ("Deque esta vacia.");
    E e;
    if (f==N-1) e = A[0];
    else e = A[f+1];
    return e;
  }
  public E getLast() throws EmptyDequeException {
    if (isEmpty()) throw new EmptyDequeException ("Deque esta vacia.");
    E e;
    if (r==0) e=A[N-1];
    else e = A[(r-1)];
    return e;
  }
  public void addFirst(E e) throws FullDequeException{
    if (isFull()) throw new FullDequeException ("Deque esta llena.");
    A[f]=e;
    if (f==0) f=N-1;
    else f = (f-1);
  }
  public void addLast(E e) throws FullDequeException{
    if (isFull()) throw new FullDequeException ("Deque esta llena.");
    A[r]=e;
    r = (r+1);
    r = r%N;
  }
  public E removeFirst() throws EmptyDequeException {
    if (isEmpty()) throw new EmptyDequeException ("Deque esta vacia.");
    f = (f+1)%N;
    E e = A[f];
    A[f] = null;
    return e;
  }
  public E removeLast() throws EmptyDequeException {
    if (isEmpty()) throw new EmptyDequeException ("Deque esta vacia.");
    if (r==0) r=N-1;
    else r = (r-1);
    E e = A[r];
    A[r] = null;
    return e;
  }
  /*
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
  */
  public String toString() {//este metodo te deja ver los espacios vacios del Arreglo
    String s = "[";
    if (N > 0) s+= A[0];
    for (int i = 1; i <= N-1; i++)
     s += ", " + A[i];
    return s + "]";
  }
  public void addAt(int i, E e)
    throws FullDequeException {
      if (isFull()) throw new FullDequeException ("Deque esta llena.");
    for (int k=size()-1; k>=i; k--)  // desplazar elementos hacia adelante
      A[k+1] = A[k];
    A[(f+i)%N] = e;
    r++;
  }
  public void removeAt(int i, E e)
    throws FullDequeException {
      if (isFull()) throw new FullDequeException ("Deque esta llena.");
    for (int k=size()-1; k>=i; k--)  // desplazar elementos hacia adelante
      A[k+1] = A[k];
    A[(f+i)%N] = e;
    r++;
    E temp = A[i];
    for (int i=i; i<tam-1; i++)
    A[i] = A[i+1];
    r--;
    return temp;
  }
  public void estado(String op, Object elemento) {
    System.out.print("Accion :" + op);
    System.out.println(", devuelve: " + elemento);
    System.out.print("En deque Ahora : " + size());
    System.out.print(", esta vacio? " + isEmpty());
    System.out.println(", Deque: " + "f: "+ f + "r: "+ r + this);
  }
  public static void main(String[] args) {
    Object o;
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    ArregloDequeC<Integer> A = new ArregloDequeC<Integer>(8);
    A.estado("Nueva Deque de Integers", null);
    A.addLast(1);
    A.estado("*al final 1*", null);
    A.addFirst(2);
    A.estado("*al inicio 2*", null);
    A.addLast(3);
    A.estado("*al final 3*", null);
    A.addFirst(4);
    A.estado("*al inicio 4*", null);
    A.addLast(5);
    A.estado("*al final 5*", null);
    A.addFirst(6);
    A.estado("*al inicio 6*", null);
    A.addFirst(85);
    A.estado("*al inicio 85*", null);
    o = A.getFirst();
    A.estado("*al inicio?*", o);
    o = A.getLast();
    A.estado("*al fin?*", o);
    o = A.removeFirst();
    A.estado("Sale el primer", o);
    o = A.removeLast();
    A.estado("Sale el ultimo", o);
    o = A.removeLast();
    A.estado("Sale el ultimo", o);
    o = A.removeFirst();
    A.addAt(3,8);
    A.estado("acomada a 8 en el segundo", null);
    A.estado("Sale el primer", o);
    o = A.getFirst();
    A.estado("*al inicio?*", o);
    o = A.getLast();
    A.estado("*al fin?*", o);
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
  }
}
