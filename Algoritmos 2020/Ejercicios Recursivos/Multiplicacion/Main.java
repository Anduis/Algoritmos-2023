/*
Autor: Andres Anguiano
fecha: 22-9-2020
Objetivo: Multiplicación (en términos de la suma) recursivamente
*/
public class Main{
  static int multi(int x, int y)
  {
    if (y == 1)
    {
      return x; // Caso base
    }
    else
    {
      return x+multi(x,y-1); // Caso recursivo
    }
  }
  public static void main(String[] args)
  {
    System.out.println("18 por 19: "+ multi(18,29));
  }
}
