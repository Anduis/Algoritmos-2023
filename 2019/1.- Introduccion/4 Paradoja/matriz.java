public class matriz{
  public static void main(String[] args) {
    for (int i=0; i<4 ; ++i ) {
      int r = 1+i;
      int[][] matriz = new int[4][];  // Sólo se indica el número de renglones, pero no el de columnas, porque será diferente en cada renglón.
      matriz[i] = new int[r*5];
      for (int j = 0; j<matriz[i]length ; j++ ) {
        matriz[i][j]=0;
      }
    }
  }
}
