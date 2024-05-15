/**
 * Excepción Runtime lanzada cuando se intenta hacer una operación top
 * o pop en una cola vacía.
 */

public class EmptyQueueException extends RuntimeException {
  public EmptyQueueException(String err) {
    super(err);
  }
}
