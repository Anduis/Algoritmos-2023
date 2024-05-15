/**
 * Se lanza cuando una lista no puede cumplir con la operación solicitada
 * porque está vacía la lista.
 * @author
 */
public class BoundaryViolationException  extends RuntimeException {
  public BoundaryViolationException (String mensaje) {
    super (mensaje);
  }
}
