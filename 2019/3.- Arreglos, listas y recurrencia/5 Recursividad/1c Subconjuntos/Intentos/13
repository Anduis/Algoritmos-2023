/*
*Autor: Andres Anguiano 1638975x
Fecha: 8 Abril 2020
**INDICACIONES DADAS:
**Aplicación Subconjuntos la cual genera todos los subconjuntos de un conjuntos de n elementos
**(sin repetir ningún subconjunto)
*/
public class Subconjuntos{
  public static void main(String[] args) {
    String[] conjunto ={"a","b","c","d","e"};
    subconjuntosCon(0,conjunto,0);

  }

  public static void subconjuntosCon(int x, String[] arreglo, int contador){
    String[] temp = new String[];
    int i = contador;
    if (i==0) System.out.println(arreglo[i]);
    if (arreglo[x]!=arreglo[i]) System.out.println(arreglo[x]+arreglo[i]);
    i++;
    if (i!=arreglo.length) subconjuntosCon(x,arreglo,i);
  }
  public static int totalSubconjuntos(int x){
    int base = 2;
    for (int i = 1; i < x ; i++ ) {
      base *= 2;
    }
    return base;
  }
}
