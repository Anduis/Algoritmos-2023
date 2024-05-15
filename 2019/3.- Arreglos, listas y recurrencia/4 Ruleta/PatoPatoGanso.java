import java . util . Random ;
public class PatoPatoGanso {
  /** Simulaci on de Pato , Pato , Ganso con una lista circular enlazada . */
  public static void main ( String [] args ) {
    ListaCircular lc = new ListaCircular ();
    int n = 3; // veces que se jugar a el juego
    Nodo eleg ; // jugador elegido
    Nodo ganso ; // el ganso
    Random rand = new Random ();
    rand . setSeed ( System . currentTimeMillis () ); // tiempo actual como semilla
    // Los jugadores ...
    String [] noms = {" Alex "," Eli "," Paco "," Gabi "," Pepe "," Luis ","To~no"," Pedro "};
    for ( String nombre : noms ) {
      lc. agregar ( new Nodo ( nombre , null ) );
      lc. avanzar ();
    }
    System . out.println (" Los jugadores son : "+lc. toString ());
    for (int i = 0; i < n; i ++) { // jugar Pato , Pato , Ganso n veces
      eleg = lc. remover ();
      System . out . println ( eleg . getElemento () + " es el elegido .");
      System . out . println (" Jugando Pato , Pato , Ganso con : "+lc. toString ());
      // marchar alrededor del circulo
      while ( rand . nextBoolean () || rand . nextBoolean ()) {
        lc. avanzar (); // avanzar con probabilidad 3/4
        System . out . println ( lc. getCursor (). getElemento () + " es un pato .");
      }
      ganso = lc. remover ();
      System . out . println ( ""+ ganso . getElemento () + " es el ganso !" );
      if ( rand . nextBoolean () ) {
        System . out . println ("El ganso gan o!");
        lc. agregar ( ganso ); // meter ganso al c rculo
        lc. avanzar (); // cursor esta sobre el ganso
        lc. agregar ( eleg ); // elegido seguir a sie ndolo en la pro xima ronda
      }
      else {
        System . out . println ("El ganso perdi o!");
        lc. agregar ( eleg ); // poner elegido en lugar del ganso
        lc. avanzar (); // cursor esta sobre persona elegida
        lc. agregar ( ganso ); // ganso es el elegido en la siguiente ronda
      }
    }
    System . out . println ("El circulo final es " + lc. toString ());
  }
}
