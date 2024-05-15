/**
 * Excepción Runtime lanzada cuando se intenta hacer una operación top
 * o pop en una cola vacía.
 */

public class EmptyStackException extends RuntimeException {
  public EmptyStackException(String err) {
    super(err);
  }
}
