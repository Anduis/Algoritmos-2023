/** Realización de una lista indizada por medio de un arreglo, el cual es 
  * doblado cuando el tamaño de la lista excede la capacidad del arreglo.
  */
public class ArregloListaIndice<E> implements ListaIndice<E> {
  private E[] A; // arreglo almacenando los elementos de la lista indizada
  private int capacidad = 16;  // tamaño inicial del arreglo A
  private int tam = 0;  // número de elementos guardados en la lista 
  /** Crear la lista indizada con capacidad inicial de 16. */
  public ArregloListaIndice() { 
    A = (E[]) new Object[capacidad]; // compilador podría advertir 
  }
  /** Insertar un elemento en el índice dado. */
  public void add(int r, E e) 
    throws IndexOutOfBoundsException {
    revisarIndice(r, size() + 1);
    if (tam == capacidad) {  // un sobreflujo
      capacidad *= 2;
      E[] B =(E[]) new Object[capacidad]; // el compilador podría advertir
      for (int i=0; i<tam; i++) 
        B[i] = A[i];
      A = B;
    }
    for (int i=tam-1; i>=r; i--)  // desplazar elementos hacia adelante
      A[i+1] = A[i];
    A[r] = e;
    tam++;
  }
  /** Quitar el elemento guardado en el índice dado. */
  public E remove(int r) 
    throws IndexOutOfBoundsException {
    revisarIndice(r, size());
    E temp = A[r];
    for (int i=r; i<tam-1; i++)  // desplazar elementos hacia atrás
      A[i] = A[i+1];
    tam--;
    return temp;
  }
  /** Revisa si el índice dado está en el rango [0, n - 1] */
  protected void revisarIndice(int r, int n) // 
    throws IndexOutOfBoundsException {  // 
    if (r < 0 || r >= n)
      throw new IndexOutOfBoundsException("Índice ilegal : " + r);
  }
  /** Regresar el número de elementos en la lista indizada. */
  public int size() {
    return tam;
  }
  /** Indica si la lista indizada está vacía. */
  public boolean isEmpty() {
    return size() == 0; 
  }
  /** Regresa el elemento guardado en el índice dado. */
  public E get(int r) 
    throws IndexOutOfBoundsException {
    revisarIndice(r, size());
    return A[r]; 
  }
  /** Reemplaza el elemento guardado en el índice dado. */
  public E set(int r, E e) 
    throws IndexOutOfBoundsException {
    revisarIndice(r, size());
    E temp = A[r];
    A[r] = e;
    return temp;
  }
}
