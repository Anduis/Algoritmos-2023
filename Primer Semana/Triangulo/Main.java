/*
Fecha: 16/08/2023
Autor: Andres Anguiano
Indicaciones: Hacer un triángulo relleno con astericos de altura n
*/

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++)
        System.out.print("*");
      System.out.println();
    }
    sc.close();
  }
}
