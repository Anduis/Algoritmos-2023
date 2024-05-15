/**
 * Se lanza cuando una lista no puede cumplir con la operación solicitada
 * porque está vacía la lista.
 * @author
 */
public class InvalidPositionException  extends RuntimeException {
  public InvalidPositionException (String mensaje) {
    super (mensaje);
  }
}
