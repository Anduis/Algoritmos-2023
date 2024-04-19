/*
Autor: Andres Anguiano
fecha: 22-9-2020
Objetivo: Calcular el factorial de un n'umero recursivamente
*/
import java.util.Scanner;
public class Main
{
  static int factorial(int x)
  {
    if (x == 0)
    {
      return 1; // Caso base
    }
    else
    {
      return x*factorial(x-1); // Caso recursivo
    }
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(factorial(n));
  }
}
