import java.util.Arrays;

public class InvertirArreglo {

  public static <E> void invertir(E[] a) {
    Stack<E> S = new ArregloStack<E>(a.length);
    for(int i=0; i<a.length; i++)
      S.push(a[i]);
    for(int i=0; i<a.length; i++)
      a[i] = S.pop();
  }

  /** Rutina para probar la inversión de arreglos */
  public static void main(String args[]) {
    // autoboxing: a partir de Java 1.5, hace la conversión de tipos 
    //             primitivos a objetos automáticamente y viceversa. 
    //             Se usa a continuación.
    Integer[] a = {4, 8, 15, 16, 23, 42};
    String[] s = {"Jorge","Paco","Pedro","Juan","Marta"};
    System.out.println("a = "+Arrays.toString(a));
    System.out.println("s = "+Arrays.toString(s));
    System.out.println("Invirtiendo ...");
    invertir(a);
    invertir(s);
    System.out.println("a = "+Arrays.toString(a));
    System.out.println("s = "+Arrays.toString(s));
  }
}
