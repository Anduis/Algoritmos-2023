/** Clase para el operador adición en una expresión aritmética. */
public class OperadorSumaNumber <T extends Number> extends OperadorExpresion {
  public T getValor() {
    // desencajonar y después encajonar
    Double dval = primerOperando.doubleValue()+segundoOperando.doubleValue();
    return (T)dval;
  }
  public String toString() { return new String("+"); }
}
