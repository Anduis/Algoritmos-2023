/** Clase para una variable de una expresión artimética. */
public class VariableExpresionNumber<T extends Number> extends TerminoExpresionNumber  {
  protected T var;
  public VariableExpresion(T x) { var = x; }
  public void setVariable(T x) { var = x; }
  public T getValor() { return  var; }
  public String toString() { return var.toString(); }
}
