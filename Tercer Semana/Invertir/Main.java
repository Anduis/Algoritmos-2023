/*
Autor: Andres Anguiano
Fecha: 30/08/2023
Indicaciones: Invertir una cadena dada
*/

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String cadena = sc.nextLine();
    printBackwards(cadena, 0);
    System.out.println();
    sc.close();
  }

  static void printBackwards(String s, int i) {
    if (i == s.length())
      return;
    printBackwards(s, i + 1);
    System.out.print(s.charAt(i));
  }

}
