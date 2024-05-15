/**
 * Se lanza cuando una lista no puede cumplir con la operación solicitada
 * porque está vacía la lista.
 * @author 
 */
public class EmptyListException  extends RuntimeException {
  public EmptyListException (String mensaje) {
    super (mensaje);
  }
}
