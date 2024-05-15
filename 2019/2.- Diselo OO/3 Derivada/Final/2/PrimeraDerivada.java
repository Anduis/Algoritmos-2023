/*
*Autor:Andres Anguiano Matricula:1638975x
*Fecha: 30 Marzo 2020 31 Marzo 2020
*
**INDICACIONES DADAS:
**Escribir la aplicación PrimeraDerivada
**la cual lee cualquier polinomio en notación algebraica estándar y
**obtiene la primera derivada de ese polinomio.
*/
import java.util.Scanner;
public class PrimeraDerivada{
  public static void main(String[] args) {
    System.out.println("Para obtener la premer derivada ingrese un polinomio en notacion algebraica estandar \nejemplo: -10x^4+3x^2-6x");
    String polinomio = usrEsbribe();
    String polinomioDerivado = deriva(polinomio);
    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    System.out.println("Ingresaste el polinomio " + polinomio + "\n Su primera derivada es " + polinomioDerivado);
  }

  public static String usrEsbribe(){
    Scanner scan = new Scanner(System.in);
    String teclado = scan.nextLine();
    return teclado;
  }

  public static String deriva(String x){
    int signo;
    int coeficiente;
    char variable;
    int exponente;
    String respuesta = "";
    int total = x.length();
    for (int i = 0 ; i<total;) {
      //revisa el signo
      if ((actual(x,i) == '+' || actual(x,i) == '-') && i < total) {//convierte el signo a una unidad positiva o negativa
        if (actual(x,i) == '+') {
          i++;
          signo = 1;
        }
        else {
          signo = -1;
          i++;
        }
      }else signo = 1;

      //leer coeficiente
      coeficiente = 0;
      while (i < total && Character.isDigit(actual(x,i))) {
        coeficiente = hazNumero(coeficiente, actual(x,i));
        i++;
      }

      // leer variable
      if (i < total && Character.isLetter(actual(x,i)) ) {
        variable = actual(x,i);
        i++;
        exponente = 1;
      }else{
        variable='\u0000';
        i++;
        exponente = 0;
      }

      // leer exponente
      if (i < total && actual(x,i) == '^'){
        exponente = 0;
        i++;
        while (i < total && Character.isDigit(actual(x,i))) {
          exponente = hazNumero(exponente, actual(x,i));
          i++;
        }
      }

      //operar
      respuesta += opera(exponente, coeficiente, signo, variable);

    }return respuesta;
  }
  public static int hazNumero(int numero, char actual){//cambia de char a int, numero deberia empezar=0
    numero = numero*10 + Character.getNumericValue(actual);
    return numero;
  }
  public static char actual(String x ,int i){//devuelve caracter que se está revisando
  char actual=  x.charAt(i);
  return actual;
  }

  public static String opera(int exponente, int coeficiente, int signo, char variable){
    String avance="";
    if (coeficiente==0 && exponente !=0) coeficiente =1;
    coeficiente = (signo*coeficiente);
    if (exponente>0) {
      if (signo == 1) avance += "+";
      avance += (coeficiente*exponente);
      if (exponente>1) avance += variable;
      if (exponente>2) avance += "^"+(exponente-1);
    }return avance;
  }
}
