import java.util.Scanner;
public class Cal{
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    double memoria =0 ;
    analiza(entrada, memoria);




  }
  public static void analiza(Scanner entrada, double memoria){
    while (entrada.hasNextLine()){
      if (entrada.hasNextDouble()) {
        double i = entrada.nextDouble();
        memoria = i;
        System.out.println("numero valido");
      }
      else {
        String operador = entrada.nextLine();
        if (operador.equals("+")) {
          System.out.println("operador suma");
          if (entrada.hasNextDouble()){
            double j = entrada.nextDouble();
            memoria = memoria+j;
            System.out.println("= \n"+memoria);
          }
        }

        if (operador.equals("-")) {
          System.out.println("operador resta");
          if (entrada.hasNextDouble()){
            double j = entrada.nextDouble();
            memoria = memoria-j;
            System.out.println("= \n"+memoria);
          }
        }

        if (operador.equals("*")) {
          System.out.println("operador producto");
          if (entrada.hasNextDouble()){
            double j = entrada.nextDouble();
            memoria = memoria*j;
            System.out.println("= \n"+memoria);
          }
        }

        if (operador.equals("/")) {
          System.out.println("operador division");
          if (entrada.hasNextDouble()){
            double j = entrada.nextDouble();
            memoria = memoria/j;
            System.out.println("= \n"+memoria);
          }
        }
      }
    }
  }
}
