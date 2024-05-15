public class Pr{
  public static void main(String[] args) {
    char x = '\u0000';
    int numero = 4;
    int exponente;
    exponente = 1;
    System.out.println("***"+x+"***");
    exponente =Character.getNumericValue('1');
    System.out.println(exponente);
  }
  if (Character.isDigit(x.charAt(posicion))) {
    digito++;
    coeficiente = Character.getNumericValue(x.charAt(posicion));
    posicion++;
      if (digito>1 && Character.isDigit(x.charAt(posicion))) {
        //si el coeficiente es de mas de un digito
        coeficiente =coeficiente*10 + Character.getNumericValue(x.charAt(posicion));
        digito++;
        posicion++;
      }else {
        digito=0;
      }
  }else {
    coeficiente = 1;
    digito=0;
  }
  if (posicion<largo && x.charAt(posicion)=='^'){
    posicion++;
      while (posicion<largo && Character.isDigit(x.charAt(posicion))){
        if (digito==0) {
          digito++;
          exponente = Character.getNumericValue(x.charAt(posicion));
        }
        while (digito>1) {
          exponente = exponente*10+Character.getNumericValue(x.charAt(posicion));
          posicion++;
        }
      }
    }
  }
}
