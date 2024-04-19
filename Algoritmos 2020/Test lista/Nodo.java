/** Nodo de una lista simple enlazada de cadenas . */
public class Nodo {
private int elemento ; // Los elementos son cadenas de caracteres
private Nodo sig ;
/** Se crea un nodo con el elemento dado y el nodo sig. */
public Nodo ( int e, Nodo n) {
elemento = e;
sig = n;
}
public Nodo ( int e) {
elemento = e;
sig = null;
}
/** Regresa el elemento de este nodo . */
public int getElemento () { return elemento ; }
/** Regresa el nodo siguiente de este nodo . */
public Nodo getSig () { return sig ; }
// metodos modificadores
/** Pone el elemento de este nodo . */
public void setElemento ( int nvoElem ) { elemento = nvoElem ; }
/** Pone el nodo sig de este nodo . */
public void setSig ( Nodo nvoSig ) { sig = nvoSig ; }
}
