/*
*Autor: Andres Anguiano
*Fecha 05 Marzo 2020/ 08 Marzo 2020
*Escribir la aplicación Permutaciones la cual muestra todas las cadenas que se pueden formar
*usando los caracteres 'f', 'l', 'o', 'r', 'n', 'u', 'b' y 'e' exactamente una vez.
*Escribir al menos tres métodos que hagan lo siguiente: entrada, procesamiento y salida
*/
// recordar que nPr = n!/(n-r)! en este caso hay 8n 8r entonces el numero de permutaciones posibles es 40320
import java.util.Scanner;
public class Permutaciones{ //Escribir la aplicación Permutaciones la cual muestra todas las cadenas que se pueden formar
  public static void main(String[] args) {
    System.out.println("Para permutar 8 caracteres\n-ingrese los 8 caracteres para su arreglo juntos(seguido uno de otro) y pulse enter \n-escriba *defecto* para usar caracteres sugeridos por el ejercicio");
    char arreglo []= hazChar();
    int r = arreglo.length;
    permuta(arreglo,r);
  }

  public static char[] hazChar(){ //Escribir al menos tres métodos que hagan lo siguiente: entrada,
    Scanner entrada = new Scanner(System.in);
    String teclado=entrada.next();
    if (teclado.equals("defecto")) {
      return ("flornube").toCharArray();  //usando los caracteres 'f', 'l', 'o', 'r', 'n', 'u', 'b' y 'e' exactamente una vez.
    }else {
      return teclado.toCharArray();
    }
  }

  public static void permuta(char[] arreglo,int r){//Escribir al menos tres métodos que hagan lo siguiente: procesamiento
    int contador=1;
    long cuenta = 0l ;
    for(int i=0;i<r;i++){
      for(int j=0;j<r;j++){if(revisa(i,j)){continue;}
        for(int k=0;k<r;k++){if(revisa(i,j,k)){continue;}
          for(int l=0;l<r;l++){if(revisa(i,j,k,l)){continue;}
            for(int m=0;m<r;m++){if(revisa(i,j,k,l,m)){continue;}
              for(int n=0;n<r;n++){if(revisa(i,j,k,l,m,n)){continue;}
                for(int o=0;o<r;o++){if(revisa(i,j,k,l,m,n,o)){continue;}
                  for(int p=0;p<r;p++){if(revisa(i,j,k,l,m,n,o,p)){continue;}
                    imprime(arreglo, i,j,k,l,m,n,o,p);
                    //cuenta++; System.out.print("#"+cuenta);
                    if(contador++%10==0){System.out.println();}
                    else{System.out.print(" ");}
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public static boolean revisa(int...b){
  boolean repetido=false;
  for(int i=0;i<b.length-1;i++){
  if(b[b.length-1]==b[i]){repetido=true;}
  }return repetido;
  }

  public static void imprime(char[] arreglo,int i, int j, int k, int l, int m, int n, int o, int p){//Escribir al menos tres métodos que hagan lo siguiente: salida
    System.out.print(""+arreglo[i]+arreglo[j]+arreglo[k]+arreglo[l]+arreglo[m]+arreglo[n]+arreglo[o]+arreglo[p]);

  }
}
