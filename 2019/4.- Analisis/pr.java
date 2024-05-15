/*
**Suponer que se dan tres conjuntos, A, B, y C,
**estando los conjuntos guardados en tres arreglos enteros diferentes, a, b, y c, respectivamentes.
**Escribir un método Java simple que determine si los tres conjuntos son disjuntos,
**esto es, si no hay un elemento x tal que x ∈ A, x ∈ B, y x ∈ C.
**Poner el método en la clase OperacionesConjuntos.
**Indicar, y justificar, el tiempo de ejecución en el peor caso agregándolo como un comentario en el código.
*/
public class OperacionesConjuntos{
  public static void main(String[] args) {
    //todo conjunto ingresado deberá contener una unica representacion de cada uno de sus elementos
    //(no ingresar repetidos)
    int [] a ={1,2,3,4,5};
    int [] b ={6,7,8,9,0};
    int [] c ={2,4,6,8,0};
    int [] abc = juntaConjuntos(a,b,c);
    System.out.println("los conjuntos son Disconjuntos? :\n"+sonDisconjuntos(abc));
  }

  public static int[] juntaConjuntos(int[]a, int[]b, int[]c){
    int[] resultado = new int[a.length+b.length+c.length];
    for (int i=0 ; i<resultado.length ; i++ ) {
      if (i<a.length) resultado[i]=a[i];
      if (i>a.length-1 && i<a.length+b.length) resultado[i]=b[i-(a.length)];
      if (i>(a.length+b.length)-1) resultado[i]=c[i-(a.length+b.length)];
    }
    return resultado;
  }
  public static boolean sonDisconjuntos(int[]a, int[]b, int[]c){
    boolean resultado = true;
    for(int i = 0 ; i < a.length ; i++){
      int iguales = 0;
      for(int j = 0 ; j < arreglo.length; j++){
        if(a[i] == b[j]) iguales++;
      }
    }
  }
  /*
  public static boolean sonDisconjuntos(int[] arreglo){
}
    boolean resultado = true;
    for(int i = 0 ; i < arreglo.length ; i++){
      int iguales = 0;
      for(int j = 0 ; j < arreglo.length; j++){
        if(arreglo[i] == arreglo[j]) iguales++;
      }
      if (iguales >= 3) resultado = false;
    }return resultado;
  }
  */
}
