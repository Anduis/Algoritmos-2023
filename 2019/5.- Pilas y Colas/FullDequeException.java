/**
 * Excepción runtime lanzada cuando se intenta hacer un acceso en una deque
 * vacía o un borrado.
 *
 */

public class FullDequeException extends RuntimeException {
  public FullDequeException(String err) {
    super(err);
  }
}
