/** Clase para un término (operador o variable de una expresión
 * aritmética.
 */
public class TerminoExpresionNumber <T extends Number> {
  public T getValor() {
    T x = (T) new Integer(0);
    return x;
  }
  public String toString() { return new String(""); }
}
