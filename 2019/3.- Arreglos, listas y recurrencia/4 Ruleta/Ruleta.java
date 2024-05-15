/*
*Autor: Andres Anguiano 1638975x
*Fecha: 5 Abril 2020
**INSTRUCCIONES DADAS:
**Empleando una lista circular, escribir la aplicación Ruleta,
**la cual tendrá 32 posibles valores que estarán entre 1 y 32.
**Los valores deberán estar puestos en la ruleta de forma aleatoria.
**Este juego de ruleta simulará la competencia entre 5 jugadores que juegan 3 rondas para saber quien es el ganador en las 3 rondas.
**La ruleta debe dar como mínimo 5 vueltas y como máximo 7 vueltas.
*/
import java.util.Random;
public class Ruleta{
  public static void main(String[] args) {
    ListaCircular lc = new ListaCircular ();//Empleando una lista circular,
    int[] ruleta = llenaAleatorio(32);//la cual tendrá 32 posibles valores que estarán entre 1 y 32. Los valores deberán estar puestos en la ruleta de forma aleatoria.
    int n = 3; // numero de rondas
    int puntosP1=0,puntosP2=0,puntosP3=0;
    for ( int x = 0 ; x < ruleta.length; x++ ) {
      lc.agregar(new Nodo(ruleta[x],null));
      lc.avanzar();
    }
    //System.out.println("la ruleta es: "+lc.toString ());
//Este juego de ruleta simulará la competencia entre 5 jugadores que juegan 3 rondas
    System.out.println("*-*-*-*-* turno del jugador 1 *-*-*-*-*");
    for (int e=1; e<=n ;e++ ) {
      System.out.println("        ronda numero: #" + e );
      int ale1 = aleatorio(64);
      girar(lc, 160+ale1);
      puntosP1 += lc.getCursor().getElemento();
      System.out.println("la ruleta cae en la casilla "+ lc.getCursor().getElemento());
      System.out.println("jugador 1 suma :"+puntosP1);
    }
    System.out.println("");
    System.out.println("*-*-*-*-* turno del jugador 2 *-*-*-*-*");
    for (int e=1; e<=n ;e++ ) {
      System.out.println("        ronda numero: #" + e );
      int ale2 = aleatorio(64);
      girar(lc, 160+ale2);
      puntosP2 += lc.getCursor().getElemento();
      System.out.println("la ruleta cae en la casilla "+ lc.getCursor().getElemento());
      System.out.println("jugador 2 suma :"+puntosP2);
    }
    System.out.println("");
    System.out.println("*-*-*-*-* turno del jugador 3 *-*-*-*-*");
    for (int e=1; e<=n ;e++ ) {
      System.out.println("        ronda numero: #" + e );
      int ale3 = aleatorio(64);
      girar(lc, 160+ale3);
      puntosP3 +=lc.getCursor().getElemento();
      System.out.println("la ruleta cae en la casilla "+ lc.getCursor().getElemento());
      System.out.println("jugador 3 suma :"+puntosP3);
    }
    puntaciones(puntosP1,puntosP2,puntosP3);
  }
  /*
  La ruleta debe dar como mínimo 5 vueltas y como máximo 7 vueltas.
  cada vuelta son 32 avances, si da 5 vueltas exactas son (5*32)160 avances, si da 72 son (7*32)224
  como no puede dar menos de 5 ni mas de 7, la cantidad de avances posibles aleatorios son (2*32) o (224-160)
  pero, como las indicaciones fueron que *debe* dar 5 vueltas minimo y maximo 7
  expresaré el numero de avances como 160(5 vueltas) + un aleatorio entre 0 y (224-160)
  */
  public static void puntaciones(int n1, int n2, int n3){//para saber quien es el ganador en las 3 rondas.
  if (n1 > n2) {
    if (n1 > n3) {
      System.out.println("El ganador es: " + "jugador 1");
    } else {
      System.out.println("el ganador es: " + "jugador 3");
    }
    } else if (n2 > n3) {
      System.out.println("el ganador es: " + "jugador 2");
    } else {
      System.out.println("el ganador es: " + "jugador 3");
    }
  }
  public static void girar(ListaCircular a,int x){
    for (int i=1; i<x+1 ;i++ ) {
      a.avanzar();
    }
  }
  public static int aleatorio(int x){
    Random aleatorio = new Random();
    //aleatorio.setSeed(System.currentTimeMillis());
    int respuesta=aleatorio.nextInt(x);
    return respuesta;
  }
  public static int[] llenaAleatorio(int x){// regresa de 1 a x(entrada) cantidad de numeros en orden aleatorio
    int n = x;
    int k = n;
    int[] resultado = new int[n];
    int[] numeros=new int[n];
    int res;
    for(int i=0;i<n;i++){
      numeros[i]=i+1;
    }
    for(int i=0;i<n;i++){
      res = aleatorio(k);
      resultado[i]=numeros[res];
      numeros[res]=numeros[k-1];
      k--;
    }
    return resultado;
  }
}
/** Nodo de una lista simple enlazada de enteros . */
class Nodo {
  private int elemento ; // Los elementos son enteros
  private Nodo sig ;
  public Nodo ( int e, Nodo n) {
    elemento = e;
    sig = n;
  }
  public int getElemento () { return elemento ; }
  public Nodo getSig () { return sig ; }
  public void setElemento ( int nvoElem ) { elemento = nvoElem ; }
  public void setSig ( Nodo nvoSig ) { sig = nvoSig ; }
}
