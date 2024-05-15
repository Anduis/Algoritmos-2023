import java.util.Scanner;
import java.util.Random;
public class nuevo{
  public static void main(String[] args) {
    int [] personas = {5,10,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100};
    boolean[] estudiados = estudiaGrupos(personas);
    for (boolean x : estudiados ) {
      System.out.println(x);
    }
    /*int[] grupo1 = llenaAleatorio(personas[0]);
    int[] grupo2 = llenaAleatorio(personas[1]);
    int[] grupo3 = llenaAleatorio(personas[2]);
    int[] grupo4 = llenaAleatorio(personas[3]);

    boolean coincidencias1 = revisaFechas(grupo1);
    boolean coincidencias2 = revisaFechas(grupo2);
    boolean coincidencias3 = revisaFechas(grupo3);
    boolean coincidencias4 = revisaFechas(grupo4);

    System.out.println(coincidencias1);
    System.out.println(coincidencias2);
    System.out.println(coincidencias3);
    System.out.println(coincidencias4);*/
  }

  public static int[] llenaAleatorio(int a){//dado un personas[x] devuelve un arreglo con int aleatorios de longitud 5*(x+1)
    Random aleatorio = new Random();
    int[] memoria = new int[a];
    for(int i=0; i<a ; i++){
      memoria[i] =  aleatorio.nextInt(360);
    }
    return memoria;
  }

  public static boolean revisaFechas(int[] arreglo){//revisa si hay al menos dos fechas iguales en el arreglo
    boolean resultado = false;
    for(int i=0;i<arreglo.length;i++){
      int iguales=0;
      for(int j=0;j<arreglo.length;j++){
        if(arreglo[i]==arreglo[j])
        iguales++;
        if (iguales >= 2)
          resultado = true;
      }
    }return resultado;
  }

  public static boolean[] estudiaGrupos(int[] personas){
    boolean[] estudio = new boolean[personas.length];
    for (int i = 0; i < personas.length ; i++) {
      int[] grupo = llenaAleatorio(personas[i]);
      estudio[i] = revisaFechas(grupo);
    }
    return estudio;
  }
}
