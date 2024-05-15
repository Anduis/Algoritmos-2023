public class Subcon{
  public static void main(String[] args) {
    String conjunto={"a","b","c","d","e"};
  }
  public static String[] subconjuntos(String[] x){
    String[] respuesta= new String[totalSubconjuntos(x.length)];
    for (int i=0;i<x.length ;i++ ) {
    for (int j=0;j<respuesta.length ;j++ ) {
        for (int k=0;k<x.length ;k++ ) {
          if(i==0) respuesta[j]=x[j];
          respuesta[j]=(x[j]+x[i];

        }
      }
    }
  }
  public static int totalSubconjuntos(int x){
    int base = 2;
    for (int i = 1; i < x ; i++ ) {
      base *= 2;
    }
    return base;
  }
}
