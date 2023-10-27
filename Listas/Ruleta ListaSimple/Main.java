/*
Autor: Andres Anguiano
Fecha: 16/10/2023
Indicaciones: Juego de la ruleta con listas circulares
*/

public class Main {
  public static void main(String[] args) {
    int n = 6;
    int m = 3;
    Lista l = new Lista();
    for (int i = 0; i < n; i++) {
      l.agregar(i + 1);
    }
    l.imprime();
    l.ruleta(m);
  }
}

class Lista {
  Nodo primero;
  Nodo ultimo;

  Lista() {
  }

  boolean haySoloUno() {
    return (primero == ultimo);
  }

  void agregar(int x) {
    Nodo nuevo = new Nodo(x);
    if (primero == null) {
      primero = nuevo;
      ultimo = nuevo;
      ultimo.siguiente = primero;
    } else {
      ultimo.siguiente = nuevo;
      nuevo.siguiente = primero;
      ultimo = nuevo;
    }
  }

  void ruleta(int paso) {
    Nodo temp = primero;
    while (!haySoloUno()) {
      for (int i = 0; i < paso - 1; i++) {
        temp = temp.siguiente;
      }
      if (temp.siguiente == primero)
        primero = temp.siguiente.siguiente;
      else if (temp.siguiente == ultimo)
        ultimo = temp;
      System.out.println("elimina a :" + temp.siguiente.valor);
      temp.siguiente = temp.siguiente.siguiente;
    }
    System.out.println(primero.valor);
  }

  void imprime() {
    Nodo temporal = primero;
    boolean dioLaVuelta = false;
    while (!dioLaVuelta) {
      System.out.print(temporal.valor + " ");
      temporal = temporal.siguiente;
      if (temporal == primero)
        dioLaVuelta = true;
    }
    System.out.println();
  }
}

class Nodo {
  int valor;
  Nodo siguiente;

  Nodo(int x) {
    valor = x;
  }
}