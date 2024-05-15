public class Test{
  public static void main(String[] args) {
    int[] arreglo = {14,13,12,11,14,9,1,5,6,7,8};
    System.out.println(esUnica(arreglo,0,arreglo.length-1));
  }
  public static boolean esUnica(int[] arr, int inicio, int fin) {
    //en cada linea se comenta el numero de veces que se ejecuta una operacion primitiva
    if (inicio>=fin) return true;//n+1
    if (!esUnica(arr, inicio, fin-1)) return false;//2^n + 3
    if (!esUnica(arr, inicio+1, fin)) return false;//2^n + 3
    return arr[inicio]!=arr[fin];//n
    //por lo que el tiempo de ejecucion del metodo es 2+ 1^n + 1^n +2
    //= 2^n +4
  }
}
