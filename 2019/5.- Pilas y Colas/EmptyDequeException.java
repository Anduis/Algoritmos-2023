/**
 * Excepción runtime lanzada cuando se intenta hacer un acceso en una deque
 * vacía o un borrado.
 *
 */

public class EmptyDequeException extends RuntimeException {
  public EmptyDequeException(String err) {
    super(err);
  }
}
