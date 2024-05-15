/** Clase para el operador producto en una expresión aritmética. */
public class OperadorProductoNumber extends OperadorExpresion {
  public Number getValor() {
    // desencajonar y después encajonar
    Double dval = primerOperando.doubleValue()*segundoOperando.doubleValue();
    return (T)dval;
  }
  public String toString() { return new String("*"); }
}
