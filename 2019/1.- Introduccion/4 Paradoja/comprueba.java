import java.util.Random;
public class comprueba{
  public static void main(String[] args) {
    int [] arreglo = llenaAleatorio(5);
    for (int x:arreglo ) {
      System.out.println(x);
    }
    boolean primero = revisa(arreglo);
    System.out.println(primero);

  }

  public static int[] llenaAleatorio(int a){
    Random aleatorio = new Random();
    int[] memoria = new int[a];
    for(int i=0; i<a ; i++){
      memoria[i] =  aleatorio.nextInt(360);
    }
    return memoria;
  }

  public static boolean revisa(int[] arreglo){
    boolean resultado = false;
    for(int i=0;i<arreglo.length;i++)
    {int iguales=0;
      for(int j=0;j<arreglo.length;j++)
        {
          if(arreglo[i]==arreglo[j])
          iguales++;
          if (iguales >= 2)
            resultado = true;
        }System.out.println(iguales);
    }return resultado;
  }
}
