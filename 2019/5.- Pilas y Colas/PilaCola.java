/*
Autor: Andres Amguiano 1638975x
fecha: 3 Mayo 2020

Implementar las interfaces Stack y Queue en la clase única PilaCola la cual extiende la clase NodoDeque.
Agregar código que muestre el uso de los métodos de la pila y la cola implementados.
*/
public class PilaCola<E> extends NodoDeque<E> implements Stack<E>, Queue<E>{
  public PilaCola() {
  }
  //Metodos de la interface Stack
  public E top() throws EmptyDequeException{
    return getFirst();
  }
  public E pop() throws EmptyDequeException{
    return removeFirst();
  }
  public void push (E elemento){
    addFirst(elemento);
  }
  //Metodos de la interface Queue
  public E front() throws EmptyDequeException{
    return getLast();
  }
  public void enqueue (E element){
    addLast(element);
  }
  public E dequeue() throws EmptyDequeException{
    return removeLast();
  }
  //
  public String toString() {
    String s = "";
    s += "(";
    if (!isEmpty()) {
      NodoDL p = cabeza.getSig();
      while (p.getElemento() != null) {
        s += p.getElemento() ;
        if (p.getSig().getElemento() != null)
          s += ", ";
        p = p.getSig();
      }
    }
    s += ")";
    return s;
  }
  public static void estado(PilaCola Q, String op, Object elemento) {
    System.out.println("---------------------------------");
    System.out.println(op);
    System.out.println("Regresado : " + elemento);
    String estadoVacio;
    if (Q.isEmpty())
      estadoVacio = "vacia";
    else
      estadoVacio = "no vacia";
    System.out.println("tamanio = " + Q.size() + ", " + estadoVacio);
    System.out.println("PilaCola: " + Q);
  }
  public static void main(String[] args) {
    Object o;
    PilaCola<Integer> A = new PilaCola<Integer>();
    estado (A, "Nueva PilaCola vacia", null);
    A.enqueue(1);
    estado(A,"*al final 1*", null);
    A.push(2);
    estado(A,"*al inicio 2*", null);
    A.enqueue(3);
    estado(A,"*al final 3*", null);
    A.push(4);
    estado(A,"*al inicio 4*", null);
    A.enqueue(5);
    estado(A,"*al final 5*", null);
    A.push(6);
    estado(A,"*al inicio 6*", null);
    A.push(85);
    estado(A,"*al inicio 85*", null);
    o = A.top();
    estado(A,"*al inicio?*", o);
    o = A.front();
    estado(A,"*al fin?*", o);
    o = A.pop();
    estado(A,"Sale el primer", o);
    o = A.dequeue();
    estado(A,"Sale el ultimo", o);
    o = A.dequeue();
    estado(A,"Sale el ultimo", o);
    o = A.pop();
    estado(A,"Sale el primer", o);
    o = A.top();
    estado(A,"*al inicio?*", o);
    o = A.front();
    estado(A,"*al fin?*", o);
  }
}
