/*
*Autor: Andres Anguiano
*fecha: 09 Marzo 2020 / 11 Marzo 2020
*
*La paradoja del cumpleaños dice que de un conjunto de 23 personas, hay una probabilidad de 50.7% de que al menos dos personas de ellas cumplan años el mismo día.
*Diseñar la aplicación PruebaParadoja para validar esta paradoja, mediante una serie de experimentos,
*considerando los siguientes tamaños n para el conjunto de personas n = 5, 10, 15, 20, ..., 100.
*Para incrementar la precisión para cada tamaño de n hacer varias repeticiones.
*/

//la probabilidad de a es p(a) = casos favorables/resultados posibles

import java.util.Scanner;

public class PruebaParadoja{
  public static void main(String[] args) {
    System.out.println("Introduzca la cantidad de repeticiones:");
    int [] personas = {05,10,15,20,23,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100};
    int[] favorables = new int[personas.length];
    float[] probabilidad = new float[personas.length];
    long repeticiones = usrEsbribe();
    float posibles = repeticiones;
    boolean[] estudiados = new boolean[personas.length];
    byte[] valores = new byte[personas.length];


    hazProbabilidad(posibles, repeticiones, personas, favorables, estudiados, valores, probabilidad );
    imprime(estudiados, personas, favorables, probabilidad);

  }

  public static void hazProbabilidad(float posibles, long repeticiones, int [] personas, int[] favorables, boolean[] estudiados, byte[] valores, float[] probabilidad ){// toma los valores binarios y los suma para obtener los favorables, para despues devidirlos entre los posibles y así optener finalmete la probabilidad
    for (long i=0; i<repeticiones ; i++) {
       estudiados = estudiaGrupos(personas);
       valores = hazBinario(estudiados,personas);
      for (int j=0; j<valores.length ; j++ ) {
        favorables[j]=favorables[j] + valores[j];
      }
      for (int k=0; k<probabilidad.length ; k++) {
        probabilidad[k] = favorables[k]/posibles;
      }
    }
  }

  public static long usrEsbribe(){// devuelve un long con los datos que ingrese el usuario
    Scanner scan = new Scanner(System.in);
    long teclado = scan.nextLong();
    return teclado;
  }

  public static int[] llenaAleatorio(int a){//dado un personas[x] devuelve un arreglo con int aleatorios de longitud 5*(x+1)
    Random aleatorio = new Random();
    int[] memoria = new int[a];
    for(int i = 0 ; i < a ; i++){
      memoria[i] =  aleatorio.nextInt(360);
    }
    return memoria;
  }

  public static boolean revisaFechas(int[] arreglo){//revisa si hay al menos dos fechas iguales en el arreglo
    boolean resultado = false;
    for(int i = 0 ; i < arreglo.length ; i++){
      int iguales = 0;
      for(int j = 0 ; j < arreglo.length; j++){
        if(arreglo[i] == arreglo[j])
        iguales++;
        if (iguales >= 2)
          resultado = true;
      }
    }return resultado;
  }

  public static boolean[] estudiaGrupos(int[] personas){//de acuerdo al valor de personas[i] asigna i valores a arreglo grupo y revisa y hay al menos 2 coincidencias
    boolean[] estudio = new boolean[personas.length];
    for (int i = 0; i < personas.length ; i++) {
      int[] grupo = llenaAleatorio(personas[i]);
      estudio[i] = revisaFechas(grupo);
    }
    return estudio;
  }

  public static byte[] hazBinario(boolean[] grupoEstudiado,int[] personas){//el resultado de estudia grupos lo vuelve 0 o 1
    byte[] binos= new byte[personas.length];
    for (int i = 0 ; i<personas.length ; ++i ) {
      if (grupoEstudiado[i]==true) {
        binos[i]=1;
      }else binos[i]=0;
    }
    return binos;
  }

  public static void imprime(boolean[] estudiados,int [] personas,int[] favorables,float[] probabilidad){//imprime formato
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    System.out.println("# personas                       Coincidencias(casos favorables)                        Probabilidad");
    for (int i=0; i<estudiados.length ; i++ ) {
      System.out.print("    "+personas[i]+" - - - - - - - - - - - - - - - - - - - - "+favorables[i]+" - - - - - - - - - - - - - - - - - - - - "+ probabilidad[i]*100 +"%");
      System.out.println("");
    }
  }
}
