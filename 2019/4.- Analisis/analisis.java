// ¿Son todas las entradas en un arreglo de valores int únicas entre inicio y fin?
public static boolean esUnica(int[] arr, int inicio, int fin) {
  if (inicio>=fin) return true; //1+1
  // revisar si la primera parte de arr es única recursivamente
  if (!esUnica(arr, inicio, fin-1)) return false;
  // revisar si la segunda parte de arr es única recursivamente
  if (!esUnica(arr, inicio+1, fin)) return false;
  return arr[inicio]!=arr[fin]; // revisar si inicio y fin son diferentes
}

public static boolean esUnicaCiclo(int[] arr, int inicio, int fin) {
  //en cada linea se comenta el numero de veces que se ejecuta una operacion primitiva
  if (inicio>=fin) return true;//n+1
  for (int i=inicio; i<fin; ++i)//1+2n+1 = 2n+2
	 for (int j=i+1; j<=fin; ++j)//(2n+2)(n) = 2n^2 +2n
      if (arr[i]==arr[j] return false;//n^2 +1
  return true;//+1
  /*
  siendo el peor de los casos en el que se recorren por completo los arreglos
  (esto es si todos los elementos del arreglo son diferentes)
  se tendria un tiempo de ejecución n+1 + 2n^2 +2n + n^2 2n^3 +2n^2 + n^2 +1 +1 que es O(n^3)
  justificacion : (2n^3 + 6n^2 + 4n + 4) <= (2+6+4+4)n^3 = cn^3,
  para c=16, cuando n>=1
  */
}
