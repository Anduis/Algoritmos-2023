
/*
Autor: Andres Anguiano
Fecha: 30/08/2023
Invertir una cadena dada
*/
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String cadena = sc.nextLine();
    imprimeInverso(cadena, 0);
    System.out.println();
    sc.close();
  }

  static void imprimeInverso(String s, int i) {
    if (i == s.length())
      return;
    else {
      imprimeInverso(s, i + 1);
      System.out.print(s.charAt(i));
    }
  }

}
