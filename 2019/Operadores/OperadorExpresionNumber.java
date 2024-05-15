/** Clase para un operador de una expresión aritmética. */
public class OperadorExpresionNumber<T extends Number> extends TerminoExpresion {
  protected T primerOperando, segundoOperando;
  public void setOperandos(T x, T y) {
    primerOperando = x;
    segundoOperando = y;
  }
}
