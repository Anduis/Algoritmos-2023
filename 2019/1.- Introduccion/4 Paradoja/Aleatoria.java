import java.util.Random;
public class Aleatoria{
  public static void main(String[] args) {
  Random aleatorio = new Random();
  int[] memoria = new int[5];
  for(int i=0; i<5 ; i++){
    memoria[i] =  aleatorio.nextInt(360);
  }for ( int x: memoria) {
    System.out.println(x);
  }
  }
}
