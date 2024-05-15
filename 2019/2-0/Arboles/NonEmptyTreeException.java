/**
 * Excepción runtime lanzada cuando se intenta crear la raíz de un
 * árbol que no está vacío.
 *
 */

public class NonEmptyTreeException extends RuntimeException {  
  public NonEmptyTreeException(String err) {
    super(err);
  }
}
