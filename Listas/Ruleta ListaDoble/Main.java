/*
Autor: Jaime Quiñones
Fecha: 18/10/2023
Indicaciones: Juego de la ruleta con listas dobles circulares
*/

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tam = sc.nextInt();
    int salto = sc.nextInt();
    int[] ori = new int[tam];
    for (int i = 0; i < tam - 1; i++)
      ori[i] = sc.nextInt();
    Lista lista = new Lista();
    for (int i = 1; i <= tam; i++)
      lista.add(i);
    lista.ruleta(tam, salto, ori);
    sc.close();
  }
}

class Lista {
  Nodo inicial;
  Nodo ultimo;

  public Lista() {
  }

  public Lista(Nodo nodo) {
    inicial = nodo;
    ultimo = nodo;
    inicial.sig = ultimo;
    ultimo.sig = inicial;
    inicial.ant = ultimo;
    ultimo.ant = inicial;
  }

  public void add(int valor) {
    Nodo nuevo = new Nodo(valor);
    if (inicial == null) {
      inicial = nuevo;
      ultimo = nuevo;
      inicial.sig = ultimo;
      ultimo.sig = inicial;
      inicial.ant = ultimo;
      ultimo.ant = inicial;
    } else {
      ultimo.sig = nuevo;
      inicial.ant = nuevo;
      nuevo.ant = ultimo;
      nuevo.sig = inicial;
      ultimo = nuevo;
    }
  }

  public void ruleta(int tamaño, int salto, int[] orientacion) {
    Nodo actual = inicial;
    int pos = 0;
    while (tamaño > 1) {
      if (orientacion[pos] == 0) {
        for (int i = 1; i < salto; i++)
          actual = actual.sig;
        actual.ant.sig = actual.sig;
        actual.sig.ant = actual.ant;
        tamaño = tamaño - 1;
        System.out.println("Se eliminó a: " + actual.valor);
        if (actual == inicial)
          inicial = actual.sig;
        else if (actual == ultimo)
          ultimo = actual.ant;
        actual = actual.sig;
      } else {
        for (int i = 1; i < salto; i++)
          actual = actual.ant;
        actual.ant.sig = actual.sig;
        actual.sig.ant = actual.ant;
        tamaño = tamaño - 1;
        System.out.println("Se eliminó a: " + actual.valor);
        if (actual == inicial)
          inicial = actual.sig;
        else if (actual == ultimo)
          ultimo = actual.ant;
        actual = actual.ant;
      }
      pos++;
    }

    System.out.println("Nodo sobreviviente: " + inicial.valor);
  }
}

class Nodo {
  int valor;
  Nodo sig;
  Nodo ant;

  public Nodo(int valor) {
    this.valor = valor;
  }
}