import java.util.Scanner;
public class Matriz < T extends Number > {
  protected int orden[];
  protected T[][] arreglo;

  public static String usrEsbribe(){
    Scanner scan = new Scanner(System.in);
    String teclado = scan.nextLine();
    return teclado;
  }
  public static int hazNumero(int  numero, char actual){//cambia de char a numero, numero deberia empezar=0
    numero = numero*10 + Character.getNumericValue(actual);
    return numero;
  }
  public static char actual(String x ,int i){//devuelve caracter que se está revisando
    char actual =  x.charAt(i);
    return actual;
  }
  public static int[] leeOrden(String x){// dada entrada del usuario en forma a*b siendo a,b enteros positivos, guarda a,b en respuesta[]
    int[] respuesta = new int[2];
    int filas=0;
    int columnas = 0;
    for (int i = 0 ; i < x.length() ; ) {
      while (i < x.length()  && Character.isDigit(actual(x,i))) {
        filas = hazNumero(filas, actual(x,i));
        i++;
      }
      if (i < x.length() && actual(x,i) == '*'){
        i++;
        while (i < x.length() && Character.isDigit(actual(x,i))) {
          columnas = hazNumero(columnas, actual(x,i));
          i++;
        }
      }
    }
    respuesta[0]=filas;
    respuesta[1]=columnas;
    return respuesta;
  }

  public T[][] llenarMatriz(T[][] a) throws IndexOutOfBoundsException {
    Scanner en = new Scanner(System.in);
    Number num;
    System.out.println("Ingresa los valores de cada fila separados con un espacio entre cada numero. pulsa enter al terminar cada fila:");
    if(a instanceof Integer[][]){
      for(int i = 0 ; i < a.length ; ++i){
        for(int j = 0 ; j < a[0].length ; ++j){
          num = (Number)en.nextInt();
          a[i][j] = (T)num;
        }
        en.nextLine();
      }
    }
    else if(a instanceof Long[][]){
      for(int i = 0 ; i < a.length ; ++i){
        for(int j = 0 ; j < a[0].length ; ++j){
          num = (Number)en.nextLong();
          a[i][j] = (T)num;
        }
        en.nextLine();
      }
    }
    else if(a instanceof Float[][]){
      for(int i = 0 ; i < a.length ; ++i){
        for(int j = 0 ; j < a[0].length ; ++j){
          num = (Number)en.nextFloat();
          a[i][j] = (T)num;
        }
        en.nextLine();
      }
    }
    else if(a instanceof Double[][]){
      for(int i = 0 ; i < a.length ; ++i){
        for(int j = 0 ; j < a[0].length ; ++j){
          num = (Number)en.nextDouble();
          a[i][j] = (T)num;
        }
        en.nextLine();
      }
    }
    return a;
  }
  //
  public static int distingue (Number[][] a){
      int tipo = 0;
      if (a instanceof Double[][]) {tipo = 1;}
          else if (a instanceof Float[][]) {tipo = 2;}
          else if (a instanceof Long[][]) {tipo = 3;}
          else if (a instanceof Integer[][]) {tipo = 4;}
          else if (a instanceof Short[][]) {tipo = 5;}
          else if (a instanceof Byte[][]) {tipo = 6;}
      return tipo ;
  }
  public static Number Conversion(Double b, int tipo){
      Number cambio = 0;
      switch(tipo){
          case 1: cambio = b.doubleValue();
              break;
          case 2: cambio = b.floatValue();
              break;
          case 3: cambio = b.longValue();
              break;
          case 4: cambio = b.intValue();
              break;
          case 5: cambio = b.shortValue();
              break;
          case 6: cambio = b.byteValue();
              break;
          default: break;
      }
      return cambio;
  }
  //
  public static void ImprimirResultado(Number[][] number){
      for(int i=0;i<number.length;i++){
          for(int j=0;j<number[i].length;j++){
              System.out.print(number[i][j] + " ");
          }
          System.out.println();
      }
      System.out.println();
  }
  public static Number[][] sumarmatrices (Number a[][], Number b[][]){
      if (a.length == b.length && a[0].length == b[0].length){
          int ident = Math.min(distingue(a), distingue(b));
          Number [][] suma = new Number[a.length][b[0].length];
          for (int i=0; i < a.length; i++) {
              for (int j=0; j < a[i].length; j++) {
                  suma[i][j]= Conversion(a[i][j].doubleValue()+b[i][j].doubleValue(),ident);
              }
          }
      return suma;
      }
        return null;
  }
  //
  public static Number[][] mulptiplica(Number[][] a, Number[][] b){
    //
    Number[][] producto = new Number[a.length][b[0].length];
    //
    return producto;
  }

  public static void main(String[] args) {
    System.out.println("*Presione 1 luego enter para realizar una Suma de matrices");
    System.out.println("*Presione 2 luego enter para realizar un Producto de matrices");
    int decision=0;
    decision = Character.getNumericValue(usrEsbribe().charAt(0));

    while (decision !=1 && decision != 2){
      System.out.println("entrada invalida");
      decision = Character.getNumericValue(usrEsbribe().charAt(0));
    }

    while (decision==1 || decision==2) {
      if (decision==1) {
        System.out.println("La suma de dos matrices solo se puede realizar entre matrices del mismo orden");
        System.out.println("ingrese el orden para sus matrices en la forma i*j siendo i la cantidad de filas y j la cantidad de columnas");
        //modificar estos para intentar con otros tipos
        Matriz<Integer> miMatriz1 = new Matriz<>();
        Matriz<double> miMatriz2 = new Matriz<>();
        int[] ordenSuma = leeOrden(usrEsbribe());
        int i = ordenSuma[0];
        int j = ordenSuma[1];
        miMatriz1.arreglo = new Integer[i][j];
        miMatriz2.arreglo = new double[i][j];
        System.out.println("Para tu primer matriz (Integer)" + miMatriz1.arregl.getClass().toString());
        miMatriz1.llenarMatriz(miMatriz1.arreglo);
        System.out.println("Para tu segunda matriz");
        miMatriz2.llenarMatriz(miMatriz2.arreglo);
        System.out.println(i);
        System.out.println(j);
        Number[][] adicion = sumarmatrices(miMatriz1.arreglo,miMatriz2.arreglo);
        ImprimirResultado(adicion);
        System.out.println(miMatriz1.arreglo instanceof Integer[][]);

        decision=3;
      }else if (decision==2) {
        System.out.println("Para el producto de dos matrices el numero de columnas de la primer matriz deberá ser igual al numero de filas de la segunda");
        System.out.println("ingrese el orden para su primer matriz en la forma i*j siendo i la cantidad de filas y j la cantidad de columnas");
        System.out.println("ingrese el orden para su segunda matriz en la forma i*j siendo i la cantidad de filas y j la cantidad de columnas");
        decision=3;
      }
    }
  }
}
