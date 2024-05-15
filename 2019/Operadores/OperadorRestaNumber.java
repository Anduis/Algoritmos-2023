/** Clase para el operador sustraccíon en una expresión aritmética. */
public class OperadorRestaNumber extends OperadorExpresion {
  public Number getValor() {
    // desencajonar y después encajonar
    Double dval = primerOperando.doubleValue()-segundoOperando.doubleValue();
    return (T)dval;
  }
  public String toString() { return new String("-"); }
}
