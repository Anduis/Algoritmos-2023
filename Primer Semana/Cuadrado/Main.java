/*
Fecha: 16/08/2023
Autor: Andres Anguiano
Indicaciones: Hacer un cuadrado relleno de asteriscos de tamaño n
*/

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        System.out.print("*");
      System.out.println();
    }
    sc.close();
  }
}