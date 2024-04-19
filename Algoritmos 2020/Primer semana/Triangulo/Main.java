/*
Autor: Andres Manuel Anguiano Peña
Objetivo: Hacer un programa que haga un triángulo de asteriscos sin relleno.
La entrada será un entero 1 <= n <=100 y la salida el contorno de un triángulo de asteriscos.
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
      for (int j = 0; j != i+1 ; ++j)
      {
        if (j==0 || j==i || i==n-1)
        {
          System.out.print("*");
        }
        else
        {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
