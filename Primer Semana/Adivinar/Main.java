/*
Fecha: 16/08/2023
Autor: Andres Anguiano
Indicaciones: Adivinar el núm. ayudando al usuario
*/

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean isSecret = true;
    int mySecretNumber = 8;
    while (isSecret) {
      System.out.print("#?");
      int usrGuess = sc.nextInt();
      if (usrGuess < mySecretNumber)
        System.out.println(">mayor");
      else if (usrGuess > mySecretNumber)
        System.out.println(">menor");
      else {
        System.out.println(">igual");
        isSecret = false;
      }
    }
    sc.close();
  }
}
