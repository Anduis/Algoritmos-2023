import java.util.Scanner;
public class Matriz < T extends Number > {
  /*protected T tipo;
  protected int i;//filas
  protected int j;//columnas
  protected T [][] matrizG;*/
  //
  protected T tipo;
  protected String resp;
  protected int i;
  protected int j;
  protected int m;
  protected int n;
  protected T[][] matriz1;
  protected T[][] matriz2;
  protected T[][] resultado;
  public Matriz(T tipo, int ie, int je){
    this.tipo = tipo;
    i=ie;
    j=je;
    //matrizG = new T[i][j];
  }
  //
  public String toString(T[][] a){
      String s = "|";
      for(int i = 0 ; i < a.length ; ++i){
          for(int j = 0 ; j < a[0].length ; ++j){
              if(j > 0)
                  s += " ";
              s += a[i][j].toString();
          }
          if(i < a.length-1)
              s += "|\n|";
      }
      return s + "|";
  }
  public T[][] llenarMatriz(T[][] a) throws IndexOutOfBoundsException {
      Scanner en = new Scanner(System.in);
      Number num;
      System.out.println("Ingresa los numeros de la matriz reglon por renglon, separando los numeros  con espacio y presionando enter al final del renglon:");
      if(a.getClass().toString().endsWith("Integer;")){
          for(int i = 0 ; i < a.length ; ++i){
              for(int j = 0 ; j < a[0].length ; ++j){
                  num = (Number)en.nextInt();
                  a[i][j] = (T)num;
              }
              en.nextLine();
          }
      }
      else if(a.getClass().toString().endsWith("Long;")){
          for(int i = 0 ; i < a.length ; ++i){
              for(int j = 0 ; j < a[0].length ; ++j){
                  num = (Number)en.nextLong();
                  a[i][j] = (T)num;
              }
              en.nextLine();
          }
      }
      else if(a.getClass().toString().endsWith("Float;")){
          for(int i = 0 ; i < a.length ; ++i){
              for(int j = 0 ; j < a[0].length ; ++j){
                  num = (Number)en.nextFloat();
                  a[i][j] = (T)num;
              }
              en.nextLine();
          }
      }
      else if(a.getClass().toString().endsWith("Double;")){
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
  public T[][] sumarMatriz(T[][] a, T[][] b){
      if(a.getClass().toString().endsWith("Integer;"))
          for(int i =0 ; i < a.length ; ++i){
              for(int j = 0 ; j < a[0].length ; ++j){
                  resultado[i][j] = (T)(Number)(a[i][j].intValue() + b[i][j].intValue());
              }
          }
      else if(a.getClass().toString().endsWith("Long;"))
          for(int i =0 ; i < a.length ; ++i){
              for(int j = 0 ; j < a[0].length ; ++j){
                  resultado[i][j] = (T)(Number)(a[i][j].longValue() + b[i][j].longValue());
              }
          }
      else if(a.getClass().toString().endsWith("Float;"))
          for(int i =0 ; i < a.length ; ++i){
              for(int j = 0 ; j < a[0].length ; ++j){
                  resultado[i][j] = (T)(Number)(a[i][j].floatValue() + b[i][j].floatValue());
              }
          }
      else if(a.getClass().toString().endsWith("Double;"))
          for(int i =0 ; i < a.length ; ++i){
              for(int j = 0 ; j < a[0].length ; ++j){
                  resultado[i][j] = (T)(Number)(a[i][j].doubleValue() + b[i][j].doubleValue());
              }
          }
      return resultado;
  }
  public T[][] multiplicarMatriz(T[][] a, T[][] b){
      if(a.getClass().toString().endsWith("Integer;")){
          int res = 0;
          for(int i = 0; i < resultado.length ; ++i){
              for(int  j = 0; j < resultado[0].length ; ++j){
                  for(int m = 0 ; m < a[0].length ; ++m){
                      res += a[i][m].intValue()*b[m][j].intValue();
                  }
                  resultado[i][j] = (T)(Number)(res);
                  res = 0;
              }
          }
      }
      if(a.getClass().toString().endsWith("Long;")){
          long res = 0;
          for(int i = 0; i < resultado.length ; ++i){
              for(int  j = 0; j < resultado[0].length ; ++j){
                  for(int m = 0 ; m < a[0].length ; ++m){
                      res += a[i][m].longValue()*b[m][j].longValue();
                  }
                  resultado[i][j] = (T)(Number)(res);
                  res = 0;
              }
          }
      }
      if(a.getClass().toString().endsWith("Float;")){
          float res = 0;
          for(int i = 0; i < resultado.length ; ++i){
              for(int  j = 0; j < resultado[0].length ; ++j){
                  for(int m = 0 ; m < a[0].length ; ++m){
                      res += a[i][m].floatValue()*b[m][j].floatValue();
                  }
                  resultado[i][j] = (T)(Number)(res);
                  res = 0;
              }
          }
      }
      if(a.getClass().toString().endsWith("Double;")){
          double res = 0;
          for(int i = 0; i < resultado.length ; ++i){
              for(int  j = 0; j < resultado[0].length ; ++j){
                  for(int m = 0 ; m < a[0].length ; ++m){
                      res += a[i][m].doubleValue()*b[m][j].doubleValue();
                  }
                  resultado[i][j] = (T)(Number)(res);
                  res = 0;
              }
          }
      }
      return resultado;
  }
  public Matriz newArray(Matriz a, int i, int j/*, int m, int n*/){
      if(a.tipo.getClass().toString().endsWith("Integer")){
          a.matriz1 = new Integer[i][j];
        //  a.matriz2 = new Integer[m][n];
        //  a.resultado = new Integer[i][n];
      }/*
      else if(a.tipo.getClass().toString().endsWith("Long")){
          a.matriz1 = new Long[i][j];
          a.matriz2 = new Long[m][n];
          a.resultado = new Long[i][n];
      }
      else if(a.tipo.getClass().toString().endsWith("Float")){
          a.matriz1 = new Float[i][j];
          a.matriz2 = new Float[m][n];
          a.resultado = new Float[i][n];
      }
      else if(a.tipo.getClass().toString().endsWith("Double")){
          a.matriz1 = new Double[i][j];
          a.matriz2 = new Double[m][n];
          a.resultado = new Double[i][n];
      }*/
      return a;
  }
  //
  public static int hazNumero(int  numero, char actual){//cambia de char a numero, numero deberia empezar=0
    numero = numero*10 + Character.getNumericValue(actual);
    return numero;
  }
  public static char actual(String x ,int i){//devuelve caracter que se está revisando
    char actual =  x.charAt(i);
    return actual;
  }
  public static String usrEsbribe(){
    Scanner scan = new Scanner(System.in);
    String teclado = scan.nextLine();
    return teclado;
  }
  public static int[] orden(String x){
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
        int[] ordenSuma = orden(usrEsbribe());
        int i = ordenSuma[0];
        int j = ordenSuma[1];
        //
          Matriz<Integer> mat = new Matriz<>(445,i,j);
          mat.newArray(mat, mat.i, mat.j);
          mat.llenarMatriz(mat.matriz1);
        //
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
