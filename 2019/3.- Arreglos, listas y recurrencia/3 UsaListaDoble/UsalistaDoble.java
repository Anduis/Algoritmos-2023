/*
*Autor: Andres Anguiano 1638975x
*Fecha: 5 Abril 2020
**INDICACIONES DADAS:
**Escribir la aplicación UsaListaDoble para que use una lista doblemente enlazada
**la cual guarda nombres y realiza las siguientes operaciones:
**Rotar completamente hasta que la lista quedé como la lista original.
**En cada rotación el último nodo pasa a ser el primero y luego se muestra la lista.
**Invertir el orden de la lista. El último nodo pasa a ser el primero, el penúltimo el segundo, y así sucesivamente.
*/
public class UsaListaDoble{//Escribir la aplicación UsaListaDoble
  public static void main(String[] args) {
    ListaDoble miLista = new ListaDoble();//para que use una lista doblemente enlazada
    String [] nombres = {" Andres "," Marco "," Polo "," Lola "," Mento "," Igor "," Dito"," John "};//la cual guarda nombres
    NodoD[] nodos = new NodoD[nombres.length];
    for (int i=0 ; i<nombres.length ; i++ ) {
      nodos[i]=new NodoD(nombres[i], null, null);
      miLista.agregarFinal(nodos[i]);
    }
    System.out.println("Lista original:");
    System.out.println(miLista.toString());
    //Rotar completamente hasta que la lista quedé como la lista original.
    System.out.println("Asi se como va rotando hasta volver a su posicion inicial:");
    imprimeRotacion(nodos.length,miLista);
    System.out.println("lista invertida:");
    System.out.println(invierteOrden(miLista).toString());

  }
  //y realiza las siguientes operaciones:
  public static void imprimeRotacion(int i, ListaDoble x){ // i = numero de rotaciones que se quiere imprimir
    //En cada rotación el último nodo pasa a ser el primero y luego se muestra la lista
    for (; i!=0 ; i-- ) {
      rotar(x);
      System.out.println(x.toString());
    }
  }
  public static void rotar(ListaDoble x){
    NodoD temp= new NodoD(x.getUltimo().getElemento(),x.getUltimo().getPrev(),x.getUltimo().getSig());
    x.remover(x.getUltimo());
    x.agregarInicio(temp);
  }
  public static ListaDoble invierteOrden(ListaDoble x){//Invertir el orden de la lista.
    ListaDoble inversion = new ListaDoble();
    ListaDoble clon = x;
    while (clon.tam!=0) {//El último nodo pasa a ser el primero, el penúltimo el segundo, y así sucesivamente.
      NodoD temp= new NodoD(clon.getUltimo().getElemento(),clon.getUltimo().getPrev(),clon.getUltimo().getSig());
      inversion.agregarFinal(temp);
      clon.remover(clon.getUltimo());
    }
    return inversion;
  }
}
