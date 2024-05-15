import  java.util.Scanner;
public class ll{
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
System.out.print("Favor de ingresar un entero: ");
while (!entrada.hasNextInt()) {
entrada.nextLine();
System.out.print("No se ingreso un entero. ");
    System.out.print("Por favor ingrese un entero: ");
}
int i = entrada.nextInt();

  }
}

import java.util.Scanner;
public class Calculadora{
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    if (entrada.hasNextDouble()) {
      double nuemro = entrada.nextDouble();
      entrada.nextLine();
    }
  }
}

if (Entrada.equals("+") || Entrada.equals("-") || Entrada.equals("*") || Entrada.equals("/")){
  System.out.println("caracter");
}
