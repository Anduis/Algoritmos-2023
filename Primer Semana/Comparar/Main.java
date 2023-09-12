/*
Fecha: 16/08/2023
Autor: Andres Anguiano
Indicaciones: Comparar 3 números y decir en que orden están
*/

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = "";
    int x = sc.nextInt();
    int y = sc.nextInt();
    int z = sc.nextInt();
    if (x <= y && x <= z) {
      if (y <= z)
        s = x + " " + y + " " + z;
      else
        s = x + " " + z + " " + y;
    } else if (y <= x && y <= z) {
      if (x <= z)
        s = y + " " + x + " " + z;
      else
        s = y + " " + z + " " + x;
    } else if (z <= x && z <= y) {
      if (x <= y)
        s = z + " " + x + " " + y;
      else
        s = z + " " + y + " " + x;
    }
    System.out.println(s);
    sc.close();
  }
}
