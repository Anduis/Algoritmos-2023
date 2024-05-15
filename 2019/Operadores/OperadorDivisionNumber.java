/** Clase para el operador cociente en una expresión aritmética. */
public class OperadorDivisionNumber, extends OperadorExpresion {
  public Number getValor() {
    // desencajonar y después encajonar
    Double dval = primerOperando.doubleValue()/segundoOperando.doubleValue();
    return (T)dval;
  }
  public String toString() { return new String("/"); }
}
