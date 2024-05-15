/*
 */
package matriz;
import java.util.Scanner;
public class MatrizChepe < T extends Number > {
    protected T tipo;
    protected String resp;
    protected int i;
    protected int j;
    protected int m;
    protected int n;
    protected T[][] matriz1;
    protected T[][] matriz2;
    protected T[][] resultado;
    public Matriz(T tipo){
        this.tipo = tipo;
        Scanner en = new Scanner(System.in);
        System.out.println("¿Qué operacion desea realizar(suma o multiplicacion)?");
        resp = en.nextLine();
        if(resp.equals("suma")){
            System.out.print("Ingresa las dimensiones de las matrices\nRenglones: ");
            i = en.nextInt();
            en.nextLine();
            System.out.print("\nColumnas: ");
            j = en.nextInt();
            en.nextLine();
            System.out.println();
            m = i;
            n = j;
        }
        else{
            do{
                System.out.print("Ingrese las dimensiones de la primer matriz\nRenglones: ");
                i = en.nextInt();
                en.nextLine();
                System.out.print("\nColumnas: ");
                j = en.nextInt();
                en.nextLine();
                System.out.print("\nIngrese las dimensiones de la segunda matriz\nRenglones: ");
                m = en.nextInt();
                en.nextLine();
                System.out.print("\nColumnas: ");
                n = en.nextInt();
                en.nextLine();
                if(j != m)
                    System.out.println("Las columnas de la primer matriz deben de ser iguales a los renglones de la segunda matriz\nIntroduzca nuevamente las dimensiones");
            }while(j != m);
        }
    }
    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);
        System.out.println("CALCULADORA DE SUMA Y MULTIPLICACION DE MATRICES\n");
        System.out.println("\t**Matriz de Enteros**");
        Matriz<Integer> mat = new Matriz<>(445);
        mat.newArray(mat, mat.i, mat.j, mat.m, mat.n);
        mat.llenarMatriz(mat.matriz1);
        mat.llenarMatriz(mat.matriz2);
        if(mat.resp.toLowerCase().equals("suma")){
            mat.sumarMatriz(mat.matriz1, mat.matriz2);
            System.out.println("El resultado de sumar las dos matrices es: ");
        }
        else{
            mat.multiplicarMatriz(mat.matriz1, mat.matriz2);
            System.out.println("El reusltado de multiplicar las dos matrices es: ");
        }
        System.out.println(mat.toString(mat.resultado) + "\n");
        System.out.println("\t**Matriz de Numeros Decimales**");
        Matriz<Double> mat2 = new Matriz<>(45D);
        mat2.newArray(mat2, mat2.i, mat2.j, mat2.m, mat2.n);
        mat2.llenarMatriz(mat2.matriz1);
        mat2.llenarMatriz(mat2.matriz2);
        if(mat2.resp.toLowerCase().equals("suma")){
            mat2.sumarMatriz(mat2.matriz1, mat2.matriz2);
            System.out.println("El resultado de sumar las dos matrices es: ");
        }
        else{
            mat2.multiplicarMatriz(mat2.matriz1, mat2.matriz2);
            System.out.println("El resultado de multiplicar las dos matrices es: ");
        }
        System.out.println(mat2.toString(mat2.resultado));
    }
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
    public Matriz newArray(Matriz a, int i, int j, int m, int n){
        if(a.tipo.getClass().toString().endsWith("Integer")){
            a.matriz1 = new Integer[i][j];
            a.matriz2 = new Integer[m][n];
            a.resultado = new Integer[i][n];
        }
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
        }
        return a;
    }
}