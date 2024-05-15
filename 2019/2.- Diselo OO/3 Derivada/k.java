public class K{
  public static void main(String[] args) {
    String x = "-10d^4+3y^2-6s";
    String resultado = "";
    int total = x.length(); //longitud del total de caracteres en el polinomio
    int i = 0; //i del caracter que se lee
    int signo;
    char variable;
    int exponente;
    int coeficiente;

    while (i<total) {
      //signo
      if ((x.charAt(i)=='+'|| x.charAt(i)=='-')&&i<total) {//convierte el signo a una unidad positiva o negativa
        if (x.charAt(i)=='+') {
          i++;
          signo=1;
        }
        else {
          signo=-1;
          i++;
        }
      }else signo=1;
      //coeficiente
        coeficiente=0;
        while (i < total && Character.isDigit(x.charAt(i))) {
          coeficiente = coeficiente*10 + Character.getNumericValue(x.charAt(i));
          i++;
        }

      // variable
      if (i < total && Character.isLetter(x.charAt(i)) ) {
        variable = x.charAt(i);
        i++;
        exponente = 1;
      }else{
      variable='\u0000';
      i++;
    }
    exponente = 0;

      // exponente
      if (i<total && x.charAt(i)=='^'){
        i++;
          while (i < total && Character.isDigit(x.charAt(i))) {
            exponente = exponente*10 + Character.getNumericValue(x.charAt(i));
            i++;
          }
      }else exponente=1;
      System.out.println(signo +" "+coeficiente +" "+variable+"^"+exponente );
      //operaciones y escritura del resultado

      if (exponente>0) {
        if (signo == 1) {
        resultado += "+";
        }
        resultado += (signo*coeficiente*exponente);
      }
      if (exponente>1) {
        resultado += variable;
      }
      if (exponente>2) {
        resultado += "^"+(exponente-1);
      }
      System.out.println(resultado);

    }
  }
}
