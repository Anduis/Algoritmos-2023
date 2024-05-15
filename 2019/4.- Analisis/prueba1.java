/*
*Autor: Andres Anguiano 1638975x
*fecha: 18 Abril 2020
**INDICACIONES DADAS:
**Suponer que se dan tres conjuntos, A, B, y C,
**estando los conjuntos guardados en tres arreglos enteros diferentes, a, b, y c, respectivamentes.
**Escribir un método Java simple que determine si los tres conjuntos son disjuntos,
**esto es, si no hay un elemento x tal que x ∈ A, x ∈ B, y x ∈ C.
**Poner el método en la clase OperacionesConjuntos.
**Indicar, y justificar, el tiempo de ejecución en el peor caso agregándolo como un comentario en el código.
*/
public class OperacionesConjuntos{
  public static void main(String[] args) {
    int[]a={0,1,2,3,4,5,6,7,8,9,10};
    int[]b={2,4,6,8,10};
    int[]c={0,1,3,5,7,9,11};
    System.out.println("Son conjuntos Disjuntos: "+sonDisjuntos(a,b,c));
  }
  public static boolean estaEn(int conjunto[], int elemento){
    for (int i=0 ; i < conjunto.length ; i++) if (conjunto[i]==elemento) return true;
    return false;
  }
  public static boolean sonDisjuntos(int[]a,int[]b,int[]c){
    for (int i=0 ; i < a.length ; i++ ){
      if (estaEn(b,a[i])){
        if (estaEn(c,a[i])) return false;
      }
    }
    return true;
  }
}
