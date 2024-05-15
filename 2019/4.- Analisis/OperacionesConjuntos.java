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
    int[]b={0,1,2,3,4,5,6,7};
    int[]c={15,16,17,16,15};
    System.out.print("Son conjuntos Disjuntos?: "+sonDisjuntos(a,b,c));
  }
  public static boolean sonDisjuntos(int[]a,int[]b,int[]c){
    //en cada linea se comenta el numero de veces que se ejecuta una operacion primitiva
    for (int i=0 ; i < a.length ; i++ ){//1+2n+1 = 2n+2
      for (int j=0 ; j < b.length ; j++){//(2n+2)(n) = 2n^2 +2n
        if (b[j]==a[i]){//n*n = n^2
          for (int k=0 ; k < c.length ; k++){//(2n+2)(n^2) = 2n^3 +2n^2
            if (c[k]==a[i]) return false;//n^2 +1
          }
        }
      }
    }
    return true;//+1
  }
  /*
  siendo el peor de los casos en el que se recorren por completo los arreglos
  (esto es si todos los x en 'b' estan tambien en 'a' y ninguno en 'c')
  se tendria un tiempo de ejecución 2n+2 + 2n^2 +2n + n^2 2n^3 +2n^2 + n^2 +1 +1 que es O(n^3)
  justificacion : (2n^3 + 6n^2 + 4n + 4) <= (2+6+4+4)n^3 = cn^3,
  para c=16, cuando n>=1
  */
}
