
import java.util.Scanner;
import java.util.Random;
public class bidimencional{
  public static void main(String[] args) {
    int [] personas = {5,10,15,20,25,30,35,40,45,50,55,60,65,70,75,80,85,90,95,100};
    for (int i=0; i<20 ; ++i ) {
    int r = 1+i;
    int[][] matriz = new int[20][];  // Sólo se indica el número de renglones, pero no el de columnas, porque será diferente en cada renglón.
    matriz[i] = new int[r*5];

    for (int x=1 ; x< ; x++ ) {
      matriz[x/5][1]=0;
    }

    for (int filas=0 ; filas<20 ; filas++ ) {
      for (int columnas=0; columnas<filas*5 ;columnas++ ) {
        matriz[filas][columnas]=0;System.out.print(matriz[filas][columnas]+"");
      }
      System.out.println();
    }
  }
}
public static int[] llenaAleatorio(int a){
  Random aleatorio = new Random();
  int[] memoria = new int[a];
  for(int i=0; i<a ; i++){
    memoria[i] =  aleatorio.nextInt(360);
  }
  return memoria;
}
}
