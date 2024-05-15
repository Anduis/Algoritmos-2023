/**
 * Excepción Runtime lanzada cuando la capacidad del arreglo usado por un
 * ArregloQueue ha sido excedido
 * @see ArregloQueue
 */

public class FullQueueException extends RuntimeException {
  public FullQueueException(String err) {
    super(err);
  }
}
