/*Autor:Andres Anguiano 1638975x
*fecha: 3 Abril 2020
*INDICACIONES DADAS:
*Escribir la aplicación Matriz,
*la cual puede sumar y multiplicar matrices de tipos genéricos,
*de tal forma que las matrices involucradas puedan contener tipos numéricos arbitrarios, como Integer, o Double.
*Limitar el tipo genérico al tipo Numeric en esta clase.
*Agregar código que muestre el uso de la clase Matriz.
*/
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

  public T[][] llenaMatriz(T[][] a) throws IndexOutOfBoundsException {
    Scanner in = new Scanner(System.in);
    Number num;
    System.out.println("Ingresa los valores de cada fila separados con un espacio entre cada numero. pulsa enter al terminar cada fila:");
    if(a instanceof Integer[][]){
      for(int i = 0 ; i < a.length ; ++i){
        for(int j = 0 ; j < a[0].length ; ++j){
          num = (Number)in.nextInt();
          a[i][j] = (T)num;
        }
        in.nextLine();
      }
    }
    else if(a instanceof Long[][]){
      for(int i = 0 ; i < a.length ; ++i){
        for(int j = 0 ; j < a[0].length ; ++j){
          num = (Number)in.nextLong();
          a[i][j] = (T)num;
        }
        in.nextLine();
      }
    }
    else if(a instanceof Byte[][]){
      for(int i = 0 ; i < a.length ; ++i){
        for(int j = 0 ; j < a[0].length ; ++j){
          num = (Number)in.nextByte();
          a[i][j] = (T)num;
        }
        in.nextLine();
      }
    }
    else if(a instanceof Short[][]){
      for(int i = 0 ; i < a.length ; ++i){
        for(int j = 0 ; j < a[0].length ; ++j){
          num = (Number)in.nextShort();
          a[i][j] = (T)num;
        }
        in.nextLine();
      }
    }
    else if(a instanceof Float[][]){
      for(int i = 0 ; i < a.length ; ++i){
        for(int j = 0 ; j < a[0].length ; ++j){
          num = (Number)in.nextFloat();
          a[i][j] = (T)num;
        }
        in.nextLine();
      }
    }
    else if(a instanceof Double[][]){
      for(int i = 0 ; i < a.length ; ++i){
        for(int j = 0 ; j < a[0].length ; ++j){
          num = (Number)in.nextDouble();
          a[i][j] = (T)num;
        }
        in.nextLine();
      }
    }
    return a;
  }
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
  public static Number[][] suma (Number a[][], Number b[][]){
    int ident = Math.min(distingue(a), distingue(b));
    Number [][] suma = new Number[a.length][b[0].length];
    for (int i=0; i < a.length; i++) {
      for (int j=0; j < a[i].length; j++) {
        suma[i][j]= Conversion(a[i][j].doubleValue()+b[i][j].doubleValue(),ident);
      }
    }
    return suma;
  }
  public static Number [][] mulptiplica (Number[][] a, Number[][] b){
    int ident = Math.min(distingue(a), distingue(b));
    Number[][] producto = new Number[a.length][b[0].length];
    double temp;
    for (int i=0; i < producto.length; i++) {
      for (int j=0; j < producto[i].length; j++) {temp = 0.0;
        for (int k=0; k<b.length; k++){
          temp += a[i][k].doubleValue() * b[k][j].doubleValue();
        }
        producto[i][j] =Conversion(temp, ident);
      }
    }return producto;
  }
  public static void imprime(Number[][] number){
    for(int i=0;i<number.length;i++){
      for(int j=0;j<number[i].length;j++){
        System.out.print(number[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    System.out.println("*Presione 1 luego enter para realizar una Suma de matrices");
    System.out.println("*Presione 2 luego enter para realizar un Producto de matrices");
    int decision=0;
    decision = Character.getNumericValue(usrEsbribe().charAt(0));

    while (decision !=1 && decision != 2){
      System.out.println("entrada invalida!");
      decision = Character.getNumericValue(usrEsbribe().charAt(0));
    }

    while (decision==1 || decision==2) {
      if (decision==1) {
        System.out.println("La suma de dos matrices solo se puede realizar entre matrices del mismo orden");
        System.out.println("ingrese el orden para sus matrices en la forma i*j siendo i la cantidad de filas y j la cantidad de columnas");
        //modificar estos para intentar con otros tipos
        Matriz<Integer> miMatriz1 = new Matriz<>();
        Matriz<Double> miMatriz2 = new Matriz<>();
        int[] ordenSuma = leeOrden(usrEsbribe());
        int i = ordenSuma[0];
        int j = ordenSuma[1];
        miMatriz1.arreglo = new Integer[i][j];
        miMatriz2.arreglo = new Double[i][j];
        System.out.println("Para tu primer matriz (Integer)");
        miMatriz1.llenaMatriz(miMatriz1.arreglo);
        System.out.println("Para tu segunda matriz (Double)");
        miMatriz2.llenaMatriz(miMatriz2.arreglo);
        Number[][] adicion = suma(miMatriz1.arreglo,miMatriz2.arreglo);

        System.out.println("la matriz resultante de la sumas es:");
        imprime(adicion);

        decision=3;
      }else if (decision==2) {
        //mulptiplicacion
        System.out.println("Para el producto de dos matrices el numero de columnas de la primer matriz deberá ser igual al numero de filas de la segunda");
        System.out.println("ingrese el orden para su primer matriz en la forma i*j siendo i la cantidad de filas y j la cantidad de columnas");
        int[] orden1 = leeOrden(usrEsbribe());

        System.out.println("ingrese el orden para su segunda matriz en la forma i*j siendo i la cantidad de filas y j la cantidad de columnas");
        int[] orden2 = leeOrden(usrEsbribe());
        while (orden2[0] != orden1[1]) {
          System.out.println("orden invalido!, j1 debe ser igual a i2");
          orden2 = leeOrden(usrEsbribe());
        }
        //modificar estos para intentar con otros tipos
        Matriz<Byte> miMatriz1 = new Matriz<>();
        Matriz<Long> miMatriz2 = new Matriz<>();
        miMatriz1.arreglo = new Byte[orden1[0]][orden1[1]];
        miMatriz2.arreglo = new Long[orden2[0]][orden2[1]];
        System.out.println("Para tu primer matriz (Byte)");
        miMatriz1.llenaMatriz(miMatriz1.arreglo);

        System.out.println("Para tu segunda matriz (Long)");
        miMatriz2.llenaMatriz(miMatriz2.arreglo);

        Number[][] producto = mulptiplica(miMatriz1.arreglo,miMatriz2.arreglo);
        System.out.println("la matriz resultante de la multiplicacion es:");

        imprime(producto);

        decision=3;
      }
    }
  }
}
