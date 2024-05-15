/** Nodo de una lista doblemente enlazada de una lista de cadenas */
public class NodoD {
  protected String elemento ; // Nodo guarda un elemento String
  protected NodoD sig , prev ; // Apuntadores a nodos siguiente y previo
  /** Constructor que crea un nodo con los campos dados */
  public NodoD ( String e, NodoD p, NodoD s) {
    elemento = e;
    prev = p;
    sig = s;
  }
  /** Regresa el elemento de este nodo */
  public String getElemento () { return elemento ; }
  /** Regresa el nodo previo de este nodo */
  public NodoD getPrev () { return prev ; }
  /** Regresa el nodo siguiente de este nodo */
  public NodoD getSig () { return sig ; }
  /** Pone el elemento de este nodo */
  public void setElemento ( String nvoElem ) { elemento = nvoElem ; }
  /** Pone el nodo previo de este nodo */
  public void setPrev ( NodoD nvoPrev ) { prev = nvoPrev ; }
  /** Pone el nodo siguiente de este nodo */
  public void setSig ( NodoD nvoSig ) { sig = nvoSig ; }
}
