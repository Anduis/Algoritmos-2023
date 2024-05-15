public class EntradaJuego {
   protected String nombre;	// nombre del dueño de la puntuación
   protected int puntuacion;	// el valor de la puntuación
   /** Constructor para crear una entrada del juego */
   public EntradaJuego(String n, int p) {
      nombre = n;
      puntuacion = p;
   }
   /** Recupera el campo nombre */
   public String getNombre() { return nombre; }
   /** Recupera el campo puntuación */
   public int getPuntuacion() { return puntuacion; }
   /** Regresa una cadena de esta entrada */
   public String toString() { 
      return "(" + nombre + ", " + puntuacion + ")"; 
   }
}
