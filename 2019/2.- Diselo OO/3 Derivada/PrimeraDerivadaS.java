//Sophie Rubí Domínguez Alvarado. Matrícula: 1837995F
//Escribir la aplicación PrimeraDerivada la cual lee cualquier polinomio en notación algebraica estándar y obtiene la primera derivada de ese polinomio.
import java.util.Scanner;
public class PrimeraDerivadaS {
    public static void main (String[] args){
        Scanner enter = new Scanner(System.in);
        System.out.println("Este programa realiza la primera derivada de un polinomio.");
        System.out.println("Ejemplo de cómo introducir el polinomio: +3x^5+7x^2, con el signo antes de TODOS los coeficientes.");
        System.out.println("Ingrese su polinomio:");
        String polinomio= enter.nextLine();
        int sig = 0;
        int constante = 0;
        int exponente = 0;
        String derivada = "";
        for(int i=0; i<polinomio.length();){
            char ident = polinomio.charAt(i);
            if(ident == '+'){
                sig = +1;
                i++;
            }else if(ident == '-'){
                sig = -1;
                i++;
            }
            ident = polinomio.charAt(i);
            while(i<polinomio.length() && ident!='x'&& ident!='+' && ident != '-'){
                int k = Integer.valueOf(String.valueOf(ident));
                constante = constante*10+k;
                i++;
                if(i<polinomio.length()){
                  ident = polinomio.charAt(i);
                }
            }
            constante*=sig;
            if (i == polinomio.length()-1){break;}
            if(ident!='x'){ constante=0;continue;}
            i++;
            ident = polinomio.charAt(i);
            if (ident == '^'){
                ident = polinomio.charAt(++i);

                while(i<polinomio.length() && ident!='+' && ident != '-'){
                int k = Integer.valueOf(String.valueOf(ident));
                exponente = exponente*10+k;
                i++;
                if(i<polinomio.length())
                  ident = polinomio.charAt(i);
                }

                derivada+=Derivada(constante,exponente);
            }

            constante = 0;
            exponente = 0;

        }

        System.out.println("La derivada de la expresion "+polinomio+" es: "+ derivada);
    }
    public static String Derivada(int constante, int exponente){
        String primeraDerivada="";
        if(constante>0){primeraDerivada+="+";}
        primeraDerivada+=(constante*exponente) + "x^" +(exponente-1);
        return primeraDerivada;
    }
}
