/*
*Autor:Andres Anguiano Matricula:1638975x
*Fecha: 27 Marzo 2020
*
**INDICACIONES DADAS:
**Escribir la aplicación PrimeraDerivada
**la cual lee cualquier polinomio en notación algebraica estándar y
**obtiene la primera derivada de ese polinomio.
*/
import java.util.Scanner;
  public class PrimeraDerivada{//Escribir la aplicación PrimeraDerivada
    public static void main(String[] args) {
    System.out.println("Ingresa un polinomio en notacion algebraica estandar");
    String polinomio = usrEsbribe();//la cual lee cualquier polinomio en notación algebraica estándar y
    String polinomioDerivado = deriva(polinomio);//obtiene la primera derivada de ese polinomio.
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    System.out.println("Ingresaste el polinomio " + polinomio + "\n Su primera derivada es " + polinomioDerivado);
  }

  public static String usrEsbribe(){
    Scanner scan = new Scanner(System.in);
    String teclado = scan.nextLine();
    return teclado;
  }

  public static String deriva(String x){
    String avance = "";
    int largo = x.length(); //longitud del total de caracteres en el polinomio
    int posicion = 0; //posicion del caracter que se lee
    char signo;
    char literal;
    int exponente;
    int coeficiente;

    while (posicion<largo) {
      //signo
      if (x.charAt(posicion)=='-' || x.charAt(posicion)=='+') {
        signo = x.charAt(posicion);
        posicion++;
      }else{
        signo = '\u0000';
      }
      //coeficiente
      if (Character.isDigit(x.charAt(posicion))) {
        coeficiente = Character.getNumericValue(x.charAt(posicion));
        posicion++;
        while (posicion<largo && Character.isDigit(x.charAt(posicion))){
          coeficiente = coeficiente*10+Character.getNumericValue(x.charAt(posicion));
          posicion++;
        }
      }else
        coeficiente = 1;
      // literal
      if (posicion<largo && Character.isLetter(x.charAt(posicion))) {
        literal=x.charAt(posicion);
        posicion++;
        exponente = 1;
      }else {
        literal = '\u0000';
        exponente = 0;
      }
      // exponente
      if (posicion<largo && x.charAt(posicion)=='^'){
        posicion++;
        if (posicion<largo && Character.isDigit(x.charAt(posicion))) {
          exponente = Character.getNumericValue(x.charAt(posicion));
          posicion++;
          while (posicion<largo && Character.isDigit(x.charAt(posicion))){
            exponente = exponente*10+Character.getNumericValue(x.charAt(posicion));
            posicion++;
          }
        }
      }
      //operaciones y escritura del avance
      if (exponente>0) {
        if (signo != '\u0000') {
        avance += signo;
        }
        avance += (coeficiente*exponente);
      }
      if (exponente>1) {
        avance += literal;
      }
      if (exponente>2) {
        avance += "^"+(exponente-1);
      }
    }
    return avance;
  }
}
