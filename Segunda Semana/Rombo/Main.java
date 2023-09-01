/*
Autor: Andres Anguiano
Fecha: 23/08/2023
Indicaciones: Hacer un rombo con asteriscos de tamaño n (preferible impar)
*/

import java.util.Scanner;
import java.lang.Math;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    printFig(n);
    sc.close();
  }

  static void printFig(int x) {
    for (int i = 0; i < x; i++) {
      for (int j = Math.abs((x / 2) - i); j > 0; j--)
        System.out.print(" ");
      for (int j = x - (Math.abs((x / 2) - i) * 2); j > 0; j--)
        System.out.print("*");
      System.out.println();
    }
  }
}