/**
 * Se lanza cuando se rebasan los límites de una colección
 * @author 
 */
public class BoundaryViolationException  extends RuntimeException {
  public BoundaryViolationException (String mensaje) {
    super (mensaje);
  }
}
