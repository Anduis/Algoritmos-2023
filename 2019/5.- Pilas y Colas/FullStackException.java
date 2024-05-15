/**
 * Excepción Runtime lanzada cuando la capacidad del arreglo usado por un
 * ArregloStack ha sido excedido
 * @see ArregloStack
 */

public class FullStackException extends RuntimeException {
  public FullStackException(String err) {
    super(err);
  }
}
