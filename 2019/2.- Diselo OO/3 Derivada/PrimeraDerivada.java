/*
*Autor:Andres Anguiano Matricula:1638975x
*Fecha: 26 Marzo 2020
*
**INDICACIONES DADAS:
**Escribir la aplicación PrimeraDerivada
**la cual lee cualquier polinomio en notación algebraica estándar y
**obtiene la primera derivada de ese polinomio.
*/
import java.util.Scanner;

public class PrimeraDerivada{ //Escribir la aplicación PrimeraDerivada
  public static void main(String[] args) {
    String polinomio = usrEsbribe(); //la cual lee cualquier polinomio en notación algebraica estándar
    String polinomioDerivado = deriva(polinomio);//obtiene la primera derivada de ese polinomio.
    System.out.println(polinomioDerivado + "Es la primer derivada de su expresion: " + polinomio);
  }

  public static String usrEsbribe(){
    Scanner scan = new Scanner(System.in);
    String teclado = scan.nextLine();
    return teclado;
  }

  public static String deriva(String x){
    String avance = "";
  int largo=x.length();
  int posicion=0;
  int coeficiente;
  Integer exponente;
  char signo ;
  char literal;
  int digito= 0;
  while (posicion<largo) {
     // leer signo si lleva el coeficiente
     if (x.charAt(posicion)=='-' || x.charAt(posicion)=='+')
        {signo = x.charAt(posicion);
        posicion++;}
     else
        signo = '\u0000';

// leer coeficiente
/*
coeficiente = 1;
if (Character.isDigit(x.charAt(posicion))) {
  digito++;
  coeficiente = Character.getNumericValue(x.charAt(posicion));
  posicion++;
  if (digito>1) {
    //si el coeficiente es de mas de un digito
    if (Character.isDigit(x.charAt(posicion))) {
      digito++;
      coeficiente = coeficiente*10 + Character.getNumericValue(x.charAt(posicion));
      posicion++;}
  }else {digito=0;}
}
*/
if (Character.isDigit(x.charAt(posicion))) {
   coeficiente = Character.getNumericValue(x.charAt(posicion));
   posicion++;
   if (posicion<largo && Character.isDigit(x.charAt(posicion))){
      coeficiente = coeficiente*10+Character.getNumericValue(x.charAt(posicion));
      posicion++;}
    }else
    coeficiente = 1;
     //if (posicion>=largo) break; //término independiente -> derivada 0

     // Leer literal
     exponente = 0;
     literal = '\u0000';
     if (posicion<largo && Character.isLetter(x.charAt(posicion))) {
        literal = x.charAt(posicion++);
        exponente = 1;
     }

     // Leer ^
     if (posicion<largo && x.charAt(posicion)=='^') ++posicion;

     // Leer exponente entero positivo
     if (posicion<largo && Character.isDigit(x.charAt(posicion))) {
           exponente = x.charAt(posicion++)-'0';
           while (posicion<largo && Character.isDigit(x.charAt(posicion)))
              exponente = exponente*10+x.charAt(posicion++)-'0';
     }

     // Calcular derivada
     // agregar signo si lo tenía
     if (exponente>0) { // agregar término derivado si no es término independ.
        if (signo != '\u0000') avance += signo;
        avance += (coeficiente*exponente);
     }
     if (exponente>1) avance += literal; // agregar "literal" si exponente>1
     if (exponente>2) avance += "^"+(exponente-1); // agregar "^exponente" si exponente>2
  }
  if (avance!="")
     return avance ;
  else
     return null;
  }
}
