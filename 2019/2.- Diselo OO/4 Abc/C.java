/*
*Autor: Andres Anguiano
*Matricula: 1638975x
*fecha: 26 Marzo 2020
*Indicaciones dadas:
**Escribir las clases A, B y C,
**tal que B extiende A y C extiende B.
**Cada clase deberá definir una variable de instancia llamada x,
**es decir, cada clase tiene su propia variable llamada x.
**Escribir un método en C el cual accede y cambia a un valor dado x de la clase A,
**sin cambiar la x de B o C
*/
public class C extends B{ //C extiende B.
  public int x = 3; //Cada clase deberá definir una variable de instancia llamada x,

  public void nuevoXdeA(int nuevoX){//Escribir un método en C el cual accede y cambia a un valor dado x de la clase A sin cambiar la x de B o C
    A a = this;
    a.x = nuevoX;
  }

  public static void imprimeX(C c){
    System.out.println("X en C ="  + c.x);
    B b = c;
    System.out.println("X en B ="  + b.x);
    A a = c;
    System.out.println("X en A ="  + a.x);

  }
  public static void main(String[] args) {
    C c = new C();
    System.out.println("Valores por defecto:");
    imprimeX(c);
    c.nuevoXdeA(45);
    System.out.println("Valores con nuevo x en A:");
    imprimeX(c);
  }
}
