/*
Autor: Andres Anguiano
Fecha: 23/08/2023
Indicaciones: Hacer una cruz con asteriscos de tamaño n (preferible impar)
*/

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    printFig(n);
    sc.close();
  }

  static void printFig(int x) {
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < x; j++)
        if (i == j || j == (x - 1) - i)
          System.out.print("*");
        else
          System.out.print(" ");
      System.out.println();
    }
  }
}