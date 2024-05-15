Escribir la aplicación Matriz,
la cual puede sumar y multiplicar matrices de tipos genéricos,
de tal forma que las matrices involucradas puedan contener tipos numéricos arbitrarios, como Integer, o Double.
Limitar el tipo genérico al tipo Numeric en esta clase.
Agregar código que muestre el uso de la clase Matriz.

public static int [] guardaFila(int x, String z){
  int[] respuesta = new int[x];
  int  numero = 0;
  int totalFilas=x;
  int filaActual = 0;
  for (int i=0 ; i<z.length(); ) {
    while (i < z.length()  && Character.isDigit(actual(z,i)) && filaActual<totalFilas ) {
      numero = hazNumero(numero, actual(z,i));
      i++;
      respuesta[filaActual]=numero;
      filaActual++;
    }
    if (i < z.length() && actual(z,i) == ','){
      i++;
      while (i < z.length() && Character.isDigit(actual(z,i)) && filaActual<totalFilas) {
        numero = hazNumero(numero, actual(z,i));
        i++;
        respuesta[filaActual]=numero;
        filaActual++;
      }
    }
  }return respuesta;
}
