/**
 * Se lanza cuando se determina que una posición es inválida.
 * @author 
 */
// Una excepción en tiempo de ejecución para posiciones inválidas.
public class InvalidPositionException extends RuntimeException {  
  public InvalidPositionException(String err) {
    super(err);
  }
  public InvalidPositionException() {
    /* constructor por defecto */
  }
}
