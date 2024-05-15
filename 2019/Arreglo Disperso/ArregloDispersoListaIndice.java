/*
Autor: Andres Anguiano 1638975x
fecha: 22 Mayo 2020
un arreglo es disperso si la mayoría de sus entradas es null.
Una lista L puede ser usada para implementar tal arreglo, A, eficientemente.
En particular, para cada celda no nula A[i] se puede guardar una entrada (i,e)
en L donde e es elemento guardado en A[i]. Esta aproximación permite representar A
usando almacenamiento O(m) donde m es la cantidad de entradas no nulas en A.
Implementar en forma eficiente los métodos del ADT lista arreglo, en la clase ArregloDispersoListaIndice
*/
public class  ArregloDispersoListaIndice<E> implements ListaIndice<E> {
  ListaNodoPosicion<Entrada<E>> L;
  public ArregloDispersoListaIndice(){ L= new ListaNodoPosicion<>(); }
  public int size(){ return L.size(); }
  public boolean isEmpty(){return L.isEmpty();}
  public String toString(){return L.toString();}
  /*
  DUDA! no supe si el add debia sustituir al toparse con un indice que ya estaba ocupado,
  crei que lo mas adecuado era desplazar los elmentos para aprovechar las funciones de la lista
  para reemplazarlos debe usarse set()
  */
  public void add(int i, E e) throws IndexOutOfBoundsException{
    if(i>=0){
      if(pos(i)!=null){
        int x=i;
        int cont=0;
        while(prox(x)!=null && getIndice(prox(x))==x+1){
          cont++;
          x++;
        }
        while(cont!=-1){
          incrementa(pos(x));
          x--;
          cont--;
        }
        L.addBefore(prox(i),new Entrada(i,e));
      }
      else{
      if (prox(i)!=null) L.addBefore(prox(i),new Entrada(i,e));
      else L.addLast(new Entrada(i,e));
      }
    }
  }
  public E remove(int i) throws IndexOutOfBoundsException{
    E temp = getElement(pos(i));
    L.remove(pos(i));
    return temp;
  }
  public E set(int i, E e) throws IndexOutOfBoundsException{
    E temp = getElement(pos(i));
    setElement(pos(i),e);
    return temp;
  }
  public E get(int i) throws IndexOutOfBoundsException{
    if (pos(i)!=null) {
      return getElement(pos(i));
    }
    return null;
  }
  public Posicion<Entrada<E>> pos(int i){//devuelve Posicion del indice ingresado
    if (i>=0 && !L.isEmpty()) {
      for (Posicion<Entrada<E>> x : L.positions() ) if(getIndice(x)==i) return x;
    }
    return null;
  }
  public Posicion<Entrada<E>> prox(int i){//devuelve proxima posicion si la hay
    for (Posicion<Entrada<E>> x : L.positions() ) {
      if(getIndice(x)>i) return x;
    }
    return null;
  }
  protected static class Entrada<E> {
    private E e;
    private int i;
    Entrada(int indice,E element){
      i=indice;
      e=element;
    }
    public E elementE(){return e;}
    public int indiceE(){return i;}
    public void setElementE(E el){e=el;}
    public void incrementaE(){i++;}
    public String toString() { return "["+i+":"+e+"]"; }
  }
  protected E getElement(Posicion<Entrada<E>> p) { return p.elemento().elementE(); }
  protected int getIndice(Posicion<Entrada<E>> p) { return p.elemento().indiceE(); }
  protected void setElement(Posicion<Entrada<E>> p, E el) { p.elemento().setElementE(el);}
  protected void incrementa(Posicion<Entrada<E>> p) { p.elemento().incrementaE(); }

  public void printAsArray(){//lo imprime como si fuera un arreglo,
    System.out.print("[");
    for (Posicion<Entrada<E>> x : L.positions() ){
      System.out.print(getElement(x));
      if (prox(getIndice(x))!=null) System.out.print(", ");
    }
    System.out.print("]");
    System.out.println();
  }

  public static void main(String[] args) {
    ArregloDispersoListaIndice<String> A =  new ArregloDispersoListaIndice<>();
    int aleatorio=0;
    String letra;
    for(int i=0;i<8;++i){
      aleatorio=(int)(Math.random()*10);
      letra=String.valueOf((char) ('A'+i));
      A.add(aleatorio,letra);
      System.out.println("agrega (add) Elemento "+letra+" Indice "+aleatorio);
      System.out.println("   Lista:"+A);
      System.out.print("   Arreglo:");
      A.printAsArray();
    }
    System.out.println();
    String o = A.get(aleatorio);
    System.out.println("reviso (get) Elemento "+o+" Indice "+aleatorio);
    System.out.println("   Lista:"+A);
    System.out.print("   Arreglo:");
    A.printAsArray();

    System.out.println();
    o = A.set(aleatorio, "nuevo");
    System.out.println("reeplaza (set) Elemento "+o+" por 'nuevo' " + "Indice "+aleatorio);
    System.out.println("   Lista:"+A);
    System.out.print("   Arreglo:");
    A.printAsArray();

    System.out.println();
    o = A.remove(aleatorio);
    System.out.println("borra (remove) Elemento "+o + " Indice "+aleatorio);
    System.out.println("   Lista:"+A);
    System.out.print("   Arreglo:");
    A.printAsArray();
  }
}
