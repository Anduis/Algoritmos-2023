/*
Autor: Andres Manuel Anguiano Peña
Objetivo: Hacer un programa que haga un rombo de asteriscos.
La entrada será un entero n impar (entre 1 y 51) y la salida el rombo de asteriscos.
*/
import java.util.Scanner;
public class Main
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0 ; i <= n/2 ; ++i)
    {
      for (int j = 0; j != n ; ++j)
      {
        if( j >= (n/2)-i && j <= (n/2)+i )
        {
          System.out.print("*");
        }
        else
        {
          System.out.print(".");
        }
      }
      System.out.println(".");
    }
    for (int i = 1 ; i <= n/2 ; ++i)
    {
      for (int j = 0; j != n ; ++j)
      {
        if( j >= i  && j <= n-i-1 )
        {
          System.out.print("*");
        }
        else
        {
          System.out.print(".");
        }
      }
      System.out.println(".");
    }
  }
}
