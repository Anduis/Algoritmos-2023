/**
 * Excepción Runtime lanzada cuando se intenta acceder la raíz 
 * de un árbol vacío.
 */

public class EmptyTreeException extends RuntimeException {  
  public EmptyTreeException(String err) {
    super(err);
  }
}
