
public interface ListaNodo<E>{
  public Posicion<E> first();
  public Posicion<E> last();
  public Posicion<E> prev(Posicion<E> p)
  throws InvalidPositionException, BoundaryViolationException;
  public Posicion<E> next(Posicion<E> p)
  throws InvalidPositionException, BoundaryViolationException;
  public E set(Posicion<E> p, E e) throws InvalidPositionException;
  public void addFirst(E e);
  public void addLast(E e);
  public void addBefore(Posicion<E> p, E e)
  throws InvalidPositionException;
  public void addAfter(Posicion<E> p, E e)
  throws InvalidPositionException;
  public E remove(Posicion<E> p) throws InvalidPositionException;
}
