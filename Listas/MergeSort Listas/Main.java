/*
Autor: Andres Anguiano
Fecha: 23/10/2023
Indicaciones: Implementacion de algoritmo O(nlogn) Merge con listas
*/

public class Main {
  public static void main(String[] args) {
    Nodo primero = null;
    for (int i = 0; i < 8; i++)
      primero = new Nodo((int) (Math.random() * 100), primero);
    imprime(primero);
    primero = mergeSort(primero);
    imprime(primero);
  }

  static Nodo merge(Nodo a, Nodo b) {
    if (a == null)
      return b;
    if (b == null)
      return a;

    if (a.valor <= b.valor) {
      a.siguiente = merge(a.siguiente, b);
      return a;
    } else {
      b.siguiente = merge(a, b.siguiente);
      return b;
    }
  }

  static Nodo mergeSort(Nodo inicio) {
    if (inicio == null || inicio.siguiente == null)
      return inicio;
    Nodo temp = medio(inicio);
    Nodo med = temp.siguiente;
    temp.siguiente = null;
    Nodo izq = mergeSort(inicio);
    Nodo der = mergeSort(med);
    return merge(izq, der);
  }

  static Nodo medio(Nodo inicio) {// devuelve el nodo en el medio
    if (inicio == null)
      return inicio;
    Nodo paso = inicio;
    Nodo salto = inicio;
    while (salto.siguiente != null && salto.siguiente.siguiente != null) {
      paso = paso.siguiente;
      salto = salto.siguiente.siguiente;
    }
    return paso;
  }

  public static void imprime(Nodo x) {
    Nodo temporal = x;
    while (temporal != null) {
      System.out.print(temporal.valor + " ");
      temporal = temporal.siguiente;
    }
    System.out.println();
  }
}

class Nodo {
  int valor;
  Nodo siguiente;

  Nodo(int valor, Nodo siguiente) {
    this.valor = valor;
    this.siguiente = siguiente;
  }
}
