/*
Autor: Andres Anguiano
fecha: 22-9-2020
Objetivo: Encontrar el minimo comun multiplo: Entrada: dos numeros x, y y, salida; el minimo comun multiplo. Ejemplo Entrada: 6 4  salida: 2
nota: por whatsapp se acordo que en lugar de buscarse el mcm se buscara el mcd
*/
import java.util.Scanner;
public class Main
{
  public static int mcd(int x, int y)
  {
    if (x == 0)
    {
      return y;
    }
    else
    {
      return mcd(y%x, x);
    }
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    scan.tokens();
    int x = scan.nextInt();
    int y = scan.nextInt();
    System.out.print(mcd(x,y));
  }
}
