/*
Autor: Andres Anguiano
fecha: 22-9-2020
Objetivo: Convertir un numero de decimal a binario:  Entrada un numero, salida numero binario.
nota: el decimal x ingresado debera ser x < 2^19
*/
import java.util.Scanner;
public class Main
{
  public static long hazBin(int x)
  {
    if (x==0)
    {
      return 0;
    }
    else
    {
      return (x%2 + 10*hazBin(x/2));
    }
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int x = scan.nextInt();
    System.out.print(hazBin(x));
  }
}
