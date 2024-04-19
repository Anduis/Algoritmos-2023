/*
Autor: Andres Manuel Anguiano Peña
Objetivo: Hacer un programa que haga un cuadrado de asteriscos.
La entrada será un entero n  y la salida el cuadrado de asteriscos.
*/
import java.util.Scanner;
public class Main
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0 ; i != n ; ++i)
    {
      for (int j = 0; j != n ; ++j)
      {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
