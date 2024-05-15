/*
*Autor: Andres Anguiano 1638975x
Fecha: 27 Abril 2020
Escribir la clase ArregloQueue la cual implementa los métodos de la interfaz Queue.
Incluir en esta clase ejemplos del uso de esta clase además de métodos auxiliares,
como se hizo en la clase Arreglo.
*/
public class ArregloQueue<E> implements Queue<E> {
  int r = 0;
  int f = 0;
  public static int N = 5;
  protected E[] Q;
  public ArregloQueue() {
    this(N);
  }
  public ArregloQueue(int x) {
    N = x;
    Q = (E[]) new Object[N];
  }
  public String toString() {
    String s = "[";
    if (N > 0) if (Q[0]!=null) s+= Q[0];
    for (int i = 1; i <= N-1; i++){
      if(Q[i-1]!=null && Q[i]!=null){ s += ", ";}
      if(Q[i]!=null) s += Q[i];
    }
    return s + "]";
  }
  public void estado(String op, Object elemento) {
    System.out.print("Accion :" + op);   // imprime esta operación
    System.out.println(", devuelve: " + elemento); // que fue regresado
    System.out.print("En cola Ahora : " + size());
    System.out.print(", esta vacio? " + isEmpty());
    System.out.println(", cola: " + this);       // contenido de la pila
  }

  public int size(){
    return (N-f+r)%N;
  }
  public boolean isEmpty(){
    return (f==r);
  }
  public E front() throws EmptyQueueException{
    if (isEmpty()) throw new EmptyQueueException ("La cola esta vacia.");
    E e = Q[f];
    return e;
  }
  public void enqueue(E e) throws FullQueueException{
    if (size()==N-1) throw new FullQueueException ("La cola esta llena.");
    Q[r]=e;
    r = (r+1);
    r = r%N;
  }
  public E dequeue () throws EmptyQueueException {
    if (isEmpty()) throw new EmptyQueueException ("La cola esta vacia.");
    E e = Q[f];
    Q[f] = null;
    f = (f+1);
    f = f%N;
    return e;
  }
  public static void main(String[] args) {
    Object o;
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    ArregloQueue<Integer> A = new ArregloQueue<Integer>();
    A.estado("Nueva cola de Integers", null);
    A.enqueue(7);
    A.estado("*Se forma 7*", null);
    o = A.dequeue();
    A.estado("Sale", o);
    A.enqueue(9);
    A.estado("*Se forma 9*", null);
    A.enqueue(11);
    A.estado("*Se forma 11*", null);
    A.enqueue(3);
    A.estado("*Se forma 3*", null);
    o = A.dequeue();
    A.estado("Sale", o);
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    ArregloQueue<String> B = new ArregloQueue<String>();
    B.estado("Nueva cola de Strintgs", null);
    B.enqueue("Martin");
    B.estado("*se forma \"Martin\"*", null);
    B.enqueue("Inventado");
    B.estado("*se forma \"Inventado\"*", null);
    B.enqueue("Paco");
    B.estado("*se forma \"Paco\"*", null);
    B.enqueue("Pepe");
    B.estado("*se forma \"Pepe\"*", null);
    o = B.dequeue();
    B.estado("Sale", o);
    B.enqueue("Juan");
    B.estado("*se forma \"Juan\"*", null);
  }
}
